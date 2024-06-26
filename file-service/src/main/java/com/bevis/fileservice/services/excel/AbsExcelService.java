package com.bevis.fileservice.services.excel;

import com.bevis.fileservice.consts.Const;
import com.bevis.fileservice.dtos.commons.FileExportParam;
import com.bevis.fileservice.enums.Extension;
import com.bevis.fileservice.utils.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;

@Slf4j
public abstract class AbsExcelService implements IExcelService {

    Workbook getWorkBook(Extension extension) {
        return Extension.EXCEL_2003 == extension ? new HSSFWorkbook() : new XSSFWorkbook();
    }

    void writeHeader(Sheet sheet, int rowIndex, List<String> headers) {
        CellStyle cellStyle = createStyleForHeader(sheet);
        // Create row
        Row row = sheet.createRow(rowIndex);
        // Create cells
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(headers.get(i));
        }
    }

    /**
     * define style for header
     *
     * @param sheet
     * @return
     */
    private CellStyle createStyleForHeader(Sheet sheet) {
        Font font = sheet.getWorkbook().createFont();
        font.setFontName(Const.TIMES_NEW_ROMAN_FONT);
        font.setBold(true);
        font.setFontHeightInPoints((short) 12); // font size
//        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    void autoSizeColumn(Sheet sheet) {
        int lastColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int index = 0; index < lastColumn; index++) {
            sheet.autoSizeColumn(index);
        }
    }

    ResponseEntity<?> createOutputFile(Extension extension, String fileName, ByteArrayOutputStream baos) {
        // add header response
        HttpHeaders headers = new HttpHeaders();
        headers.add(Const.CONTENT_DISPOSITION, String.format(Const.ATTACHMENT_FILENAME, fileName));

        return ResponseEntity.ok().headers(headers)
                .contentLength(baos.size())
                .contentType(MediaType.parseMediaType(extension.getContentType()))
                .body(new InputStreamResource(new ByteArrayInputStream(baos.toByteArray())));
    }

    ResponseEntity<?> exportFile(FileExportParam param) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (Workbook workbook = getWorkBook(param.getExtension())) {
            Sheet sheet = workbook.createSheet("Sheet1");
            int rowIndex = 0;
            writeHeader(sheet, rowIndex, param.getHeaders());
            for (Object obj : param.getData()) {
                int cellIndex = 0;
                Row row = sheet.createRow(++rowIndex);
                for (String fieldName : param.getFieldNames()) {
                    Field field = obj.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    String str = null == value ? Const.EMPTY : field.get(obj).toString();
                    if (ValidateUtils.isNotNullOrEmpty(param.getMapValues())
                            && ValidateUtils.isNotNullOrEmpty(param.getMapValues().get(fieldName))) {
                        str = param.getMapValues().get(fieldName).get(str);
                    }
                    row.createCell(cellIndex).setCellValue(str);
                    cellIndex++;
                }
            }
            autoSizeColumn(sheet);
            workbook.write(baos);
        } catch (Exception ex) {
            log.error("exportFile has error: ", ex);
        }
        return createOutputFile(param.getExtension(), param.getFileName(), baos);
    }

}

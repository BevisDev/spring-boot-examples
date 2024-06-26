package com.bevis.fileservice.services.excel;

import com.bevis.fileservice.consts.Const;
import com.bevis.fileservice.enums.Extension;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public abstract class AbsExcelService implements IExcelService {

    Workbook getWorkBook(Extension extension) {
        return Extension.EXCEL_2003 == extension
                ? new HSSFWorkbook() : new XSSFWorkbook();
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
//        font.setFontHeightInPoints((short) 14); // font size
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

    ResponseEntity<?> exportFile(Extension extension, String fileName, ByteArrayOutputStream baos) {
        // add header response
        HttpHeaders headers = new HttpHeaders();
        headers.add(Const.CONTENT_DISPOSITION, String.format(Const.ATTACHMENT_FILENAME, fileName));

        return ResponseEntity.ok().headers(headers)
                .contentLength(baos.size())
                .contentType(MediaType.parseMediaType(extension.getContentType()))
                .body(new InputStreamResource(new ByteArrayInputStream(baos.toByteArray())));
    }

}

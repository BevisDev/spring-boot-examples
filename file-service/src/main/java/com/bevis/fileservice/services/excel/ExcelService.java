package com.bevis.fileservice.services.excel;

import com.bevis.fileservice.consts.MockData;
import com.bevis.fileservice.dtos.commons.FileExportParam;
import com.bevis.fileservice.enums.Extension;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ExcelService extends AbsExcelService {

    @Override
    public ResponseEntity<?> exportDataTest() {
        List<String> headers = List.of("ID", "Name", "Date of birth");
        List<String> fieldNames = List.of("id", "customerName", "dob", "active", "phone");

        FileExportParam params = new FileExportParam();
        params.setData(MockData.dataList);
        params.setExtension(Extension.EXCEL);
        params.setHeaders(headers);
        params.setFieldNames(fieldNames);
        params.setFileName("data.xlsx");
        Map<String, String> map = new HashMap<>();
        map.put(Boolean.TRUE.toString(), "da kich hoat");
        map.put(Boolean.FALSE.toString(), "da out");
        Map<String, Map<String, String>> values = new HashMap<>();
        values.put("active", map);
        params.setMapValues(values);
        return exportFile(params);
    }

}

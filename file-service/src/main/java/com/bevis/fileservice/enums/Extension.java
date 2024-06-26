package com.bevis.fileservice.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Extension {

    WORD_2003("doc", ".doc", "application/msword"),
    WORD("docx", ".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    EXCEL_2003("xls", ".xls", "application/vnd.ms-excel"),
    EXCEL("xlsx", ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    PPOINT_2003("ppt", ".ppt", "application/vnd.ms-powerpoint"),
    PPOINT("pptx", ".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"),
    PDF("pdf", ".pdf", "application/pdf"),
    TEXT("txt", ".txt", "text/plain"),
    CSV("csv", ".csv", "text/csv"),
    PNG("png", ".png", "image/png"),
    JPG("jpg", ".jpg", "image/jpeg"),
    JPEG("jpeg", ".jpeg", "image/jpeg"),
    TMP("tmp", ".tmp");

    final String value;
    final String dotValue;
    String contentType;

    Extension(String value, String dotValue) {
        this.value = value;
        this.dotValue = dotValue;
    }

}

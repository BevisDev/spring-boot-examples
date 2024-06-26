package com.bevis.fileservice.dtos.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class DataTestDTO {

    String id;
    String customerName;
    String dob;
    boolean active;
    Integer phone;

    public DataTestDTO(String id, String customerName, String dob) {
        this.id = id;
        this.customerName = customerName;
        this.dob = dob;
    }
}

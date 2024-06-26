package com.bevis.fileservice.consts;

import com.bevis.fileservice.dtos.commons.DataTestDTO;

import java.util.List;

public final class MockData {

    public static final List<DataTestDTO> dataList = List.of(
            new DataTestDTO("1", "Nguyen Van A", "2000-01-01", false, 1245),
            new DataTestDTO("2", "Nguyen Van B", "2000-02-02", true, 6536),
            new DataTestDTO("3", "Nguyen Van C", "2000-03-03")
    );

}

package com.example.administrator.poi;

import org.apache.poi.ss.usermodel.Row;

public interface RowItemAdapter<T>{
    void matchData(T item, Row row);
}

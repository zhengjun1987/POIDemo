package com.example.administrator.poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/8/13  23:39
 * Summary : 在这里描述Class的主要功能
 */

public class POIManager implements IExcelManager {

    private int index;

    @Override
    public void writeTitles(File file, String[] titles) throws IOException {
        System.out.println("POIManager.writeTitles  " + "file = [" + file + "], titles = [" + Arrays.toString(titles) + "]");
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = hssfWorkbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }
        index = 1;
        hssfWorkbook.write(new FileOutputStream(file));
        hssfWorkbook.cloneSheet(0);
        hssfWorkbook.close();
        System.out.println("写入标题完成");
    }

    @Override
    public  <T> void writeData(File file, List<T> data) throws IOException {
        System.out.println("POIManager.writeData  " + "file = [" + file + "], data = [" + data + "]");
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook();
        XSSFSheet hssfSheet = hssfWorkbook.createSheet();
        for (int i = 0; i < data.size(); i++) {
            XSSFRow row = hssfSheet.createRow(index + i);
            T t = data.get(i);
            String toString = t.toString();
            String[] split = toString.split("_");
            for (int in = 0; in < split.length; in++) {
                XSSFCell cell = row.createCell(in);
                cell.setCellValue(split[in]);
            }
        }
        hssfWorkbook.write(new FileOutputStream(file));
        hssfWorkbook.cloneSheet(0);
        hssfWorkbook.close();
        System.out.println("写入完成");
        index += data.size();
    }
}


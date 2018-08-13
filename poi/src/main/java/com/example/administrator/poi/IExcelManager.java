package com.example.administrator.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/8/13  23:23
 * Summary : 在这里描述Class的主要功能
 */

public interface IExcelManager {
    void writeTitles(File file, String[] titles) throws IOException;
    <T> void writeData(File file, List<T> data) throws IOException;
}

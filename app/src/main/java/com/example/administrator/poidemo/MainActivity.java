package com.example.administrator.poidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.poi.POIManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("MainActivity.onClick  " + "v = [" + v + "]");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ArrayList<OpenRecord> arrayList = new ArrayList<>();
                for (int i = 0; i < 70000; i++) {
                    OpenRecord openRecord = new OpenRecord("姓名" + i, simpleDateFormat.format(new Date()), i % 3 + "", i + "");
                    arrayList.add(openRecord);
                }

                File file = new File(getDataDir(), "2018.xlsx");

                POIManager poiManager = new POIManager();
                try {
                    poiManager.writeTitles(file, new String[]{"姓名","时间","方式","编号"});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ArrayList<OpenRecord> openRecords = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    OpenRecord openRecord = arrayList.get(i);
                    openRecords.add(openRecord);
                    if (openRecords.size() % 500 == 0 || i == size - 1) {
                        try {
                            poiManager.writeData(file, openRecords);
                            openRecords.clear();
                            System.out.println("i = " + i);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}

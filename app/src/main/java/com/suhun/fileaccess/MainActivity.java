package com.suhun.fileaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void writeFun(View view){
        String writeData = "Hello! My name is happy!!!";
        try{
            FileOutputStream fout = openFileOutput("mydata1.txt",MODE_PRIVATE);
            fout.write(writeData.getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void readFun(View view){
        try{
            FileInputStream fin = openFileInput("mydata1.txt");
            BufferedReader breader = new BufferedReader(new InputStreamReader(fin));
            String line;
            while((line = breader.readLine())!=null){
                Toast.makeText(this, line.toString(), Toast.LENGTH_SHORT).show();
            }
            fin.close();
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
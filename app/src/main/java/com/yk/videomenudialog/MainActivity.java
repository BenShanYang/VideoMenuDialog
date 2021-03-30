package com.yk.videomenudialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yk.videomenu.VideoDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        new VideoDialog(this) {
            @Override
            public void album(VideoDialog dialog) {
                Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void record(VideoDialog dialog) {
                Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_SHORT).show();
            }
        }.show();
    }

}
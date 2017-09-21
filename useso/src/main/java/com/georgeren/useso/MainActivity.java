package com.georgeren.useso;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.georgeren.myndk.Cryptor;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textCrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crypt();
            }
        });
        findViewById(R.id.textDecrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrypt();
            }
        });
    }

    public void crypt() {
        String src = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separatorChar + "test_src.txt";
        String dest = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separatorChar + "test_crypt.txt";
        Cryptor.cryptFile(src, dest);
        Toast.makeText(this, "加密完成了", Toast.LENGTH_SHORT).show();
    }

    public void decrypt() {
        String src = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separatorChar + "test_crypt.txt";
        String dest = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separatorChar + "test_decrypt.txt";
        Cryptor.decryptFile(src, dest);
        Toast.makeText(this, "解密完成了", Toast.LENGTH_SHORT).show();
    }
}

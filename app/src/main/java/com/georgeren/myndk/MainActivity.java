package com.georgeren.myndk;

import android.Manifest;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import io.reactivex.functions.Consumer;
// 参考：http://www.jianshu.com/p/b4a4cd12d528
public class MainActivity extends AppCompatActivity {

    private RxPermissions mRxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.sample_text);
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

        //调用JNI方法，把获取到的字符串显示到TextView上面
        tv.setText(new Cryptor().stringFromJNI());

        mRxPermissions = new RxPermissions(this);

        mRxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if (!granted) {
                            finish();
                        }
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

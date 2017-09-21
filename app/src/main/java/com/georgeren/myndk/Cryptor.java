package com.georgeren.myndk;

/**
 * Created by georgeRen on 2017/9/21.
 */

public class Cryptor {
    static {
        //加载动态库.so文件，注意不用写lib前缀，系统会默认添加
        System.loadLibrary("native-lib");
    }

    public static native void cryptFile(String src, String dest);

    public static native void decryptFile(String src, String dest);

    //一个native方法的例子
    public native String stringFromJNI();
}

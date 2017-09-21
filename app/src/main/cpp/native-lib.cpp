#include <jni.h>
#include <string>

//用于加密解密的密码
char password[] = "I AM MI MA";

extern "C"
JNIEXPORT void JNICALL
Java_com_georgeren_myndk_Cryptor_cryptFile(JNIEnv *env, jclass type, jstring src_, jstring dest_) {
    const char *src = env->GetStringUTFChars(src_, 0);
    const char *dest = env->GetStringUTFChars(dest_, 0);

    // TODO
    FILE *f_read = fopen(src, "rb");
    FILE *f_write = fopen(dest, "wb");

    //判断文件是否正确打开
    if (f_read == NULL || f_write == NULL) {
        printf("file open field");
        return;
    }

    //一次读取一个字符
    int ch;
    int i = 0;
    int pwd_len = strlen(password);
    while ((ch = fgetc(f_read)) != EOF) {
        //通过异或运算进行加密
        fputc(ch ^ password[i % pwd_len], f_write);
        i++;
    }

    //关闭文件
    fclose(f_read);
    fclose(f_write);


    env->ReleaseStringUTFChars(src_, src);
    env->ReleaseStringUTFChars(dest_, dest);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_georgeren_myndk_Cryptor_decryptFile(JNIEnv *env, jclass type, jstring src_,
                                             jstring dest_) {
    const char *src = env->GetStringUTFChars(src_, 0);
    const char *dest = env->GetStringUTFChars(dest_, 0);
    // TODO

    FILE *f_read = fopen(src, "rb");
    FILE *f_write = fopen(dest, "wb");

    //判断文件是否正确打开
    if (f_read == NULL || f_write == NULL) {
        printf("file open field");
        return;
    }

    //一次读取一个字符
    int ch;
    int i = 0;
    int pwd_len = strlen(password);
    while ((ch = fgetc(f_read)) != EOF) {
        //通过异或运算进行加密
        fputc(ch ^ password[i % pwd_len], f_write);
        i++;
    }

    //关闭文件
    fclose(f_read);
    fclose(f_write);


    env->ReleaseStringUTFChars(src_, src);
    env->ReleaseStringUTFChars(dest_, dest);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_georgeren_myndk_Cryptor_stringFromJNI(JNIEnv *env, jobject /* this */) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

# MyNDK
 1. 利用NDK对文件加密和解密，cmake挺不错的。
 2. 注意我加了 extern "C" 不然编译不过。谁知道为什么？？
 3. cpp中有略微调整，加了 extern "C" 等,我也不知道为什么？？不调整就是编译不过。
 4. 如果你发现app爆红了，其实可以运行的，是由于lib这个module，jar级别的module是为使用so的jar做准备。在这里可以不写或删除
# useso so+jar--》使用so
 1. 获取so：执行assembleRelease会在build/cmake/release/obj/支持cpu架构的so
 2. 生成jar:lib（jar级别的module）中，build/libs/lib.jar
 3. 使用：把libnative-lib.so放进jniLibs下，lib.jar放到libs下。你会发现奇迹般的可以用jar+so。
# 注意：别忘记加读写权限。不然...坑。
 1. JNI：（Java Native Interface）：Java调用C/C++，C/C++调用Java的一套API。
 2. NDK 调试 ndk-stack
 
[参考1](http://www.jianshu.com/p/b4a4cd12d528)  
[参考2](http://www.jianshu.com/p/8191a654dcb8) 


# Digitial-Clock
Digitial clock with time zoon selection and alarm function

This programme is supported by NJUPT Java class teacher Mr.Deng and my teammate Miss.chen.
Also, it is submitted to teacher as a team work for our final exam.
Java Swing is used to design the interactive interface.

运行程序中注意修改音频文件（用作铃声）的路径

程序涉及到多线程任务处理，由于程序中有较多界面显示和时间获取、计时、计算等功能，计时器在进程中起到重要作用。计时器在不同的进程中扮演者计时、刷新界面等不同的功能，所以需要设置好不同的计时时间，和应用范围，设计错误将会导致用户使用体验差等问题。
具体解决方案是显示界面刷新率设置为300ms，确保用户的操作可以及时的在界面上显示出来，提高用户使用的使用体验。倒计时刷新时间为1s，即每经过1s，距离倒计时时间结束减1，直到时间归0，弹窗响铃。

功能设计：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E5%8A%9F%E8%83%BD%E8%AE%BE%E8%AE%A1.png)

流程图：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

倒计时流程图：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E5%80%92%E8%AE%A1%E6%97%B6%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

具体类和方法描述：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E5%85%B7%E4%BD%93%E7%B1%BB%E5%92%8C%E6%96%B9%E6%B3%95%E6%8F%8F%E8%BF%B0.png)

初始界面：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E5%88%9D%E5%A7%8B%E7%95%8C%E9%9D%A2.png)

时区调整：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E6%97%B6%E5%8C%BA%E8%B0%83%E6%95%B4.png)

闹钟对话：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E9%97%B9%E9%92%9F%E5%AF%B9%E8%AF%9D.png)

倒计时对话：

![image](https://github.com/Zh-Qr/Digitial-Clock/blob/main/%E5%80%92%E8%AE%A1%E6%97%B6%E5%AF%B9%E8%AF%9D.png)

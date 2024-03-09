# Digitial-Clock
Digitial clock with time zoon selection and alarm function

This programme is supported by NJUPT Java class teacher Mr.Deng and my teammate Miss.chen
Also, it is submissed to teacher as a team work for our final exam.
Java Swing is used to design the interactive interface.

运行程序中注意修改音频文件（用作铃声）的路径

程序涉及到多线程任务处理，由于程序中有较多界面显示和时间获取、计时、计算等功能，计时器在进程中起到重要作用。计时器在不同的进程中扮演者计时、刷新界面等不同的功能，所以需要设置好不同的计时时间，和应用范围，设计错误将会导致用户使用体验差等问题。
具体解决方案是显示界面刷新率设置为300ms，确保用户的操作可以及时的在界面上显示出来，提高用户使用的使用体验。倒计时刷新时间为1s，即每经过1s，距离倒计时时间结束减1，直到时间归0，弹窗响铃。


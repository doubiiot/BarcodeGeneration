# BarcodeGeneration
##Introduction：
程序主要功能是通过用户输入和控制生成CODE39码或EAN码，同时会检测用户的输入是否有错误。

##遇到的主要问题：
JLbel显示图片不刷新的问题，网上相关的资料比较少，看到比较多的是通过开一个线程来进行实时刷新，偶然看到了一个简单的解决办法

'''
jlabel.setIcon(new ImageIcon(ImageIO.read(new File("image.png"))));
'''

##用户运行图：

![](https://github.com/doubiiot/BarcodeGeneration/blob/master/pic/1.png)  
![](https://github.com/doubiiot/BarcodeGeneration/blob/master/pic/2.png)  
![](https://github.com/doubiiot/BarcodeGeneration/blob/master/pic/3.png)  
![](https://github.com/doubiiot/BarcodeGeneration/blob/master/pic/4.png)  
![](https://github.com/doubiiot/BarcodeGeneration/blob/master/pic/5.png)  



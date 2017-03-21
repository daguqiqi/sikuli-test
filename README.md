# sikuli-test
sikuli flex test
sikuli的官网地址：http://www.sikuli.org
根据图片识别，对页面元素进行操作（Flash自动化）
Sikuli配置步骤:
1.下载sikuliX的jar包：https://launchpad.net/sikuli/sikulix/1.1.0
2.将sikuli jar加入本地仓库
进入项目目录运行：
mvn install:install-file -Dfile=sikulixsetup-1.1.0.jar -DgroupId=com.test.sikuli -DartifactId=sikuli -Dversion-1.1.0 -Dpackaging=jar
3.maven引入sikuli jar（代码里已经做了）
        <dependency>
            <groupId>com.test.sikuli</groupId>
            <artifactId>sikuli</artifactId>
            <version>1.1.0</version>
        </dependency>
4.在cmd中运行该jar包。java -jar sikulixsetup-1.1.0.jar，则会出现如下图，选择相应选项后，启动会下载sikulixapi.jar。不然会报错：libs to export not found on above classpath: /sikulixlibs/mac/libs64

5.运行test（x y 为屏幕分辨率）
mvn test -Dx=1440 -Dy=900 

打开浏览器指定Url
Windows：Runtime.getRuntime().exec("cmd.exe /c start Chrome " + url);
Mac：Runtime.getRuntime().exec("open "+url);


参考文档：
http://sikulix.com/
http://nightly.sikuli.de/docs/index.html
https://www.testwo.com/article/299
http://www.softwaretestinghelp.com/sikuli-tutorial-part-2/
http://blog.csdn.net/u012496940/article/details/49301247
https://chromedriver.storage.googleapis.com/index.html?path=2.28/
https://github.com/mozilla/geckodriver/releases
http://www.bubuko.com/infodetail-1489494.html

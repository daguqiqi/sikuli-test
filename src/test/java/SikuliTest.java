import jxl.read.biff.BiffException;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by fu.yang on 2017/3/14.
 */
public class SikuliTest {

    @DataProvider(name="template")
    public Object[][] Numbers() throws BiffException, IOException {
        ExcelData e=new ExcelData("testdata", "testdata");
        return e.getExcelData();
    }

    @Test(dataProvider="template")
    public void testAdd(HashMap<String, String> data) throws Exception{
        System.out.println(data.toString());
        String template_name = data.get("template_name");
        String template_screenshot_path = data.get("template_screenshot_path");
//
//        int x = Integer.parseInt(System.getProperty("x"));
//        int y = Integer.parseInt(System.getProperty("y"));
        int x = 1440;
        int y = 900;
        File classpathRoot = new File(System.getProperty("user.dir"));
        String picturePath = new File(classpathRoot, "/pictures").getAbsolutePath();
        String url = "http://simulator.spec.dl.alipaydev.com/SIMUFlex/SIMUFlex.html";
        String osName = System.getProperty("os.name");

        if (osName.startsWith("Mac")) {
            //Mac OS
            Runtime.getRuntime().exec("open "+url);
        } else if (osName.startsWith("Windows")) {
            //Windows
            Runtime.getRuntime().exec("cmd.exe /c start Chrome " + url);
        }

        Thread.sleep(5000);
        Screen s = new Screen();

        System.out.println("选择对手行...");
        s.find(picturePath+"/1.png");
        s.click(picturePath+"/1.png");

        try{
            System.out.println("选择中国银行...");
            s.find(picturePath+"/2.png");
            s.click(picturePath + "/2.png");
        }catch (Exception e) {
            s.click(picturePath + "/1.png");
            s.click(picturePath + "/2.png");
        }

        System.out.println("登录...");
        s.find(picturePath+"/3.png");
        s.doubleClick(picturePath+"/3.png");

        Thread.sleep(3000);
        System.out.println("点击【大额往款】...");
        s.find(picturePath+"/4.png");
        s.click(picturePath+"/4.png");

        System.out.println("点击【客户发起汇兑业务】...");
        s.find(picturePath+"/5.png");
        s.click(picturePath+"/5.png");

        System.out.println("点击【新增】...");
        s.find(picturePath+"/6.png");
        s.click(picturePath+"/6.png");

        Thread.sleep(1000);
        System.out.println("下拉滚动条...");
        Region r1 = new Region(25*x/36,5*y/9,11*x/36,4*y/9);
        r1.find(picturePath+"/14.png");
        for(int i =0;i<3;i++){
            r1.click(picturePath+"/14.png");
        }

        System.out.println("点击【录入模板数据】...");
        s.find(picturePath+"/7.png");
        s.click(picturePath+"/7.png");

        System.out.println("下拉选择模板...");
//      System.out.println(s.find(picturePath+"/12.png").getTarget());
        Region r2 = new Region(5*x/12,4*y/9,23*x/144,7*y/90);
        r2.find(picturePath+"/8.png");
        r2.click(picturePath+"/8.png");


        System.out.println("选择模板"+template_name+"...");
        Region r3 = new Region(5*x/12,4*y/9,x/6,4*y/15);
        int k = 50;

        while(k>0){
            System.out.println("K"+k);
            k--;
            if(k==0){
                throw new Exception("没有定位到模板"+template_name+"！请检查模板名字和截图路径是否正确！");
            }
            try{
                System.out.println(template_screenshot_path);
                Location lc = s.find(template_screenshot_path).getCenter();
                s.click(lc);
                break;
            }catch (Exception e) {
                r3.find(picturePath+"/14.png");
                r3.click(picturePath+"/14.png");

            }
        }

        s.click(template_screenshot_path);
        System.out.println("点击【确认】...");
        s.find(picturePath+"/10.png");
        s.click(picturePath+"/10.png");

        System.out.println("点击【确定】...");
        s.find(picturePath+"/11.png");
        s.click(picturePath+"/11.png");

    }


}

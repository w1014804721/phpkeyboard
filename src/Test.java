import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class Test {
    public static void main(String []args) throws IOException, AWTException, InterruptedException{
//创建Windows命令打开记事本
        Runtime.getRuntime().exec("notepad");
//创建机器人
        Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_I);
        rb.keyPress(KeyEvent.VK_SPACE);
        rb.keyPress(KeyEvent.VK_L);
        rb.keyPress(KeyEvent.VK_O);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_SPACE);
        rb.keyPress(KeyEvent.VK_Y);
        rb.keyPress(KeyEvent.VK_O);
        rb.keyPress(KeyEvent.VK_U);

    }
}
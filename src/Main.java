import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by 17854 on 2016/9/21.
 */
public class Main extends JFrame
{
    Robot robot = null;
    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
        e.printStackTrace();
    }}
    JButton msgBtn;
    JButton exitBtn;
    public static final int FUNC_KEY_MARK = 1;
    public static final int EXIT_KEY_MARK = 0;
    public void start()
    {
        this.setTitle("$!$!$!");
        this.setBounds(100,100,50,50);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        msgBtn = new JButton("$!!! q+w");
        msgBtn.setMargin(new Insets(0,0,0,0));
        msgBtn.setFocusable(false);
        msgBtn.setBounds(20,20,120,30);
        msgBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage();
            }
        });
   //     this.add(msgBtn);

        exitBtn = new JButton("退出（Alt+Q）");
        exitBtn.setMargin(new Insets(0,0,0,0));
        exitBtn.setFocusable(false);
        exitBtn.setBounds(160, 20, 120, 30);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        TextArea textArea = new TextArea("alt+s");
        textArea.setBounds(0,0,50,50);
    //    this.add(exitBtn);
   //     this.add(textArea);
        this.add(textArea);
        //第一步：注册热键，第一个参数表示该热键的标识，第二个参数表示组合键，如果没有则为0，第三个参数为定义的主要热键
        JIntellitype.getInstance().registerHotKey(FUNC_KEY_MARK, 0, (int)'1');
        JIntellitype.getInstance().registerHotKey(EXIT_KEY_MARK, JIntellitype.MOD_ALT, 1);
        //第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {

            @Override
            public void onHotKey(int markCode) {
                switch (markCode) {
                    case FUNC_KEY_MARK:
                        showMessage();
                        break;
                    case EXIT_KEY_MARK:
                        System.exit(0);
                        break;
                }
            }
        });

        this.setVisible(true);
    }
    public void showMessage() {
        Robot roBot = null;
        try {
             roBot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_SHIFT);
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_4);
    }
    public static void main(String[] args) {
        new Main().start();
    }
}
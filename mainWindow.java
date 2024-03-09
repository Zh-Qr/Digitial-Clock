import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class mainWindow {
    public static String zone_id = "";
    public static int[] date;
    public static int[] alarmTime = {0,0};
    public static long countDownNum;
    public static boolean alarmoption = false;
    public static boolean countoption = false;

    public static void main(String[] args){
        System.out.println("mianWindow");
    }


    public static void mainwindow(){
        
        JFrame jf = new JFrame("智能时钟");
        jf.setLayout(new FlowLayout());
        jf.setBounds(400,300,500,250);

        JComboBox zone = new JComboBox<>();
        zone.addItem("---选择时区（默认时区为当地时区）---");
        zone.addItem("Coordinated Universal Time，UTC 格林尼治标准时间");
        zone.addItem("China Standard Time，CST 中国标准时间 ");
        zone.addItem("Asia/Tokyo 日本标准时间 ");
        zone.addItem("Pacific/Guadalcanal 所罗门群岛时间 ");
        zone.addItem("Asia/Kolkata 印度标准时间 ");
        zone.addItem("Europe/Berlin 欧洲中部时间 ");
        zone.addItem("Australia/Sydney 澳大利亚东部标准时间 ");
        zone.addItem("Australia/Adelaide 澳大利亚中部标准时间 ");
        zone.addItem("America/New_York 东部标准时间 ");
        zone.addItem("America/Los_Angeles 太平洋标准时间 ");
        zone.addItem("Africa/Johannesburg 南非标准时间 ");

        JTextField currentYear = new JTextField(40);
        JTextField currentDay = new JTextField(40);
        JTextField currentTime = new JTextField(40);
        currentYear.setEditable(false);
        currentDay.setEditable(false);
        currentTime.setEditable(false);
        currentYear.setOpaque(false);
        currentDay.setOpaque(false);
        currentTime.setOpaque(false);
        currentYear.setBorder(null);
        currentDay.setBorder(null);
        currentTime.setBorder(null);

        JTextField  alarmStatue = new JTextField(40);
        alarmStatue.setEditable(false);
        alarmStatue.setOpaque(false);
        alarmStatue.setBorder(null);
        JButton setAlarm = new JButton("设置闹钟");

        JRadioButton on = new JRadioButton("打开闹钟");
        JRadioButton off = new JRadioButton("关闭闹钟");

        ButtonGroup group = new ButtonGroup();
        group.add(on);
        group.add(off);

        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alarmoption = true;
                System.out.println("闹钟已打开");
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alarmoption = false;
                System.out.println("闹钟已关闭");
            }
        });
        off.doClick();


        JTextField  countStatue = new JTextField(40);
        countStatue.setEditable(false);
        countStatue.setOpaque(false);
        countStatue.setBorder(null);
        JButton setCount = new JButton("设置倒计时");

        JRadioButton on_c = new JRadioButton("打开倒计时");
        JRadioButton off_c = new JRadioButton("关闭倒计时");

        ButtonGroup group_c = new ButtonGroup();
        group_c.add(on_c);
        group_c.add(off_c);

        on_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countoption = true;
                System.out.println("倒计时已打开");
                setAlarmWindow.decreaseCT(jf);
            }
        });

        off_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countoption = false;
            }
        });


        setAlarm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e){
                setAlarmWindow.setalarmwindow(jf);
            }
        });

        setCount.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e){
                countDownNum = setAlarmWindow.setCountWindow(jf);
            }
        });

        ActionListener updateCount = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                countDownNum = setAlarmWindow.countTime;
                int[] countarr = utils.transerform(countDownNum);
                countStatue.setText("倒计时："+String.format("%02d时 %02d分 %02d秒", countarr[0],countarr[1],countarr[2]));
                if (countoption) {
                    countoption = setAlarmWindow.decreaseCT(jf);
                }
                else{
                    off_c.doClick();
                }
            }
        };
        Timer timer2 = new Timer(1000, updateCount);  // Corrected import and instantiation
        timer2.start();

        ActionListener updateAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                int z = zone.getSelectedIndex(); 
                if (z==0) {
                    date = timeZone.get_local_time();
                }
                else{
                    zone_id = timeZone.indexId(z);
                    date = timeZone.get_zone_time(zone_id);
                }
                alarmTime = setAlarmWindow.alarmTime;
                currentYear.setText(String.format("%d 年", date[0]));
                currentDay.setText("日期："+String.format("%d月 %02d日 星期", date[1], date[2])+utils.weekday(date[6]));
                currentTime.setText("时间："+String.format("%02d时 %02d分 %02d秒", date[3], date[4], date[5])); 
                alarmStatue.setText(String.format("闹钟时间：%02d：%02d", alarmTime[0],alarmTime[1]));     
                

            }
        };

        javax.swing.Timer timer = new javax.swing.Timer(300, updateAction);
        timer.start();  // 启动定时器

        ActionListener asponseRing = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int z = zone.getSelectedIndex(); 
                if (z==0) {
                    date = timeZone.get_local_time();
                }
                else{
                    zone_id = timeZone.indexId(z);
                    date = timeZone.get_zone_time(zone_id);
                }
                if (date[3]==alarmTime[0]&&date[4]==alarmTime[1]&&alarmoption) {
                    if(setAlarmWindow.alarmring(jf)){
                        alarmTime = utils.moresleep(alarmTime);
                    }
                    else{
                        off.doClick();
                    }
                }
            }
        };

        javax.swing.Timer timer3 = new javax.swing.Timer(10, asponseRing);
        timer3.start();

        jf.add(currentYear);
        jf.add(currentDay);
        jf.add(currentTime);
        jf.add(zone);
        jf.add(alarmStatue);
        jf.add(setAlarm);
        jf.add(on);
        jf.add(off);
        jf.add(countStatue);
        jf.add(setCount);
        jf.add(on_c);
        jf.add(off_c);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

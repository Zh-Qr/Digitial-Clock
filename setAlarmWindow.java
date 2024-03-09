import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class setAlarmWindow {
    public static void main(String[] args) {
        System.out.println("this is alarm window file");
    }

    public static int[] alarmTime = { 0, 0 };
    public static long countTime;
    public static boolean waittoreturn;

    public static int[] setalarmwindow(JFrame jf) {
        JDialog setwindow = new JDialog(jf, "设置闹钟");
        setwindow.setLayout(new FlowLayout());
        setwindow.setBounds(450, 350, 250, 80);

        JComboBox<Integer> hour = new JComboBox<>();
        JComboBox<Integer> minute = new JComboBox<>();

        JButton confirm = new JButton("确认");

        for (int i = 0; i < 24; i++) {
            hour.addItem(i);
        }

        for (int i = 0; i < 60; i++) {
            minute.addItem(i);
        }

        int[] selectedTime = new int[2];

        hour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTime[0] = (int) hour.getSelectedItem();
            }
        });

        minute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTime[1] = (int) minute.getSelectedItem();
            }
        });

        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alarmTime[0] = selectedTime[0];
                alarmTime[1] = selectedTime[1];

                setwindow.dispose();
                // confirmed = true; // 设置确认标志�? true
            }
        });

        setwindow.add(hour);
        setwindow.add(minute);
        setwindow.add(confirm);

        setwindow.setVisible(true);
        setwindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Return the updated alarmTime array
        return alarmTime;
    }

    public static boolean alarmring(JFrame jf) {
        // Play music
        String musicPath = "D:\\桌面\\南京邮电大学\\大科目\\java\\大作业\\program\\digitialClock\\张晓涵_戚琦-绝世舞姬.wav";
        AlarmPlayer.playAlarm(musicPath);

        int option = JOptionPane.showOptionDialog(
                jf,
                "闹钟时间�?",
                "闹钟响起",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[] { "贪睡模式", "退�?" },
                "退�?");

        // Stop the music when the alarm dialog is closed or an option is selected
        AlarmPlayer.stopAlarm();

        return option == JOptionPane.YES_OPTION;
    }

    public static long setCountWindow(JFrame jf) {
        JDialog setwindow = new JDialog(jf, "设置倒计�?");
        setwindow.setLayout(new FlowLayout());
        setwindow.setBounds(450, 350, 250, 100);

        JComboBox<Integer> hour = new JComboBox<>();
        JComboBox<Integer> minute = new JComboBox<>();
        JComboBox<Integer> second = new JComboBox<>();

        for (int i = 0; i < 24; i++) {
            hour.addItem(i);
        }

        for (int i = 0; i < 60; i++) {
            minute.addItem(i);
        }

        for (int i = 0; i < 60; i++) {
            second.addItem(i);
        }

        JButton confirm = new JButton("确认");

        int[] selectedTime = new int[3];

        hour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTime[0] = (int) hour.getSelectedItem();
            }
        });

        minute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTime[1] = (int) minute.getSelectedItem();
            }
        });

        second.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTime[2] = (int) second.getSelectedItem();
            }
        });
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countTime = selectedTime[0] * 60 * 60 * 1000 + selectedTime[1] * 60 * 1000 + selectedTime[2] * 1000;
                setwindow.dispose();
                // confirmed = true; // 设置确认标志�? true
            }
        });
        setwindow.add(hour);
        setwindow.add(minute);
        setwindow.add(second);
        setwindow.add(confirm);

        setwindow.setVisible(true);
        setwindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        return countTime;

    }

    // 倒计时时间减一
    public static boolean decreaseCT(JFrame jf) {
        countTime = countTime - 1000;
        if (countTime < 0) {
            countTime = 0;
            countover(jf);
            return false;
        }
        return true;
    }

    public static void countover(JFrame jf) {
        JDialog cover = new JDialog(jf, "倒计时结�?");
        cover.setLayout(new FlowLayout());
        cover.setBounds(450, 350, 200, 100);

        JLabel overJLabel = new JLabel("倒计时结�?");
        JButton back = new JButton("返回");
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cover.dispose();
                // 停止音乐
                AlarmPlayer.stopAlarm();
            }
        });

        // Add window listener to stop music when the dialog is closed
        cover.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Stop the music when the dialog is closed
                AlarmPlayer.stopAlarm();
            }
        });

        cover.add(overJLabel);
        cover.add(back);
        cover.setVisible(true);
        cover.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // 播放音乐
        String musicPath = "D:\\桌面\\南京邮电大学\\大科目\\java\\大作业\\program\\digitialClock\\张晓涵_戚琦-绝世舞姬.wav";
        AlarmPlayer.playAlarm(musicPath);
    }

}
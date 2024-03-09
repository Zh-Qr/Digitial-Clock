import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class utils {
    public static void main(String[] args){
        System.out.println("this is utils file");
        }
    //print the time
    public static void print_time(int[] date){
        if (date.length==7) {
            System.out.printf("%d年 %d月 %02d日 星期%d %02d时 %02d分 %02d秒\n",date[0],date[1],date[2],date[6],date[3],date[4],date[5]);
        }
        else{
            if (date.length==3) {
                System.out.printf("剩余时间：%02d时 %02d分 %02d秒\n",date[0],date[1],date[2]);
            }
            else{
                System.out.printf("您设置的闹钟是：%02d时 %02d分\n",date[0],date[1]);
            }
            
        }
    }

    //transer the ms to normal time
    public static int[] transerform(long millisecond){
        int[] countdown_time = new int[3];
        countdown_time[0] = (int)((millisecond % (24 * 60 * 60 * 1000))) / (60 * 60 * 1000);//hour
        countdown_time[1] = (int)((millisecond % (60 * 60 * 1000)) / (60 * 1000));//minutes
        countdown_time[2] = (int)((millisecond % (60 * 1000)) / 1000);//minutes
        return countdown_time;
    }

    // 将日期时间格式转换为数组
    public static int[] toArr(LocalDateTime currentDateTime) {
        int[] date = new int[7]; // 初始化数组
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date[0] = currentDateTime.getYear();
        date[1] = currentDateTime.getMonthValue();
        date[2] = currentDateTime.getDayOfMonth();
        date[3] = currentDateTime.getHour();
        date[4] = currentDateTime.getMinute();
        date[5] = currentDateTime.getSecond();
        date[6] = currentDateTime.getDayOfWeek().getValue();
        return date;
    }

    //贪睡模式修改时间
    public static int[] moresleep(int[] date){
        if (date[1]+10>=60) {
            date[1] = (date[1]+10)%60;
            date[0] = date[0] + 1;
            if (date[0]>=24) {
                date[0] = date[0] % 24;
            }  
        }
        else{
            date[1] = (date[1]+10);
        }
        return date;
    }

    //int型数值星期数转换为中文字符
    public static String weekday(int week){
        String chinaNum = "错误";
        switch (week) {
            case 1:
                chinaNum = "一";
                break;
            case 2:
                chinaNum = "二";
                break;
            case 3:
                chinaNum = "三";
                break;
            case 4:
                chinaNum = "四";
                break;
            case 5:
                chinaNum = "五";
                break;
            case 6:
                chinaNum = "六";
                break;
                case 7:
                chinaNum = "日";
            default:
                break;
        }
        return chinaNum;
    }
}

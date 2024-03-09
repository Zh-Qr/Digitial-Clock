import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.Scanner;

public class timeZone {
    public static void main(String[] args){
        System.out.println("this is timeZone file");
    }
    public static String get_zone(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String zone_id=null;
        System.out.println("input the time zone:\n1.Coordinated Universal Time，UTC 格林尼治标准时间\n"+
        "2.China Standard Time，CST 中国标准时间\n"+
        "3.Asia/Tokyo 日本标准时间\n"+
        "4.Pacific/Guadalcanal 所罗门群岛时间\n"+
        "5.Asia/Kolkata 印度标准时间\n"+
        "6.Europe/Berlin 欧洲中部时间\n"+
        "7.Australia/Sydney 澳大利亚东部标准时间\n"+
        "8.Australia/Adelaide 澳大利亚中部标准时间\n"+
        "9.America/New_York 东部标准时间\n"+
        "10.America/Los_Angeles 太平洋标准时间\n"+
        "11.Africa/Johannesburg 南非标准时间");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                zone_id = "UTC";
                System.out.println("Coordinated Universal Time，UTC 格林尼治标准时间");
                break;
            case 2:
                zone_id = "Asia/Shanghai";
                System.out.println("China Standard Time，CST 中国标准时间 ");
                break;
            case 3:
                zone_id = "Asia/Tokyo";
                System.out.println("Asia/Tokyo 日本标准时间 ");
                break;
            case 4:
                zone_id = "Pacific/Guadalcanal";
                System.out.println("Pacific/Guadalcanal 所罗门群岛时间 ");
                break;
            case 5:
                zone_id = "Asia/Kolkata";
                System.out.println("Asia/Kolkata 印度标准时间 ");
                break;
            case 6:
                zone_id = "Europe/Berlin";
                System.out.println("Europe/Berlin 欧洲中部时间 ");
                break;
            case 7:
                zone_id = "Australia/Sydney";
                System.out.println("Australia/Sydney 澳大利亚东部标准时间 ");
                break;
            case 8:
                zone_id = "Australia/Adelaide";
                System.out.println("Australia/Adelaide 澳大利亚中部标准时间 ");
                break;
            case 9:
                zone_id = "America/New_York";
                System.out.println("America/New_York 东部标准时间 ");
                break;
            case 10:
                zone_id = "America/Los_Angeles";
                System.out.println("America/Los_Angeles 太平洋标准时间 ");
                break;
            case 11:
                zone_id = "Africa/Johannesburg";
                System.out.println("Africa/Johannesburg 南非标准时间 ");
                break;
            default:
                break;
        }
        return zone_id;
    }

    public static int[] get_zone_time(String zone_id){
        ZonedDateTime currentDateTime = ZonedDateTime.now(TimeZone.getTimeZone(zone_id).toZoneId());
        int[] date = new int[7]; // 初始化数组
        LocalDateTime DateTime = currentDateTime.toLocalDateTime();
        date = utils.toArr(DateTime);
        return date;
    }

    public static String indexId(int index){
        switch (index) {
            case 1:
                return "UTC";
            case 2:
                return "Asia/Shanghai";
            case 3:
                return "Asia/Tokyo";
            case 4:
                return "Pacific/Guadalcanal";
            case 5:
                return "Asia/Kolkata";
            case 6:
                return "Europe/Berlin";
            case 7:
                return "Australia/Sydney";
            case 8:
                return "Australia/Adelaide";
            case 9:
                return "America/New_York";
            case 10:
                return "America/Los_Angeles";
            case 11:
                return "Africa/Johannesburg";
            default:
                return "error";
        }
    }

    public static int[] get_local_time(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int[] date = new int[7]; // 初始化数组
         date = utils.toArr(currentDateTime);
        return date;
    }

}

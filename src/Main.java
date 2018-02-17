
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");
        System.out.println("Today's Date: " + LocalDateTime.now());
        tomorrowsDate();

    }

    private static void tomorrowsDate() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow=today.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = tomorrow.format(formatter);
        System.out.println("Tomorrow's Date:" +formatDateTime);
    }
}


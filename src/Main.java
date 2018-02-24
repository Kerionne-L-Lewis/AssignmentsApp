
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");
        today();
        tomorrowsDate();
        fiveWksAdded();
        LocalDateTime borndate = LocalDateTime.of(1996, 10, 10,
                12, 35);
        birthday(borndate);
        daysBeenAlive(borndate);


    }

    private static void daysBeenAlive(LocalDateTime borndate) {
        LocalDateTime today= LocalDateTime.now();
        long daysAlive= ChronoUnit.DAYS.between(borndate,today);
        System.out.println("The number of days I've been alive "+ daysAlive);
    }

    private static void birthday(LocalDateTime borndate) {
        System.out.println("The day of the week I was born on is " + DayOfWeek.from(borndate));
    }

    private static void fiveWksAdded() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime fiveWeeks = today.plusWeeks(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = fiveWeeks.format(formatter);
        System.out.println("Add Five Weeks to today's Date " + formatDateTime);
    }

    private static void tomorrowsDate() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = tomorrow.format(formatter);
        System.out.println("Tomorrow's Date:" + formatDateTime);
    }

    public static void today(){
        System.out.println("Today's Date: "+ LocalDateTime.now());
    }

}



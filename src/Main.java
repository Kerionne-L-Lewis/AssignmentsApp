
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        LocalDateTime today = LocalDateTime.now();
        System.out.println("Today's Date: " + today);

        LocalDateTime tomorrow = today.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = tomorrow.format(formatter);
        System.out.println("Tomorrow's Date:" + formatDateTime);


        LocalDateTime fiveWeeks = today.plusWeeks(5);
        String formatDateTime1 = fiveWeeks.format(formatter);
        System.out.println("Add Five Weeks to today's Date " + formatDateTime1);

        LocalDateTime borndate = LocalDateTime.of(1996, 10, 10,
                12, 35);
        birthday(borndate);
        daysBeenAlive(borndate, today);

        LocalDateTime date1 = LocalDateTime.of(2007, 5, 18, 3, 25);
        LocalDateTime date2 = LocalDateTime.of(1996, 10, 10, 6, 39);

        numDaysBetweenTwoDates(date1, date2);

        outputEarlierDate(date1, date2);

        randomToFile();
        ArrayList<String> datesFromFile = readFromAFile();
        System.out.println("Data stored from a file " + datesFromFile);

        outputNumberOfDates("2018",datesFromFile);

        countNumberOfDatesDuringYear("2018", datesFromFile);

        //Count the number of duplicates.use set

        Set<String> dupes= findDupes(datesFromFile);
        System.out.println("Here is the set "+ dupes);

      //  Map<String, Integer> countDuplicates=duplicatesCount()


    }

    private static Set<String> findDupes(ArrayList<String> datesFromFile) {
        Set<String> dateList=new HashSet<>();
        for (int i = 0; i <datesFromFile.size() ; i++) {

            dateList.add(datesFromFile.get(i));

        }
        return dateList;
    }

    private static void outputNumberOfDates(String s, ArrayList<String> datesFromFile) {
        for (int i = 0; i <datesFromFile.size() ; i++) {
            if (datesFromFile.=s){
                System.out.println(" The number of stored dates: " +datesFromFile.size() );
            }
        }
    }

    private static void countNumberOfDatesDuringYear(String year, ArrayList<String> datesFromFile) {
        int count = 0;
        for (int j = 0; j < datesFromFile.size(); j++) {
            if (datesFromFile.get(j)==year ) {
                count++;
            }
        }
        System.out.println("The number of stored dates in year "+ year + " is " +
                + count);
    }

    private static ArrayList<String> readFromAFile() {
        File infile = new File("Dates.txt");
        ArrayList<String> datesAndTimes = new ArrayList<>();
        try (Scanner sc = new Scanner(infile)) {
            while (sc.hasNext()) {
                String date = sc.next();
                System.out.println("Is this a date? " + date);

                String[] parts = date.split("/");
                for (int i = 0; i <parts.length ; i++) {
                    System.out.println("split " + i + "is" + parts[i]);
                }
                datesAndTimes.add(date);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return datesAndTimes;
    }

    private static void randomToFile() {
        File outfile = new File("Dates.txt");
        try (PrintWriter pw = new PrintWriter(outfile)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
            Random rand = new Random();
            for (int i = 0; i < 100; i++) {
                LocalDateTime currentDate = LocalDateTime.now();
                int nums = rand.nextInt(101);
                LocalDateTime k = currentDate.plusDays(nums);
                String formatDateTime = k.format(formatter);
                pw.println(formatDateTime);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void outputEarlierDate(LocalDateTime date1, LocalDateTime date2) {
        System.out.println("Is " + date1 + " before " + date2 + ": " + date1.isBefore(date2));
        System.out.println("Is " + date1 + " after " + date2 + ": " + date1.isAfter(date2));
        System.out.println(date1 + " compared to " + date2 + " is " + date1.compareTo(date2));
    }

    private static void numDaysBetweenTwoDates(LocalDateTime date1, LocalDateTime date2) {

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("The days between " + date1 + " and " + date2 + " is " + daysBetween);
    }

    private static void daysBeenAlive(LocalDateTime borndate, LocalDateTime today) {
        long daysAlive = ChronoUnit.DAYS.between(borndate, today);
        System.out.println("The number of days I've been alive " + daysAlive);
    }

    private static void birthday(LocalDateTime borndate) {
        System.out.println("The day of the week I was born on is " + DayOfWeek.from(borndate));
    }


}




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

        ArrayList<LocalDateTime> datesFromFile = readFromAFile();
        System.out.println("Data stored from a file " + datesFromFile);

        outputDates(datesFromFile, 2017);

        int numOfDates = countNumberOfDatesDuringYear(datesFromFile, LocalDateTime.now().getYear());
        System.out.println("The number of stored dates in year "
                + numOfDates);

        Set<LocalDateTime>count = findDupes(datesFromFile);
         System.out.println("Here is the set (" + count.size() + ")" + count);

         Map<LocalDateTime, Integer> countDupes = countingDupesInSet(datesFromFile);
         System.out.println("counting dupes: " + countDupes);

        Collections.sort(datesFromFile);
        System.out.println("Sorted " + datesFromFile);

         int dupeCounter= count(datesFromFile);
        System.out.println("Counting the Duplicates " + dupeCounter);


    }

   private static int count(ArrayList<LocalDateTime> datesFromFile) {
        int count = 0;
        for (int i = 0; i < datesFromFile.size(); i++) {
            findDupes(datesFromFile);
            count++;
        }
        return count;
    }


    private static Map<LocalDateTime, Integer> countingDupesInSet(ArrayList<LocalDateTime> datesFromFile) {
        Map<LocalDateTime, Integer> countingDupes = new HashMap<>();
        for (int i = 0; i < datesFromFile.size(); i++) {
            LocalDateTime dupe = datesFromFile.get(i);
            if (countingDupes.containsKey(dupe)) {
                int count = countingDupes.get(dupe);
                countingDupes.put(dupe, count + 1);
            } else {
                countingDupes.put(dupe, 1);
            }
        }
        return countingDupes;
    }

    private static Set<LocalDateTime> findDupes(ArrayList<LocalDateTime> datesFromFile) {
        Set<LocalDateTime> dateList=new HashSet<>();
        for (int i = 0; i < datesFromFile.size(); i++) {
            boolean value = dateList.add(datesFromFile.get(i));
            if (value==true){
                dateList.add(value);
            }
        }
        return dateList;
    }

    private static void outputDates(ArrayList<LocalDateTime> datesFromFile, int year) {
        ArrayList<LocalDateTime> numberOfStoredDatesInYear = new ArrayList<>();
        for (int i = 0; i < datesFromFile.size(); i++) {
                if (datesFromFile.get(i).getYear() == year) {
                    numberOfStoredDatesInYear.add(datesFromFile.get(i));
                }
        }
        System.out.println("Output the dates in the year " + numberOfStoredDatesInYear.size());
    }


    private static int countNumberOfDatesDuringYear(ArrayList<LocalDateTime> datesFromFile, int year) {
        int count = 0;
        for (int j = 0; j < datesFromFile.size(); j++) {
            if (datesFromFile.get(j).getYear() == year) {
                count++;
            }
        }
        return count;
    }

    private static ArrayList<LocalDateTime> readFromAFile() {
        File infile = new File("Dates.txt");
        ArrayList<LocalDateTime> datesAndTimes = new ArrayList<>();
        try (Scanner sc = new Scanner(infile)) {
            while (sc.hasNext()) {
                String date = sc.nextLine();

                String[] parts = date.split(" ");
                String[] partsDate = parts[0].split("/");
                String[] partsTime = parts[1].split(":");


                int year = Integer.parseInt(partsDate[0]);
                int month = Integer.parseInt(partsDate[1]);
                int day = Integer.parseInt(partsDate[2]);
                int hour = Integer.parseInt(partsTime[0]);
                int minute = Integer.parseInt(partsTime[1]);

                LocalDateTime temp = LocalDateTime.of(year, month, day, hour, minute);

                datesAndTimes.add(temp);

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




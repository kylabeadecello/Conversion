import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Monday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char response;
        do {
            setAndShowAlarm(scanner);
            System.out.print("\nDo you want to set another alarm? (Enter 'Y' for yes, 'N' for no): ");
            response = scanner.nextLine().toUpperCase().charAt(0);
        } while (response != 'N');
    }

    private static void setAndShowAlarm(Scanner scanner) {
        System.out.println("Local time is: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        String enteredAlarmTime = scanner.nextLine();
        
        MondayAlarm monday = new MondayAlarm();
        monday.setAlarm(enteredAlarmTime);
        monday.showAlarm();
    }
}

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday implements Alarm {
}

class MondayAlarm extends Weekday {
    private LocalDateTime alarmDateTime;

    @Override
    public void setAlarm(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime enteredAlarmTime = LocalTime.parse(time, formatter);
            LocalDateTime currentDateTime = LocalDateTime.now();

            LocalDateTime enteredAlarmDateTime = LocalDateTime.of(currentDateTime.toLocalDate(), enteredAlarmTime);

            if (enteredAlarmDateTime.isBefore(currentDateTime) || enteredAlarmDateTime.equals(currentDateTime)) {
                enteredAlarmDateTime = enteredAlarmDateTime.plusDays(1);
            }

            this.alarmDateTime = enteredAlarmDateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
        }
    }

    @Override
    public void showAlarm() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (alarmDateTime.isAfter(currentDateTime)) {
            if (alarmDateTime.minusMinutes(450).isBefore(currentDateTime)) {
                System.out.println("\n\tI'll wake you up later!");
                System.out.println("\t       .-.-.");
                System.out.println("\t  ((  (__I__)  ))");
                System.out.println("\t    .'_....._'.");
                System.out.println("\t   / / .12 . \\ \\");
                System.out.println("\t  | | '  |  ' | |");
                System.out.println("\t  | | 9  /  3 | |");
                System.out.println("\t   \\ \\ '.6.' / /");
                System.out.println("\t    '.`-...-'.");
                System.out.println("\t     /'-- --'\\");
                System.out.println("\t    `\"\"\"\"\"\"\"\"\"`");
            } else {
                System.out.println("\n\tAlarm is set for tomorrow!");
                System.out.println("\t       .-.-.");
                System.out.println("\t  ((  (__I__)  ))");
                System.out.println("\t    .'_....._'.");
                System.out.println("\t   / / .12 . \\ \\");
                System.out.println("\t  | | '  |  ' | |");
                System.out.println("\t  | | 9  /  3 | |");
                System.out.println("\t   \\ \\ '.6.' / /");
                System.out.println("\t    '.`-...-'.");
                System.out.println("\t     /'-- --'\\");
                System.out.println("\t    `\"\"\"\"\"\"\"\"\"`");
            }
        } else {
            System.out.println("\n\tI'll wake you up later!");
            System.out.println("\t       .-.-.");
            System.out.println("\t  ((  (__I__)  ))");
            System.out.println("\t    .'_....._'.");
            System.out.println("\t   / / .12 . \\ \\");
            System.out.println("\t  | | '  |  ' | |");
            System.out.println("\t  | | 9  /  3 | |");
            System.out.println("\t   \\ \\ '.6.' / /");
            System.out.println("\t    '.`-...-'.");
            System.out.println("\t     /'-- --'\\");
            System.out.println("\t    `\"\"\"\"\"\"\"\"\"`");

        }
    }
}


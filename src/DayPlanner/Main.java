package DayPlanner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {

        int choice;
        HashMap<LocalDateTime, Event> map = new HashMap<LocalDateTime, Event>();
        EventProcessing eventProcessing = new EventProcessing();

        try {
            do {
                choice = InputData.mainMenu();

                switch (choice) {
                    case 1:
                        FileHandler reader = new FileHandler();
                        eventProcessing.setEvents(reader.readFromFile());
                        System.out.println("Done!");
                        break;
                    case 2:
                        eventProcessing.printListOfEvents();
                        break;
                    case 3:
                        map = eventProcessing.add(InputData.inputEventFromConsole());
                        eventProcessing.setEvents(map);
                        System.out.println("Done!\n");
                        break;
                    case 4:
                        map = eventProcessing.delete(InputData.inputDateFromConsole());
                        eventProcessing.setEvents(map);
                        System.out.println("Done!\n");
                        break;
                    case 5:
                        map = eventProcessing.edit();
                        eventProcessing.setEvents(map);
                        System.out.println("Done!\n");
                        break;
                    case 6:
                        eventProcessing.printDayCalendar();
                        break;
                    case 7:
                        eventProcessing.printMonthCalendar();
                        break;
                    case 8:
                        System.out.println("Do you want to save changes to the file?");
                        System.out.println("Enter Yes or No:");
                        String str = InputData.inputFromConsole().toUpperCase();
                        if (str.equals("YES")) {
                            FileHandler writer = new FileHandler();
                            writer.writeToFile(map);
                            System.out.println("Done!");
                        }
                }
            } while (choice != 8);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


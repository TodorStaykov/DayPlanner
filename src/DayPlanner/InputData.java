package DayPlanner;

import DayPlanner.Enums.*;
import DayPlanner.Exceptions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.*;

public class InputData {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Event inputEventFromConsole() throws IOException {

        System.out.println("\t\tEnter new event:");
        Type type;
        while (true) {
            System.out.println("Enter type:");
            try {
                String enteredType=br.readLine().toUpperCase();
                if(Validator.validateType(enteredType)){
                    type = Type.valueOf(enteredType);
                    break;
                }
            } catch (InvalidEventType e) {
                System.out.println(e.getMessage());
            }
        }
        Marker marker;
        while (true) {
            System.out.println("Enter marker:");
            try {
                String enteredMarker=br.readLine().toUpperCase();
                if(Validator.validateMarker(enteredMarker)){
                    marker = Marker.valueOf(enteredMarker);
                    break;
                }
            } catch (InvalidEventMarker e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter date and hour(format:year-month-day hour:minutes)");
        String date = br.readLine();
        LocalDateTime dateTime = Validator.parseDate(date);

        System.out.println("Enter description:");
        String description = br.readLine();

        Event event = new Event(type, marker, dateTime, description);

        return event;
    }

    static LocalDateTime inputDateFromConsole() throws IOException {

        System.out.println("Enter date and hour(format:year-month-day hour:minutes):");
        String date = br.readLine();

        LocalDateTime dateTime = Validator.parseDate(date);

        return dateTime;
    }

    public static int mainMenu() throws IOException {

        int command;

        System.out.println("\n//////////// Day Planner ////////////");
        System.out.println(".....................................");
        System.out.println("  1.Read events from file");
        System.out.println("  2.Print list of events");
        System.out.println("  3.Add event");
        System.out.println("  4.Delete event");
        System.out.println("  5.Edit event");
        System.out.println("  6.Print day calendar");
        System.out.println("  7.Print month calendar");
        System.out.println("  8.Quit");


        System.out.println("Choose your selection:");
        command = Integer.parseInt(br.readLine());

        if (command < 1 || command > 8) {
            try {
                throw new WrongChoiceException("Wrong choice! You must enter a number between 1 and 8!");
            } catch (WrongChoiceException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

        return command;
    }

    public static int editMenu() throws IOException {

        int command;

        System.out.println("Which one do you want to edit?\n");
        System.out.println("1. Date");
        System.out.println("2. Type");
        System.out.println("3. Marker");
        System.out.println("4. Description");
        System.out.println("5. Quit");

        System.out.println("Choose your selection:");
        command = Integer.parseInt(br.readLine());

        if (command < 1 || command > 5) {
            try {
                throw new WrongChoiceException("Wrong choice! You must enter a number between 1 and 5!\n");
            } catch (WrongChoiceException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        return command;
    }

    static String inputFromConsole() throws IOException {

        return br.readLine();
    }
}
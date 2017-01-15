package DayPlanner;

import DayPlanner.Enums.*;
import DayPlanner.Exceptions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

class EventProcessing implements IEventProcessing {

    private HashMap<LocalDateTime, Event> events=new HashMap<LocalDateTime,Event>();

    public void setEvents(HashMap<LocalDateTime, Event> events) {
        this.events = events;
    }

    @Override
    public void printListOfEvents() {

        System.out.println("List of events:\n");
        for (Map.Entry<LocalDateTime, Event> event : this.events.entrySet()) {
            OutputData.printList(event);
        }

    }

    @Override
    public HashMap<LocalDateTime, Event> add(Event event) {

        events.put(event.getDate(), event);

        return events;
    }

    @Override
    public HashMap<LocalDateTime, Event> delete(LocalDateTime dateTime) throws IOException {

        if (events.containsKey(dateTime)) {
            events.remove(dateTime);
        } else {
            System.out.println("This event does not exist!\n");
            events = delete(InputData.inputDateFromConsole());
        }
        return this.events;
    }

    @Override
    public HashMap<LocalDateTime, Event> edit() throws IOException {

        int choice;

        LocalDateTime dateTime = InputData.inputDateFromConsole();

        if (events.containsKey(dateTime)) {
            Event event = null;
            do {
                choice = InputData.editMenu();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new date:");
                        String newDate = InputData.inputFromConsole();

                        LocalDateTime parseDate = Validator.parseDate(newDate);
                        event = events.get(dateTime);
                        event.setDate(parseDate);
                        events.remove(dateTime);
                        events.put(parseDate, event);
                        break;
                    case 2:
                        Type newType;
                        while (true) {
                            System.out.println("Enter new type:");
                            try {
                                String enteredType=InputData.inputFromConsole().toUpperCase();
                                if(Validator.validateType(enteredType)){
                                    newType = Type.valueOf(enteredType);
                                    break;
                                }
                            } catch (InvalidEventType e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        event = events.get(dateTime);
                        event.setType(newType);
                        events.remove(dateTime);
                        events.put(dateTime, event);
                        break;
                    case 3:
                        Marker newMarker;
                        while (true) {
                            System.out.println("Enter new marker:");
                            try {
                                String enteredMarker=InputData.inputFromConsole().toUpperCase();
                                if(Validator.validateMarker(enteredMarker)){
                                    newMarker = Marker.valueOf(enteredMarker);
                                    break;
                                }
                            } catch (InvalidEventMarker e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        event = events.get(dateTime);
                        event.setMarker(newMarker);
                        events.remove(dateTime);
                        events.put(dateTime, event);
                        break;
                    case 4:
                        System.out.println("Enter new description:");
                        String newDescription = InputData.inputFromConsole();
                        event = events.get(dateTime);
                        event.setDescription(newDescription);
                        events.remove(dateTime);
                        events.put(dateTime, event);
                        break;
                }
            } while (choice != 5);
        } else {
            System.out.println("This event does not exist!\n");
            events = delete(InputData.inputDateFromConsole());
        }
        return events;
    }

    @Override
    public void printDayCalendar() throws IOException {

        System.out.println("Enter day:");
        int day = Integer.parseInt(InputData.inputFromConsole());

        System.out.println("Enter month:");
        String month = InputData.inputFromConsole();

        System.out.println("Enter year:");
        int year = Integer.parseInt(InputData.inputFromConsole());

        System.out.format("\nDate: %s-%s-%s\n", day, month.toUpperCase(), year);
        OutputData.printTable();

        for (Map.Entry<LocalDateTime, Event> event : events.entrySet()) {

            LocalDateTime monthCalendar = event.getKey();

            if (monthCalendar.getDayOfMonth() == day &&
                    monthCalendar.getMonth().toString().substring(0, 3).equals(month.toUpperCase()) &&
                    monthCalendar.getYear() == year) {

                OutputData.colorPrint(event);
            }
        }
    }

    @Override
    public void printMonthCalendar() throws IOException {

        System.out.println("Enter month:");
        String month = InputData.inputFromConsole();

        System.out.println("Enter year:");
        int year = Integer.parseInt(InputData.inputFromConsole());

        System.out.format("\nDate: %s-%s\n", month.toUpperCase(), year);
        OutputData.printTable();

        for (Map.Entry<LocalDateTime, Event> event : events.entrySet()) {

            LocalDateTime monthCalendar = event.getKey();

            if (monthCalendar.getMonth().toString().substring(0,3).equals(month.toUpperCase()) && monthCalendar.getYear() == year) {

                OutputData.colorPrint(event);
            }
        }
    }
}
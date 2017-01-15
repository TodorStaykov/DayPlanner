package DayPlanner;

import DayPlanner.Exceptions.*;
import DayPlanner.Exceptions.InvalidEventType;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Validator {

    public static boolean validateType(String type) throws InvalidEventType {
        if(type.toUpperCase().equals("TASK") || type.toUpperCase().equals("MEETING")){
            return true;
        }
        throw new InvalidEventType("Error! Type of the event must be task or meeting.");
    }

    public static boolean validateMarker(String type) throws InvalidEventMarker {
        if(type.toUpperCase().equals("PUBLIC") || type.toUpperCase().equals("PERSONAL")|| type.toUpperCase().equals("CONFIDENTIAL")){
            return true;
        }
        throw new InvalidEventMarker("Error! Marker of the event must be public, personal or confidential.");
    }


    static LocalDateTime parseDate(String date) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parseDate;
        try {
            parseDate = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error! Format must be: year-month-day hour:minutes\n");
            parseDate = InputData.inputDateFromConsole();
        }

        return parseDate;
    }

}



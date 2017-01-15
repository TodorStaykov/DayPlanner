package DayPlanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class OutputData {

    static void printList(Map.Entry<LocalDateTime, Event> event) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm", Locale.ENGLISH);
        String format = "%s      %-12s %-16s %-20s";

        System.out.printf(format, event.getValue().getDate().format(formatter), event.getValue().getType(),
                event.getValue().getMarker(),
                event.getValue().getDescription());
        System.out.println();
    }

    static void colorPrint(Map.Entry<LocalDateTime, Event> event) {

        char escapeChar = (char) 27;
        String blue = "[34m";
        String red = "[31m";
        String clearFormat = "[0m";

        if (event.getValue().getType().toString().equals("TASK")) {

            System.out.format("| " + escapeChar + red + "%-15s" + escapeChar + clearFormat + " | " + escapeChar +
                            red + "%-15s" + escapeChar + clearFormat + " | " + escapeChar +
                            red + "%-103s" + escapeChar + clearFormat + " |%n", event.getValue().getType(),
                    event.getValue().getMarker(), event.getValue().getDescription());
            System.out.format("+-----------------+-----------------+---------------------------------------------------------------------------------------------------------+%n");
        } else {
            System.out.format("| " + escapeChar + blue + "%-15s" + escapeChar + clearFormat + " | " + escapeChar +
                            blue + "%-15s" + escapeChar + clearFormat + " | " + escapeChar +
                            blue + "%-103s" + escapeChar + clearFormat + " |%n", event.getValue().getType(),
                    event.getValue().getMarker(), event.getValue().getDescription());
            System.out.format("+-----------------+-----------------+---------------------------------------------------------------------------------------------------------+%n");
        }
    }

    static void printTable() {
        System.out.format("+-----------------+-----------------+---------------------------------------------------------------------------------------------------------+%n");
        System.out.format("|      Type       |     Marker      |                                            Description                                                  |%n");
        System.out.format("+-----------------+-----------------+---------------------------------------------------------------------------------------------------------+%n");
    }
}

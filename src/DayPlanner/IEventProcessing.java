package DayPlanner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public interface IEventProcessing {

    HashMap<LocalDateTime, Event> add(Event event);

    HashMap<LocalDateTime, Event> delete(LocalDateTime dateTime) throws IOException;

    HashMap<LocalDateTime, Event> edit() throws IOException;

    void printListOfEvents();

    void printDayCalendar() throws IOException;

    void printMonthCalendar() throws IOException;


}

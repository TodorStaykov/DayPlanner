package DayPlanner;

import DayPlanner.Enums.Marker;
import DayPlanner.Enums.Type;

import java.time.LocalDateTime;

public class Event {

    private Type type;
    private Marker marker;
    private LocalDateTime date;
    private String description;

    public Event(Type type, Marker marker, LocalDateTime date, String description)  {
        this.setType(type);
        this.setMarker(marker);
        this.setDate(date);
        this.setDescription(description);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type)  {

        this.type = type;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {

        this.marker = marker;

    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

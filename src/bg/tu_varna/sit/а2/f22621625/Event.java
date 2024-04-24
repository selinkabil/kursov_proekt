package bg.tu_varna.sit.à2.f22621625;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Event {
    private String name;
    private String date;
    private Hall hall;

    public Event(String name, String date, Hall halls) {
        this.name = name;
        this.date = date;
        this.hall = halls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Hall getHalls() {
        return hall;
    }

    public void setHalls(Hall hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nEvent\n");
        sb.append("name: '").append(name).append("'");
        sb.append(",\n");
        sb.append("date: '").append(date).append("'");
        sb.append(",\n");
        sb.append("hall: '").append(hall).append("'");
        return sb.toString();
    }
}

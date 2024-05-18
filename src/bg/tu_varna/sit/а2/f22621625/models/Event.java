package bg.tu_varna.sit.à2.f22621625.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Event {
    private String name;
    private Date date;
    private Hall hall;

    public Event(String name, Date date, Hall halls) {
        this.name = name;
        this.date=date;
        this.hall = halls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!Objects.equals(name, event.name)) {
            return false;
        } else {
            if (!Objects.equals(date, event.date)) return false;
            return Objects.equals(hall, event.hall);
        }
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Hall getHalls() {
        return hall;
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

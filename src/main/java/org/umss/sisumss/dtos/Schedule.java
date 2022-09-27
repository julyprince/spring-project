package org.umss.sisumss.dtos;

import java.time.DayOfWeek;

public class Schedule {
    private DayOfWeek dayOfWeek;
    private String start;
    private String end;
    public Schedule(DayOfWeek dayOfWeek, String start, String end) {
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

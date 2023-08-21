package com.frederic.classpage.models;

import java.util.List;

public class CourseSchedule {
    private List<String> daysOfWeek;
    private List<List<String>> timeSlots;

    public CourseSchedule(List<String> daysOfWeek, List<List<String>> timeSlots) {
        this.daysOfWeek = daysOfWeek;
        this.timeSlots = timeSlots;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public List<List<String>> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<List<String>> timeSlots) {
        this.timeSlots = timeSlots;
    }
}

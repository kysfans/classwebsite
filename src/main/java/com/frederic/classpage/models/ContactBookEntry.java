package com.frederic.classpage.models;

public class ContactBookEntry {
    private String studentName;
    private String task;
    private String message;

    public ContactBookEntry(String studentName, String task, String message) {
        this.studentName = studentName;
        this.task = task;
        this.message = message;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

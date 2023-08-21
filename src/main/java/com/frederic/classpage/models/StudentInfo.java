package com.frederic.classpage.models;

public class StudentInfo {
    private String studentName;
    private int studentId;
    // 其他屬性...

    public StudentInfo(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // 其他 getter 和 setter 方法...
}

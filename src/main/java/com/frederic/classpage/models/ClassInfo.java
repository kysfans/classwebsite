package com.frederic.classpage.models;

public class ClassInfo {
    private String className;
    private String classNumber;
    private String teacherName;

    public ClassInfo(String className, String classNumber, String teacherName) {
        this.className = className;
        this.classNumber = classNumber;
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

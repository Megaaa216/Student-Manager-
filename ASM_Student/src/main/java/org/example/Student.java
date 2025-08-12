package org.example;

public class Student {
    private String id;
    private String fullName;
    private double mark;

    public Student(String id, String fullName, double mark) {
        this.id = id;
        this.fullName = fullName;
        setMark(mark);
    }

    public String getRank() {
        double m = this.mark;
        if (m < 5.0) return "Fail";
        if (m < 6.5) return "Medium";
        if (m < 7.5) return "Good";
        if (m < 9.0) return "Very Good";
        return "Excellent";
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public double getMark() { return mark; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setMark(double mark) {
        if (mark < 0.0) mark = 0.0;
        if (mark > 10.0) mark = 10.0;
        this.mark = mark;
    }


    @Override
    public String toString() {
        return String.format("%s | %s | %.2f | %s", id, fullName, mark, getRank());
    }
}

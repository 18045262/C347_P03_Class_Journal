package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

public class Grade implements Serializable {
    private String grade;
    private Integer week;

    public Grade (String grade, Integer week){
        this.grade = grade;
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}

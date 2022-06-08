package com.eleks.framework.utils;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 128, nullable = false, unique = true)
    private String name;

    @Column(name = "salary", nullable = false)
    private String salary;

    @Column(name = "durationWorked", length = 2, nullable = false)
    private String durationWorked;

    @Column(name = "grade", length = 2, nullable = false)
    private String grade;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    public String getName() {
        return name;
    }

    public User() {
    }

    public User(String name, String salary, String durationWorked, String grade, String email) {
        this.name = name;
        this.salary = salary;
        this.durationWorked = durationWorked;
        this.grade = grade;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDurationWorked() {
        return durationWorked;
    }

    public void setDurationWorked(String durationWorked) {
        this.durationWorked = durationWorked;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

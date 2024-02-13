package org.codewithomar.project.model;

public class Person {
    private Integer id;
    private String first_name;
    private String middle_name;
    private String pa_surname;
    private String ma_surname;
    private String username;

    public Person() {
    }

    public Person(Integer id, String first_name, String middle_name, String pa_surname, String ma_surname, String username) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.pa_surname = pa_surname;
        this.ma_surname = ma_surname;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPa_surname() {
        return pa_surname;
    }

    public void setPa_surname(String pa_surname) {
        this.pa_surname = pa_surname;
    }

    public String getMa_surname() {
        return ma_surname;
    }

    public void setMa_surname(String ma_surname) {
        this.ma_surname = ma_surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", pa_surname='" + pa_surname + '\'' +
                ", ma_surname='" + ma_surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

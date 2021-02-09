package com.jacup101.weatherapi;

public class WeatherTime {
    private String date;
    private String time;
    private String desc;
    private String temp;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public WeatherTime(String date, String time, String desc, String temp) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.temp = temp;
    }
}

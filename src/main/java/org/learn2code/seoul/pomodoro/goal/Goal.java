package org.learn2code.seoul.pomodoro.goal;

import java.util.Date;

/**
 * Created by hector on 12/10/16.
 */
public class Goal {
    private int accomplished;
    private int remaining;
    private Date date;
    private String type;

    public Goal(){
    }

    public Goal(int accomplished, int remaining) {
        this.accomplished = accomplished;
        this.remaining = remaining;
    }

    public Goal(int accomplished, int remaining, Date date, String type) {
        this.accomplished = accomplished;
        this.remaining = remaining;
        this.date = date;
        this.type = type;
    }

    public int getAccomplished() {
        return accomplished;
    }

    public void setAccomplished(int accomplished) {
        this.accomplished = accomplished;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

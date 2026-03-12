package com.klef.fsad.exam;

import javax.persistence.*;

@Entity
@Table(name="booking")
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String date;
    private String status;

    public Booking() {}

    public Booking(String name, String date, String status)
    {
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDate()
    {
        return date;
    }

    public String getStatus()
    {
        return status;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
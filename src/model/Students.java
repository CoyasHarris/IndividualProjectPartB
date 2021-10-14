/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
/**
 *
 * @author Akaros
 */
public class Students {
    private int Stuid;
    private String Stlast;
    private String Stfirst;
    private Date Stdob;
    private float Stfees;

    public Students(int Stuid, String Stlast, String Stfirst, Date Stdob, float Stfees) {
        this.Stuid = Stuid;
        this.Stlast = Stlast;
        this.Stfirst = Stfirst;
        this.Stdob = Stdob;
        this.Stfees = Stfees;
    }

    public Students() {
    }

    public int getStuid() {
        return Stuid;
    }

    public void setStuid(int Stuid) {
        this.Stuid = Stuid;
    }

    public String getStlast() {
        return Stlast;
    }

    public void setStlast(String Stlast) {
        this.Stlast = Stlast;
    }

    public String getStfirst() {
        return Stfirst;
    }

    public void setStfirst(String Stfirst) {
        this.Stfirst = Stfirst;
    }

    public Date getStdob() {
        return Stdob;
    }

    public void setStdob(Date Stdob) {
        this.Stdob = Stdob;
    }

    public float getStfees() {
        return Stfees;
    }

    public void setStfees(float Stfees) {
        this.Stfees = Stfees;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.sql.Date;
/**
 *
 * @author Akaros
 */
public class Courses {
    private int Courseid;
    private String Ctitle;
    private String Cstream;
    private String Ctype;
    private Date Cstdate;
    private Date Cendate;

    public Courses(int Courseid, String Ctitle, String Cstream, String Ctype, Date Cstdate, Date Cendate) {
        this.Courseid = Courseid;
        this.Ctitle = Ctitle;
        this.Cstream = Cstream;
        this.Ctype = Ctype;
        this.Cstdate = Cstdate;
        this.Cendate = Cendate;
    }

    public Courses() {
    }

    public int getCourseid() {
        return Courseid;
    }

    public void setCourseid(int Courseid) {
        this.Courseid = Courseid;
    }

    public String getCtitle() {
        return Ctitle;
    }

    public void setCtitle(String Ctitle) {
        this.Ctitle = Ctitle;
    }

    public String getCstream() {
        return Cstream;
    }

    public void setCstream(String Cstream) {
        this.Cstream = Cstream;
    }

    public String getCtype() {
        return Ctype;
    }

    public void setCtype(String Ctype) {
        this.Ctype = Ctype;
    }

    public Date getCstdate() {
        return Cstdate;
    }

    public void setCstdate(Date Cstdate) {
        this.Cstdate = Cstdate;
    }

    public Date getCendate() {
        return Cendate;
    }

    public void setCendate(Date Cendate) {
        this.Cendate = Cendate;
    }
    
    

}

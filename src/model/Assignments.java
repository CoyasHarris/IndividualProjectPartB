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
public class Assignments {
    private int Assid;
    private String Asstitle;
    private String Assdescr;
    private Date subDate;
    private Integer OralMark;
    private Integer TotalMark;
    private int CourseId;

    public Assignments(int Assid, String Asstitle, String Assdescr, Date subDate, Integer OralMark, Integer TotalMark, int CourseId) {
        this.Assid = Assid;
        this.Asstitle = Asstitle;
        this.Assdescr = Assdescr;
        this.subDate = subDate;
        this.OralMark = OralMark;
        this.TotalMark = TotalMark;
        this.CourseId = CourseId;
    }

    

    public Assignments() {
    }

    public int getAssid() {
        return Assid;
    }

    public void setAssid(int Assid) {
        this.Assid = Assid;
    }

    public String getAsstitle() {
        return Asstitle;
    }

    public void setAsstitle(String Asstitle) {
        this.Asstitle = Asstitle;
    }

    public String getAssdescr() {
        return Assdescr;
    }

    public void setAssdescr(String Assdescr) {
        this.Assdescr = Assdescr;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public Integer getOralMark() {
        return OralMark;
    }

    public void setOralMark(Integer OralMark) {
        this.OralMark = OralMark;
    }

    public Integer getTotalMark() {
        return TotalMark;
    }

    public void setTotalMark(Integer TotalMark) {
        this.TotalMark = TotalMark;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }
    
    
}

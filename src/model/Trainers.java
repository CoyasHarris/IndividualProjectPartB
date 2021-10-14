/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Akaros
 */
public class Trainers {
    private int Trainerid;
    private String Trlast;
    private String Trfirst;
    private String Trsubject;

    public Trainers(int Trainerid, String Trlast, String Trfirst, String Trsubject) {
        this.Trainerid = Trainerid;
        this.Trlast = Trlast;
        this.Trfirst = Trfirst;
        this.Trsubject = Trsubject;
    }

    public Trainers() {
    }

    public int getTrainerid() {
        return Trainerid;
    }

    public void setTrainerid(int Trainerid) {
        this.Trainerid = Trainerid;
    }

    public String getTrlast() {
        return Trlast;
    }

    public void setTrlast(String Trlast) {
        this.Trlast = Trlast;
    }

    public String getTrfirst() {
        return Trfirst;
    }

    public void setTrfirst(String Trfirst) {
        this.Trfirst = Trfirst;
    }

    public String getTrsubject() {
        return Trsubject;
    }

    public void setTrsubject(String Trsubject) {
        this.Trsubject = Trsubject;
    }
    
    
      
    
}

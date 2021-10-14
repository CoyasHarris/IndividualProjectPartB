/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Trainers;
import utils.DbUtils;


public class TrainersDaoImpl implements TrainersDaoInter {

    @Override
    public void printAllTrainers() {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT *FROM TRAINERS";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int Trainerid = rs.getInt(1);
                String Trlast = rs.getString(2);
                String TrFirst = rs.getString(3);
                String Trsubject = rs.getString(4);
                System.out.println("Trainer ID:" + Trainerid + "/Last Name :" + Trlast + "/First Name :" + TrFirst + "/Subject :" + Trsubject + " ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                con.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    @Override
    public void PrintAllTrainersPerCourse() {
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT  COURSES.*,TRAINERS.TRLAST" +
            " FROM trainerspercourse,courses,TRAINERS" +
            " WHERE trainerspercourse.TRAINERID=TRAINERS.Trainerid" +
            " AND trainerspercourse.COURSEID=COURSES.COURSEID" +
            " ORDER BY trainerspercourse.Courseid;";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int Courseid = rs.getInt(1);
                String Ctitle = rs.getString(2);
                String Cstream = rs.getString(3);
                String Ctype = rs.getString(4);
                String Cstdate = rs.getString(5);
                String Cendate = rs.getString(6);
                String TrLast = rs.getString(7);

                System.out.println("Course ID:" + Courseid + "/Title :" + Ctitle + "/Stream :" + Cstream + 
                        "/Type :" + Ctype + "/Start Date:" + Cstdate + "/End Date" + Cendate + "/Trainer Last Name:" + TrLast);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                con.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public Trainers createTrainer(TrainersDaoImpl daoTr) {
        Scanner sc = new Scanner(System.in);
        String givenTrainer;


        System.out.println("Provide Trainer in the following form :\nLast Name/First Name / Subject");
        givenTrainer = sc.nextLine();
        String[] givenTrainerArray = givenTrainer.split("/");

        Trainers tr = new Trainers(daoTr.trainerLastAvailablePK(), givenTrainerArray[0].trim(), givenTrainerArray[1].trim(), givenTrainerArray[2].trim());

        return tr;
    }

    public int trainerLastAvailablePK() {
        int key = 0;
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT max(Trainerid) "
                + " FROM TRAINERS;";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                key = rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                con.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return key + 1;
    }

    public void insertTrainerToDB(Trainers Tr) {
        int Trid = Tr.getTrainerid();
        String TrLast = Tr.getTrlast();
        String TrFirst = Tr.getTrfirst();
        String TrSbj = Tr.getTrsubject();

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "INSERT INTO TRAINERS(TRAINERID,TRLAST,TRFIRST,TRSUBJECT)"
                + " VALUES" + "(" + Trid + "," + "'" + TrLast + "'" + "," + "'" + TrFirst + "'," + "'" + TrSbj + "');";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                con.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void insertTrainerPerCourse(CoursesDaoImpl daoCrse,TrainersDaoImpl daoTr) {
        Scanner sc = new Scanner(System.in);
        int Tr,Crs;
        System.out.println("Which of the following Trainers you want to add to a Course?\nPress:");
        daoTr.printAllTrainers();
        Tr=sc.nextInt();
        System.out.println("To which of the following Courses you want to add the Trainer?\nPress:");
        daoCrse.printAllCourses();
        Crs=sc.nextInt();
        

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "INSERT INTO TRAINERSPERCOURSE(TRAINERID,COURSEID)"
                + " VALUES("+Tr + "," + Crs + ");";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                con.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

}

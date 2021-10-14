/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assignments;
import utils.DbUtils;

/**
 *
 * @author Akaros
 */
public class AssignmentsDaoImpl implements AssignmentsDaoInter{

    @Override
    public void printAllAssignments() {
 

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT *FROM Assignments";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int Assid = rs.getInt(1);
                String Asstitle = rs.getString(2);
                String Assdescr = rs.getString(3);
                Date Subdate = rs.getDate(4);
                int OralMark = rs.getInt(5);
                int TotalMark=rs.getInt(6);
                
                System.out.println("Assignment ID :"+ Assid + " " + "/Assignment Title :" + Asstitle + " " +"/Assignment Descr :" +
                        Assdescr + " /Submission Date:" + Subdate + " /Oral Mark:" + OralMark + "/Total Mark:" + TotalMark);
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
    public void printAllAssignmentsPerCourse() {
    Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT COURSES.CTITLE,COURSES.CSTREAM,COURSES.CTYPE,ASSIGNMENTS.ASSTITLE,assignments.ASSDESCR,assignments.SUBDATE" +
            " FROM COURSES , ASSIGNMENTS\n" +
            " WHERE COURSES.COURSEID=ASSIGNMENTS.CourseId" +
            " ORDER BY COURSES.CTITLE;";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String cTitle = rs.getString(1);
                String cStream = rs.getString(2);
                String ctype = rs.getString(3);
                String assTitle = rs.getString(4);
                String assDescr = rs.getString(5);
                Date subDate = rs.getDate(6);
                
                
                
                System.out.println("Course Title:" + cTitle + "/Course Stream:" + cStream + "/Course Type:" + ctype + "/Assign Title: " +
                        assTitle + "/Assign Descr:" + assDescr + "/Submiss Date:" + subDate);
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
    public void printAllAssignmentsPerCoursePerStudent() {
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT ASSIGNMENTS.ASSTITLE,ASSIGNMENTS.ASSDESCR,COURSES.CTITLE,COURSES.CSTREAM,COURSES.CTYPE,STUDENTS.STLAST" +
            " FROM ASSIGNMENTS , STUDENTS ,STUPERCOURSE , COURSES" +
            " WHERE COURSES.COURSEID=ASSIGNMENTS.COURSEID" +
            " AND  STUPERCOURSE.STUDENTID=STUDENTS.STUID" +
            " AND STUPERCOURSE.COURSEID=COURSES.COURSEID" +
            " ORDER BY ASSIGNMENTS.ASSTITLE;";
        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String Asstitle = rs.getString(1);
                String AssDescr = rs.getString(2);
                String Ctitle = rs.getString(3);
                String Cstream = rs.getString(4);
                String Ctype=rs.getString(5);
                String StLast = rs.getString(6);
                
                
                
                System.out.println("Assign Title :" + Asstitle + "/Assign Description:" + AssDescr + "/Course Title:" 
                        + Ctitle + "/Course Stream:" + Cstream + "/Student Last name:" + StLast );
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
    public Assignments createAssignment(AssignmentsDaoImpl daoAs,CoursesDaoImpl daoCrse) {
        Scanner sc = new Scanner(System.in);
        String givenAssignment;
        String givenAssSubDate;
        int crse;

        System.out.println("Provide Assignment in the following form :\nAssginment Title/Assignment Description ");
        givenAssignment = sc.nextLine();
        String[] givenAssignmentArray = givenAssignment.split("/");
        System.out.println("Provide Assignment Submission Date on the following form(YYYY-MM-DD)");
        givenAssSubDate = (sc.nextLine());
        String[] givenStudentDobArray = givenAssSubDate.split("-");
        LocalDate ld
                = LocalDate.of(Integer.parseInt(givenStudentDobArray[0]), Integer.parseInt(givenStudentDobArray[1]), Integer.parseInt(givenStudentDobArray[2]));

        Date dt1 = Date.valueOf(ld);
        
        System.out.println("Choose Course to Assign it to");
        daoCrse.printAllCourses();
        crse= sc.nextInt();
        
        Assignments as = new Assignments(daoAs.AssignmentLastAvailablePK(), givenAssignmentArray[0].trim(), givenAssignmentArray[1].trim(), dt1,null ,null,crse);
        return as;
        
        
        
    }

    @Override
    public int AssignmentLastAvailablePK() {
        int key = 0;
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT max(Assid) "
                + " FROM ASSIGNMENTS;";

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

    @Override
    public void InsertAssignmentToDB(Assignments As) {
        int AssId = As.getAssid();
        String Asstitle = As.getAsstitle();
        String AssDesc= As.getAssdescr();
        Date ld = As.getSubDate();
        Integer Oral= As.getOralMark();
        Integer Total = As.getTotalMark();
        int CrseId=As.getCourseId();
        
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "INSERT INTO ASSIGNMENTS(ASSID,ASSTITLE,ASSDESCR,SUBDATE,ORALMARK,TOTALMARK,COURSEID)"
                + " VALUES" + "(" + AssId + "," + "'" + Asstitle + "'" + "," + "'" + AssDesc + "'," + "'" + ld + "'," + Oral + "," +Total + "," + CrseId+");";
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
    


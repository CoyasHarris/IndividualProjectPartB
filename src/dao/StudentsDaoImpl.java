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
import model.Students;
import utils.DbUtils;


public class StudentsDaoImpl implements StudentsDaoInt {

    private static model.Students st;

    @Override
    public void PrintAllStudents() {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT *FROM STUDENTS";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int Stuid = rs.getInt(1);
                String Stlast = rs.getString(2);
                String Stfirst = rs.getString(3);
                Date Stdob = rs.getDate(4);
                float Stfees = rs.getFloat(5);
                System.out.println("Student ID:" + Stuid + "/Last name:" + Stlast + "/First Name:" 
                        + Stfirst + "/DoB:" + Stdob + "/Fees:" + Stfees);
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
    public void PrintAllStudentsPerCourse() {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT COURSES.CTITLE,COURSES.CSTREAM,COURSES.CTYPE,STUDENTS.STLAST,STUDENTS.STFIRST "
                + " FROM STUPERCOURSE,COURSES,STUDENTS"
                + " WHERE STUPERCOURSE.STUDENTID=STUDENTS.STUID"
                + " AND STUPERCOURSE.COURSEID=COURSES.COURSEID"
                + " ORDER BY STUPERCOURSE.Courseid;";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String Ctitle = rs.getString(1);
                String Cstream = rs.getString(2);
                String Ctype = rs.getString(3);

                String Stlast = rs.getString(4);
                String Stfirst = rs.getString(5);

                System.out.println("Course Title:" + Ctitle + "/Stream:" + Cstream + "/Type:" + Ctype + "/Student Last Name:" + Stlast + "/Student First Name:" + Stfirst);
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
    public void PrintStudentsBelongToMoreThanOneCourse() {
        Connection con = null;
        ResultSet rs = null;
       Statement st = null;
        String sql = "SELECT STUDENTID ,STUDENTS.STLAST,STUDENTS.STFIRST"
                + " FROM STUPERCOURSE, STUDENTS"
                + " WHERE STUDENTS.STUID=STUPERCOURSE.STUDENTID"
                + " GROUP BY STUDENTID"
                + " HAVING COUNT(STUDENTID)>1"
                + " ORDER BY STUDENTID;";

        try {
            con = DbUtils.getConnection();
            st = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {

                String studentId = rs.getString(1);
                String StLast = rs.getString(2);
                String StFirst = rs.getString(3);

                System.out.println(studentId + " " + StLast + " " + StFirst);
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
    public void insertStudentToDB(Students st) {
        int stuid = st.getStuid();
        String stLast = st.getStlast();
        String stFirst = st.getStfirst();
        Date ld = st.getStdob();
        float stFees = st.getStfees();

        Connection con = null;
        ResultSet rs = null;
        Statement sta = null;
        String sql = "INSERT INTO STUDENTS(STUID,STLAST,STFIRST,STDOB,STFEES)"
                + " VALUES" + "(" + stuid + "," + "'" + stLast + "'" + "," + "'" + stFirst + "'," + "'" + ld + "'," + stFees + ");";

        try {
            con = DbUtils.getConnection();
            sta = con.createStatement();

        } catch (SQLException ex) {

        }

        try {
            sta.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                con.close();
                sta.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    @Override
    public int studentLastAvailablePK() {
        int key = 0;
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT max(STUID) "
                + " FROM STUDENTS;";

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
    public Students createStudent(StudentsDaoImpl daoStu) {

        Scanner sc = new Scanner(System.in);
        String givenStudentus;
        String givenStudentDob;

        System.out.println("Provide Students in the following form :\nLast Name/First Name / Tuition Fees");
        givenStudentus = sc.nextLine();
        String[] givenStudentusArray = givenStudentus.split("/");
        System.out.println("Provide Student Date of birth on the following form(YYYY-MM-DD)");
        givenStudentDob = (sc.nextLine());
        String[] givenStudentDobArray = givenStudentDob.split("-");
        LocalDate ld
                = LocalDate.of(Integer.parseInt(givenStudentDobArray[0]), Integer.parseInt(givenStudentDobArray[1]), Integer.parseInt(givenStudentDobArray[2]));

        Date dt1 = Date.valueOf(ld);
        Students st = new Students(daoStu.studentLastAvailablePK(), givenStudentusArray[0].trim(), givenStudentusArray[1].trim(), dt1, Float.parseFloat(givenStudentusArray[2].trim()));

        return st;
    }

    @Override
    public void insertStudentsPerCourse(CoursesDaoImpl daoCrse, StudentsDaoImpl daoSt) {
        Scanner sc = new Scanner(System.in);
        int St, Crs;
        System.out.println("Which of the following Students you want to add to a Course?\nPress:");
        daoSt.PrintAllStudents();
        St = sc.nextInt();
        System.out.println("To which of the following Courses you want to add the Trainer?\nPress:");
        daoCrse.printAllCourses();
        Crs = sc.nextInt();

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "INSERT INTO STUPERCOURSE(STUDENTID,COURSEID)"
                + " VALUES(" + St + "," + Crs + ");";
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

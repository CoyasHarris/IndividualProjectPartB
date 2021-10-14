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
import model.Courses;
import utils.DbUtils;

/**
 *
 * @author Akaros
 */
public class CoursesDaoImpl implements CoursesDaoInter {

    @Override
    public void printAllCourses() {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT *FROM Courses";

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
                Date Cstdate = rs.getDate(5);
                Date Cendate = rs.getDate(6);

                System.out.println(Courseid + ". " + "Course Title :" + Ctitle + "/Course Stream:" + Cstream + "/Course Type :"
                        + Ctype + "/Course Start Date :" + Cstdate + "/Course End Date :" + Cendate);
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
    public Courses createCourse(CoursesDaoImpl daoCrse) {
        Scanner sc = new Scanner(System.in);
        String givenCourse;
        String givenCourseStartDate;
        String givenCourseEndDate;

        System.out.println("Provide COURSE in the following form :\nCourse Title/Course Stream/Course Type");
        givenCourse = sc.nextLine();
        String[] givenCourseArray = givenCourse.split("/");
        System.out.println("Provide COURSE START DATE on the following form(YYYY-MM-DD)");
        givenCourseStartDate = (sc.nextLine());
        String[] givenCourseStartDateArray = givenCourseStartDate.split("-");
        LocalDate ld1
                = LocalDate.of(Integer.parseInt(givenCourseStartDateArray[0]), Integer.parseInt(givenCourseStartDateArray[1]), Integer.parseInt(givenCourseStartDateArray[2]));

        Date dt1 = Date.valueOf(ld1);
        System.out.println("Provide COURSE END DATE on the following form(YYYY-MM-DD)");
        givenCourseEndDate = (sc.nextLine());
        String[] givenCourseEndDateArray = givenCourseEndDate.split("-");
        LocalDate ld2
                = LocalDate.of(Integer.parseInt(givenCourseEndDateArray[0]), Integer.parseInt(givenCourseEndDateArray[1]), Integer.parseInt(givenCourseEndDateArray[2]));

        Date dt2 = Date.valueOf(ld2);

        Courses crs = new Courses(daoCrse.CoursesLastAvailablePK(), givenCourseArray[0].trim(), givenCourseArray[1].trim(), givenCourseArray[2].trim(), dt1, dt2);

        return crs;
    }

    @Override
    public int CoursesLastAvailablePK() {
        int key = 0;
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "SELECT max(Courseid) "
                + " FROM COURSES;";

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
    public void InsertCourseToDB(Courses Crse) {
        int courseId = Crse.getCourseid();
        String courseTitle = Crse.getCtitle();
        String courseStream = Crse.getCstream();
        String courseType = Crse.getCtype();
        Date courseStartDate = Crse.getCstdate();
        Date courseEndDate = Crse.getCendate();

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String sql = "INSERT INTO COURSES(COURSEID,CTITLE,CSTREAM,CTYPE,CSTDATE,CENDATE)"
                + " VALUES" + "(" + courseId + "," + "'" + courseTitle + "'" + "," + "'" + courseStream + "'," + "'" + courseType + "'," + "'" + courseStartDate + "'," + "'" + courseEndDate + "');";
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

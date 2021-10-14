/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Courses;


public interface CoursesDaoInter {
    
    public  void printAllCourses();
    public Courses createCourse(CoursesDaoImpl daoCrse);
    public int CoursesLastAvailablePK();
    public void InsertCourseToDB(Courses Crse);
}
    


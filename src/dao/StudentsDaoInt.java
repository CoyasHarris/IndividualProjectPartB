/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Students;


public interface StudentsDaoInt {

    public void PrintAllStudents();

    public void PrintAllStudentsPerCourse();

    public void PrintStudentsBelongToMoreThanOneCourse();

    public int studentLastAvailablePK();

    public Students createStudent(StudentsDaoImpl daoStu);

    public void insertStudentToDB(Students st);
    
    public void insertStudentsPerCourse(CoursesDaoImpl daoCrse,StudentsDaoImpl daoSt);
}

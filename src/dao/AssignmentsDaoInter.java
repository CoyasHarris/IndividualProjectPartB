/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Assignments;


public interface AssignmentsDaoInter {
    
    
    public void printAllAssignments ();
    public void printAllAssignmentsPerCourse();
    public void printAllAssignmentsPerCoursePerStudent();
    public Assignments createAssignment(AssignmentsDaoImpl daoAs,CoursesDaoImpl daoCrse);
    public int AssignmentLastAvailablePK();
    public void InsertAssignmentToDB(Assignments As);
}

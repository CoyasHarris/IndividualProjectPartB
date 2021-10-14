/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectpartb;

import dao.AssignmentsDaoImpl;
import dao.CoursesDaoImpl;
import dao.StudentsDaoImpl;
import dao.TrainersDaoImpl;
import java.util.Scanner;
import model.Assignments;
import model.Courses;
import model.Students;
import model.Trainers;

public class IndividualProjectPartB {

    
    public static void main(String[] args) {
        int answer;
        int ans;
        int ans3;
        int ans4;
        int ans5;
        
        Scanner sc = new Scanner(System.in);
     
        
        StudentsDaoImpl daoStu = new StudentsDaoImpl();
        TrainersDaoImpl daoTr = new TrainersDaoImpl();
        AssignmentsDaoImpl daoAss = new AssignmentsDaoImpl();
        CoursesDaoImpl daoCrse = new CoursesDaoImpl();

        
        System.out.println("Welcome to our Private school.");
        do {

            System.out.println("\nPlease press:\n 1.For All Students.\n"
                    + " 2.For All Trainers.\n 3.For All Assignments.\n 4.For All Courses\n 5.For All Students Per Course\n"
                    + " 6.For All Trainers Per Course \n 7.For All Assignments Per Course\n"
                    + " 8.For All Assignments Per Course Per Student \n 9.For Students that belong to more than one course");

            ans = sc.nextInt();

            switch (ans) {

                case 1:
                    System.out.println("All Students:");
                    daoStu.PrintAllStudents();
                    break;
                case 2:
                    System.out.println("All Trainers:");
                    daoTr.printAllTrainers();
                    break;
                case 3:
                    System.out.println("All Assignments :");
                    daoAss.printAllAssignments();
                    break;
                case 4:
                    System.out.println("All Courses :");
                    daoCrse.printAllCourses();
                    break;
                case 5:
                    System.out.println("All Students Per Course:");
                    daoStu.PrintAllStudentsPerCourse();
                    break;
                case 6:
                    System.out.println("All Trainers Per Course:");
                    daoTr.PrintAllTrainersPerCourse();
                    break;
                case 7:
                    System.out.println("All Assignments Per Course :");
                    daoAss.printAllAssignmentsPerCourse();
                    break;
                case 8:
                    System.out.println("All Assignments Per Course Per Student :");
                    daoAss.printAllAssignmentsPerCoursePerStudent();
                    break;
                case 9:
                    System.out.println("Students that belong to more than one course :");
                    daoStu.PrintStudentsBelongToMoreThanOneCourse();
                    break;
            }
            System.out.println("\nWould you like some more information ?\n1.YES\n2.NO");
            answer = sc.nextInt();
        } while (answer == 1);

        System.out.println("Would you like to make some changes to the Database?\n1.YES\n2.NO");
        ans5=sc.nextInt();
        if(ans5==1){
        do{
        System.out.println(
                 "\nPress:\n1.Create and Insert Student to DataBase."
                + "\n2.Create and Insert Trainer To Database.\n3."
                + "Create and Insert Assignment to DataBase.\n4."
                + "Create and Insert Course to Database.\n5.Relate an existing Trainer to an existing Course.\n6.Insert Students Per Course");
        ans3 = sc.nextInt();
        switch (ans3) {

            case 1:
                Students st = daoStu.createStudent(daoStu);
                daoStu.insertStudentToDB(st);
                break;
            case 2:
                Trainers tr = daoTr.createTrainer(daoTr);
                daoTr.insertTrainerToDB(tr);
                break;
            case 3:
                Assignments as = daoAss.createAssignment(daoAss, daoCrse);
                daoAss.InsertAssignmentToDB(as);
                break;
            case 4:
                Courses cr = daoCrse.createCourse(daoCrse);
                daoCrse.InsertCourseToDB(cr);
                break;
            case 5:
                daoTr.insertTrainerPerCourse(daoCrse, daoTr);
                break;
            case 6:
                daoStu.insertStudentsPerCourse(daoCrse, daoStu);
                break;
        }
            System.out.println("Would you like to repeat some function?\n1.YES.\n2.NO.");
            ans4 = sc.nextInt();
        }
        while (ans4==1);
    }
    }
}

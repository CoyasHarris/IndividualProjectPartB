/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Trainers;

public interface TrainersDaoInter {
    
    public void printAllTrainers();
    public void PrintAllTrainersPerCourse();
    public Trainers createTrainer(TrainersDaoImpl daoTr);
    public int trainerLastAvailablePK();
    public void insertTrainerToDB(Trainers Tr);
    public void insertTrainerPerCourse(CoursesDaoImpl daoCrse,TrainersDaoImpl daoTr);
}

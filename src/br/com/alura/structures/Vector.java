package br.com.alura.structures;

import br.com.alura.models.Student;

import java.util.Arrays;

public class Vector {
    private Student[] students = new Student[100];
    private int totalOfStudents = 0;

    public void add(Student student){
        this.guaranteesSpace();

        this.students[totalOfStudents] = student;
        totalOfStudents++;
    }

    public void add(int position, Student student){
        this.guaranteesSpace();

        if(!validPosition(position)) throw new IllegalArgumentException("posição inválida");

        for (int i = totalOfStudents - 1; i >= position ; i--) {
            students[i+1] = students[i];
        }

        students[position] = student;
        totalOfStudents++;
    }

    public Student get(int position) throws IllegalArgumentException {
        //recebe uma posição e devolve um aluno
        if (!positionOccupied(position)) throw new IllegalArgumentException("posição inválida");

        return students[position];
    }

    public void remove(int position){
        //remove pela posição
        for (int i = position; i < this.totalOfStudents; i++) {
            this.students[i] = this.students[i+1];
        }
        totalOfStudents--;
    }

    public boolean contain(Student student){
        //descobre se o aluno está ou não na lista
        for (int i = 0; i < totalOfStudents; i++) {
            if(student.equals(students[i])){
                return true;
            }
        }
        return false;
    }

    public int size(){
        //devolve a quantidade de alunos
        return totalOfStudents;
    }

    public String toString(){
        //facilitará na impressão
        return Arrays.toString(students);
    }

    private boolean positionOccupied(int position){
        //validará se a posição está ocupada
        return position >= 0 && position < totalOfStudents;
    }

    private boolean validPosition(int position) {
        return position >= 0 && position <= totalOfStudents;
    }

    private void guaranteesSpace() {
        if(totalOfStudents == students.length) {
            Student[] newArray = new Student[students.length * 2];
            for (int i = 0; i < students.length; i++) {
                newArray[i] = students[i];
            }
            this.students = newArray;
        }
    }
}

package org.example;

import org.example.presonal.Personal;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static LinkedList<Personal> list = new LinkedList<Personal>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] materails;
        double[] grades;


        while (true) {
            System.out.print("1- Add Student\n2- print Student\n0- Exit\n: ");
            String option = input.nextLine();
            if (option.equals("1")) {
                Personal personal = new Personal();

                Random r = new Random();
                long academicNumber = 10000;
                while (true) {
                    String storageNum = String.valueOf(r.nextLong(academicNumber));
                    String id = "2025"+"0".repeat((String.valueOf(academicNumber).length() - 1) - storageNum.length()) + storageNum;
                    System.out.println(id);
                    if (findById(Long.parseLong(id))) {
                        personal.setId(Long.parseLong(id));
                        break;
                    }
                }
                while (true) {
                    System.out.print("Enter name student: ");
                    personal.setName(input.nextLine());
                    if (personal.getName().length() > 2) {
                        break;
                    }
                    System.out.println("Please, the name must be more than two letters.");
                }
                System.out.print("Enter specialty student: ");
                personal.setSpecialty(input.nextLine());

                while (true) {
                    try {
                        System.out.print("Enter number materails learn student: ");
                        int numMaterails = Integer.parseInt(input.nextLine());
                        materails = new String[numMaterails];
                        grades = new double[numMaterails];
                        for (int i = 0; i < numMaterails; i++) {
                            System.out.print("Enter name materail " + (i + 1) + ": ");
                            materails[i] = input.nextLine();
                            while (true) {
                                try {
                                    System.out.print("Enter degree materail " + (i + 1) + "(0-100): ");
                                    grades[i] = Double.parseDouble(input.nextLine());
                                    if (grades[i] >= 0 & grades[i] <= 100) {
                                        personal.setMaterials(materails);
                                        personal.setGrades(grades);
                                        break;
                                    }
                                    System.out.println("This's, not degree");
                                } catch (NumberFormatException e) {
                                    System.out.println("Please, enter number degree materail (0-100)");
                                }
                            }
                        }
                        list.add(personal);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please, enter number materails");
                    }
                }


            } else if (option.equals("2")) {
                list.forEach(System.out::println);
            } else if (option.equals("3")) {
                break;
            } else {
                System.out.println("This's option not exists");
            }
        }
    }

    static boolean findById(long id) {
//        for (Personal read : list){
//            if (read.getId() == id){
//                return false;
//            }
//        }
//        return true;
        return list.stream().noneMatch(read -> read.getId() == id);
    }
}
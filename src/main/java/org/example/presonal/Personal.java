package org.example.presonal;

public class Personal {

    private String name, specialty;
    private long id;
    private String[] materials;
    private double[] grades;
    private int total = 0;

    public Personal(String name, String specialty, long id, String[] materials, double[] grades) {
        this.name = name;
        this.specialty = specialty;
        this.id = id;
        this.materials = materials;
        this.grades = grades;
    }

    public Personal() {

    }

    public String printDataPerson() {
        System.out.print("Student{" +
                "ID: " + id +
                        ", Name: " + name +
                        ", Specialty: " + specialty);
        for (int i = 0; i < materials.length; i++) {
            System.out.print(", material " + (i + 1) + ": " + materials[i] + " | " + "degree: " + grades[i]);
            total += grades[i];
        }
        if (total / materials.length >= 50){
            System.out.print(", Passed");
        } else {
            System.out.print(", Failed");
        }
        System.out.print("}");
        total = 0;
        return "";
    }

    @Override
    public String toString() {
        return printDataPerson();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String[] getMaterials() {
        return materials;
    }

    public void setMaterials(String[] materials) {
        this.materials = materials;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }
}

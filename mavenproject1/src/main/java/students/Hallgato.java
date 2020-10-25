/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

/**
 *
 * @author lkcsd
 */
public class Hallgato {
    private String name;
    private String nationality;
    private double maverage;

    public Hallgato(String name, String nationality, double maverage) {
        this.name = name;
        this.nationality = nationality;
        this.maverage = maverage;
    }

    public double getMaverage() {
        return maverage;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setMaverage(double maverage) {
        this.maverage = maverage;
    }

    @Override
    public String toString() {
        return "Hallgato{" + "name=" + name + ", nationality=" + nationality + ", maverage=" + maverage + '}';
    }
}

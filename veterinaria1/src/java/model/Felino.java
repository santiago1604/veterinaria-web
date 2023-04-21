/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Felino extends Mascota {
    private final boolean libreDeToxoplasmosis;
    
public Felino(String nombre, String raza, String color, int edad, boolean libreDeToxoplasmosis) {
    super(nombre, raza, color, edad);
    this.libreDeToxoplasmosis = libreDeToxoplasmosis;
}

public boolean isLibreDeToxoplasmosis() {
    return libreDeToxoplasmosis;
}

//    @Override
//    public String getTipo() {
//    return "Felino";
//}
//
//    @Override
//    public String getInfoExtra() {
//    return "Libre de toxoplasmosis: " + (libreDeToxoplasmosis ? "Sí" : "No");
//}
}
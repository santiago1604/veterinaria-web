/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Canino extends Mascota {
    private int nivelEntrenamiento;

    public Canino(String nombre, String raza, String color, int edad, int nivelEntrenamiento) {
        super(nombre, raza, color, edad);
        this.nivelEntrenamiento = nivelEntrenamiento;
    }

    public int getNivelEntrenamiento() {
        return nivelEntrenamiento;
    }

//    @Override
//    public String getTipo() {
//        return "Canino";
//    }
//
//    @Override
//    public String getInfoExtra() {
//        return "Nivel de entrenamiento: " + nivelEntrenamiento;
//    }
}

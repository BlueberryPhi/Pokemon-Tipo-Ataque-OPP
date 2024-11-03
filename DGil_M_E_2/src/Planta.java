/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Planta extends Pokemon {

    public Planta(String nombre, String[] ataques) {
        super(nombre, "Planta", ataques);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Pokémon de tipo Planta: " + getNombre());
        System.out.println("Ataques: " + String.join(", ", getAtaques()));
    }
}
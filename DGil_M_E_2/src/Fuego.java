/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Fuego extends Pokemon {

    public Fuego(String nombre, String[] ataques) {
        super(nombre, "Fuego", ataques);
    }

    
    @Override
    public void mostrarInfo() {
        System.out.println("Pokémon de tipo Fuego: " + getNombre());
        System.out.println("Ataques: " + String.join(", ", getAtaques()));
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Agua extends Pokemon {

    
    public Agua(String nombre, String[] ataques) {
        super(nombre, "Agua", ataques);
    }

    
    @Override
    public void mostrarInfo()  {
        System.out.println("Pokémon de tipo Agua: " + getNombre());
        System.out.println("Ataques: " + String.join(", ", getAtaques()));
    }
}
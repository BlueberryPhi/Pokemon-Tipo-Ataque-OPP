/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public abstract class Pokemon {
    private String nombre;
    private String tipo;
    private String[] ataques;

    public Pokemon(String nombre, String tipo, String[] ataques) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataques = ataques;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getAtaques() {
        return ataques;
    }

    public void setAtaques(String[] ataques) {
        this.ataques = ataques;
    }

    public boolean tieneAtaque(String ataque) {
        for (int i = 0; i < ataques.length; i++) {
            if (ataque.equalsIgnoreCase(ataques[i])) {
                return true;
            }
        }
        return false;
    }


    
    public abstract void mostrarInfo();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import java.io.*;

public class PerfilJugador {
    private String nombre;
    private int partidasJugadas;
    private int partidasGanadas;
    private File archivo;

    public PerfilJugador(String nombre) {
        this.nombre = nombre.toLowerCase();
        this.archivo = new File(this.nombre + ".txt");
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;

        cargarPerfil();
    }

    private void cargarPerfil() {
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                partidasJugadas = Integer.parseInt(reader.readLine());
                partidasGanadas = Integer.parseInt(reader.readLine());
                System.out.println("Bienvenido de nuevo, " + nombre + "!");
                System.out.println("Partidas jugadas: " + partidasJugadas);
                System.out.println("Partidas ganadas: " + partidasGanadas);
            } catch (IOException e) {
                System.out.println("Error al leer el archivo del perfil.");
            }
        } else {
            System.out.println("Creando nuevo perfil para " + nombre + ".");
            guardarPerfil();
        }
    }

    public void guardarPerfil() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(partidasJugadas + "\n");
            writer.write(partidasGanadas + "\n");
            System.out.println("Perfil guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo del jugador: " + e.getMessage());
        }
    }

    public void incrementarPartidasJugadas() {
        partidasJugadas++;
    }

    public void incrementarPartidasGanadas() {
        partidasGanadas++;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public String getNombre() {
        return nombre;
    }
}

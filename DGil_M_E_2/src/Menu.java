/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int mostrarOpcionesPregunta() {
        System.out.println("¿Qué tipo de pregunta quieres hacer?");
        System.out.println("1. Preguntar por el tipo de un Pokémon");
        System.out.println("2. Preguntar si un Pokémon tiene un ataque específico");
        System.out.print("Ingresa 1 o 2: ");
        int choice = 0;
         while (true) {
            
                choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice == 1 || choice == 2) {
                    break; 
                } 
                else {
                    System.out.print("Entrada inválida. Ingresa 1 o 2: ");
                 }
            
         }
        return choice;
        }

    
    public String solicitarTipo() {
        System.out.print("Ingresa el tipo de Pokémon (Agua, Fuego, Planta): ");
        String tipo = "";
        
        while (true) {
            tipo = scanner.nextLine();
            if (tipo.equalsIgnoreCase("Agua") || tipo.equalsIgnoreCase("Fuego") || tipo.equalsIgnoreCase("Planta")) {
                break;
            } else {
                System.out.print("Tipo inválido. Ingresa Agua, Fuego o Planta: ");
            }
        }
        return tipo;
    }

    
    public String solicitarAtaque(String[] AvailableAttacks) {
        System.out.println("Ataques disponibles: Hydro pump, Solar Beam, Eruption, Flamethrower, Aqua Jet, Whirlpool, Synthesis, Petal Dance");
        System.out.print("Ingresa el ataque que deseas preguntar: ");
        String attack = "";
        while (true) {
            attack = scanner.nextLine();
            boolean chido = false;
            for (int i = 0; i < AvailableAttacks.length; i++) {
                if (attack.equalsIgnoreCase(AvailableAttacks[i])) {
                    chido = true;
                    break;
                }
            }
            if (chido) {
                break;
            } else {
                System.out.print("Ataque inválido. Ingresa uno de los ataques disponibles: ");
            }
        }
        return attack;
    }

    
    public String solicitarAdivinanza(String[] posiblesNombres) {
        System.out.println("Pokémon restantes:");
        for (int i = 0; i < posiblesNombres.length; i++) {
            System.out.println((i + 1) + ". " + posiblesNombres[i]);
        }
        System.out.print("Ingresa el nombre del Pokémon que crees que es el objetivo: ");
        String adivinanza = "";
        while (true) {
            adivinanza = scanner.nextLine();
            boolean existe = false;
            for (int i = 0; i < posiblesNombres.length; i++) {
                if (adivinanza.equalsIgnoreCase(posiblesNombres[i])) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                break;
            } else {
                System.out.print("El nombre ingresado no está en la lista. Ingresa un nombre válido: ");
            }
        }
        return adivinanza;
    }


    }
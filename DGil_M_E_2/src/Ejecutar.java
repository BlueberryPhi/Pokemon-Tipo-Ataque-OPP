/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Random;

public class Ejecutar {
    private Pokemon[] listaPokemon;
    private Pokemon pokemonElegido;
    private Pokemon[] posiblesPokemon;
    private Menu menu;
    private Random rand;
    private int currentIndex;
    private String nombreJugador;
    private int partidasJugadas = 0;
    private int partidasGanadas = 0;
private File archivoJugador;
private PerfilJugador perfilJugador;



     String[] AvailableAttacks = { "Hydro pump", "Solar Beam", "Eruption", "Flamethrower",
        "Aqua Jet", "Whirlpool", "Synthesis", "Petal Dance" };

    
    public Ejecutar() {
        listaPokemon = new Pokemon[15];
        posiblesPokemon = new Pokemon[15];
        menu = new Menu();
        rand = new Random();
        currentIndex=0;
        inicializarPokemon();

        
        for (int i = 0; i < currentIndex; i++) {
            posiblesPokemon[i] = listaPokemon[i];
        }
    }

    
     void inicializarPokemon() {

         String[][] tiposYNombres = {
            {"Agua", "Squirtle"}, {"Agua", "Totodile"}, {"Agua", "Mudkip"},
            {"Agua", "Froakie"}, {"Agua", "Quaxly"}, {"Fuego", "Charmander"},
            {"Fuego", "Cyndaquil"}, {"Fuego", "Torchic"}, {"Fuego", "Litten"},
            {"Fuego", "Fuecoco"}, {"Planta", "Bulbasaur"}, {"Planta", "Chikorita"},
            {"Planta", "Treecko"}, {"Planta", "Rowlet"}, {"Planta", "Sprigatito"}
        };

        for (int i = 0; i < tiposYNombres.length; i++) {
            String tipo = tiposYNombres[i][0];
            String nombre = tiposYNombres[i][1];
            String[] ataques = obtenerAtaquesAleatorios();
            Pokemon pokemon = crearPokemon(tipo, nombre, ataques);
            agregarPokemon(pokemon);
        }

      
        if (currentIndex > 0) {
            int indice = rand.nextInt(currentIndex);
            pokemonElegido = listaPokemon[indice];
        } else {
            System.out.println("No se han inicializado Pokémon para adivinar.");
        }
    }
    
     Pokemon crearPokemon(String tipo, String nombre, String[] ataques) {
        if (tipo.equalsIgnoreCase("Agua")) {
            return new Agua(nombre, ataques);
        } else if (tipo.equalsIgnoreCase("Fuego")) {
            return new Fuego(nombre, ataques);
        } else if (tipo.equalsIgnoreCase("Planta")) {
            return new Planta(nombre, ataques);
        } else {
            return null; 
        }
    }
    
      void agregarPokemon(Pokemon pokemon) {
        if (pokemon != null && currentIndex < listaPokemon.length) {
            listaPokemon[currentIndex] = pokemon;
            currentIndex++;
        } 
    }

     String[] obtenerAtaquesAleatorios() {
        String[] ataques = new String[4];
        String[] AttacksCopy = AvailableAttacks.clone();
        for (int i = 0; i < 4; i++) {
            int index = rand.nextInt(AttacksCopy.length - i);
            ataques[i] = AttacksCopy[index];

            String temp = AttacksCopy[index];
            AttacksCopy[index] = AttacksCopy[AttacksCopy.length - 1 - i];
            AttacksCopy[AttacksCopy.length - 1 - i] = temp;
        }
        return ataques;
    }

     
     void iniciarPrograma() {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Por favor, ingresa tu nombre: ");
          nombreJugador = scanner.nextLine().toLowerCase();
    perfilJugador = new PerfilJugador(nombreJugador);
    
        System.out.println(pokemonElegido.getNombre());
        System.out.println("¡Bienvenido al juego de Adivina Quién: Pokémon!");
        System.out.println("Se te presentarán 15 Pokémon. Uno de ellos es el objetivo que debes adivinar.");
        System.out.println("Puedes hacer 4 preguntas sobre el tipo o los ataques de los Pokémon.");
        System.out.println("Después de las preguntas, deberás elegir un Pokémon. ¡Buena suerte!\n");

       System.out.println("Pokémon disponibles:");
    mostrarPosiblesPokemon();  

    for (int i = 1; i <= 4; i++) {
        System.out.println("Pregunta " + i + ":");
        realizarPregunta();
        System.out.println("Pokémon restantes:");
        mostrarPosiblesPokemon();
        System.out.println();
    }
      adivinarPokemon();
    }


     void realizarPregunta() {
        int eleccion = menu.mostrarOpcionesPregunta();
        if (eleccion == 1) {
           
            String tipo = menu.solicitarTipo();
            boolean respuesta = pokemonElegido.getTipo().equalsIgnoreCase(tipo);
            if (respuesta) {
                System.out.println("Sí, el Pokémon objetivo es de tipo " + tipo + ".");

                eliminarPokemonNoTipo(tipo);
            } else {
                System.out.println("No, el Pokémon objetivo NO es de tipo " + tipo + ".");
 
                eliminarPokemonSiTipo(tipo);
            }
        } else {

            String ataque = menu.solicitarAtaque(AvailableAttacks);
            boolean respuesta = pokemonElegido.tieneAtaque(ataque);
            if (respuesta) {
                System.out.println("Sí, el Pokémon objetivo tiene el ataque " + ataque + ".");
              
                eliminarPokemonNoAtaque(ataque);
            } else {
                System.out.println("No, el Pokémon objetivo NO tiene el ataque " + ataque + ".");
   
                eliminarPokemonSiAtaque(ataque);
            }
        }
    }

  
     void eliminarPokemonNoTipo(String tipo) {
        for (int i = 0; i < posiblesPokemon.length; i++) {
            if (posiblesPokemon[i] != null && !posiblesPokemon[i].getTipo().equalsIgnoreCase(tipo)) {
                posiblesPokemon[i] = null;
            }
        }
    }

     void eliminarPokemonSiTipo(String tipo) {
        for (int i = 0; i < posiblesPokemon.length; i++) {
            if (posiblesPokemon[i] != null && posiblesPokemon[i].getTipo().equalsIgnoreCase(tipo)) {
                posiblesPokemon[i] = null;
            }
        }
    }

    void eliminarPokemonNoAtaque(String ataque) {
        for (int i = 0; i < posiblesPokemon.length; i++) {
            if (posiblesPokemon[i] != null && !posiblesPokemon[i].tieneAtaque(ataque)) {
                posiblesPokemon[i] = null;
            }
        }
    }

    void eliminarPokemonSiAtaque(String ataque) {
        for (int i = 0; i < posiblesPokemon.length; i++) {
            if (posiblesPokemon[i] != null && posiblesPokemon[i].tieneAtaque(ataque)) {
                posiblesPokemon[i] = null;
            }
        }
    }

     int contarPokemon() {
        int contador = 0;
        for (int i = 0; i < posiblesPokemon.length; i++) {
            if (posiblesPokemon[i] != null) {
                contador++;
            }
        }
        return contador;
    }

         void mostrarPosiblesPokemon() {
    int contador = 1;
    for (int i = 0; i < posiblesPokemon.length; i++) {
        if (posiblesPokemon[i] != null) {
            System.out.print(contador + ". ");
            posiblesPokemon[i].mostrarInfo(); 
            System.out.println();
            contador++;
        }
    }
}

     private void cargarPerfilJugador() {
        File archivo = new File(nombreJugador + ".txt");
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                System.out.println("Bienvenido de nuevo, " + nombreJugador + "!");
                partidasJugadas = Integer.parseInt(reader.readLine());
                partidasGanadas = Integer.parseInt(reader.readLine());
                System.out.println("Partidas jugadas: " + partidasJugadas);
                System.out.println("Partidas ganadas: " + partidasGanadas);
            } catch (IOException e) {
                System.out.println("Error al leer el archivo del perfil.");
            }
        } else {
            System.out.println("Creando nuevo perfil para " + nombreJugador + ".");
          
        }
    }

    private void actualizarPerfilJugador() {
        File archivo = new File(nombreJugador + ".txt");
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(partidasJugadas + "\n");
            writer.write(partidasGanadas + "\n");
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo del perfil.");
        }
    }
    

    
void cargarPerfilJugador(String nombreJugador) {
    this.nombreJugador = nombreJugador;
    archivoJugador = new File(nombreJugador + ".txt");

    if (archivoJugador.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoJugador))) {
            partidasJugadas = Integer.parseInt(br.readLine());
            partidasGanadas = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo del jugador.");
        }
    } else {
        partidasJugadas = 0;
        partidasGanadas = 0;
        guardarPerfilJugador();
    }
}
   void guardarPerfilJugador() {
    if (archivoJugador != null) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoJugador))) {
            bw.write(partidasJugadas + "\n");
            bw.write(partidasGanadas + "\n");
            System.out.println("Perfil guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo del jugador: " + e.getMessage());
        }
    } else {
        System.out.println("Error: archivoJugador es null. Asegúrate de que el archivo se haya inicializado correctamente.");
    }
}
    void imprimirEstadisticas() {
    System.out.println("Estadísticas de " + perfilJugador.getNombre() + ":");
    System.out.println("Partidas jugadas: " + perfilJugador.getPartidasJugadas());
    System.out.println("Partidas ganadas: " + perfilJugador.getPartidasGanadas());
}
    public void jugarPartida() {
        partidasJugadas++;
    }
     
     void adivinarPokemon() {
        System.out.println("Has terminado tus preguntas. Ahora es hora de adivinar el Pokémon.");
        System.out.println("Pokémon restantes:");
        String[] nombres = new String[contarPokemon()];
        int index = 0;
          for (int i = 0; i < posiblesPokemon.length; i++) {
        if (posiblesPokemon[i] != null) {
            nombres[index] = posiblesPokemon[i].getNombre();
            String tipo = posiblesPokemon[i].getTipo(); 
            String[] ataques = posiblesPokemon[i].getAtaques();
            
           System.out.print((index + 1) + ". " + nombres[index] + " de tipo " + tipo + " con ataques: ");
            for (int j = 0; j < ataques.length; j++) {
                System.out.print(ataques[j]);
                if (j < ataques.length - 1) {
                    System.out.print(", "); 
                }
            }
            System.out.println(); 
            
            index++;
        }
    }
        String adivinanza = menu.solicitarAdivinanza(nombres);

        boolean gano = adivinanza.equalsIgnoreCase(pokemonElegido.getNombre());

        perfilJugador.incrementarPartidasJugadas();
        if (gano) {
            System.out.println("¡Felicidades! Has adivinado correctamente el Pokémon: " + pokemonElegido.getNombre());
         perfilJugador.incrementarPartidasGanadas();
        } else {
            boolean encontrado = false;
            for (int i = 0; i < posiblesPokemon.length; i++) {
                if (posiblesPokemon[i] != null && adivinanza.equalsIgnoreCase(posiblesPokemon[i].getNombre())) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("Lastima, no es el Pokémon correcto");
            } else {
                System.out.println("El nombre ingresado no está en la lista de Pokémon restantes.");
            }
            System.out.println("El Pokémon correcto era: " + pokemonElegido.getNombre());
        }
          perfilJugador.guardarPerfil();
    imprimirEstadisticas(); 
}
}
import java.util.Scanner;
import java.util.Stack;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner entrada2 = new Scanner(System.in);
        int star;
        System.out.println("""
                \033[34m
                ************************************
                *   🌊💥  Battleship Game   🚢💣  *
                *  Introducción a la programación  *            
                *  Profesor: Jose A. Rivera Tencio *
                *             Grupo 05             *  
                *           Estudiantes:           * 
                *       Amber Bustos Araya         * 
                *       Rachel Cortés Torres       *
                *       Joseph Garay Morales       *
                *       Arleth Serrano Rodriguez   *                             
                ************************************
                """);
        System.out.print("\033[34mDigite 1 para empezar el juego o cualquier tecla para salir.\n-> ");

        star = entrada2.nextInt();
        switch (star) {
            case 1 -> Start();
            default -> System.out.println("Hasta la próxima!");
        }
    }

    tableros tablero = new tableros();
    char[][] TuTablero = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
    char[][] TableroEnemigo = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
    char agua = tablero.getagua();

    private static void ImprimirTablero(char[][] tablero, char agua) {
        byte tamanoTablero = (byte) tablero.length;
        System.out.print("  ");
        for (byte i = 0; i < tamanoTablero; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (byte fila = 0; fila < tamanoTablero; fila++) {
            System.out.print(fila + 1 + " ");
            for (byte columna = 0; columna < tamanoTablero; columna++) {
                char Posicion = tablero[fila][columna];
                //escondemos los barcos con agua
                //de momento rellenamos solo con agua ya que no hay barcos
                if (Posicion == agua) {
                    System.out.print(agua + " ");
                } else {
                    System.out.print(Posicion + " ");
                }
            }
            System.out.println();
        }
    }


    private static void Start() {
        tableros tablero = new tableros();
        String[] nombres = new String[4];
        int Aleatorios[] = new int[6];

        char[][] TuTablero = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TableroEnemigo = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TableroenemigoAtacado = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());

        char agua = tablero.getagua();

        Stack<Integer> Numeros = new Stack<Integer>();
        Random Rnd = new Random();
        int Aleatorio;
        for (int x = 0; x < 6; x++) {
            Aleatorio = (int) (Rnd.nextDouble() * 6);
            while (Numeros.contains(Aleatorio)) {
                Aleatorio = (int) (Rnd.nextDouble() * 6);
                //Posiciones de las naves enemigas
            }
            Numeros.push(Aleatorio);
            Aleatorios[x] = Aleatorio;
        }
        System.out.println("\n");

        TableroEnemigo[Aleatorios[0]][Aleatorios[1]] = '1';
        TableroEnemigo[Aleatorios[2]][Aleatorios[3]] = '2';
        TableroEnemigo[Aleatorios[4]][Aleatorios[5]] = '3';

        int Almirante = 4;
        int Capitan = 3;
        int Teniente = 4;
        Scanner entrada = new Scanner(System.in);
        int menu;

        boolean salir = true;


        System.out.println("Ingresa los nombres de los jugadores: ");
        // Se piden los nombres a los jugadores
        Scanner entrada3 = new Scanner(System.in);
        Scanner entrada4 = new Scanner(System.in);
        System.out.print("\033[34mNombre del jugador 1 \uD83D\uDC64= ");
        String jugador1 = entrada3.nextLine();
        System.out.print("Nombre del jugador 2 \uD83D\uDC64= ");
        String jugador2 = entrada4.nextLine();
        System.out.println("----" + jugador1 + "----");
        ImprimirTablero(TuTablero, agua);
        nombres[0] = jugador1;
        nombres[1] = jugador2;

        System.out.println("\nIngrese donde quiere colocar sus naves Capitán.");
        Scanner s = new Scanner(System.in);
        int col;
        int fila;

        System.out.println("\nIngrese donde quiere colocar la nave del almirante, Capitan");
        System.out.print("Fila: ");
        fila = s.nextInt();
        fila = fila-1;
        System.out.print("Columna: ");
        col = s.nextInt();
        col = col-1;
        // Busca en el tablero y coloca la nave
        TuTablero[fila][col] = '1';
        System.out.println("----" + nombres[0] + "----");
        ImprimirTablero(TuTablero, agua);

        Scanner c = new Scanner(System.in);
        int colc;
        int filac;

        System.out.println("\nIngrese donde quiere colocar su nave Capitan");
        System.out.print("Fila: ");
        filac = c.nextInt();
        filac = filac-1;
        System.out.print("Columna: ");
        colc = c.nextInt();
        colc = colc-1;
        // Busca en el tablero y coloca la nave
        TuTablero[filac][colc] = '2';
        System.out.println("----" + nombres[0] + "----");
        ImprimirTablero(TuTablero, agua);

        Scanner t = new Scanner(System.in);
        int colt;
        int filat;
        System.out.println("\nIngrese donde quiere colocar la nave del teniente Capitan");
        System.out.print("Fila: ");
        filat = t.nextInt();
        filat = filat-1;
        System.out.print("Columna: ");
        colt = t.nextInt();
        colt = colt-1;
        // Busca en el tablero y coloca la nave
        TuTablero[filat][colt] = '3';
        System.out.println("----" + nombres[0] + "----");
        ImprimirTablero(TuTablero, agua);


        while (salir) {

            System.out.println("\n\n1 -Ver tableros");
            System.out.println("2 -Atacar");
            System.out.println("3 -Hacer trampa");
            System.out.println("4 -Exit");
            System.out.print("-> ");
            menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("\n*******************************");
                    System.out.println("\n----" + nombres[1] + "----");
                    ImprimirTablero(TableroenemigoAtacado, agua);

                    System.out.println("\n----" + nombres[0] + "----");
                    ImprimirTablero(TuTablero, agua);
                    System.out.print("*******************************\n");

                    break;
                case 2:
                    System.out.println("\n5 Atacar");
                    break;
                case 3:
                    System.out.println("\n\n*****Haciendo trampa*****");
                    ImprimirTablero(TableroEnemigo, agua);
                    System.out.println("*****Haciendo trampa*****\n\n");

                    break;
                case 4:
                    System.out.println("\nSalida del juego!");
                    salir = false;
                    break;
                default:
                    System.out.println("\n *Error: Ingrese una opción válida");
                    break;
                    }
            }
        }
    }

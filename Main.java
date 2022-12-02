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
        System.out.print("\033[34mPresione 1 para empezar el juego");
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
                    System.out.print(Posicion + "  ");
                }
            }
            System.out.println();
        }
    }


    private static void Start() {
        tableros tablero = new tableros();
        String[] nombres = new String[4];

        char[][] TuTablero = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TableroEnemigo = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char agua = tablero.getagua();

        int Almirante = 4;
        int Capitan = 3;
        int Teniente = 4;
        Scanner entrada = new Scanner(System.in);
        int menu;
        boolean salir = true;
        while (salir) {
            System.out.println("1 -Ingresar nombres");
            System.out.println("2 -Ver tablero propio");
            System.out.println("3 -Ver tablero de ataque");
            System.out.println("4 -Colocar naves del capitán");
            System.out.println("5 -Atacar");
            System.out.println("6 -Hacer trampa");
            System.out.println("6 -Exit");
            menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("\n1 Ingresar los nombres de los jugadores ");
                    // Se piden los nombres a los jugadores
                    Scanner entrada3 = new Scanner(System.in);
                    Scanner entrada4 = new Scanner(System.in);
                    System.out.print("\033[34mNombre del jugador 1 \uD83D\uDC64= ");
                    String jugador1 = entrada3.nextLine();
                    System.out.print("Nombre del jugador 2 \uD83D\uDC64= ");
                    String jugador2 = entrada4.nextLine();
                    System.out.println("----" + jugador2 + "----");
                    ImprimirTablero(TableroEnemigo, agua);
                    nombres[0] = jugador1;
                    nombres[1] = jugador2;
                    break;
                case 2:
                    System.out.println("\n2 Ver tablero propio");
                    System.out.println("----" + nombres[0] + "----");
                    ImprimirTablero(TuTablero, agua);

                    break;
                case 3:
                    System.out.println("\n3 Ver tablero de ataque");
                    System.out.println("----" + nombres[1] + "----");
                    ImprimirTablero(TableroEnemigo, agua);
                    break;
                case 4:
                    System.out.println("Ingrese donde quiere colocar sus naves Capitán solo una vez por partida");
                    Scanner s = new Scanner(System.in);
                    int col;
                    int fila;
                    System.out.println("                                             ");
                    System.out.println("Ingrese donde quiere colocar la nave del almirante, Capitan");
                    System.out.println("Fila:");
                    fila = s.nextInt();
                    System.out.println("Columna");
                    col = s.nextInt();
                    // Busca en el tablero y coloca la nave
                    TuTablero[fila][col] = '1';
                    System.out.println("----" + nombres[0] + "----");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print(TuTablero[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println(" ");
                    }

                    Scanner c = new Scanner(System.in);
                    int colc;
                    int filac;
                    System.out.println("                                             ");
                    System.out.println("Ingrese donde quiere colocar su nave Capitan");
                    System.out.println("Fila:");
                    filac = c.nextInt();
                    System.out.println("Columna");
                    colc = c.nextInt();
                    // Busca en el tablero y coloca la nave
                    TuTablero[filac][colc] = '2';
                    System.out.println("----" + nombres[0] + "----");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print(TuTablero[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println(" ");
                    }

                    Scanner t = new Scanner(System.in);
                    int colt;
                    int filat;
                    System.out.println("                                             ");
                    System.out.println("Ingrese donde quiere colocar la nave del teniente Capitan");
                    System.out.println("Fila:");
                    filat = t.nextInt();
                    System.out.println("Columna");
                    colt = t.nextInt();
                    // Busca en el tablero y coloca la nave
                    TuTablero[filat][colt] = '3';
                    System.out.println("----" + nombres[0] + "----");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print(TuTablero[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 5:
                    System.out.println("\n4 Atacar");
                    System.out.println("\n3 Ver tablero de ataque");
                    System.out.println("----" + nombres[1] + "----");
                    ImprimirTablero(TableroEnemigo, agua);
                    System.out.println("Naves de enemigo colocadas...");
                    Stack <Integer>Numeros=new Stack<Integer>();
                    Random Rnd = new Random();
                    int Aleatorio;
                    int Aleatorios[]=new int [5];
                    for (int i=0;i<5;i++){
                        Aleatorio=(int)(Rnd.nextDouble()*5+1);
                        while (Numeros.contains(Aleatorio)){
                            Aleatorio=(int)(Rnd.nextDouble()*5+1);
                        }
                        Numeros.push(Aleatorio);
                        Aleatorios[i]=Aleatorio;
                        System.out.println(Aleatorios[i]);
                    }

                    break;

                case 6:
                            System.out.println("\n5 Hacer trampa");
                            break;
                        case 7:
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

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
                *  Introducción a la programación  *\040\040\040\040\040\040\040\040\040\040\040\040
                *  Profesor: Jose A. Rivera Tencio *
                *             Grupo 05             *\040\040
                *           Estudiantes:           *\040
                *       Amber Bustos Araya         *\040
                *       Rachel Cortés Torres       *
                *       Joseph Garay Morales       *
                *       Arleth Serrano Rodriguez   *\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\
                \040\040\040\040\040\040\040\040\040\040\040\040\040
                ************************************
                """);
        System.out.print("\033[34mDigite 1 para empezar el juego o cualquier tecla para salir.\n-> ");

        star = entrada2.nextInt();
        if ( star == 1 ){
            Start();
        } else {
            System.out.println("Hasta la próxima!");
        }
    }


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
                if ( Posicion == agua ){
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
        int[] Aleatorios = new int[6];
        int[] Aleatorios2 = new int[6];


        char[][] TuTablero = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TableroEnemigo = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TableroenemigoAtacado = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TuTableroAtacado = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());

        char agua = tablero.getagua();

        Stack<Integer> Numeros = new Stack<>();
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

        Stack<Integer> Numeros2 = new Stack<>();
        Random Rnd2 = new Random();
        int Aleatorio2;
        for (int w = 0; w < 6; w++) {
            Aleatorio2 = (int) (Rnd2.nextDouble() * 6);
            while (Numeros2.contains(Aleatorio2)) {
                Aleatorio2 = (int) (Rnd2.nextDouble() * 6);
                //Posiciones de las naves enemigas
            }
            Numeros2.push(Aleatorio2);
            Aleatorios[w] = Aleatorio2;
        }
        TableroEnemigo[Aleatorios[0]][Aleatorios2[0]] = '4';
        TableroEnemigo[Aleatorios2[1]][Aleatorios[1]] = '3';
        TableroEnemigo[Aleatorios[2]][Aleatorios2[2]] = '3';
        TableroEnemigo[Aleatorios2[3]][Aleatorios[3]] = '1';
        TableroEnemigo[Aleatorios2[4]][Aleatorios[4]] = '1';
        TableroEnemigo[Aleatorios2[5]][Aleatorios[5]] = '1';


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
        fila = fila - 1;
        System.out.print("Columna: ");
        col = s.nextInt();
        col = col - 1;
        // Busca en el tablero y coloca la nave
        TuTablero[fila][col] = '4';
        System.out.println("----" + nombres[0] + "----");
        TuTableroAtacado[fila][col]='4';
        ImprimirTablero(TuTablero, agua);


        Scanner c = new Scanner(System.in);
        int colc;
        int filac;

        for (int i = 0; i < 2; i++) {
            System.out.println("\nDonde quiere colocar el capitán " + (i + 1));
            System.out.print("Fila: ");
            filac = c.nextInt();
            filac = filac - 1;
            System.out.print("Columna: ");
            colc = c.nextInt();
            colc = colc - 1;
            // Busca en el tablero y coloca la nave
            TuTablero[filac][colc] = '3';
            System.out.println("----" + nombres[0] + "----");
            TuTableroAtacado[filac][colc]='3';
            ImprimirTablero(TuTablero, agua);
        }

        Scanner t = new Scanner(System.in);
        int colt;
        int filat;
        for (int i = 0; i < 3; i++) {
            System.out.println("\nIngrese donde quiere colocar la nave del teniente " + (i + 1));
            System.out.print("Fila: ");
            filat = t.nextInt();
            filat = filat - 1;
            System.out.print("Columna: ");
            colt = t.nextInt();
            colt = colt - 1;
            // Busca en el tablero y coloca la nave
            TuTablero[filat][colt] = '1';
            System.out.println("----" + nombres[0] + "----");
            TuTableroAtacado[filat][colt]='1';
            ImprimirTablero(TuTablero, agua);
        }
        vidas vj = new vidas();
        vidas v = new vidas();
        int Almirante = v.getAlmirante();
        int Capitan = v.getCapitan();
        int Teniente = v.getTeniente();

        int Almirantej = vj.getAlmirante();
        int Capitanj = vj.getCapitan();
        int Tenientej = vj.getTeniente();

        while (salir) {
            if ( Almirante == 0 && Capitan == 0 && Teniente == 0){
                System.out.println("FELICIDADES!!! HAS GANADO!!");
                salir= false;
                break;
            }if ( Almirantej == 0 && Capitanj == 0 && Tenientej == 0){
                System.out.println("TE HAN DERROTADO :(");
                salir = false;
                break;
            }

            System.out.println("\n\n1 -Ver tableros");
            System.out.println("2 -Atacar");
            System.out.println("3 -Hacer trampa");
            System.out.println("4 -Exit");
            System.out.print("-> ");
            menu = entrada.nextInt();



            switch (menu) {
                case 1 -> {
                    System.out.print("\n*******************************");
                    System.out.println("\n----" + nombres[1] + "----");
                    ImprimirTablero(TableroenemigoAtacado, agua);
                    System.out.println("\n----" + nombres[0] + "----");
                    ImprimirTablero(TuTablero, agua);
                    System.out.print("*******************************\n");
                }
                case 2 -> {
                    System.out.println("\n Atacar");
                    int filaataque;
                    int columataque;
                    Scanner fa = new Scanner(System.in);
                    Scanner ca = new Scanner(System.in);
                    System.out.println("***********************************************************");
                    System.out.print("Fila: ");
                    filaataque = fa.nextInt();
                    System.out.print("Columna: ");
                    columataque = ca.nextInt();


                    int[] ataques = new int[2];
                    ataques[0] = filaataque-1;
                    ataques[1] = columataque-1;


                    if( TableroEnemigo[ataques[0]][ataques[1]] == TableroEnemigo[ataques[0]][ataques[1]] ){

                        if(TableroEnemigo[ataques[0]][ataques[1]] == '*'){
                            System.out.println("***********************************************************");
                            System.out.println("La nave ya ha sido destruida!!");
                            System.out.println("***********************************************************");
                        }
                        if(TableroEnemigo[ataques[0]][ataques[1]] == '4'){
                            Almirante = atacarAlmirante(Almirante);
                            v.setAlmirante(Almirante);
                            System.out.println("***********************************************************");
                            System.out.println("Hit! Nave: Almirante | Vida: "+ Almirante);
                            TableroenemigoAtacado[ataques[0]][ataques[1]] = 'O';
                            if (Almirante == 0){
                                System.out.println("Almirante destruido!! ");
                                System.out.println("***********************************************************");
                                TableroEnemigo[ataques[0]][ataques[1]] = '*';
                                TableroenemigoAtacado[ataques[0]][ataques[1]] = '*';
                            }
                        }
                        if(TableroEnemigo[ataques[0]][ataques[1]] == '3'){
                            Capitan = atacarCapitan(Capitan);
                            System.out.println("***********************************************************");
                            System.out.println("Hit! Nave: Capitan | Vidas de los capitanes: "+ Capitan);
                            System.out.println("***********************************************************");
                            TableroenemigoAtacado[ataques[0]][ataques[1]] = 'O';
                            if (Capitan == 0){
                                System.out.println("Capitanes destruidos!! ");
                                System.out.println("***********************************************************");
                                for(int i=0; i < TableroEnemigo.length; i++){
                                    for(int j=0; j < TableroEnemigo.length; j++){
                                        if(TableroEnemigo[i][j] == '3'){
                                            TableroEnemigo[i][j] = '*';
                                            TableroenemigoAtacado[i][j] = '*';
                                        }
                                    }
                                }
                                TableroEnemigo[ataques[0]][ataques[1]] = '*';
                                TableroenemigoAtacado[ataques[0]][ataques[1]] = '*';
                            }
                        }
                        if(TableroEnemigo[ataques[0]][ataques[1]] == '1'){

                            Teniente = atacarTeniente(Teniente);
                            System.out.println("Hit! Nave: Teniente | Tenientes restantes: "+ Teniente);
                            System.out.println("Teniente destruido!! ");
                            System.out.println("***********************************************************");
                            TableroEnemigo[ataques[0]][ataques[1]] = '*';
                            TableroenemigoAtacado[ataques[0]][ataques[1]] = '*';
                        }
                        if(TableroEnemigo[ataques[0]][ataques[1]] == '-') {
                            TableroenemigoAtacado[ataques[0]][ataques[1]] = 'X';
                            System.out.println("El misil cayó en el agua!");
                            System.out.println("***********************************************************");
                        }
                    }


                    int[] pcAtaques = new int[2];

                    int filaAt = pcRandom();
                    int colAt = pcRandom();
                    pcAtaques[0] = (filaAt-1);
                    pcAtaques[1] = (colAt-1);


                    if( TuTablero[pcAtaques[0]][pcAtaques[1]] == TuTablero[pcAtaques[0]][pcAtaques[1]] ){

                        if(TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] == '*'){
                            System.out.println("***********************************************************");
                            System.out.println(jugador2+" ha atacado!!");
                            System.out.println("Fila: "+filaAt +" \n"+ "Columna: "+colAt);
                            System.out.println("Tu nave ya ha sido destruida!!");
                            System.out.println("***********************************************************");
                        }
                        if(TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] == '4'){
                            Almirantej = atacarAlmirante(Almirantej);
                            vj.setAlmirante(Almirantej);
                            System.out.println("***********************************************************");
                            System.out.println(jugador2+" ha atacado!!");
                            System.out.println("Fila: "+filaAt +" \n"+ "Columna: "+colAt);
                            System.out.println("Hit! Nave: Almirante | Vida: "+ Almirantej);
                            System.out.println("***********************************************************");
                            TuTablero[pcAtaques[0]][pcAtaques[1]] = 'O';
                            if (Almirantej == 0){
                                System.out.println("Tu almirante destruido!! ");
                                System.out.println("***********************************************************");
                                TuTablero[pcAtaques[0]][pcAtaques[1]] = '*';
                                TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] = '*';

                            }
                        }
                        if(TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] == '3'){
                            Capitanj = atacarCapitan(Capitanj);
                            vj.setCapitan(Capitanj);
                            System.out.println("***********************************************************");
                            System.out.println(jugador2+" ha atacado!!");
                            System.out.println("Fila: "+filaAt +" \n"+ "Columna: "+colAt);
                            System.out.println("Hit! Nave: Capitan | Vidas de los capitanes: "+ Capitanj);
                            System.out.println("***********************************************************");
                            TuTablero[pcAtaques[0]][pcAtaques[1]] = 'O';
                            if (Capitanj == 0){
                                System.out.println("Tus capitanes han sido destruidos!! ");
                                System.out.println("***********************************************************");
                                for(int i=0; i < TuTablero.length; i++){
                                    for(int j=0; j < TuTablero.length; j++){
                                        if(TuTablero[i][j] == '3'){
                                            TuTablero[i][j] = '*';
                                            TuTableroAtacado[i][j] = '*';
                                        }
                                    }
                                }
                                TuTablero[pcAtaques[0]][pcAtaques[1]] = '*';
                            }
                        }
                        if(TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] == '1'){

                            Tenientej = atacarTeniente(Tenientej);
                            vj.setTeniente(Tenientej);
                            System.out.println("***********************************************************");
                            System.out.println(jugador2+" ha atacado!!");
                            System.out.println("Fila: "+filaAt +" \n"+ "Columna: "+colAt);
                            System.out.println("Hit! Nave: Teniente | Tenientes restantes: "+ Tenientej);
                            System.out.println("Tu teniente ha sido destruido!! ");
                            System.out.println("***********************************************************");
                            TuTablero[pcAtaques[0]][pcAtaques[1]] = '*';
                            TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] = '*';
                        }
                        if(TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] == '-'|| 
                           TuTableroAtacado[pcAtaques[0]][pcAtaques[1]] == 'X') {
                            TuTablero[pcAtaques[0]][pcAtaques[1]] = 'X';
                            System.out.println("***********************************************************");
                            System.out.println(jugador2+" ha atacado!!");
                            System.out.println("Fila: "+filaAt +" \n"+ "Columna: "+colAt);
                            System.out.println("El misil cayó en el agua!");
                            System.out.println("***********************************************************");
                        }
                    }

                    /*ataquejugador(ataques, filaataque, columataque, TableroEnemigo, TableroenemigoAtacado);*/


                }
                case 3 -> {
                    System.out.println("\n\n*****Haciendo trampa*****");
                    ImprimirTablero(TableroEnemigo, agua);
                    System.out.println("*****Haciendo trampa*****\n\n");
                }
                case 4 -> {
                    System.out.println("\nSalida del juego!");
                    salir = false;
                }
                default -> System.out.println("\n *Error: Ingrese una opción válida");
            }

        }
    }


    private static int pcRandom() {
        int min = 1;
        int max = 6;
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    private static int atacarTeniente(int teniente) {
        teniente = teniente -1;
        return teniente;
    }

    private static int atacarCapitan(int capitan) {
        capitan = capitan -1;
        return capitan;
    }

    private static int atacarAlmirante(int almirante) {
        almirante = almirante - 1;
        return almirante;
    }
}

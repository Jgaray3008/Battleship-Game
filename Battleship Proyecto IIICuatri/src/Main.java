public class Main {
    public static void main(String[] args) {


        tableros tablero = new tableros();

        char[][] TuTablero = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char[][] TableroEnemigo = tablero.crearTablero(tablero.gettamanoTablero(), tablero.getagua());
        char agua = tablero.getagua();




        //tiene salir el nombre nuestro
        ImprimirTablero(TuTablero, agua);

        //Tiene el nombre del CPU
        ImprimirTablero(TableroEnemigo, agua);


    }

    private static void ImprimirTablero(char [][] tablero, char agua) {
        byte tamanoTablero = (byte)tablero.length;
        System.out.print("\n");
        System.out.print("  ");
        for(byte i=0; i < tamanoTablero; i++){
            //para ver las posiciones de las filas
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        //for para imprimir la matriz
        for(byte fila = 0; fila < tamanoTablero; fila++){
            //para ver las posiciones de las columnas
            System.out.print(fila + 1 + " ");
            for(byte columna =0; columna < tamanoTablero; columna++){
                char Posicion = tablero[fila][columna];
                //escondemos los barcos con agua
                //de momento rellenamos solo con agua ya que no hay barcos
                if (Posicion == agua){
                    System.out.print(agua+" ");
                }
                else{
                    System.out.print(Posicion+" ");
                }
            }
            System.out.println();
        }
    }
}
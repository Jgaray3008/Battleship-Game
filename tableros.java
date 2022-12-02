import java.util.Arrays;

public class tableros {
    private byte tamanoTablero = 6;
    private char agua = '-';
    char[][] tablero = crearTablero(tamanoTablero, agua);

    public byte gettamanoTablero(){
        return tamanoTablero;
    }
    public char getagua(){
        return agua;
    }

    public char[][] crearTablero(byte tamanoTablero, char agua) {
        char[][] tablero = new char[tamanoTablero][tamanoTablero];
        for(char[] fila: tablero){
            Arrays.fill(fila, agua);
        }
        return tablero;
    }



}

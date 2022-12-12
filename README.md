# Battleship-Game


A continuación, se muestra un ejemplo de un tablero vacío de tamaño de 6x6.
Características del Juego
En el juego se tienen dos jugadores. Para efectos del proyecto únicamente se va a poder jugar
contra el CPU. Cada jugador tiene un tablero de matriz cuadrada 6x6. Sobre este tablero se van a
colocar una cantidad 6 de naves. Estas naves abarcan únicamente una celda del tablero.
Existen 3 tipos de naves. La nave del Almirante abarca solo una celda, pero esta tiene 4 puntos de
vida. Esto quiere decir que se le debe atacar 4 veces para ser destruida. La nave del Capitán tiene
abarca solo una celda y tiene 3 puntos de vida. La nave del Teniente tiene 1 punto de vida. La
cantidad de naves a colocar es la siguiente:
• 1 Almirante
• 2 Capitán
• 3 Teniente
Al iniciar el juego el jugador debe colocar sus naves. Esto se puede hacer de manera aleatoria o
solicitando al jugador las coordenadas de las naves. La colocación de las naves del CPU puede
ser preestablecido por los desarrolladores.
1 2 3 4 5 6 |
A - - - - - |
B - - - - - |
C - - - - - |
D - - - - - |
E - - - - - |
F - - - - - |
Universidad Fidélitas | Escuela de Ingeniería en Sistemas de Computación | SC-205 | 2022
Flujo de Juego
Primero se determina cual jugador va a iniciar. Para esto siempre se va a tener que el jugador inicia
y luego sigue el CPU. En su turno el jugador se le presentara un menú que va a contener las
siguientes opciones:
• Atacar
• Ver tablero de ataque
• Ver tablero propio
• Hacer trampa

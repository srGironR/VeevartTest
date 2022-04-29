import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadderTest{
    public static void main (String[] args){
        SnakeNLadder snakeLadder = new SnakeNLadder();
		snakeLadder.startGame();
    }
}

class SnakeNLadder{
    final static int WINPOINT = 25;
	static Map<Integer, Integer> snake = new HashMap<>();
	static Map<Integer, Integer> ladder = new HashMap<>();
	{
		snake.put(14, 4);
		snake.put(19, 8);
		snake.put(24, 16);
		snake.put(22, 20);
		
		ladder.put(3, 11);
		ladder.put(6, 17);
		ladder.put(9, 18);
		ladder.put(10, 12);
		
	}
    //Este metódo crea un dado que da un número random entre 1 y 6
	public int rollDice() {
		int n = 0;
		Random r = new Random();
		n = r.nextInt(7);
		return (n == 0 ? 1 : n);
	}
    /*Este metódo calculará la posición del jugador basado en su
    posición actual después de tirar el dado*/
    public int calculatePlayerValue(int playerPosition, int diceValue) {
		int playerNewPosition=playerPosition+diceValue;

        //retorna el jugador a la posición inicial
		if (playerNewPosition > WINPOINT){
            playerNewPosition = playerPosition;
            System.out.println("Te pasaste, vuelves a la misma posición");
        }					
        //Indica si una serpiente te come y el cuadro al cual baja
		if (null !=snake.get(playerNewPosition)) {			
			playerNewPosition=snake.get(playerNewPosition);
            System.out.println("La serpiente te comió bajaste al cuadro " + playerNewPosition);
		}
		//Indica si sube una escalera y a que cuadro lo lleva esté
		if (null !=ladder.get(playerNewPosition)) {			
			playerNewPosition=ladder.get(playerNewPosition);
            System.out.println("WOW, subiste una escalera al cuadro " + playerNewPosition);
		}
		
		return playerNewPosition;
	}

    //Metódo para saber si gana
    public boolean isWin(int playerPosition) {
		return WINPOINT==playerPosition;
	}

    //Comienzo de el juego

    public void startGame (){
        int player1Position=0;
        int currentPlayer = -1;		
		Scanner scan= new Scanner(System.in);
		String rPressed;
		int diceValue = 0;
        
        //Comienza el loop hasta ganar
        do{            
		    System.out.println("Jugador presione 'r' para tirar el dado");
		    rPressed=scan.next();
		    diceValue=rollDice();
            
            //Indica el turno, posición y dado para calcular cuanto avanza
            if (currentPlayer==-1) {
                System.out.println("Dado arroja : "+diceValue);
                player1Position=calculatePlayerValue(player1Position, diceValue);                
                System.out.println("Jugador se encuentra en el cuadro : "+player1Position);                
                System.out.println("-------------------------");


                //Indica si el jugador ha ganado y procede a reiniciar el juego
                if(isWin(player1Position)){
                    System.out.println("Felicidades ganó");
                    player1Position = 0;
                    System.out.println("se procede a reiniciar el juego");
                }
            }
            //Indica que el turno no termina hasta volver a presionar r
        } while("r".equals(rPressed));

    }

}
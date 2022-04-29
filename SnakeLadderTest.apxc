public class SnakeLadderTest {
    
    //Definir posición de ganar
    Public Integer winpoint = 25;
    //Definir posición del jugador en el turno
    Public Integer PlayerPosition = 0;
    
    //Crear maps que indican el inicio y fin de una serpiente o escalera
    Map<Integer, Integer> snake = new Map<Integer, Integer>();
    Map<Integer, Integer> ladder = new Map<Integer, Integer>();
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
    
    //Loop para jugar y calcular posiciones
	{ 
        do{
            //Dado random
            Integer diceValue = Integer.valueOf((1 + Math.random()*6));
            	system.debug('Dado arrroja:'+ diceValue);
            
            //Posición actual
            Integer newPlayerP = PlayerPosition + diceValue;           
           
           //Calculos de cuadros 
            if(newPlayerP > winpoint){
                 newPlayerP = playerPosition;
            	System.debug('Te pasaste, vuelves a la misma posición');
            }
            
            if(null !=snake.get(newPlayerP)){
                newPlayerp = snake.get(newPlayerP);
                system.debug('La serpiente te comió bajaste al cuadro:'+ newPlayerP);
            }
            
            if(null !=ladder.get(newPlayerP)){
                newPlayerp = ladder.get(newPlayerp);
                system.debug('WOW subiste una escalera al cuadro:'+ newPlayerP);
            }   
            
            //Indica que ganó            
            if(newPlayerP == winpoint){
                System.debug('Felicidades ganó');                           
            }	
            
            //El valor de la posición nueva será la final para comenzar de nuevo el loop hasta 25
            PlayerPosition = newPlayerp;
            System.debug('Jugador se encuentra en el cuadro ' + newPlayerP);            
            
        }while(PlayerPosition < 25);}        

}
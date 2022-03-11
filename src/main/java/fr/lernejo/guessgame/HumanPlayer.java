package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player
{
    private final Logger logger = LoggerFactory.getLogger("player");
    Scanner UserInput = new Scanner(System.in);

    @Override
    public long askNextGuess()
    {
        //long tmp;
        logger.log("Please enter the number to be compared : ");
        /*tmp = UserInput.nextLong();
        UserInput.nextLine();
        return tmp;*/
        do {
            String input = UserInput.nextLine();
            try
            {
                return Long.parseLong(input);
            }catch (NumberFormatException e){
                logger.log("This was not a number, try again !");
            }
        }while(true);
    }

    @Override
    public void respond(boolean lowerOrGreater)
    {
        logger.log("Your guess was  " + (lowerOrGreater ? "lower" : "greater"));  //ternaire
    }
}

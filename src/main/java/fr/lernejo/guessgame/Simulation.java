package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation
{
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess)
            return true;
        else
        {
            player.respond(guess < numberToGuess);
            return false;
        }

    }

    public void loopUntilPlayerSucceed() {
        int counter = 0;
        do {
            counter++;
        }while(!nextRound());
        logger.log("Congrats you find the number to guess in " + counter + " rounds !!");
    }
}

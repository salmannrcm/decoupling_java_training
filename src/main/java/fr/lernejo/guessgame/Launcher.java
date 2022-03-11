package fr.lernejo.guessgame;

import java.util.Random;

public class Launcher
{
    public static void main(String[] args) {

        Configuration configuration = Configuration.parseArgs(args);


        //Player player = new HumanPlayer();
        Simulation simulation = new Simulation(configuration.player);

        long numberToGuess = configuration.numberToGuess;

        simulation.initialize(numberToGuess);
        simulation.loopUntilPlayerSucceed();

    }
}

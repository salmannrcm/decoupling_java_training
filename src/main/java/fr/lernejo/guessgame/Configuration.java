package fr.lernejo.guessgame;

import java.util.Random;

public class Configuration
{
    final Player player;
    final long numberToGuess;

    private Configuration(Player player, long numberToGuess) {
        this.player = player;
        this.numberToGuess = numberToGuess;
    }

    static Configuration parseArgs(String[] Args)
    {
        if(Args.length == 0)
            throw new IllegalArgumentException("Missing argument: -interactive or -auto");
        String type = Args[0];
        return switch (type){
            case "-interactive" -> new Configuration(new HumanPlayer(), new Random().nextInt(101));
            case "-auto" ->{
                if(Args.length <2)
                    throw new IllegalArgumentException("In -auto mode number to guess should be supplied");
                yield new Configuration(new ComputerPlayer(), Long.parseLong(Args[1]));
            }default -> throw new IllegalArgumentException("Invalid argument !");
        };
    }
}

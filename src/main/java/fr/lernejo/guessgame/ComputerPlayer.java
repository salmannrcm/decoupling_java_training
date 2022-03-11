package fr.lernejo.guessgame;

public class ComputerPlayer implements Player{

    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        return avg();
    }

    private long avg()
    {
        return (min + max) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater)
            max = avg();
        else
            min =avg();
    }
}

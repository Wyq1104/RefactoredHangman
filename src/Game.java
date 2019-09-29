import java.util.Set;

/**
 * encapsulate the code for looping through a set of games and recording the results
 */
public abstract class Game {
    public static GamesRecord playAll(Set<Game> games){
        GamesRecord gamesRecord=new GamesRecord();
        for(Game game: games){
            GameInstance gameInstance=game.play();
            gamesRecord.add(gameInstance);
        }
        return gamesRecord;
    }

    public abstract GameInstance play();

    public abstract boolean playNext();

}

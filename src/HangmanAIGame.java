import java.util.ArrayList;
import java.util.List;

public class HangmanAIGame extends Hangman{
    List<HangmanPlayer> hangmanPlayers=new ArrayList<>();
    HangmanPlayer hangmanPlayer;
    int playerIndex;

    /**
     * set the HangmanPlayer to a default player
     */
    public HangmanAIGame() {
        Player1 player1=new Player1();
        hangmanPlayers.add(player1);
        readPhrases("phrases.txt");
    }

    /**
     * allow the client to specify a single concrete HangmanPlayer
     * @param player
     */
    public HangmanAIGame(HangmanPlayer player){
        hangmanPlayers.add(player);
    }

    /**
     * accept a list of HangmanPlayers
     * @param players
     */
    public HangmanAIGame(List<HangmanPlayer> players){
        hangmanPlayers=players;
    }

    @Override
    public GameInstance play() {
        GameInstance gameInstance=new GameInstance();
        if(hangmanPlayer==null){
            hangmanPlayer=hangmanPlayers.get(playerIndex);
        }
        gameInstance.setPlayer(hangmanPlayer.getId());
        randomPhrase();
        getHiddenPhrase();
        System.out.println(hiddenPhrase);
        int chancesLeft=TOTALCHANCES;
        previousGuesses="";
        while(chancesLeft>0){
            boolean bool=processGuess();
            if(!bool){
                chancesLeft--;
            }
            System.out.println("Chances left: "+chancesLeft);
            System.out.println(hiddenPhrase);
            if(hiddenPhrase.indexOf("*")==-1){
                break;
            }
        }
        if(chancesLeft==0){
            System.out.println("Sorry, You lose!!!");
            System.out.println("The correct answer is: "+phrase);
            gameInstance.setScore(0);
        }else{
            System.out.println("Congratulation, you win!!!");
            gameInstance.setScore(chancesLeft);
        }
        hangmanPlayer.reset();
        return gameInstance;
    }

    @Override
    public boolean playNext() {
        if(changeablePhraseList.size()==0){
            changeablePhraseList=phraseList;
            hangmanPlayer=null;
            playerIndex++;
            if(playerIndex==hangmanPlayers.size()){
                return false;
            }
        }
        return true;
    }

    @Override
    char getGuess(String previousGuesses) {
        System.out.println(previousGuesses);
        return hangmanPlayer.nextGuess();
    }

    public static void main(String[] args) {
        HangmanAIGame hangmanAIGame=new HangmanAIGame();
        GamesRecord record = hangmanAIGame.playAll();
        System.out.println(record);
    }
}

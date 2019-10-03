public class Player1 implements HangmanPlayer{
    private String Id="Player1";
    private String alphabets="abcdefghijklmnopqrstuvwxyz";
    private int index;

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public char nextGuess() {
        char guess=alphabets.charAt(index);
        index++;
        return guess;
    }

    @Override
    public boolean reset() {
        index=0;
        return true;
    }


}

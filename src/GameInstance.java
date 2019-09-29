/**
 * Class used to keep track of the score and player
 */
public class GameInstance implements Comparable{
    int score;
    String player;

    /**
     * compares scores
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        GameInstance other=(GameInstance)o;
        if(this.score>other.score){
            return 1;
        }else if(this.score<other.score){
            return -1;
        }else{
            return 0;
        }
    }

}

/**
 * Created by noureldin on 7/21/16.
 */
public class Game {
    private int SIZE;
    private int [] [] State;
    public Game(){
        SIZE = 3;
        State = new int[SIZE][SIZE];
    }
    public Game(int size){
        SIZE = size;
        State = new int[SIZE][SIZE];
    }
    public int getSize(){
        return SIZE;
    }
    public int [] [] getState(){
        int [] [] ret = new int[SIZE][SIZE];
        for(int i = 0;i < SIZE;i++) for(int j = 0;j < SIZE;j++) ret[i][j] = State[i][j];
        return ret;
    }
    public static Boolean isValidState(int [] [] State){
        if(State == null) return false;
        int ctr1 = 0,ctr2 = 0,n = State.length;
        for(int i = 0;i < n;i++) if(State[i].length != n) return false;
        for(int i = 0;i < n;i++) for(int j = 0;j < n;j++) {
            if(State[i][j] == 1) ctr1++;
            if(State[i][j] == 2) ctr2++;
            if(State[i][j] < 0 || State[i][j] > 2) return false;
        }
        if(Math.abs(ctr1 - ctr2) > 1) return false;
        return true;
    }

    public boolean makeMove(int player,int x,int y){
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE || (player != 1 && player != 2)) return false;
        if(State[x][y] != 0) return false;
        State[x][y] = player;
        return isValidState(State);
    }

/*
    public static int getGameState(int [] [] State){

    }
*/
}

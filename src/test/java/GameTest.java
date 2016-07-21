import org.junit.Test;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Created by noureldin on 7/21/16.
 */
@RunWith(JUnitParamsRunner.class)
public class GameTest {
    @Test
    public void testDefaultConstructor() throws Exception {
        Game G = new Game();
        int [] [] expectedState = new int[3][3];
        assertEquals("Default Game Size",G.getSize(),3);
        assertEquals("Default Game State",G.getState(),expectedState);
    }

    @Test
    @Parameters (
            {
                "5",
                "6"
            }
    )
    public void testConstructor(int a) throws Exception {
        Game G = new Game(a);
        assertEquals("Constructor retSize ",a,G.getSize());
        assertEquals("Constructor State",new int [a][a],G.getState());
    }


    @Test
     public void testIsValidState1(){
        int [][] State = {{1,1,1},{0,0,0},{0,0,0}};
        Boolean correctState = false;
        assertEquals("test validity",correctState,Game.isValidState(State));
    }
    @Test
    public void testIsValidState2(){
        int [][] State = {{1,2,1},{0,0,0},{0,0,0}};
        Boolean correctState = true;
        assertEquals("test validity",correctState,Game.isValidState(State));
    }
    @Test
    public void testMakeMoveOutOfBound(){
        Game G = new Game();
        assertEquals("test MakeMove",false,G.makeMove(1,-1,0));
    }
    @Test
    public void testMakeMoveImaginaryPlayer(){
        Game G = new Game();
        assertEquals("test MakeMove",false,G.makeMove(3,0,0));
    }
    @Test
    public void testMakeMoveCorrectPlayer(){
        Game G = new Game();
        assertEquals("test MakeMove",true,G.makeMove(1,0,0));
    }
    

    /*
    protected void getGameState(int [] [] State,int correctState) throws Exception {
        assertEquals("Game State",correctState,Game.getGameState(State));
    }*/

}
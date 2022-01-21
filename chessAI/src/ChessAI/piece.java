
package ChessAI;

/**
 *
 * @author Logan
 */



public class piece {
    public String type=null;
    public int positionx;
    public int positiony;
    public int colour=0; //t.rev4 0 is white, 1 is black, 2 is " "
    public int lastMoved=0;
    public int numMoves=0; //t.rev4 counts number of moves piece has made

    public piece( String type ,int colour, int positionx, int positiony){
    this.positionx=positionx;
    this.positiony=positiony;
    this.type=type;
    this.colour=colour;
    }
}



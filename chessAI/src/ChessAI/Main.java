
package ChessAI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Logan
 */
public class Main {
    public static board readBoard(board board){
        System.out.print("enter File name:");
        Scanner myScanner = new Scanner(System.in);
        String myString = myScanner.next();
       try{
      BufferedReader br = new BufferedReader(new FileReader(new File(myString)));
      LinkedList<char[]> lines = new LinkedList<>();
      String line;
      while( (line = br.readLine()) != null) {
        lines.add(line.toCharArray());
      }
      char[][] chessboard = new char[8][8];
      int n=0;
      while(n<8){
         chessboard[n]=lines.get(7-n);
         n++;
      }
      
      for (int i=0; i<8;i++){
      for (int j=0; j<8;j++){
  
      board.board[j][i].positionx=j;
      board.board[j][i].positiony=i;
      switch (chessboard[i][j]) {
                        case ('-'):
                             board.board[j][i].type=null;
                             board.board[j][i].colour=2;
                            break;
                        case ('q'):
                              board.board[j][i].type="queen";
                              board.board[j][i].colour=1;
                            break;
                        case ('r'):
                              board.board[j][i].type="rook";
                              board.board[j][i].colour=1;
                            break;
                        case ('b'):
                              board.board[j][i].type="bishop";
                              board.board[j][i].colour=1;
                            break;
                        case ('n'):
                              board.board[j][i].type="knight";
                              board.board[j][i].colour=1;
                            break;
                        case ('k'):
                              board.board[j][i].type="king";
                              board.board[j][i].colour=1;
                            break;
                        case ('p'):
                             board.board[j][i].type="pawn";
                              board.board[j][i].colour=1;
                           break;
                          
                        case ('Q'):
                              board.board[j][i].type="queen";
                              board.board[j][i].colour=0;
                            break;
                        case ('R'):
                              board.board[j][i].type="rook";
                              board.board[j][i].colour=0;
                            break;
                        case ('B'):
                              board.board[j][i].type="bishop";
                              board.board[j][i].colour=0;
                            break;
                        case ('N'):
                              board.board[j][i].type="knight";
                              board.board[j][i].colour=0;
                            break;
                        case ('K'):
                              board.board[j][i].type="king";
                              board.board[j][i].colour=0;
                            break;
                        case ('P'):
                             board.board[j][i].type="pawn";
                              board.board[j][i].colour=0;
                           break;
                    }
              }
              }
      br.close();
       }
       catch(IOException e) {
      System.out.println(e.getMessage());
      return null;
    }
      
       
        return board;
    }
    public static board Ai(board board,int turn, int depth){
    double bestscore=-10000;
    int bestmove[]= new int[4];
    for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board.board[i][j].colour == turn % 2) {
                        int[][] moves = board.movement(board.board, board.board[i][j], turn);

                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (moves[k][l] == 1) {

                                    piece save = new piece(board.board[i][j].type, board.board[i][j].colour, board.board[i][j].positionx, board.board[i][j].positiony);
                                    piece save2 = new piece(board.board[k][l].type, board.board[k][l].colour, board.board[k][l].positionx, board.board[k][l].positiony);
                                    board.moveAI(board.board, i, j, k, l, turn);

                                    double score = alphabeta(-1000,1000, board, turn + 1, depth - 1,false,true);

                                    board.board[i][j].colour = save.colour;
                                    board.board[i][j].type = save.type;
                                    board.board[i][j].positionx = save.positionx;
                                    board.board[i][j].positiony = save.positiony;
                                    board.board[k][l].colour = save2.colour;
                                    board.board[k][l].type = save2.type;
                                    board.board[k][l].positionx = save2.positionx;
                                    board.board[k][l].positiony = save2.positiony;
                                    if (score>bestscore){ 
                                       
                                         bestscore=score;
                                         bestmove[0]=i;
                                         bestmove[1]=j;
                                         bestmove[2]=k;
                                         bestmove[3]=l;
                                        
                                    }
                                   
                                } 
                            }
                        }
                    }
                }
    }
    System.out.print(Arrays.toString(bestmove));
    board.moveAI(board.board, bestmove[0],bestmove[1],bestmove[2],bestmove[3], turn);
    return board;
    }
    public static double alphabeta(double alpha, double beta, board board, int turn, int depth, boolean isMax,boolean start) {
        double og = alpha;
        double ob = beta;
        double newa = alpha;
        double newb = beta;

        if (depth > 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board.board[i][j].colour == turn % 2) {
                        int[][] moves = board.movement(board.board, board.board[i][j], turn);

                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (moves[k][l] == 1) {

                                    piece save = new piece(board.board[i][j].type, board.board[i][j].colour, board.board[i][j].positionx, board.board[i][j].positiony);
                                    piece save2 = new piece(board.board[k][l].type, board.board[k][l].colour, board.board[k][l].positionx, board.board[k][l].positiony);
                                    board.moveAI(board.board, i, j, k, l, turn);

                                    double score = alphabeta(newa, newb, board, turn + 1, depth - 1, !isMax,false);

                                    board.board[i][j].colour = save.colour;
                                    board.board[i][j].type = save.type;
                                    board.board[i][j].positionx = save.positionx;
                                    board.board[i][j].positiony = save.positiony;
                                    board.board[k][l].colour = save2.colour;
                                    board.board[k][l].type = save2.type;
                                    board.board[k][l].positionx = save2.positionx;
                                    board.board[k][l].positiony = save2.positiony;
                                    if(start){
                                        if(newb>score){
                                            newb=score;
                                        }
                                    }
                                    else{
                                    if (isMax) {
                                        if (score > ob) {
                                            return ob;
                                        } else {
                                            if (newa < score) {
                                                newa = score;
                                            }

                                        }
                                    } else {
                                        if (score < og) {
                                            return og;
                                        } else {
                                            if (newb > score) {
                                                newb = score;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
            
        }
            else {
            double value = board.evaluate();
            
            if (isMax) {
                if (value > ob) {

                    return ob;
                } 
                else {
                        return value;
                    }
                
            } else {
                if (value < og) {

                    return og;
                } else {
                        return value;
                    }
                }
            }
        
        if(isMax){
            return newa;
        }
        else{
            return newb;
        }
    
    }
    
    public static void main(String[] args) {
        int movex=0;
        int movey=0;
        int movetox=0;
        int movetoy=0;
        int turn=0; //evens are white, odds are black
       
        board board = new board();
        Scanner myScanner = new Scanner(System.in);
        while(movetox!=9){
            char[][] display = board.display(board.board);
            System.out.println("  0 1 2 3 4 5 6 7");
            for (int i=7;i>=0;i--){
                System.out.print(i+" ");
                for (int j=0;j<8;j++){
                    System.out.print(display[j][i]+" ");
                   
                }
                System.out.print('\n');
            }
            //modified in t.rev3, t.rev4.2
            System.out.print("choose x position: ");
            movex = myScanner.nextInt();
            System.out.print("choose y position: ");
            movey = myScanner.nextInt();
            System.out.print("move to x position: ");
            movetox = myScanner.nextInt();
            System.out.print("move to y position: ");
            movetoy = myScanner.nextInt();
            //t.rev4.2 added out of bounds check
            if ((0 <= movex && movex <= 7) && (0 <= movey && movey <= 7) && (0 <= movetox && movetox <= 7) && (0 <= movetoy && movetoy <= 7)) {
                turn = turn + board.move(board.board, movex, movey, movetox, movetoy, turn);
            }else{
                System.out.println("invald move: out of bounds");
            }

            //checks to see if checkmate has occured
            if (board.isKingInCheck(board.board, turn)) {
                if (board.mateChecker(board.board, turn)) {
                    System.out.println("CheckMate. Game Over");
                    movetox = 9; // trigger for ending game
                }
            } else if (board.mateChecker(board.board, turn) && board.mateChecker(board.board, turn)) {
                //checks if both sides have no possible moves left
                System.out.println("StaleMate. Game Over");
                movetox = 9; // trigger for ending game
            }
            if (turn % 2 ==1){
               board=Ai(board,turn,4);
               turn++;
            }
            /* added in t.rev1, modified in t.rev2, modified in t.rev3, modified in t.rev4.2
             * little toolkit for testing out functions
             */
          
        }
    }
}

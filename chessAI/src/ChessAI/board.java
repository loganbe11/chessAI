
package ChessAI;

/**
 *
 * @author Logan
 */
public class board {

    piece[][] board = new piece[8][8];

    public board() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 8; i++) {
                this.board[i][j * 5 + 1] = new piece("pawn", j, i, j * 5 + 1);
            }
            this.board[0][j * 7] = new piece("rook", j, 0, j * 7);
            this.board[7][j * 7] = new piece("rook", j, 7, j * 7);
            this.board[1][j * 7] = new piece("knight", j, 1, j * 7);
            this.board[6][j * 7] = new piece("knight", j, 6, j * 7);
            this.board[2][j * 7] = new piece("bishop", j, 2, j * 7);
            this.board[5][j * 7] = new piece("bishop", j, 5, j * 7);
            this.board[3][j * 7] = new piece("queen", j, 3, j * 7);
            this.board[4][j * 7] = new piece("king", j, 4, j * 7);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                this.board[i][j] = new piece(null, 2, i, j);
            }
        }
    }

    public int[][] movement(piece[][] board, piece piece, int turn) {
        int[][] moves = new int[8][8];
        int counter = 1;
        if (turn % 2 != piece.colour) {
            return moves;
        }
        boolean next = true;
        if (piece.type == null) {
            return moves;
        }
        switch (piece.type) {
            case "king":
                if (piece.positionx < 6) {
                    if (board[piece.positionx + 1][piece.positiony].colour != piece.colour) {
                        moves[piece.positionx + 1][piece.positiony] = 1;
                    }
                    if (piece.positiony < 6) {
                        if (board[piece.positionx + 1][piece.positiony + 1].colour != piece.colour) {
                            moves[piece.positionx + 1][piece.positiony + 1] = 1;
                        }
                    }
                    if (piece.positiony > 0) {
                        if (board[piece.positionx + 1][piece.positiony - 1].colour != piece.colour) {
                            moves[piece.positionx + 1][piece.positiony - 1] = 1;
                        }
                    }
                }
                if (piece.positiony < 6) {
                    if (board[piece.positionx][piece.positiony + 1].colour != piece.colour) {
                        moves[piece.positionx][piece.positiony + 1] = 1;
                    }

                }
                if (piece.positionx > 0) {
                    if (board[piece.positionx - 1][piece.positiony].colour != piece.colour) {
                        moves[piece.positionx - 1][piece.positiony] = 1;
                    }
                    if (piece.positiony > 0) {
                        if (board[piece.positionx - 1][piece.positiony - 1].colour != piece.colour) {
                            moves[piece.positionx - 1][piece.positiony - 1] = 1;
                        }
                    }
                    if (piece.positiony < 6) {
                        if (board[piece.positionx - 1][piece.positiony + 1].colour != piece.colour) {
                            moves[piece.positionx - 1][piece.positiony + 1] = 1;
                        }
                    }
                }
                if (piece.positiony > 0) {
                    if (board[piece.positionx][piece.positiony - 1].colour != piece.colour) {
                        moves[piece.positionx][piece.positiony - 1] = 1;
                    }
                }
                break;
            case "queen":
                while (piece.positiony + counter <= 7 && next == true) {
                    if (board[piece.positionx][piece.positiony + counter].type == null) {
                        moves[piece.positionx][piece.positiony + counter] = 1;
                    } else if (board[piece.positionx][piece.positiony + counter].colour != piece.colour) {
                        moves[piece.positionx][piece.positiony + counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony - counter >= 0 && next == true) {
                    if (board[piece.positionx][piece.positiony - counter].type == null) {
                        moves[piece.positionx][piece.positiony - counter] = 1;
                    } else if (board[piece.positionx][piece.positiony - counter].colour != piece.colour) {
                        moves[piece.positionx][piece.positiony - counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positionx + counter <= 7 && next == true) {
                    if (board[piece.positionx + counter][piece.positiony].type == null) {
                        moves[piece.positionx + counter][piece.positiony] = 1;
                    } else if (board[piece.positionx + counter][piece.positiony].colour != piece.colour) {
                        moves[piece.positionx + counter][piece.positiony] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positionx - counter >= 0 && next == true) {
                    if (board[piece.positionx - counter][piece.positiony].type == null) {
                        moves[piece.positionx - counter][piece.positiony] = 1;
                    } else if (board[piece.positionx - counter][piece.positiony].colour != piece.colour) {
                        moves[piece.positionx - counter][piece.positiony] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony + counter <= 7 && piece.positionx - counter >= 0 && next == true) {
                    if (board[piece.positionx - counter][piece.positiony + counter].type == null) {
                        moves[piece.positionx - counter][piece.positiony + counter] = 1;
                    } else if (board[piece.positionx - counter][piece.positiony + counter].colour != piece.colour) {
                        moves[piece.positionx - counter][piece.positiony + counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony - counter >= 0 && piece.positionx + counter <= 7 && next == true) {
                    if (board[piece.positionx + counter][piece.positiony - counter].type == null) {
                        moves[piece.positionx + counter][piece.positiony - counter] = 1;
                    } else if (board[piece.positionx + counter][piece.positiony - counter].colour != piece.colour) {
                        moves[piece.positionx + counter][piece.positiony - counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony + counter <= 7 && piece.positionx + counter <= 7 && next == true) {
                    if (board[piece.positionx + counter][piece.positiony + counter].type == null) {
                        moves[piece.positionx + counter][piece.positiony + counter] = 1;
                    } else if (board[piece.positionx + counter][piece.positiony + counter].colour != piece.colour) {
                        moves[piece.positionx + counter][piece.positiony + counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony - counter >= 0 && piece.positionx - counter >= 0 && next == true) {
                    if (board[piece.positionx - counter][piece.positiony - counter].type == null) {
                        moves[piece.positionx - counter][piece.positiony - counter] = 1;
                    } else if (board[piece.positionx - counter][piece.positiony - counter].colour != piece.colour) {
                        moves[piece.positionx - counter][piece.positiony - counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                break;
            case "bishop":
                while (piece.positiony + counter <= 7 && piece.positionx + counter <= 7 && next == true) {
                    if (board[piece.positionx + counter][piece.positiony + counter].type == null) {
                        moves[piece.positionx + counter][piece.positiony + counter] = 1;
                    } else if (board[piece.positionx + counter][piece.positiony + counter].colour != piece.colour) {
                        moves[piece.positionx + counter][piece.positiony + counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony - counter >= 0 && piece.positionx + counter <= 7 && next == true) {
                    if (board[piece.positionx + counter][piece.positiony - counter].type == null) {
                        moves[piece.positionx + counter][piece.positiony - counter] = 1;
                    } else if (board[piece.positionx + counter][piece.positiony - counter].colour != piece.colour) {
                        moves[piece.positionx + counter][piece.positiony - counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony + counter <= 7 && piece.positionx - counter >= 0 && next == true) {
                    if (board[piece.positionx - counter][piece.positiony + counter].type == null) {
                        moves[piece.positionx - counter][piece.positiony + counter] = 1;
                    } else if (board[piece.positionx - counter][piece.positiony + counter].colour != piece.colour) {
                        moves[piece.positionx - counter][piece.positiony + counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony - counter >= 0 && piece.positionx - counter >= 0 && next == true) {
                    if (board[piece.positionx - counter][piece.positiony - counter].type == null) {
                        moves[piece.positionx - counter][piece.positiony - counter] = 1;
                    } else if (board[piece.positionx - counter][piece.positiony - counter].colour != piece.colour) {
                        moves[piece.positionx - counter][piece.positiony - counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                break;
            case "knight":
                if (piece.positionx + 2 <= 7 && piece.positiony + 1 <= 7) {
                    if (board[piece.positionx + 2][piece.positiony + 1].colour != piece.colour) {
                        moves[piece.positionx + 2][piece.positiony + 1] = 1;
                    }
                }
                if (piece.positionx + 1 <= 7 && piece.positiony + 2 <= 7) {
                    if (board[piece.positionx + 1][piece.positiony + 2].colour != piece.colour) {
                        moves[piece.positionx + 1][piece.positiony + 2] = 1;
                    }
                }
                if (piece.positionx - 2 >= 0 && piece.positiony + 1 <= 7) {
                    if (board[piece.positionx - 2][piece.positiony + 1].colour != piece.colour) {
                        moves[piece.positionx - 2][piece.positiony + 1] = 1;
                    }
                }
                if (piece.positionx - 1 >= 0 && piece.positiony + 2 <= 7) {
                    if (board[piece.positionx - 1][piece.positiony + 2].colour != piece.colour) {
                        moves[piece.positionx - 1][piece.positiony + 2] = 1;
                    }
                }
                if (piece.positionx + 2 <= 7 && piece.positiony - 1 >= 0) {
                    if (board[piece.positionx + 2][piece.positiony - 1].colour != piece.colour) {
                        moves[piece.positionx + 2][piece.positiony - 1] = 1;
                    }
                }
                if (piece.positionx + 1 <= 7 && piece.positiony - 2 >= 0) {
                    if (board[piece.positionx + 1][piece.positiony - 2].colour != piece.colour) {
                        moves[piece.positionx + 1][piece.positiony - 2] = 1;
                    }
                }
                if (piece.positionx - 2 >= 0 && piece.positiony - 1 >= 0) {
                    if (board[piece.positionx - 2][piece.positiony - 1].colour != piece.colour) {
                        moves[piece.positionx - 2][piece.positiony - 1] = 1;
                    }
                }
                if (piece.positionx - 1 >= 0 && piece.positiony - 2 >= 0) {
                    if (board[piece.positionx - 1][piece.positiony - 2].colour != piece.colour) {
                        moves[piece.positionx - 1][piece.positiony - 2] = 1;
                    }
                }
                break;
            case "rook":
                while (piece.positiony + counter <= 7 && next == true) {
                    if (board[piece.positionx][piece.positiony + counter].type == null) {
                        moves[piece.positionx][piece.positiony + counter] = 1;
                    } else if (board[piece.positionx][piece.positiony + counter].colour != piece.colour) {
                        moves[piece.positionx][piece.positiony + counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positiony - counter >= 0 && next == true) {
                    if (board[piece.positionx][piece.positiony - counter].type == null) {
                        moves[piece.positionx][piece.positiony - counter] = 1;
                    } else if (board[piece.positionx][piece.positiony - counter].colour != piece.colour) {
                        moves[piece.positionx][piece.positiony - counter] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positionx + counter <= 7 && next == true) {
                    if (board[piece.positionx + counter][piece.positiony].type == null) {
                        moves[piece.positionx + counter][piece.positiony] = 1;
                    } else if (board[piece.positionx + counter][piece.positiony].colour != piece.colour) {
                        moves[piece.positionx + counter][piece.positiony] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                next = true;
                counter = 1;
                while (piece.positionx - counter >= 0 && next == true) {
                    if (board[piece.positionx - counter][piece.positiony].type == null) {
                        moves[piece.positionx - counter][piece.positiony] = 1;
                    } else if (board[piece.positionx - counter][piece.positiony].colour != piece.colour) {
                        moves[piece.positionx - counter][piece.positiony] = 1;
                        next = false;
                    } else {
                        next = false; //changed in t.rev1
                    }
                    counter++;
                }
                break;
            case "pawn":
                if (piece.colour == 0) {
                    if (board[piece.positionx][piece.positiony + 1].type == null) {
                        if (piece.lastMoved == 0) {
                            if (board[piece.positionx][piece.positiony + 2].type == null) {
                                moves[piece.positionx][piece.positiony + 2] = 1;
                            }
                        }
                        moves[piece.positionx][piece.positiony + 1] = 1;
                    }
                    if (piece.positionx > 0) {
                        if (board[piece.positionx - 1][piece.positiony + 1].type != null && board[piece.positionx - 1][piece.positiony + 1].colour != piece.colour) {
                            moves[piece.positionx - 1][piece.positiony + 1] = 1;
                        }
                    }
                    if (piece.positionx < 6) {
                        if (board[piece.positionx + 1][piece.positiony + 1].type != null && board[piece.positionx + 1][piece.positiony + 1].colour != piece.colour) {
                            moves[piece.positionx + 1][piece.positiony + 1] = 1;
                        }
                    }
                } else if (piece.colour == 1) {
                    if (board[piece.positionx][piece.positiony - 1].type == null) {
                        if (piece.lastMoved == 0) {
                            if (board[piece.positionx][piece.positiony - 2].type == null) {
                                moves[piece.positionx][piece.positiony - 2] = 1;
                            }
                        }
                        moves[piece.positionx][piece.positiony - 1] = 1;
                    }
                    if (piece.positionx > 0) {
                        if (board[piece.positionx - 1][piece.positiony - 1].type != null && board[piece.positionx - 1][piece.positiony - 1].colour != piece.colour) {
                            moves[piece.positionx - 1][piece.positiony - 1] = 1;
                        }
                    }
                    if (piece.positionx < 6) {
                        if (board[piece.positionx + 1][piece.positiony - 1].type != null && board[piece.positionx + 1][piece.positiony - 1].colour != piece.colour) {
                            moves[piece.positionx + 1][piece.positiony - 1] = 1;
                        }
                    }
                }
                break;
        }
        return moves;
    }

    /* added in t.rev3, rearranged in t.rev4
     * checks if can castle left by seeing if King will be in check if moved
     * checks if Rook has ever moved
     * checks if there are any pieces inbetween Rook and King's left
     */
    /* added in t.rev3, rearranged in t.rev4
     * checks if can castle left by seeing if King will be in check if moved
     * checks if Rook has ever moved
     * checks if there are any pieces inbetween Rook and King's left
     */
    public boolean canCastleLeft(piece[][] board, int x, int y, int turn) {

        if (board[x][y].lastMoved != 0) {
            System.out.println("cCL: Can't castle left, king has moved");
            return false; // king can't castle if it's moved
        }
        if (board[0][y].lastMoved != 0) {
            return false; //rook has moved
        } else {
            System.out.println("cCL: Rook hasn't moved");
        }
        System.out.println("cCL: Can castle left");
        if (quickCheck(board, x - 2, y, turn) == true) {
            System.out.println("cCL: Can't castle left, king would be in check");
            return false; //king would be in check if it was moved
        }
        if ((board[x - 1][y].type != null) && (board[x - 2][y].type != null)) {
            System.out.println("cCL: Pieces in the way");
            return false; //pieces are in kings way
        }
        return true;
    }

    /* added in t.rev3, rearranged in t.rev4
     * checks if can castle right by seeing if King will be in check if moved
     * checks if Rook has ever moved
     * checks if there are any pieces inbetween Rook and King's right
     */
    public boolean canCastleRight(piece[][] board, int x, int y, int turn) {

        if (board[x][y].lastMoved != 0) {
            System.out.println("cCR: Can't castle right, king has moved");
            return false; // king can't castle if it's moved
        }
        if (board[7][y].lastMoved != 0) {
            return false; // rook has moved
        } else {
            System.out.println("cCR: Rook hasn't moved");
        }
        System.out.println("cCR: Can castle right");
        if (quickCheck(board, x + 2, y, turn) == true) {
            return false; // king would be in check if it was moved
        }
        if ((board[x + 1][y].type != null) && (board[x + 2][y].type != null)) {
            System.out.println("cCR: Pieces in the way");
            return false; // pieces are in kings way
        }
        return true;
    }
    /* added in t.rev2
     * quickly checks if any coordinate x,y is can be attacked next turn
     * precurser to implementing checking check for the king
     */
    public boolean quickCheck(piece[][] board, int x, int y, int turn) {
        int[][] allMoves = opponentsMoves(board, turn);
        if (allMoves[x][y] == 1) {
            //System.out.println("King will be in check at " + x + " " + y);
            return true; //in check
        } else {
            //System.out.println("King won't be in check at " + x + " " + y);
            return false; //not in check
        }
    }

    /* added in t.rev4.2
     * returns true if stalemate or checkmate
     * checks if any moves are possible
     */
    public boolean mateChecker(piece[][] board, int turn) {
        boolean checkMate = true;
        int[][] moves = opponentsMoves(board, turn-1); //all moves possible by current side
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moves[i][j] == 1) {
                    //System.out.print("move found");
                    checkMate = false; //moves still possible, no checkmate
                }
            }
        }
        return checkMate;
    }

    /* added in t.rev4
     * Find the king and see if it'll be in check
     */
    public boolean isKingInCheck(piece[][] board, int turn) {
        // find the king
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].type == "king" && turn % 2 == board[i][j].colour) {
                    if (quickCheck(board, i, j, turn)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /* added in t.rev1, modified in t.rev4
     * puts all the possible moves of the opponent into one allMoves array
     */
    public int[][] opponentsMoves(piece[][] board, int turn) {
        int[][] allMoves = new int[8][8];
        int[][] tempMoves = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tempMoves = movement(board, board[j][i], turn + 1);
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (tempMoves[k][l] == 1) {
                            allMoves[k][l] = 1;
                        }
                    }
                }
            }
        }
        //printMoves(allMoves); //used for testing
        return allMoves;
    }

    public void printMoves(int[][] moves) {
        System.out.println("  0  1  2  3  4  5  6  7");
        for (int i = 7; i >= 0; i--) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(moves[j][i] + "  ");
            }
            System.out.print('\n');
        }
    }

    /* added in t.rev3, modified in t.rev4
     * moves a piece without changing the turn
     * used in castling, and checking if king will be put in check by a move
     */
    public void quickMove(piece[][] board, int moveX, int moveY, int movetoX, int movetoY, int turn) {
        piece temp;
        temp = board[movetoX][movetoY];
        temp.type = null;
        temp.positionx = moveX;
        temp.positiony = moveY;
        temp.colour = 2;
        board[movetoX][movetoY] = board[moveX][moveY];
        board[movetoX][movetoY].positionx = movetoX;
        board[movetoX][movetoY].positiony = movetoY;
        if ("rook".equals(board[moveX][moveY].type)) { //makes sure quick move only adds turn to rooks
            board[movetoX][movetoY].lastMoved = turn;
            board[movetoX][movetoY].numMoves++;
        }
        board[temp.positionx][temp.positiony] = temp;
    }

    // modified in t.rev3, t.rev4
    public int move(piece[][] board, int moveX, int moveY, int movetoX, int movetoY, int turn) {
        int[][] moves = new int[8][8];
        piece temp;
        moves = movement(board, board[moveX][moveY], turn);
        
        /* added in t.rev4
         * En passant
         */
        if ("pawn".equals(board[moveX][moveY].type)) {
            // checks if pawn wants to do en passant 
            if (turn % 2 == 0 && movetoY == 5 && movetoY == moveY + 1 && (movetoX == moveX + 1 || movetoX == moveX - 1)) { //white pawn
                if ("pawn".equals(board[movetoX][movetoY - 1].type) && board[movetoX][movetoY - 1].numMoves == 1) { //checks if piece ia a pawn & has only moved once
                    board[movetoX][movetoY - 1].type = null;
                    board[movetoX][movetoY - 1].colour = 2;
                    if(isKingInCheck(board, turn)){ //check if removing pawn results in king being in check
                        board[movetoX][movetoY - 1].type = "pawn";
                        board[movetoX][movetoY - 1].colour = 1;
                        moves[movetoX][movetoY] = 0; //disallow this move, can't put king in check
                    }
                }
            } else if (movetoY == 2 && movetoY == moveY - 1 && (movetoX == moveX + 1 || movetoX == moveX - 1)) { //black pawn
                if ("pawn".equals(board[movetoX][movetoY + 1].type) && board[movetoX][movetoY + 1].numMoves == 1) { //checks if piece ia a pawn & has only moved once
                    board[movetoX][movetoY + 1].type = null;
                    board[movetoX][movetoY + 1].colour = 2;
                    if (isKingInCheck(board, turn)) { //check if removing pawn results in king being in check
                        board[movetoX][movetoY - 1].type = "pawn";
                        board[movetoX][movetoY - 1].colour = 1;
                        moves[movetoX][movetoY] = 0; //disallow this move, can't put king in check
                    }
                }
            }
        }

        /* added in t.rev3, modified in t.rev4
         * Objective king specific tasks
         * check if move will put king in check and block it from happening
         * check if it's kings first move, check if king is being moved to trigger castling
         * check if king can castle, allow move, move rook into position
         */
        if (board[moveX][moveY].type == "king") {
            //System.out.println("The king is in motion! I repeat the king is in motion!");
            //t.rev4 check if moving the king will put it in check
            if (quickCheck(board, movetoX, movetoY, turn) == true) {
                moves[movetoX][movetoY] = 0; //disallow this move, can't put king in check
            } else if (board[moveX][moveY].lastMoved == 0) { // if it's the kings first move, check if king wishes to castl
                //can attempt to see if it wants to castle
                if (movetoX == (moveX - 2) && movetoY == moveY) { // checks if want castle left
                    if (canCastleLeft(board, moveX, moveY, turn)) {
                        moves[movetoX][movetoY] = 1; //allow this move
                        quickMove(board, 0, moveY, movetoX + 1, movetoY, turn);
                    }
                }
                if (movetoX == (moveX + 2) && movetoY == moveY) { // checks if want castle right
                    if (canCastleRight(board, moveX, moveY, turn)) {
                        moves[movetoX][movetoY] = 1; //allow this move
                        quickMove(board, 7, moveY, movetoX - 1, movetoY, turn);
                    }
                }
            }
        } else if (moves[movetoX][movetoY] == 1){//t.rev4 makes sure moves by other pieces don't put king in check
            quickMove(board, moveX, moveY, movetoX, movetoY, turn); //makes move happen without turn being changed
            if(isKingInCheck(board, turn)){
                moves[movetoX][movetoY]=0; //move would put king in check so not allowed
            }
            quickMove(board, movetoX, movetoY, moveX, moveY, turn); //reverses previous quickMove
        }
        

        if (moves[movetoX][movetoY] == 1) {
            //printMoves(moves);
            temp = board[movetoX][movetoY];
            temp.type = null;
            temp.positionx = moveX;
            temp.positiony = moveY;
            temp.colour = 2;
            board[movetoX][movetoY] = board[moveX][moveY];
            board[movetoX][movetoY].positionx = movetoX;
            board[movetoX][movetoY].positiony = movetoY;
            board[movetoX][movetoY].lastMoved = turn;
            board[movetoX][movetoY].numMoves++; //t.rev4 adds 1 the number of moves piece has made
            board[temp.positionx][temp.positiony] = temp;
        } else {
            System.out.println("invalid move");
            return 0;
        }
        return 1;
    }

    //copied into t.rev3, modified in t.rev4
    public int moveAI(piece[][] board, int tomoveX, int tomoveY, int moveX, int moveY, int turn) {
        piece temp;
        temp = board[moveX][moveY];
        temp.type = null;
        temp.positionx = tomoveX;
        temp.positiony = tomoveY;
        temp.colour = 2;
        board[moveX][moveY] = board[tomoveX][tomoveY];
        board[moveX][moveY].positionx = moveX;
        board[moveX][moveY].positiony = moveY;
        board[moveX][moveY].lastMoved = turn;
        board[moveX][moveY].numMoves++; //t.rev4 adds 1 the number of moves piece has made
        
        board[temp.positionx][temp.positiony] = temp;
        return 1;
    }

    public char[][] display(piece board[][]) {
        char[][] display = new char[8][8];
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (board[i][j].type == null) {
                    display[i][j] = '-';
                } 
                else {
                    switch (board[i][j].type) {
                        case ("king"):
                             if (board[i][j].colour==0){
                                display[i][j] = 'K';
                            }
                            else{
                                display[i][j] = 'k';
                            }
                            
                            break;
                        case ("queen"):
                             if (board[i][j].colour==0){
                                display[i][j] = 'Q';
                            }
                            else{
                                display[i][j] = 'q';
                            }
                            break;
                        case ("rook"):
                             if (board[i][j].colour==0){
                                display[i][j] = 'R';
                            }
                            else{
                                display[i][j] = 'r';
                            }
                            break;
                        case ("pawn"):
                            if (board[i][j].colour==0){
                                display[i][j] = 'P';
                            }
                            else{
                                display[i][j] = 'p';
                            }
                            break;
                        case ("bishop"):
                             if (board[i][j].colour==0){
                                display[i][j] = 'B';
                            }
                            else{
                                display[i][j] = 'b';
                            }
                            break;
                        case ("knight"):
                             if (board[i][j].colour==0){
                                display[i][j] = 'N';
                            }
                            else{
                                display[i][j] = 'n';
                            }
                            break;
                    }
                }
        
    }
        }
        return display;
    }
//change to own evaluation maps
public static double evaluatepawn(int x, int y, int colour){
        double pawnmap[][]={{0,0,0,0,0,0,0,0},{0.4,1,1,-2,-2,1,1,0.4},{0.4, -0.4,-1,  0,  0,-1, -0.4,  0.4},{0,  0,  0.4, 1.8, 1.8,  0,  0,  0},{0.4,  0.45, 1, 2.25, 2.25, 1,  0.4,  0.4},{1, 1, 1.8, 2.5, 2.5, 1.8, 1, 1},{4, 4, 4, 4, 4, 4, 4, 4},{0,  0,  0,  0,  0,  0,  0,  0}};
        if(colour==1){
            y=(y-7)*-1;
        }
        return pawnmap[y][x];
    }
    public static double evaluatebishop(int x, int y, int colour){
        double bishopmap[][]={{-2.5,-1,-1,-1,-1,-1,-1,-2.5},{-1.5,  0.5,  0,  0,  0,  0,  0.5,-1.5},{-1, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8,-1},{-1,  0.2, 1, 1, 1, 1,  0.2,-1},{-0.1,  0.4,  0.4, 0.1, 0.1,  0.4,  0.4,-1},{-1,  0,  0.4, 1, 1,  0.4,  0,-1},{-2,  0,  0,  0,  0,  0,  0,-2},{-2.5,-1,-1,-1,-1,-1,-1,-2.5}};
         if(colour==1){
            y=(y-7)*-1;
        }
        return bishopmap[y][x];
    }
    public static double evaluateknight(int x, int y, int colour){
        double knightmap[][]={{-4.5,-4.0,-2.7,-2.7,-2.7,-2.7,-4.0,-4.5},{-4.0,-1.8,0,4.0,4.0,0,-1.8,-4.0},{-2.7,0.5, 1.0, 1.25, 1.25, 1.0,0.5,-2.7},{-3.0,  0, 1.25, 1.8, 1.8, 1.25,  0.0,-3.0},{-3.0,  0, 1.25, 2.3, 2.3, 1.25,  0,-3.0},{-3.0,  0.0, 0.8, 1.25, 1.25, 0.8,0,-3},{-3.6,-1.5,  0,  0,  0,  0,-1.5,-3.6},{-4.5,-3.8,-2.8,-2.8,-2.8,-2.8,-3.8,-4.5}};
     if(colour==1){
            y=(y-7)*-1;
        }
        return knightmap[y][x];
    }
    public static double evaluaterook(int x, int y, int colour){
          double rookmap[][]={{0,  0,  0,  0.4,  0.4,  0.1,  0,  0},{ -0.4,  -0.2,  0,  0,  0,  0,  -0.2, -0.4},{-0.4,  -0.2,  0,  0,  0,  0,  -0.2, -0.4},{-0.4,  -0.2,  0,  0,  0,  0, -0.2, -0.4},{-0.4, -0.2,  0,  0,  0,  0,  -0.2, -0.4},{-4,  -0.2,  0,  0,  0,  0,  -0.2, -0.4},{ 0.3, 0.6, 0.6, 0.6, 0.6, 0.6, 0.6,0.3},{-0.1,0,0,0,0,0,0,-0.1}};
     if(colour==1){
            y=(y-7)*-1;
        }
        return rookmap[y][x];
    }
    public static double evaluatequeen(int x, int y, int colour){
          double queenmap[][]={{-1.8,-0.75,-0.75, -0.4, -0.4,-0.75,-0.75,-1.8},{-1,  0,  0,  0,  0,  0,  0,-1},{-1,  0.35,  0.35,  0.35,  0.35,  0.35, 0,-1},{-0.5,  0,  0.35,  0.35,  0.35,  3.5,  0, -0.5},{ -0.5,  0,  0.35,  0.35,  0.35,  0.35,  0, -0.5},{-1,  0,  0.35,  0.35,  0.35,  0.35,  0,-1},{-1,  0,  0,  0,  0,  0,  0,-1},{-2,-1,-0.9, -0.4, -0.4,-0.9,-1,-2}};
     if(colour==1){
            y=(y-7)*-1;
        }
        return queenmap[y][x];
    }
    public static double evaluateking(int x, int y, int colour){
          double kingmap[][]={{ 2, 3, 1.5,  0,  0, 1.5, 3, 2.1},{1.4, 1.4,  0,  0,  0,  0, 1.4, 1.4},{-1,-1.5,-1.5,-1.5,-1.5,-1.5,-1.5,-1},{-2,-2.5,-2.5,-2.8,-2.8,-2.5,-2.5,-2},{-2.6,-3,-3,-3.5,-3.5,-3,-3,-2.6},{-2.8,-3,-3,-3.6,-3.6,-3,-3,-2.8},{-2.8,-3,-3,-3.6,-3.6,-3,-3,-2.8},{-2.8,-3,-3,-3.6,-3.6,-3,-3,-2.8}};
     if(colour==1){
            y=(y-7)*-1;
        }
        return kingmap[y][x];
    }

    // copied to t.rev4.1, modified bmoves[][] and wmoves[][], and changed allMoves to opponentMoves
    public double evaluate() {
        double score = 0.0;
        int bmoves[][] = this.opponentsMoves(this.board, 0);
        int wmoves[][] = this.opponentsMoves(this.board, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (wmoves[i][j] == 1) {
                    score = score - 0.1;
                }
                if (bmoves[i][j] == 1) {
                    score = score + 0.1;
                }
                if (this.board[i][j].type != null) {

                    switch (this.board[i][j].type) {
                        case ("king"):
                            if (this.board[i][j].colour == 0) {
                           
                                
                                score = score - 500;
                                score = score - evaluateking(i, j, 0);
                            } else {
                                score = score + 500;
                                score = score + evaluateking(i, j, 1);
                            }
                            break;
                        case ("queen"):
                            if (this.board[i][j].colour == 0) {
                                score = score - 11;
                                score = score - evaluatequeen(i, j, 0);
                            } else {
                                score = score + 11;
                                score = score + evaluatequeen(i, j, 1);
                            }
                            break;
                        case ("rook"):
                            if (this.board[i][j].colour == 0) {
                                score = score - 5;
                                score = score - evaluaterook(i, j, 0);
                            } else {
                                score = score + 5;
                                score = score + evaluaterook(i, j, 1);
                            }
                            break;
                        case ("pawn"):
                            if (this.board[i][j].colour == 0) {
                                score = score - 1;
                                score = score - evaluatepawn(i, j, 0);                              
                            } else {
                                score = score + 1;
                                score = score + evaluatepawn(i, j, 1);
                            }
                            break;
                        case ("bishop"):
                            if (this.board[i][j].colour == 0) {
                                score = score - 3.5;
                                score = score - evaluatebishop(i, j, 0);
                            } else {
                                score = score + 3.5;
                                score = score + evaluatebishop(i, j, 1);
                            }
                            break;
                        case ("knight"):
                            if (this.board[i][j].colour == 0) {
                                score = score - 3.2;
                                score = score - evaluateknight(i, j, 0);
                            } else {
                                score = score + 3.2;
                                score = score + evaluateknight(i, j, 1);
                            }
                            break;
                    }
                }
            }
        }
        return score;
    }
}

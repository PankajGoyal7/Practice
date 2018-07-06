/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 21:37:53
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 22:34:17
*/
package interview.design.chess;

import java.util.List;
import java.util.ArrayList;

class Player{

	int color;
	private List<Piece> pieces = new ArrayList<>();
	private List<Command> cmds = new ArrayList<>();

	public Player(int color){
		this.color = color;
		initializePieces();
	}

	public List<Piece> getPieces(){
		return pieces;
	}

	public void initializePieces(){
        if(this.color == 1){
            for(int i=0; i<8; i++){ // draw pawns
                pieces.add(new Pawn(true,i,1, 1));
            }
            pieces.add(new Rook(true, 0, 0, 1));
            pieces.add(new Rook(true, 7, 0, 1));
            pieces.add(new Bishop(true, 2, 0, 1));
            pieces.add(new Bishop(true, 5, 0, 1));
            pieces.add(new Knight(true, 1, 0, 1));
            pieces.add(new Knight(true, 6, 0, 1));
            pieces.add(new Queen(true, 3, 0, 1));
            pieces.add(new King(true, 4, 0, 1));
        }
        else{
            for(int i=0; i<8; i++){ // draw pawns
                pieces.add(new Pawn(true,i,6, 0));
            }
            pieces.add(new Rook(true, 0, 7, 0));
            pieces.add(new Rook(true, 7, 7, 0));
            pieces.add(new Bishop(true, 2, 7, 0));
            pieces.add(new Bishop(true, 5, 7, 0));
            pieces.add(new Knight(true, 1, 7, 0));
            pieces.add(new Knight(true, 6, 7, 0));
            pieces.add(new Queen(true, 3, 7, 0));
            pieces.add(new King(true, 4, 7, 0));
        }
    }
}
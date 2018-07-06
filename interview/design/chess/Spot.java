/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 21:27:36
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 21:32:00
*/

package interview.design.chess;


class Spot{

	int x;
	int y;

	Piece piece;

	public Spot(int x,int y){
		this.x = x;
		this.y = y;
		piece =  null;
	}

	public void occupySpot(Piece piece){
		Piece origin = this.piece;
		if(this.piece != null)
			this.piece.setAvailable(false);

		this.piece = piece;
		return origin;
	}

	public boolean isOccupied(){
		if(piece != null)
			return true;
		return false;
	}

	public Piece releaseSpot(){
		Piece releasedPiece = this.piece;
		this.piece =  null;
		return releasedPiece;
	}

	public Piece getPiece(){
		return this.piece;
	}
}
/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 21:17:25
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 21:27:28
*/
package interview.design.chess;

class Board{

	private Spot[][] spots;
	private boolean win;

	public Board(){
		win = false;
		spots = new Spot[8][8];
	}

	public void initialize(Player p){
		for(int i=0;i<p.getPieces().size();i++){
			spots[p.getPieces().get(i).getX()][p.getPieces().get(i).getY()].occupySpot(p.getPieces().get(i));
		}
	}

	public boolean executeMove(Player p){
		Command cmd = p.getCurrentCmd();
		Piece piece = cmd.getPiece();

		if(!piece.validMove(this,cmd.curX,cmd.curY,cmd.desX,cmd.desY)){
			p.removeCurrentCmd();
			return false;
		}

		if(spots[cmd.desX][cmd.desY] != null && spots[cmd.desX][cmd.desY].color == piece.color)
			return false;

		Piece taken = spots[cmd.desX][cmd.desY].occupySpot(piece);
		if(taken != null && taken.getClass().getName.equals("King"))
			this.win = true;

		spots[cmd.curX][cmd.curY].releaseSpot;
		return true;
	}

	public boolean getWin(){
		return win;
	}
}
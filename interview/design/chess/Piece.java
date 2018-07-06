/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 21:33:51
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 22:32:56
*/

package interview.design.chess;

class Piece{
	
	private int x;
	private int y;
	private boolean available;
	private int color;


	public Piece(boolean available,int x,int y,int color){
		this.color = color;
		this.available = available;
		this.x = x;
		this.y = y;
	}

	public boolean isAvailable(){
		return available;
	}

	public void setAvailable(boolean available){
		this.available = available;
	}

	public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
        // different by character of piece
    }
}
/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 22:27:45
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 22:30:48
*/
package interview.design.chess;

public class Command {
    Piece piece;
    int curX, curY, desX, desY;
    public Command(Piece piece, int curX, int curY, int desX, int desY) {
        this.piece = piece; 
        this.curX = curX;
        this.curY = curY;
        this.desX = desX;
        this.desY = desY;
    }
}
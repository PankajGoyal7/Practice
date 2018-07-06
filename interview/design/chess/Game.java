/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 21:10:33
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 21:17:10
*/

package interview.design.chess;

public class Game{

	final static Board board;

	Player p1;

	Player p2;

	public Game(){
		board = new Board();
	}

	public boolean enterPlayer(Player p){
		if(p1 == null)
			this.p1 = p;
		else if(p2 == null)
			this.p2 = p2;
		else
			return false;

		board.initialize(p);
		return true;
	}

	public void proccessTrun(Player p){
		do{
			Command cmd = new Command(input);
			p.addCommand(cmd);
		}while(!board.executeMove(p));
	}

	public void startGame(){
		enterPlayer(new ComputerPlayer("computer"));
		enterPlayer(new HumanPlayer("Bill"));

		while(true){
			proccessTrun(p1);
			if(this.board.getWin()){
				System.out.println("P1 Win!");
				break;
			}

			proccessTrun(p2);
			if(this.board.getWin()){
				System.out.println("P2 Win!");
				break;
			}
		}
	}
}
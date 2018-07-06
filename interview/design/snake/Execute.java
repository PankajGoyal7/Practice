/*
* @Author: pankajgoyal7
* @Date:   2018-06-28 20:18:40
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-28 20:48:03
*/
package interview.design.snake;

import java.util.*;

class Execute{

	public static void main(String[] args) {

		Cell start = new Cell(0,0);	
		Snake snake = new Snake(start);
		Board board = new Board(10,10);
		Router router = new Router(snake,board);

			System.out.println("Enter Direction....");
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()){
				String direction =sc.nextLine();
				direction = direction.toUpperCase();
				switch(direction){
					case "UP":
						router.setDirection(Router.DIRECTION_UP);
						break;		
					case "LEFT":
						router.setDirection(Router.DIRECTION_LEFT);
						break;
					case "RIGHT":
						router.setDirection(Router.DIRECTION_RIGHT);
						break;
					case "DOWN":
						router.setDirection(Router.DIRECTION_DOWN);
						break;
				}
				
				router.update();
			}
	}
}
/*
* @Author: pankajgoyal7
* @Date:   2018-06-05 13:36:46
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-05 14:09:26
*/
class knightsTourProblem{
	static int N =8;

	static void printlnSolution(int sol[][]){
		for(int i =0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}

	static boolean isSafe(int x,int y,int sol[][]){
		return ( x >=0 &&  x <N && y>=0 && y<N && sol[x][y] == -1);
	}

	static boolean solveKT() {
        int sol[][] = new int[8][8];
 
        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
 
       /* xMove[] and yMove[] define next move of Knight.
          xMove[] is for next value of x coordinate
          yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
 
        // Since the Knight is initially at the first block
        sol[0][0] = 0;
 
        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printlnSolution(sol);
 
        return true;
    }

	 static boolean solveKTUtil(int x, int y, int movei,
                               int sol[][], int xMove[],
                               int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
 
        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                                sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1;// backtracking
            }
        }
 
        return false;
    }

	public static void main(String[] args) {
		solveKT();
	}
}

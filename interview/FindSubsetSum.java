/*
* @Author: pankajgoyal7
* @Date:   2018-06-17 23:12:08
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-17 23:31:06
*/
class FindSubsetSum{

	static boolean[][] subset;


	static boolean isSubSetSum(int set[],int n,int sum){

		if(sum == 0)
			return true;

		if(n == 0 &&  sum != 0)
			return false;

		subset = new boolean[n+1][sum+1];

		for(int i=0;i<=sum;i++)
			subset[0][i] = false;

		for(int i=0;i<=n;i++)
			subset[i][0] = true;

		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(j < set[i-1])
					subset[i][j] = subset[i-1][j];
				else
					subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]];
			}
		}

		return subset[n][sum];
	}


	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;

        boolean result = isSubSetSum(set,n,sum);
        System.out.println(result);

        //print the subset 
       	if(result){
       		int row = n;
       		int col = sum;
       		while(col != 0){
       			if(!subset[row-1][col]){
       				System.out.println(set[row-1]);
       				row = row-1;
       				col = col-set[row];
       			}else{
       				while(subset[row-1][col])
       					row = row-1;
       			}
       		}
       	}
	}
}
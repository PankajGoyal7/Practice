/*
* @Author: pankajgoyal7
* @Date:   2018-05-22 00:04:49
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-05-22 00:25:17
*/
class SubsetSumProblem{

	public boolean isSubsetSum(int[] set,int sum,int n){

		boolean subset[][] = new boolean[n+1][sum+1];
		for(int i=1;i<=n;i++)
			subset[i][0] = true;

		for(int i=1;i<=sum;i++)
			subset[0][i] = false;

		for(int i=1;i<=n;i++){
			for(int j =1;j<=sum;j++){
				if (set[i-1] > j)
					subset[i][j] = subset[i-1][j];
				else
					subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]];
			}
		}

		return subset[n][sum];
	}

	public static void main(String[] args) {
		SubsetSumProblem obj = new SubsetSumProblem();
		int[] set = {3,34,4,12,5,2};
		int sum = 26;

		System.out.println(obj.isSubsetSum(set,sum,set.length));
	}
}
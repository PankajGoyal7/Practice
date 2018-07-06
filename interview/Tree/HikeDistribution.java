/*
* @Author: pankajgoyal7
* @Date:   2018-05-10 13:07:00
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-05-10 13:17:36
*/
import java.util.Scanner;

class HikeDistribution{

	int n;
	int arr[];
	int values[];
	int ans;

	public static void main(String[] args){
		HikeDistribution hikeDistribution = new HikeDistribution();
		hikeDistribution.readInput();
		hikeDistribution.findMinimumHike();
	}

	private void readInput(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		values = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
	}

	void findMinimumHike(){

		values[0] = 1;
		for(int i = 1;i< n;i++){
			if(arr[i] > arr[i-1]){
				values[i] = values[i-1]+1;
			}else{
				values[i] = 1;
			}
		}

		ans = values[n-1];
		int tmp = 0;
		for (int i = n-2;i >=0 ;i-- ) {
			if(arr[i] > arr[i+1]){
				tmp = values[i+1]+1;
			}else{
				tmp = 1;
			}
			ans += Math.max(tmp,values[i]);
			values[i] = tmp;
		}

		System.out.println(ans);
	}

}
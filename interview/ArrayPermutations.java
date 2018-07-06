/*
* @Author: pankajgoyal7
* @Date:   2018-06-02 11:53:04
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-02 11:59:56
*/
class ArrayPermutations{

	static int INDEX = 0;

	private static void permutations(int[] arr){
		permutationHelper(arr,INDEX);
	}

	private static void permutationHelper(int[] arr,int index){

		if(index  >= arr.length -1){

			System.out.print("[");
			for(int i=0;i<arr.length-1;i++){
				System.out.print(arr[i]+",");
			}
			if(arr.length > 0)
				System.out.print(arr[arr.length-1]);
			System.out.println("]");
			return;
		}


		for(int i =0 ;i < arr.length;i++){

			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;

			permutationHelper(arr,index+1);

			t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
		}
	}

	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4};
		permutations(arr);
	}
}
/*
* @Author: pankajgoyal7
* @Date:   2018-06-08 17:42:38
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-08 18:07:05
*/
class KthElementSortedArray{

	static int findKthElement(int a[],int b[],int sizeOfA,int sizeOfB,int k){

		if(sizeOfB+sizeOfA < k ||  k < 1)
			return -1;

		if(sizeOfA > sizeOfB)
			return findKthElement(b,a,sizeOfB,sizeOfA,k);

		if(sizeOfA == 0 && sizeOfB > 0)
			return b[k-1];

		if(k==1)
			return Math.min(a[0],b[0]);

		int i = Math.min(sizeOfA,k/2);
		int j = Math.min(sizeOfB,k/2);

		System.out.println(i+" "+j);
		if(a[i-1] < b[j-1]){
			int newA[] =  new int[sizeOfA-i];
			System.arraycopy(a,i,newA,0,newA.length);
			return findKthElement(newA,b,sizeOfA-i,sizeOfB,k-i);
		}else{
			int newB[] =  new int[sizeOfB-j];
			System.arraycopy(b,j,newB,0,newB.length);
			return findKthElement(a,newB,sizeOfA,sizeOfB-j,k-j);
		}
	}

	public static void main(String[] args) {
		int a[] = {2,3,6,7,9};
		int b[] = {1,4,8,10};

		int r = findKthElement(a,b,a.length,b.length,6);
		System.out.println(r);
	}
}
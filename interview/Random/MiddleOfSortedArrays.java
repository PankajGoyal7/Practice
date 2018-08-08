class MiddleOfSortedArrays{

	int i,j = 0;

	public static void main(String[] args) {
			
		int[] a1={1,12,15,26,38};

		int[] a2={2,13,17,30,45,60};

		int len1 = a1.length;
		int len2 = a2.length;

		int sum  = 0;

		MiddleOfSortedArrays obj = new MiddleOfSortedArrays();
		if(len1 == len2){
			sum  = obj.sameLengthMiddle(a1,a2,len1);
		}else{
			sum  = obj.diffLengthMiddle(a1,a2,len1,len2);
		}

		System.out.println("Sum is "+sum);
	}

	private void findMiddle(int[] a1,int[] a2,int n){
		int k = n-1;
		while(k != 0){
			if(a1[i] == a2[j]){
				i++;
				j++;
				k =  k-2;
			}else if(a1[i] < a2[j]){
				i++;
				k--;
			}else{
				j++;
				k--;
			}
		}
	}

	private int sameLengthMiddle(int[] a1,int[] a2,int n){

	 	this.findMiddle(a1,a2,n);

		if(a1[i] < a2[j] &&  a1[i+1] < a2[j]){
			return a1[i]+a1[i+1];
		}

		if(a1[i] > a2[j] &&  a1[i]> a2[j+1]){
			return a2[j]+a2[j+1];
		}

		return a1[i]+a2[j];
	}

	private int diffLengthMiddle(int[] a1,int[] a2,int len1,int len2){

		if(len1 > len2){
			this.findMiddle(a1,a2,len1);
			return a1[i];
		}
		this.findMiddle(a1,a2,len2);
		return a2[j];
	}
}
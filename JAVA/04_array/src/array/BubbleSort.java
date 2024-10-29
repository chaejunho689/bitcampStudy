package array;

public class BubbleSort {
	public static void main(String[] args) {

		int[] ar = {25, 36, 30, 45, 28};
		

		System.out.println("정렬 전");
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
		
		
		// Bubble Sort
		int temp;
		for(int i = 0; i < ar.length-1; i++) {
			for(int j = 0; j < ar.length-1-i; j++ ) {
				if(ar[j] > ar[j+1] ) {
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}
			}
		}
		
		
		// 정렬 후
		System.out.println("정렬 후");
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
		
	}
}

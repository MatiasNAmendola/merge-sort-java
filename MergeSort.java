/**
 *	MergeSort.java
 *	Implementing a merge sorting algorithm for integer arrays
 *	
 *	@author Mandeep Condle
 */

class MergeSort {
	public static void main(String[] args) {
		int[] test = {3, 4, 7, 8, 1, 2, 6, 5};
		MergeSort.mergesort(test, 0, 7);

	}


	public static void mergesort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergesort(array, low, mid);
			mergesort(array, mid+1, high);
			merge(array, low, mid, high);
		}
	}

	public static void merge(int[] array, int low, int mid, int high) {
		int[] helper = new int[array.length];

		//copy all the elements from array to helper
		for (int i=low; i<=high; i++) {
			helper[i] = array[i];
		}

		int helperLow = low;
		int helperHigh = mid+1;
		int current = low;

		while (helperLow <= mid && helperHigh <= high) {
			if (helper[helperLow] <= helper[helperHigh]) {
				array[current] = helper[helperLow];
				helperLow++;
			} else {
				array[current] = helper[helperHigh];
				helperHigh++;
			}
			current++;	
		}

		int remaining = mid - helperLow;
		for (int i=0; i<=remaining; i++) {
			array[current+i] = helper[helperLow+i];
		}

		MergeSort.printarray(array);
	}

	public static void printarray(int[] array) {
		String str = "{ ";
		for (int i=0; i<array.length; i++) {
			str += array[i] + " ";
		}
		str += "}";

		System.out.println(str);
	}

}
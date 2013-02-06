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

	/**
	 *	recursively sorts the left/low and right/high subarrays and merges them
	 *	@param	int array
	 *	@param	index of the left most element of the subarray
	 *	@param	index of the right most element of the subarray
	 */
	public static void mergesort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergesort(array, low, mid);
			mergesort(array, mid+1, high);
			merge(array, low, mid, high);
		}
	}

	/**
	 *	merges 2 subarrays and copies the merged sorted elements back into array
	 *	@param	int array to be mergeed
	 *	@param	index of the left most element of the subarray
	 *	@param	index of the middle element of the subarray
	 *	@param	index of the right most element of the subarray
	 */
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

	/**
	 *	prints out an int array as a string
	 *	@param	int array to be printed
	 */
	public static void printarray(int[] array) {
		String str = "{ ";
		for (int i=0; i<array.length; i++) {
			str += array[i] + " ";
		}
		str += "}";

		System.out.println(str);
	}

}
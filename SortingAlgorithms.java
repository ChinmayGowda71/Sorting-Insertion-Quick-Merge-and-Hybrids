import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {

	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static <T> void swap(T[] list, int i, int j) {
		if (i < 0 || i >= list.length)
			return;
		if (j < 0 || j >= list.length)
			return;
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	// ####################
	// ## INSERTION SORT ## ----------------------------------------------------------------------
	// ####################
	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
	}

	//=================================================================================


	// ################
	// ## MERGE SORT ## ----------------------------------------------------------------------
	// ################
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		if (j - i < 2) {
			if (list[i].compareTo(list[j]) > 0) {
				swap(list, i, j);
				return;
			}
		}
		else {
			int k = Math.floorDiv(i + j, 2);
			mergeSort(list, i, k);
			mergeSort(list, k + 1, j);
			merge(list, i, k + 1, j);
		}


	}
	

	public static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		@SuppressWarnings("unchecked")
		T[] merged = (T[]) new Comparable[j-i+1];
		int count = i;
		int countMid = mid;
		int x = 0;
		while (x < merged.length) {
			if(count == mid){
				merged[x] = list[countMid];
				countMid++;
			}
			else if (countMid == j + 1){
				merged[x] = list[count];
				count++;
			}
			else if (list[count].compareTo(list[countMid]) > 0) {
				merged[x] = list[countMid];
				countMid++;
			}
			else if (list[count].compareTo(list[countMid]) <= 0){
				merged[x] = list[count];
				count++;
			}
			x++;

		}
		for (int m = 0; m <merged.length; m++) {
			list[m+i] = merged[m];
		}

	}

	
	// ###############
	// ## QUICKSORT ## ----------------------------------------------------------------------
	// ###############	

	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		if(i < j) {
			int mid = partition(list, i, j);
			quickSort(list, i, mid - 1);
			quickSort(list, mid + 1, j);
		}

	}

	public static<T extends Comparable<T>> int partition(T[] list, int i, int j) {	
		//TODO: write the body of this method
		int index = i;
		for(int x = i+1; x<=j ; x++){
			if(list[x].compareTo(list[i]) < 0){
				index++;
				swap(list,x,index);
			}
		}
		swap(list,i,index);
		return index;


	}
	
	//=================================================================================

    // ######################
	// ## HYBRID QUICKSORT ## ----------------------------------------------------------------------
	// ######################

	public static<T extends Comparable<T>> void quickSortHybrid(T[] list) {
		quickSortHybrid(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list, int i, int j) {
		if(i < j) {
			int mid = partitionHybrid(list, i, j);
			quickSortHybrid(list, i, mid - 1);
			quickSortHybrid(list, mid + 1, j);
		}
		//TODO: write the body of this method
		// When the size of array to be sorted is < 100, call insertionSort rather than recurse
	}

	public static<T extends Comparable<T>> int partitionHybrid(T[] list, int i, int j) {
		//TODO: write the body of this method
		int index = i;
		for(int x = i+1; x<=j ; x++){
			if(list[x].compareTo(list[i]) < 0){
				index++;
				swap(list,x,index);
			}
		}
		swap(list,i,index);
		return index;
	}

}
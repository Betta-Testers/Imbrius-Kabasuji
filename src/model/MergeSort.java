package model;

import java.util.ArrayList;
import java.util.Arrays;

// Proper Merge Sort from Sedgewick, 4ed
public class MergeSort {
    
	@SuppressWarnings("rawtypes")
	static Comparable aux[];
	@SuppressWarnings("rawtypes")
	Comparable[] b;

	
    @SuppressWarnings("rawtypes")
	public static void sort(ArrayList<Comparable> a) {
    	Comparable[] b = new Comparable[a.size()];
    	b = a.toArray(b);
    	aux = new Comparable[b.length];
    	sort (b, 0, b.length-1);
    	a = new ArrayList<Comparable>(Arrays.asList(aux));
    }
    
    // recursive helper function
    @SuppressWarnings("rawtypes")
	static void sort (Comparable[] a, int lo, int hi) {
    	if (hi <= lo) return;
    	
    	int mid = lo + (hi - lo)/2;
    	
    	sort(a, lo, mid);
    	sort(a, mid+1, hi);
    	merge(a, lo, mid, hi);
    }
    
    // merge sorted results a[lo..mid] with a[mid+1..hi] back into a
    @SuppressWarnings("rawtypes")
	static void merge (Comparable[] a, int lo, int mid, int hi) {
    	int i = lo;     // starting index into left sorted sub-array
    	int j = mid+1;  // starting index into right sorted sub-array
    	
    	// copy a[lo..hi] into aux[lo..hi]
    	for (int k = lo; k <= hi; k++) {
    		aux[k] = a[k];
    	}
    	
    	// now comes the merge. Something you might simulate with flashcards
    	// drawn from two stack piles. This is the heart of mergesort. 
    	for (int k = lo; k <= hi; k++) {
    		if       (i > mid)               { a[k] = aux[j++]; }
    		else if  (j > hi)                { a[k] = aux[i++]; }
    		else if  (less(aux[j], aux[i]))  { a[k] = aux[j++]; }
    		else                             { a[k] = aux[i++]; }
    	}
    }

    // is v < w ?
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}

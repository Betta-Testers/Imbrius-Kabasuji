package model;

import java.util.ArrayList;
import java.util.Arrays;

// Proper Merge Sort from Sedgewick, 4ed adapted for sorting PieceGroups
public class MergeSort {
    
	static PieceGroup aux[];
	PieceGroup[] b;

	
	public static ArrayList<PieceGroup> sort(ArrayList<PieceGroup> a) {
		PieceGroup[] b = new PieceGroup[a.size()];
    	b = a.toArray(b);
    	aux = new PieceGroup[b.length];
    	sort (b, 0, b.length-1);
    	return new ArrayList<PieceGroup>(Arrays.asList(aux));
    }
    
    // recursive helper function
	static void sort (PieceGroup[] a, int lo, int hi) {
    	if (hi <= lo) return;
    	
    	int mid = lo + (hi - lo)/2;
    	
    	sort(a, lo, mid);
    	sort(a, mid+1, hi);
    	merge(a, lo, mid, hi);
    }
    
    // merge sorted results a[lo..mid] with a[mid+1..hi] back into a
	static void merge (PieceGroup[] a, int lo, int mid, int hi) {
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
	private static boolean less(PieceGroup v, PieceGroup w) {
        return v.compareTo(w) < 0;
    }
}

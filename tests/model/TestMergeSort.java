package model;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author ejbosia
 *
 */

public class TestMergeSort extends TestCase{
	ArrayList<PieceGroup> unsorted;
	ArrayList<PieceGroup> sorted;
	
	
	@Override
	protected void setUp(){
		PieceGroup a1,a2,a3,a4;
		a1 = new PieceGroup(2, 10);
		a2 = new PieceGroup(1, 10);
		a3 = new PieceGroup(10, 10);
		a4 = new PieceGroup(5, 10);
		
		unsorted = new ArrayList<PieceGroup>();
		unsorted.add(a1);
		unsorted.add(a2);
		unsorted.add(a3);
		unsorted.add(a4);
		
		sorted = new ArrayList<PieceGroup>();
		sorted.add(a2);
		sorted.add(a1);
		sorted.add(a4);
		sorted.add(a3);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	
	public void testSort(){
		System.out.println(sorted);
		System.out.println(unsorted);
		unsorted = MergeSort.sort(unsorted);
		System.out.println(unsorted);
	}
	

}

package com.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.wal.replenish.model.PRIORITY;
import com.wal.replenish.model.Task;

public class TaskTest {
	
	@Test
	public void rankTest() {
		Task task1 = new Task("Test 1", "Description 1", 5,10, PRIORITY.HIGH, "ASSIGNED");
		
		double result = task1.getRank();
		assertEquals(result, 0.3,0.1);
	}
	
	@Test
	public void compareToTest() {
		
		Task task1 = new Task("Test 1", "Description 1", 5,10, PRIORITY.HIGH, "ASSIGNED");
		Task task2 = new Task("Test 2", "Description 2", 4, 5,PRIORITY.MID, "INPROGRESS");
		
		int result = task1.compareTo(task2);
		assertTrue(result<0);
	}
	
	//this compares with rank to enable sorting by rank
	@Test
	public void compareToTest2() {
		
		Task task1 = new Task("Test 1", "Description 1", 5,10, PRIORITY.HIGH, "ASSIGNED"); //0.3
		Task task2 = new Task("Test 2", "Description 2", 4, 5,PRIORITY.MID, "ASSIGNED"); //0.4
		
		int result = task1.compareTo(task2);
		assertTrue(result<0);
	}
	
}

package com.adrianbarnard.thursdayalgosweek5;

public class Week5Algos {
	/*
	 * Challenge: Page flips (From Hacker Rank - https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=true)
	 * Imagine opening a book.  You can either open the front or the back.  Assume all books have
	 * odd numbers for pages on the right, and even numbers for pages on the left, like so:
	 * [   | 1 ]
	 * [ 2 | 3 ]
	 * etc.
	 * Given a book of n pages and a goal of going to page p, where n and p are integers,
	 * figure out the minimum number of page flips you'll need to reach the specified page and
	 * return that value.  Assume every book starts with page 1, and that the book size is 1 or more pages.
	 */
	public int countPageFlips(int totalPages, int pageGoal) {
		int numFlipsFromFront = 0;
		// Loop going forwards for page flips
		for (int curPage = 1; curPage < pageGoal; curPage += 2) {
			numFlipsFromFront++;
		}
		int numFlipsFromBack = 0;
		int startingPoint;
		// Starting point will depend on if we start on an even or odd numbered page
		if (totalPages % 2 == 0) {
			startingPoint = totalPages + 1;
		} else {
			startingPoint = totalPages;
		}
		// Looping back - note the + 1 to account for the page being on either the left or right
		for (int curPage = startingPoint; curPage > pageGoal + 1; curPage -= 2) {
			numFlipsFromBack++;
		}
		System.out.println("Flips from front: " + numFlipsFromFront);
		System.out.println("Flips from back: " + numFlipsFromBack);
		
		return Math.min(numFlipsFromFront, numFlipsFromBack);
	}
	
	/* Scratch work - test cases:
	 * totalPages = 1 - no need to flip; return 0
	 * totalPages = 2 - no need to flip; return 0 because you can go straight to the back or front
	 * [  | 1 ]   [ 2 |   ]
	 * totalPages = 3 - no need to flip; return 0 [   | 1 ] [ 2 | 3 ] - can go straight to front or back
	 * totalPages = 4 - 5
	 *    page 1: 0    [  | 1 ] (go to front)
	 *    page 2-3: 1  [  | 1 ] ->  [ 2 | 3 ] OR [ 2 | 3 ] <- [ 4 |   ] (need 1 flip either way)
	 *    page 4-5: 0    [ 4 | (5) ] (go to back)
	 * totalPages = 6 - 7
	 *    page 1: 0    [  | 1 ] (go to front)
	 * 	  page 2-3: 1  [  | 1 ] -> [ 2 | 3 ] (from front)
	 *    page 4-5: 1  [ 4 | 5 ] <- [ 6 | 7 ] (from back)
	 *    page 6-7: 0    [ 6 | (7) ] (go to back)
	 * totalPages = 8 - 9
	 *    page 1: 0    [  | 1 ] (go to front)
	 *    page 2-3: 1  [  | 1 ] -> [ 2 | 3 ] (from front)
	 *    page 4-5: 2  [  | 1 ] -> [ 2 | 3 ] -> [ 4 | 5 ] <- [ 6 | 7 ] <- [ 8 | 9 ] (from either way)
	 *    page 6-7: 1    [ 6 | 7 ] <- [ 8 | 9 ] (from back)
	 *    page 8-9: 0    [ 8 | (9) ] (go to back)
	 * totalPages = 10-11
	 *    page 1: 0
	 *    page 2-3: 1
	 *    page 4-5: 2
	 *    page 6-7: 2
	 *    page 8-9: 1
	 *    page 10-11: 0
	 */
}

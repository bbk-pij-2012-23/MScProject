import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author eleanormann
 *
 */
public class TestDealer {
	Dealer testDealer;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/** Card rules
	 *  1. card value between 1-13
	 *  2. card value repeats no more than 4 times 
	 * 	3. suit & card value combo not repeated
	 * 
	 * Game rules
	 * 1. no more than 5 cards
	 * 2. hand not empty
	 * 
	 */
	@Test
	public void testValidateCards() {
		fail("Not yet implemented");
	}
	
	/** Make it controller's job to interpret calculator results as card hands
	 *  Hands could have some static values. not sure yet. 
	 * 
	 * works but implemented very badly - consult patterns for way to improve
	 * following tests check for expected results and pass
	 */
	
	@Test
	public void testIDHandsStraight() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcConsecValues.add(3);
		calcConsecValues.add(4);
		calcConsecValues.add(5);
		calcConsecValues.add(6);
		calcConsecValues.add(7);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "a straight";
		assertEquals(expected, output);
		
	}
	
	@Test
	public void testIDHandsFlush() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcSameSuits.add(3);
		calcSameSuits.add(3);
		calcSameSuits.add(3);
		calcSameSuits.add(3);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "a flush";
		assertEquals(expected, output);
		
	}
	
	@Test
	public void testIDHandsPair() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcSameValues.add(3);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "a pair";
		assertEquals(expected, output);
		
	}
	
	@Test
	public void testIDHands2Pairs() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcSameValues.add(3);
		calcSameValues.add(4);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "two pairs";
		assertEquals(expected, output);
		
	}
	
	@Test
	public void testIDHands3OAKind() {
		testDealer = new Dealer();
		
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcSameValues.add(3);
		calcSameValues.add(3);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "three of a kind";
		assertEquals(expected, output);
		
	}
	
	/*
	 * can also get 3oakind and pair
	 */
	@Test
	public void testIDHands3OAKindAlt() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcSameValues.add(3);
		calcSameValues.add(3);
		calcSameValues.add(4);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "three of a kind";
		assertEquals(expected, output);
		
	}
	
	@Test
	public void testIDHands4OAKind() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		calcSameValues.add(3);
		calcSameValues.add(3);
		calcSameValues.add(3);
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "four of a kind";
		assertEquals(expected, output);
		
	}
	
	@Test
	public void testIDHandsNothing() {
		testDealer = new Dealer();
		ArrayList<Integer> calcSameSuits = new ArrayList<Integer>();
		ArrayList<Integer> calcConsecValues = new ArrayList<Integer>();
		ArrayList<Integer> calcSameValues = new ArrayList<Integer>();
		String output = testDealer.bestHand(calcSameValues, calcConsecValues, calcSameSuits);
		String expected = "nothing";
		assertEquals(expected, output);
		
	}
	
	/* need tests to check for unexpected results
	 * Work out pos combos
	 * 
	 */

}













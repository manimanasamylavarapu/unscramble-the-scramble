package org.unscrambler;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WordsTest {
	
	
	@Test
	public void testScramble() throws IOException
	{
		Words words = new Words();
		assertFalse("hello".contentEquals(words.scramble("hello")));
		assertFalse(words.scramble("hello").contentEquals(words.scramble("hello")));
	}
	
	@Test
	public void testGetWord() throws IOException
	{
		Words words = new Words();
		assertEquals(15,words.getWord(15).length());
	}
}

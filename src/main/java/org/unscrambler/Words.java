package org.unscrambler;

import java.util.Date;
import java.util.Random;

public class Words {
	
	long seed = new Date().getTime();
	
	public String scramble(String word)
	{
		char[] arr = word.toCharArray();
		int len = arr.length;
		seed += new Date().getTime();
		Random random = new Random(seed);
		for(int i = 0; i < len; i++)
		{
			int randomIndex = random.nextInt(len);
			char c = arr[i];
			arr[i] = arr[randomIndex];
			arr[randomIndex] = c;
		}
		System.out.println(arr);
		return new String(arr);
	}
}

package org.unscrambler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Words {
		
	Set<String> set = new HashSet<String>();
	List<String> list = new ArrayList<String>();
	HashMap<Integer, ArrayList<String>> lenghIndex = new HashMap<>();
	HashMap<String, ArrayList<String>> charSortIndex = new HashMap<>();
	
	public Words() throws IOException {
		InputStream stream = getClass().getClassLoader().getResourceAsStream("wordlist.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;

		while((line = bufferedReader.readLine()) != null)
		{
			line = line.toLowerCase().trim().replace("-","");
			list.add(line);
			set.add(line);
			if (!lenghIndex.containsKey(line.length())) {
				lenghIndex.put(line.length(), new ArrayList<String>());
			}
			lenghIndex.get(line.length()).add(line);
			char[] arr = line.toCharArray();
			Arrays.sort(arr);
			String sortedWord = new String(arr);
			if(!charSortIndex.containsKey(sortedWord)){
				charSortIndex.put(sortedWord, new ArrayList<String>());
			}
			charSortIndex.get(sortedWord).add(line);
		}
	}
	
	public boolean find(String word, String scrambled)
	{
		char[] arr = scrambled.toCharArray();
		Arrays.sort(arr);
		String sortedWord = new String(arr);
		return charSortIndex.containsKey(sortedWord) && set.contains(word);
	} 
	
	public boolean find(String word)
	{
		return set.contains(word);
	} 
	
	public String getWord()
	{
		seed += new Date().getTime();
		Random random = new Random(seed);
		
		return list.get(random.nextInt(list.size()));
		
	}
	
	public String getWord(int length)
	{
		seed += new Date().getTime();
		Random random = new Random(seed);
		
		return lenghIndex.get(length).get(random.nextInt(lenghIndex.size()));
	}
	
	
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
//		System.out.println(arr);
		return new String(arr);
	}
}

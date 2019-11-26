import java.util.Arrays;
import exceptions.NoWordException;

public class Search {

	static int length; //length of max word
	static String words; //max word
	
	
	
	public void findLongestWord(String word)
	{ 
		length=0;
			if(word.trim().length()==length)
			{
				throw new NoWordException("Invalid Input -  Please enter string as input - ");
			}
			for(String s:Arrays.stream(word.split("\\s+")).toArray(String[]::new))
			{
				if(s.length() > length)
				{
					//System.out.println(s);
					length = s.length();
					words = s;
				}
				else if(s.length()==length)
				{
					words =words+ ", "+ s;
				}
			
		}
		
	}
	
	/*
	 *  Assuming longest word is of length 100
	 */
	public void findShortestWord(String word)
	{ 
		length=100;
			if(word.trim().length()==0)
			{
				throw new NoWordException("Invalid Input -  Please enter string as input ");
			}
			for(String s:Arrays.stream(word.split("\\s+")).toArray(String[]::new))
			{
				if(s.length() < length)
				{
					//System.out.println(s);
					length = s.length();
					words = s;
				}
				else if(s.length()==length)
				{
					words =words+ ", "+ s;
				}
			
		}
		
	}
	
	public static void main(String[]args)
	{
		Search search = new Search();
		search.findLongestWord(" ");
		//System.out.println(words);
	}
}

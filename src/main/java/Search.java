import java.util.Arrays;

public class Search {

	static int length; //length of max word
	static String words; //max word
	
	
	public void findLongestWord(String word)
	{ 
		length=0;
		try{
			for(String s:Arrays.stream(word.split("\\s+")).toArray(String[]::new))
			{
				if(s.length() > length)
				{
					//System.out.println(s);
					length = s.length();
					words = s;
				}
			}
		}
			catch(Exception e)
			{
				
			}
	}
	
	public static void main(String[]args)
	{
		Search search = new Search();
		search.findLongestWord("Somewhere over the rainbow");
		System.out.println(words);
	}
}

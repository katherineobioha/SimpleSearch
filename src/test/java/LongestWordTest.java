import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import exceptions.NoWordException;

public class LongestWordTest {
	
	int i;
	int j;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("*****************Running Test****************");
		i=0;
		j=0;
	}
	
	
	@Test(dataProvider="positivescenario", priority=0)
	public void positiveLength(String searchword)
	{	
		System.out.println("*****************Longest Word Test****************");
		System.out.println("Search word is: " + searchword);
		String[]correctans={"somewhere", "bank", "heavy", "I"};
		Search search = new Search();
		search.findLongestWord(searchword);
		System.out.println("LongestWord: " + search.words + " - Length: " + search.length);
		System.out.printf("%n");
		Assert.assertEquals(search.words, correctans[i], "Expected: "+ correctans[i]);
		Assert.assertEquals(search.words.length(), correctans[i].length());
		i++;
	}
	
	
	@Test(dataProvider="negativescenario", expectedExceptions=NoWordException.class, priority=26)
	public void zerowords(String searchword)
	{
		System.out.println("Search word is: " + null);
		System.out.printf("%n");
		Search search = new Search();	
		search.findLongestWord(searchword);
		Assert.assertFalse(true, "Expected: "+ "NoWordException");
	}
	
	@Test(dataProvider="negativescenario2",expectedExceptions= IllegalArgumentException.class, priority=26)
	public void illegalinput(String searchWord)
	{
		System.out.println("Search word is: " + searchWord);
		Search search = new Search();	
		search.findLongestWord(searchWord);
	}
	
	@Test(dataProvider="multipleword", priority=1)
	public void multipleWords(String searchWord)
	{
		System.out.println("Search word is: " + searchWord);
		String[]correctans={"back, time, then", "Somewhere, Somewhere", "10", "*, b, ."};
		Search search = new Search();
		search.findLongestWord(searchWord);
		System.out.println("Multiple Longest Words: " + search.words + " - Length: " + search.length);
		System.out.printf("%n");
		Assert.assertEquals(search.words, correctans[j], "Expected: "+ correctans[j]);
		Assert.assertEquals(search.words.length(), correctans[j].length());
		j++;
	}
	
	
	@AfterTest
	public void teardown()
	{
		
	}
	
	@DataProvider(name="positivescenario")
	public Object[][]getdata(){
		return new Object[][]{
			{"somewhere over the rainbow"},
			{"big bank"},
			{"heavy"},
			{"I"}
		};
	}
	
	@DataProvider(name="negativescenario")
	public Object[][]getnulldata(){
		return new Object[][]{
			{""},
			{"      "}
		};
	}
	@DataProvider(name="negativescenario2")
	public Object[][]getinvaliddata(){
		return new Object[][]{
			{1},
			{5f},
			{43493444343434343F}
		};
	}
	
	@DataProvider(name="multipleword")
	public Object[][]getmultipledata(){
		return new Object[][]{
			{"Did she go back in time then"},
			{"Somewhere over the Somewhere"},
			{"2 2 5 0 10"},
			{"* b ."}
		};
	}
}

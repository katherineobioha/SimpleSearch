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
		System.out.println("Hi");
		i=0;
		j=0;
	}
	
	
	@Test(dataProvider="positivescenario")
	public void positiveLength(String searchword)
	{	
		String[]correctans={"somewhere", "bank", "take", "I"};
		Search search = new Search();
		search.findLongestWord(searchword);
		System.out.println(search.words.length() + " "+ correctans[i].length());
		new SoftAssert().assertEquals(search.words, correctans[i]);
		new SoftAssert().assertEquals(search.words.length(), correctans[i].length());
		i++;
	}
	
	
	@Test(dataProvider="negativescenario", expectedExceptions=NoWordException.class)
	public void zerowords(String searchword)
	{
		
		Search search = new Search();	
		search.findLongestWord(searchword);
	}
	
	@Test(dataProvider="negativescenario2",expectedExceptions= IllegalArgumentException.class)
	public void illegalinput(String searchWord)
	{
		Search search = new Search();	
		search.findLongestWord(searchWord);
	}
	
	@Test(dataProvider="multipleword" )
	public void multipleWords(String searchWord)
	{
		String[]correctans={"back, time, then", "Somewhere, Somewhere", "10", "*, b, ."};
		Search search = new Search();
		search.findLongestWord(searchWord);
		System.out.println(search.words + "-- "+ correctans[j]);
		Assert.assertEquals(search.words, correctans[j]);
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
			{"take"},
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

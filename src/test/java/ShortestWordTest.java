import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import exceptions.NoWordException;

public class ShortestWordTest {
	int i;
	int j;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("Shortest Word Test");
		i=0;
		j=0;
	}
	
	
	@Test(dataProvider="positivescenario", priority=0)
	public void positiveLength(String searchword)
	{	System.out.println("Search word is: " + searchword);
		String[]correctans={"the", "bank", "take", "I"};
		Search search = new Search();
		search.findShortestWord(searchword);
		System.out.println("ShortestWord: " + search.words + " - Length: " + search.length);
		System.out.printf("%n");
		new SoftAssert().assertEquals(search.words, correctans[i],"Expected: "+ correctans[i]);
		new SoftAssert().assertEquals(search.words.length(), correctans[i].length());
		i++;
	}
	
	
	@Test(dataProvider="negativescenario", expectedExceptions=NoWordException.class, priority=26)
	public void zerowords(String searchword)
	{
		System.out.println("Search word is: " + null);
		Search search = new Search();	
		search.findShortestWord(searchword);
		Assert.assertTrue(true, "Expected: NoWordException");
	}
	
	@Test(dataProvider="negativescenario2",expectedExceptions= IllegalArgumentException.class, priority=26)
	public void illegalinput(String searchWord)
	{
		System.out.println("Search word is: " + searchWord);
		Search search = new Search();	
		search.findShortestWord(searchWord);
	}
	
	@Test(dataProvider="multipleword" , priority=1)
	public void multipleWords(String searchWord)
	{
		System.out.println("Search word is: " + searchWord);
		String[]correctans={"go, in", "the, the", "2, 2, 5, 0", "*, b, ."};
		Search search = new Search();
		search.findShortestWord(searchWord);
		System.out.println("Multiple Shortest Word: " + search.words + " - Length: " + search.length);
		System.out.printf("%n");
		Assert.assertEquals(search.words, correctans[j],"Expected: "+ correctans[j]);
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
			{"small bank"},
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
			{"Somewhere over the Somewhere over the"},
			{"2 2 5 0 10"},
			{"* b ."}
		};
	}
}

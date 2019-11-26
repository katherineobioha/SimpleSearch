import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LongestWordTest {
	
	int i;
	
	@BeforeTest
	public void some()
	{
		System.out.println("Hi");
		i=0;
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
	
	
	@Test()
	public void zeroLength(String searchword)
	{
		Search search = new Search();
		search.findLongestWord(searchword);
		System.out.println(search.words.length() + " "+ correctans[i].length());
		new SoftAssert().assert
		
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
}

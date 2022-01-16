package ImageDoublesFinderTestPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.NotDirectoryException;

import org.junit.Before;
import org.junit.Test;

import DoubleImagesFinderPackage.DoubleImagesFinder;
import DoubleImagesFinderPackage.DuplicateStrategyHeightWidth;
import DoubleImagesFinderPackage.PathPair;



public class ImageDoublesFindersTests {


	@Before
	public void setUp()
	{
		
	}
	
//	@Test
//	public void checkDirectoryExistsTest()
//	{
//		DoubleImagesFinder finder = new DoubleImagesFinder("src\\test\\resources\\TestImagesFolder");
//		try {
//			finder.process();
//		} catch (NotDirectoryException e) {
//			e.printStackTrace();
//			fail("Not a directory exception thrown");
//		} catch (IOException e) {
//			fail("Failed to read image file");
//		}
//	}
//	
//	@Test
//	public void notADirectoryTest()
//	{
//		DoubleImagesFinder finder = new DoubleImagesFinder("src\\test\\resources\\TestImagesFolderThatDoesntExist");
//		try {
//			finder.process();
//		} catch (NotDirectoryException e) {
//			
//		} catch (IOException e) {
//			
//		}
//	}
//	
//	@Test
//	public void findImagesWithSameSize()
//	{
//		DoubleImagesFinder finder = new DoubleImagesFinder("src\\test\\resources\\TestImagesFolder");
//		finder.addStrat(new DuplicateStrategyHeightWidth());
//		
//		try {
//			finder.process();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		for(PathPair pair : finder.getDuplicateList())
//		{
//			System.out.println(pair.toString());
//		}
//	}
	

	
}

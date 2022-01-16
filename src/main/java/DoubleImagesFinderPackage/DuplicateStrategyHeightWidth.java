package DoubleImagesFinderPackage;

import static org.junit.Assert.assertThat;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class DuplicateStrategyHeightWidth extends DuplicateStrategy {

	public DuplicateStrategyHeightWidth() {
		super();
		
		imageSizeHashMap = new HashMap<String, ArrayList<String>>();
	}

	@Override
	public void execute(String directoryPath, ArrayList<PathPair> duplicates) {
		
		File dir1 = new File(directoryPath + "\\duplicates");
		dir1.mkdir();
		
		numProcessed = 0;
		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				if(numProcessed%100 == 99)
					System.out.println("Number Processed: " + (numProcessed+1));
				numProcessed++;
				
				
				theName = child.getName();
				dotIndex = theName.lastIndexOf('.');
				extention = theName.substring(dotIndex + 1).toLowerCase();
				if(!(extention.equals("png") || extention.equals("jpg") || extention.equals("jpeg")))
				{
					continue;
				}
				
			try {
				bimg = ImageIO.read(child);

			
			      width       = bimg.getWidth();
			      height         = bimg.getHeight();
			      
			      newKey = String.valueOf(width) + "x" + String.valueOf(height);
			      
			      if(!imageSizeHashMap.containsKey(newKey))
			      {
			    	  imageSizeHashMap.put(newKey, new ArrayList<String>());
			    	  imageSizeHashMap.get(newKey).add(child.getPath());
			      }
			      else
			      {
			    	  //Duplicate found. Check the pixels
			    	  if(dataIsTheSame(imageSizeHashMap.get(newKey), child.getPath(), duplicates))
			    	  {
	
			    	  }
			    	  else
			    	  {
			    		  imageSizeHashMap.get(newKey).add(child.getPath());
			    	  }
			      }
			      
				} catch (IOException e) {
					System.out.println("Bad File: " + child.getPath());
					continue;
				} catch (IllegalArgumentException e) {
					System.out.println("Bad File Argument: " + child.getPath());
					continue;
				}
		      
		    }
		} 
	}
	
	private boolean dataIsTheSame(ArrayList<String> files1, String file2, ArrayList<PathPair> duplicates)
	{
		for(String file1 : files1)
		{
			try {
				bimg2 = ImageIO.read(new File(file1));

			
			int j = height / 2;
			boolean allPixelsMatch = true;
			for(int i = 0; i < width; i++)
			{
				if(bimg.getRGB(i, j) != bimg2.getRGB(i, j))
					allPixelsMatch = false;
			}
			
			if(allPixelsMatch)
			{
		    	  System.out.println("Match: " + file1 + "  |  " + file2);
		    	  copyDuplicate(file2);
		    	  //duplicates.add(new PathPair(file1, file2, "Size"));
		    	  return true;
			}
			
			} catch (IOException e) {
				continue;
			}
		}
		
		return false;
	}
	
	private void copyDuplicate(String fileName)
	{
		File original = new File(fileName);
		String copyPath =  original.getParentFile().getPath() + "\\duplicates\\" + original.getName();
		
		File copiedCreate = new File(copyPath);
		try {
			copiedCreate.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
	    Path copied = Paths.get(copyPath);
	    Path originalPath = original.toPath();
	    try {
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
			original.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String theName;
	private String extention;
	private int dotIndex;
	private int numProcessed;
	private String newKey;
	private int width, height;
	private BufferedImage bimg;
	private BufferedImage bimg2;
	private HashMap<String, ArrayList<String>> imageSizeHashMap;
}

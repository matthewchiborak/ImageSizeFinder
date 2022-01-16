package DoubleImagesFinderPackage;

import java.io.IOException;

public class MainDoubleImagesFinder {

	public static void main(String[] args) {
		
		DoubleImagesFinder finder = new DoubleImagesFinder(args[0]);
		finder.addStrat(new DuplicateStrategyHeightWidth());
		
		try {
			finder.process();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(PathPair pair : finder.getDuplicateList())
		{
			System.out.println(pair.toString());
		}

	}

}

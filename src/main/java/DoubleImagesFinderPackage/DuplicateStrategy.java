package DoubleImagesFinderPackage;

import java.io.IOException;
import java.util.ArrayList;

public abstract class DuplicateStrategy {

	public DuplicateStrategy() {
		
	}
	
	public abstract void execute(String directoryPath, ArrayList<PathPair> duplicates);

}

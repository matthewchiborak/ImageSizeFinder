package DoubleImagesFinderPackage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class DoubleImagesFinder {

	public DoubleImagesFinder(String directoryPath) {
		
		this.directoryPath = directoryPath;
		this.duplicates = new ArrayList<PathPair>();
		this.strats = new ArrayList<DuplicateStrategy>();
	}
	
	public void addStrat(DuplicateStrategy strat)
	{
		this.strats.add(strat);
	}
	
	public void process() throws IOException
	{
		for(DuplicateStrategy strat : strats)
			strat.execute(directoryPath, duplicates);
	}
	
	public ArrayList<PathPair> getDuplicateList()
	{
		return duplicates;
	}

	private String directoryPath;
	private ArrayList<PathPair> duplicates;
	private ArrayList<DuplicateStrategy> strats;
	
}

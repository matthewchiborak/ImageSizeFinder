package DoubleImagesFinderPackage;

public class PathPair {

	public PathPair(String file1, String file2, String duplicateReason) {
		this.file1 = file1;
		this.file2 = file2;
		this.duplicateReason = duplicateReason;
	}

	public String toString()
	{
		return duplicateReason + ": " + file1 + " | " + file2;
	}
	
	private String file1;
	private String file2;
	private String duplicateReason;
}

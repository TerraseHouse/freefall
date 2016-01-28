package pt.isec.tp.am;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CloudFactory {
	
	List<Cloud> mClouds;
	List<Integer> mAvailableResources;
	private HashMap<Integer, Size> mResourceToSize;
	Random mRandom;
	Size mScreenSize;
	private int MIN_CLOUD_WIDTH = 10;
	
	public CloudFactory(Size screenSize, HashMap<Integer, Size> resourceToSize)
	{
		mRandom = new Random();
		mScreenSize = screenSize;
		mClouds = new ArrayList<Cloud>();
		mAvailableResources = new ArrayList<Integer>();
		mResourceToSize = resourceToSize;
	}
	
	public void setSize(Size size)
	{
		mScreenSize = size;
	}
	
	public void addResource(int res)
	{
		mAvailableResources.add(res);
	}
	
	public void generateCloud()
	{
		if ( mRandom.nextInt(100) >= 98 ) {
			int index = mRandom.nextInt(mAvailableResources.size());
			Size defSize = mResourceToSize.get(mAvailableResources.get(index));
			float defWidth = defSize.width;
			float defHeight = defSize.height;
			float maxWidth = (int) defWidth;
			if (maxWidth > mScreenSize.width)
				maxWidth = mScreenSize.width; //so the image doesn't get stretched
			int cx = (int) mRandom.nextInt((int) mScreenSize.width);
			int width = (int) (MIN_CLOUD_WIDTH + (Math.random() * (maxWidth - MIN_CLOUD_WIDTH)));
			
			float ratio = 1;
			if (width < defWidth)
				ratio = width / defWidth;
			else
				ratio = defWidth / width;
			int height = (int) (defHeight * ratio);
			Cloud cloud = new Cloud(mAvailableResources.get(index), new Point(cx, mScreenSize.height), new Size(width, height));
			mClouds.add(cloud);
		}
	}
	
	public void moveClouds()
	{
		List<Cloud> cloudsToRemove = new ArrayList<Cloud>();
		for(Cloud cloud : mClouds) {
			cloud.moveUp();
			if (cloud.coordinates.x + cloud.size.height <= 0)
				cloudsToRemove.add(cloud);
		}
		
		for(Cloud cloud : cloudsToRemove) {
			mClouds.remove(cloud);
		}
	}
	
	public List<Cloud> getClouds()
	{
		return mClouds;
	}
}

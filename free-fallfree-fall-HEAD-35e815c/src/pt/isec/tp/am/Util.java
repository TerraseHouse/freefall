package pt.isec.tp.am;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class Util {
	
	public static Size getBitmapSize(int resource, Resources resources) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(resources, resource, options);
		int imageHeight = options.outHeight;
		int imageWidth = options.outWidth;
		return new Size(imageWidth, imageHeight);
		//String imageType = options.outMimeType;
	}

}

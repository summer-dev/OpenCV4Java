package img_proc;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ErosionDilation {
	int DELAY_TIME = 1500;
	Mat src = new Mat(), dst = new Mat();
	String windowName = "ErosionDilation";
/**
 * 	
 * @param imgUrl absolute path of image(s) to be processed
 */
public int Erosion(String imgUrl) {
	
	src = Imgcodecs.imread(imgUrl, Imgcodecs.IMREAD_COLOR);
	
	Mat kernel =  Imgproc.getStructuringElement(0, new Size(3,3));
	
	Imgproc.erode(src, dst, kernel);
	
    return imshow(DELAY_TIME);
}
/**
 * 
 * @param delay
 * @return
 */
int imshow(int delay) {
    HighGui.imshow( windowName, dst );
    int c = HighGui.waitKey( delay );
    if (c >= 0) { return -1; }
    return 0;
}
}

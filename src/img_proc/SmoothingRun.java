package img_proc;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class SmoothingRun {
    int DELAY_CAPTION = 1500;
    int DELAY_BLUR = 100;
    int MAX_KERNEL_LENGTH = 31;
    Mat src = new Mat(), dst = new Mat();
    String windowName = "Filter Demo 1";
    //String lenaImg = "/home/summer/insight/tools/eclipse/workspace/HelloCV/img/lena.jpeg";
    public void run(String lenaImg) {
        //String filename = ((lenaImg2.length > 0) ? lenaImg2[0] : lenaImg);
        src = Imgcodecs.imread(lenaImg, Imgcodecs.IMREAD_COLOR);
        if( src.empty() ) {
            System.out.println("Error opening image");
            //System.out.println("Usage: ./Smoothing [image_name -- default ../data/lena.jpg] \n");
            System.exit(-1);
        }
        if( displayCaption( "Original Image" ) != 0 ) { System.exit(0); }
        dst = src.clone();
        if( displayDst( DELAY_CAPTION ) != 0 ) { System.exit(0); }
        if( displayCaption( "Homogeneous Blur" ) != 0 ) { System.exit(0); }
        for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
            Imgproc.blur(src, dst, new Size(i, i), new Point(-1, -1));
            displayDst(DELAY_BLUR);
        }
        if( displayCaption( "Gaussian Blur" ) != 0 ) { System.exit(0); }
        for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
            Imgproc.GaussianBlur(src, dst, new Size(i, i), 0, 0);
            displayDst(DELAY_BLUR);
        }
        if( displayCaption( "Median Blur" ) != 0 ) { System.exit(0); }
        for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
            Imgproc.medianBlur(src, dst, i);
            displayDst(DELAY_BLUR);
        }
        if( displayCaption( "Bilateral Blur" ) != 0 ) { System.exit(0); }
        for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2) {
            Imgproc.bilateralFilter(src, dst, i, i * 2, i / 2);
            displayDst(DELAY_BLUR);
        }
        displayCaption( "Done!" );
        System.exit(0);
    }
    int displayCaption(String caption) {
        dst = Mat.zeros(src.size(), src.type());
        Imgproc.putText(dst, caption,
                new Point(src.cols() / 4, src.rows() / 2),
                Core.FONT_HERSHEY_COMPLEX, 1, new Scalar(255, 255, 255));
        return displayDst(DELAY_CAPTION);
    }
    int displayDst(int delay) {
        HighGui.imshow( windowName, dst );
        int c = HighGui.waitKey( delay );
        if (c >= 0) { return -1; }
        return 0;
    }
}

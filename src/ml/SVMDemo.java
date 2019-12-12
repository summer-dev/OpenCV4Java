package ml;

import org.opencv.core.*;
import org.opencv.ml.*;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.*;
import org.opencv.highgui.*;

public class SVMDemo {
	
    // Data for visual representation
    int width = 512, height = 512;
    // Unsigned 8 bit three channel img matrix
    Mat image = Mat.zeros(height, width, CvType.CV_8UC3);
	// Set up training data
    int[] labels = {1,-1,-1,-1};
    float[][] trainingData = { {501,10}, {255,10}, {501,255}, {10,50}};
    Mat trainingDataMat = Mat.Mat(4,2,CvType.CV_32FC1,labels);
}

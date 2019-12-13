import java.util.HashMap;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import img_proc.*;

public class HelloCV {
	static String lenaImg = "/home/summer/insight/tools/eclipse/workspace/HelloCV/img/lena.jpeg";
	//store function name value pairs
	
	static HashMap<Integer, String> functionMap = new HashMap<Integer, String>();
    
	public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        inifFunctionList();
        runDemo(0,lenaImg);
    }
    
/**
 * Used to initialize the function list
 */
private static void inifFunctionList(){
	functionMap.put(0, "SmoothingRun");
	functionMap.put(1, "MatDemo");
	functionMap.put(2, "ErosionDilation");
}
/**
 * 
 * @param functionKey the index of functionList
 * @param args: absolute img url passed to the functions
 */
private static void runDemo(int functionIndex,String lenaImg2){
	
	String functionName = functionMap.get(functionIndex);
	System.out.println(functionName + " is running ...");
	
	switch(functionIndex) {
	case 0:
		SmoothingRun smoothingRun = new SmoothingRun();
		smoothingRun.run(lenaImg);
		break;
	case 1:
		MatDemo matDemo = new MatDemo();
		System.out.println("matDemo = " + matDemo.mat.dump());
		break;
	case 2:
		ErosionDilation erosionDilation = new ErosionDilation();
		erosionDilation.Erosion(lenaImg);
		break;
		default:
			break;
	}
}
}

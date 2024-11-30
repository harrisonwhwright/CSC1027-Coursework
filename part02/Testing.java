package part02;

import part01.QUBMuseum;
import part01.Artifact;
import part01.Exhibit;
import part01.AnnualPlan;
import part01.Type;

public class Testing {
    public static void main(String[] args) {
    	
    	test("Adding Valid Artifact",
    		"Artifact 'Van Gogh', with type 'Painting'\nand engagement time of '5'",
    		"Successful"
    		);
        try {
    	QUBMuseum.addArtifacts("Van Gogh", Type.PAINTING, 5);
        } catch (Exception exception) {
        	exception.printStackTrace();
        }
        endTest();
    	
    	test("Adding null Name to Artifact",
    			"Artifact 'null', with type 'Painting'\nand engagement time of '5'",
        		"Invalid"
        		);
        try {
            QUBMuseum.addArtifacts(null, Type.PAINTING, 5);
        } catch (Exception exception) {
        	exception.printStackTrace();
        }
        endTest();
        
    	test("Adding Invalid Type to Artifact",
        		"Artifact 'Van Gogh', with type 'test'\nand engagement time of '5'",
        		"Successful"
        		);
        try {
            QUBMuseum.addArtifacts("bob", Type.valueOf("test"), 5);
        } catch (Exception exception) {
        	exception.printStackTrace();
        }
        endTest();

        
        
        
    }

    static int testCase = 1;
    public static void test (String whatTesting, String testData, String expectedOutput) {
    	System.out.println("\n**************** Test Case: " + testCase + " ****************");
  
    	System.out.println("Testing " + whatTesting);
    	System.out.println("Test Data: " + testData);
    	System.out.println("Expected Output: " + expectedOutput);
    	System.out.println("+++++++++++++++++ Begin Test +++++++++++++++++");
    }
    public static void endTest () {
    	System.out.println("+++++++++++++++++  End Test  +++++++++++++++++");
    	testCase += 1;
    }
}

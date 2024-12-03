package part02;

import part01.QUBMuseum;
import part01.Artifact;
import part01.Exhibit;
import part01.AnnualPlan;
import part01.Type;

public class Testing {
    public static void main(String[] args) {
    	
    	// PLEASE NOTE
    	// TEST CASES 1.1 - 1.8 ARE MENU TESTS AND VISIBLE BY RUNNING QUBMuseum.java

    	// ARTIFACT TEST CASES
    	test ("2.1.1",
    			"Adding Valid Artifact",
    			"\n     name = TouchIt\n     type = Tactile\n     engagementTime = 8",
    			"Success");
    	try {
        	QUBMuseum.addArtifacts("TouchIt", Type.TACTILE, 8);
            } catch (Exception exception) {
            	exception.printStackTrace();
            }
    	endTest();

        test ("2.1.2",
        		"Adding Multiple Valid Artifacts",
        		"\n     name = Incas Interactive\n     type = Digital\n     engagementTime = 10",
        		"Success");
        try {
            QUBMuseum.addArtifacts("Incas Interactive", Type.DIGITAL, 10);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        endTest();
                
        test ("2.1.3",
        		"Adding Artifact with Null Name",
        		"\n     name = null\n     type = Digital\n     engagementTime = 10",
        		"Error Message, Don't Add");
        try {
        	QUBMuseum.addArtifacts(null, Type.DIGITAL, 10);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        		}
        endTest();

        test ("2.1.4",
    			"Adding Artifact with Invalid Name Data Type",
    			"\n     name = 12345\n     type = Sculpture\n     engagementTime = 5",
    			"Error Message, Don't Add");
        try {
        	QUBMuseum.addArtifacts(12345, Type.SCULPTURE, 5);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
                
        test ("2.1.5",
    			"Adding Artifact with Null Type",
    			"\n     name = Acropolis Statues\n     type = null\n     engagementTime = 5",
    			"Error Message, Don't Add");
        try {
        	QUBMuseum.addArtifacts("Acropolis Statues", null, 10);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
                
        test ("2.1.6",
    			"Adding Artifact with Invalid Type",
    			"\n     name = Acropolis Statues\n     type = 12345\n     engagementTime = 5",
    			"Error Message, Don't Add");
        try {
        	QUBMuseum.addArtifacts("Acropolis Statues", 12345, 10);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();       
                
                
                
                
    }

    public static void test (String testCase, String objective, String testData, String expectedResult) {
    	System.out.println("\n***** Test Case: " + testCase);
    	System.out.println("Objective: " + objective);
    	System.out.println("Test Data: " + testData);
    	System.out.println("Expected Output: " + expectedResult);
    	System.out.println("+++++ Begin Test");
    }
    public static void endTest () {
    	System.out.println("+++++  End Test");
    }
}

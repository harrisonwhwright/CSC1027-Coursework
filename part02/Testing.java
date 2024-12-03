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
    			"Success, Change Type to OTHER");
        try {
        	QUBMuseum.addArtifacts("Acropolis Statues", null, 10);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
                
        test ("2.1.6",
    			"Adding Artifact with Invalid Type",
    			"\n     name = Acropolis Statues\n     type = 12345\n     engagementTime = 5",
    			"Success, Change Type to OTHER");
        try {
        	QUBMuseum.addArtifacts("Acropolis Statues", 12345, 10);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();       
                
                
        test ("2.1.7",
    			"Adding Artifact with Null Engagement Time",
    			"\n     name = Acropolis Statues\n     type = Sculpture\n     engagementTime = null",
    			"Error Message, Don't Add");
        try {
        	QUBMuseum.addArtifacts("Acropolis Statues", Type.SCULPTURE, null);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();  

        test ("2.1.8",
    			"Adding Artifact with Invalid Engagement Time Data Type",
    			"\n     name = Acropolis Statues\n     type = Sculpture\n     engagementTime = abcde",
    			"Error Message, Don't Add");
        try {
        	QUBMuseum.addArtifacts("Acropolis Statues", Type.SCULPTURE, "abcde");
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();  
        
        test ("2.2.1",
    			"Viewing Artifact with Null ID",
    			"\n     iD = null",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactById(null);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();  
        
        test ("2.2.2",
    			"Viewing Artifact with Valid ID",
    			"\n     iD = 1",
    			"Success");
        try {
        	QUBMuseum.viewArtifactById(1);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();  
        
        test ("2.2.3",
    			"Viewing Artifact with Invalid ID Data Type",
    			"\n     iD = abcde",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactById("abcde");
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.4",
    			"Viewing Artifact that does not Exist",
    			"\n     iD = 999",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactById(999);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.5",
    			"Veiwing Artifact with Null Name",
    			"\n     name = null",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactByName(null);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.6",
    			"Veiwing Artifact with Valid Name",
    			"\n     name = Acropolis Statues",
    			"Success");
        try {
        	QUBMuseum.viewArtifactByName("Acropolis Statues");
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.7",
    			"Veiwing Artifact with Invalid Name Data Type",
    			"\n     name = 12345",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactByName(12345);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.8",
    			"Veiwing Artifact with Null Part Name",
    			"\n     partName = null",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactByPartName(null);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.9",
    			"Veiwing Artifact with Valid Part Name",
    			"\n     partName = Acropolis",
    			"Success");
        try {
        	QUBMuseum.viewArtifactByPartName("Acropolis");
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.10",
    			"Viewing Artifact with Invalid Part Name Data Type",
    			"\n     partName = 12345",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactByPartName(12345);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.11",
    			"Viewing Artifact with Null Type",
    			"\n     type = null",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactByType(null);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.12",
    			"Viewing Artifact with Valid Type",
    			"\n     type = Painting",
    			"Success");
        try {
        	QUBMuseum.viewArtifactByType(Type.PAINTING);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.2.13",
    			"Viewing Artifact with Invalid Type Data Type",
    			"\n     type = 12345",
    			"Error Message, Display that there is nothing to view");
        try {
        	QUBMuseum.viewArtifactByType(12345);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.3.1",
    			"Deleting Artifact that does not Exist",
    			"\n     id = 999",
    			"Error Message, Display that there is nothing to delete");
        try {
        	QUBMuseum.deleteArtifacts(999);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.3.2",
    			"Deleting Artifact with null ID",
    			"\n     id = null",
    			"Error Message, Display that there is nothing to delete");
        try {
        	QUBMuseum.deleteArtifacts(null);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.3.3",
    			"Deleting Artifact with Valid ID",
    			"\n     id = 2",
    			"Success");
        try {
        	QUBMuseum.deleteArtifacts(2);
        	} catch (Exception exception) {
        		exception.printStackTrace();
        	}
        endTest();
        
        test ("2.3.4",
    			"Deleting Artifact with Invalid ID Data Type",
    			"\n     id = abcde",
    			"Error Message, Display that there is nothing to delete");
        try {
        	QUBMuseum.deleteArtifacts("abcde");
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

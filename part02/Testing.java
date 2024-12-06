package part02;

import part01.QUBMuseum;
import part01.Type;
import part01.Artifact;
import part01.Exhibit;
import part01.AnnualPlan;

public class Testing {

    private static void test (String testCase, String data, String result) {
    	System.out.println("+++++ TEST CASE: " + testCase);
    	System.out.println("  Testing: " + data);
    	System.out.println("  Result: " + result);
    	System.out.println("----------");
    }
    
    private static void endTest () {
    	System.out.println("+++++ END TEST\n");
    }
    
    public static void main(String[] args) {
    	// FOR TESTS 1 (1.1 - 1.8) SEE QUBMuseum.java, NO MENU INTERFACE TESTING IN THIS FILE
        System.out.println("FOR TESTS 1 (1.1 - 1.8) SEE QUBMuseum.java, NO MENU INTERFACE TESTING IN THIS FILE");
        
    	testArtifacts();
    	
    	testExhibits();
    	
    	testAnnualPlans();
    }
    
    
    public static void testArtifacts() {
    	// 2. ARTIFACT TESTS
    	System.out.println("2. ARTIFACT TESTS");
    	
    	// 2.1 CREATING/ADDING NEW ARTIFACTS
    	// Artifact.addArtifacts (Object name, Object classification, Object engagementTime)
    	System.out.println("\n2.1 CREATING NEW ARTIFACTS");
    	
    	test ("2.1.1", "Adding Null Data", "Invalid");
        Artifact.addArtifacts(null, null, null);
        endTest();
    	
    	test ("2.1.2", "Adding Invalid Data Type", "Invalid");
        Artifact.addArtifacts(12345, 12345, "abcde");
        endTest();
    	
    	test ("2.1.3", "Adding Valid Data", "Success");
        Artifact.addArtifacts("Delaware Landscape", Type.PAINTING, 1);
        endTest();
    	
    	// 2.2 VIEWING ARTIFACTS
        // Artifact.viewById (Object id)
        // Artifact.viewByName (Object name)
        // Artifact.viewByPartName (Object partName)
        // Artifact.viewByType (Object type)
    	System.out.println("\n2.2 VIEWING ARTIFACTS");

    	test ("2.2.1", "Viewing ID with Null Data", "Invalid");
    	Artifact.viewById(null);
        endTest();
        
    	test ("2.2.2", "Viewing ID with Invalid Data Type", "Invalid");
    	Artifact.viewById("abcde");
        endTest();
        
    	test ("2.2.3", "Viewing ID with Out of Range Data", "Invalid");
        Artifact.viewById(0);
        endTest();
        
    	test ("2.2.4", "Viewing ID with Non-existant Data", "Invalid");
        Artifact.viewById(999);
        endTest();
        
    	test ("2.2.5", "Viewing ID with Valid Data", "Valid");
        Artifact.viewById(1);
        endTest();
        
    	test ("2.2.6", "Viewing Name with Null Data", "Invalid");
    	Artifact.viewByName(null);
        endTest();
        
    	test ("2.2.7", "Viewing Name with Invalid Data Type", "Invalid");
    	Artifact.viewByName(1);
        endTest();
        
    	test ("2.2.8", "Viewing Name with Non-existant Data", "Invalid");
    	Artifact.viewByName("abcde");
        endTest();
        
    	test ("2.2.9", "Viewing Name with Valid Data", "Valid");
    	Artifact.viewByName("Delaware Landscape");
        endTest();
        
    	test ("2.2.10", "Viewing Part Name with Null Data", "Invalid");
    	Artifact.viewByPartName(null);
        endTest();
        
    	test ("2.2.11", "Viewing Part Name with Invalid Data Type", "Invalid");
    	Artifact.viewByPartName(1);
        endTest();
        
    	test ("2.2.12", "Viewing Part Name with Non-existant data", "Invalid");
    	Artifact.viewByPartName("abcde");
        endTest();
        
    	test ("2.2.13", "Viewing Part Name with Valid Data", "Valid");
    	Artifact.viewByPartName("Delaware");
        endTest();
        
    	test ("2.2.14", "Viewing Type with Null Data", "Invalid");
    	Artifact.viewByType(null);
        endTest();
        
    	test ("2.2.15", "Viewing Type with Invalid Data Type", "Invalid");
    	Artifact.viewByType(12345);
        endTest();
        
    	test ("2.2.16", "Viewing Type with Invalid String Data", "Invalid");
        Artifact.viewByType("abcde");
        endTest();
        
    	test ("2.2.17", "Viewing Type with String Data", "Valid");
    	Artifact.viewByType("Painting");
        endTest();
        
    	test ("2.2.18", "Viewing Type with Valid data", "Valid");
    	Artifact.viewByType(Type.PAINTING);
        endTest();
        
    	// 2.3 UPDATING ARTIFACTS
        // Artifact.updateArtifact (Object id, Object name, Object classification, Object engagementTime)
    	System.out.println("\n2.3 UPDATING ARTIFACTS");
    	
    	test ("2.3.1", "Updating with null data", "Invalid");
    	Artifact.updateArtifact(null, null, null, null);
        endTest();
        
    	test ("2.3.2", "Updating with Non-existant data", "Invalid");
    	Artifact.updateArtifact(999, "New Name", Type.SCULPTURE, 5);
        endTest();
        
    	test ("2.3.3", "Updating with Invalid data types", "Invalid");
    	Artifact.updateArtifact("abcde", 12345, 12345, "abcde");
        endTest();
        
    	test ("2.3.4", "Updating with Valid data", "Valid");
    	Artifact.updateArtifact(1, "New Name", Type.SCULPTURE, 5);
        endTest();
    	
    	// 2.4 DELETING ARTIFACTS
        // Artifact.deleteArtifact (Object id)
    	System.out.println("\n2.4 DELETING ARTIFACTS");

    	test ("2.4.1", "Deleting with null data", "Invalid");
    	Artifact.deleteArtifact(null);
        endTest();
        
    	test ("2.4.2", "Deleting with Non-existant data", "Invalid");
    	Artifact.deleteArtifact("abcde");
        endTest();
        
    	test ("2.4.3", "Deleting with Invalid data types", "Invalid");
    	Artifact.deleteArtifact(999);
        endTest();
        
    	test ("2.4.4", "Deleting with Valid data", "Valid");
    	Artifact.deleteArtifact(1);
        endTest();
    }

    public static void testExhibits() {
    	// 3. EXHIBITS TESTS
    	System.out.println("\n3. EXHIBIT TESTS");
    	
    	// 3.1 CREATING NEW EXHIBITS
    	// createExhibit (Object name)
    	System.out.println("\n3.1 CREATING NEW EXHIBITS");
    	
    	test ("3.1.1", "Creating Exhibit with null data", "Invalid");
    	Exhibit.createExhibit(null);
        endTest();
        
    	test ("3.1.2", "Creating Exhibit with invalid data type", "Invalid");
    	Exhibit.createExhibit(12345);
        endTest();
        
    	test ("3.1.3", "Creating Exhibit with valid data", "Valid");
    	Exhibit.createExhibit("New Exhibit");
        endTest();
    	
    	
    	// 3.2 ADDING ARTIFACTS TO EXHIBITS
    	// addArtifact (Object exhibitId, Object artifactId, Object sign)
        System.out.println("\n3.2 ADDING ARTIFACTS TO EXHIBITS");
        
        // NOTE: ADDING THESE ARTIFACTS TO ADD TO EXHIBITS FOR TESTING
        System.out.println("\n[NOTE FOR 3.2: THESE ARTIFACTS ARE CREATED FOR TESTING PURPOSES]");
        Artifact.addArtifacts("Acropolis Statues", Type.SCULPTURE, 5); // CREATING NEW ARTIFACT FOR TESTING
        Artifact.addArtifacts("Mona Lisa", Type.PAINTING, 8); // CREATING NEW ARTIFACT FOR TESTING
        Artifact.addArtifacts("TouchIT", Type.TACTILE, 4); // CREATING NEW ARTIFACT FOR TESTING
        
        test ("3.2.1", "Adding Artifacts to Exhibit with null data", "Invalid");
    	Exhibit.addArtifact(null, null, null);
        endTest();
        
    	test ("3.2.2", "Adding Artifacts to Exhibit with invalid data types", "Invalid");
    	Exhibit.addArtifact("abcde", "abcde", 12345);
        endTest();
        
    	test ("3.2.3", "Adding Artifacts to Exhibit with valid data", "Valid");
    	Exhibit.addArtifact(1, 2, "Artifact Sign");
        endTest();
        
    	test ("3.2.4", "Adding Artifacts to Exhibit with valid data BUT Artifact already in Exhibit list", "Invalid");
    	Exhibit.addArtifact(1, 2, "Artifact Sign");
        endTest();
        
    	// 3.3 ADDING ARTIFACTS TO EXHIBITS WITH INDEX
    	// addArtifact (Object exhibitId, Object artifactId, Object sign, Object index)
        System.out.println("\n3.3 ADDING ARTIFACTS WITH INDEX TO EXHIBITS");
    
        test ("3.3.1", "Adding Artifact to Exhibit with null data and null index", "Invalid");
    	Exhibit.addArtifact(null, null, null, null);
        endTest();
        
    	test ("3.3.2", "Adding Artifact to Exhibit with invalid data type and invalid index", "Invalid");
    	Exhibit.addArtifact("abcde", "abcde", 12345, "abcde");
        endTest();
        
    	test ("3.3.3", "Adding Artifact to Exhibit with valid data and index of -1", "Valid");
    	// NOTE: INVALID INDEXES APPEND AN ARTIFACT TO THE END OF AN EXHIBIT, THEREFORE VALID
    	Exhibit.addArtifact(1, 3, "Different Artifact Sign", -1);
        endTest();
        
        test ("3.3.4", "Adding Artifact to Exhibit with valid data and valid index", "Valid");
    	Exhibit.addArtifact(1, 4, "Completely Different Artifact Sign", 0);
        endTest();
    	
    	// 3.4 VIEWING EXHIBITS
    	// viewById (Object id)
    	// viewByName (Object name)
    	// viewByPartName (Object partName)
    	// viewByEngagementTime (Object engagementTime)
        System.out.println("\n3.4 VIEWING EXHIBITS");
        
        test ("3.4.1", "Viewing Exhibit by ID with null data", "Invalid");
    	Exhibit.viewById(null);
        endTest();
        
        test ("3.4.2", "Viewing Exhibit by ID with invalid data type", "Invalid");
    	Exhibit.viewById("abcde");
        endTest();
        
        test ("3.4.3", "Viewing Exhibit by ID with Out of Range data", "Invalid");
    	Exhibit.viewById(-5);
        endTest();
        
        test ("3.4.4", "Viewing Exhibit by ID with Non-existant data", "Invalid");
    	Exhibit.viewById(999);
        endTest();
        
        test ("3.4.5", "Viewing Exhibit by ID with valid data", "Valid");
    	Exhibit.viewById(1);
        endTest();
        
        test ("3.4.6", "Viewing Exhibit by Name with null data", "Invalid");
        Exhibit.viewByName(null);
        endTest();
        
        test ("3.4.7", "Viewing Exhibit by Name with invalid data type", "Invalid");
        Exhibit.viewByName(1);
        endTest();
        
        test ("3.4.8", "Viewing Exhibit by Name with non-existant data", "Invalid");
        Exhibit.viewByName("abcde");
        endTest();
        
        test ("3.4.9", "Viewing Exhibit by Name with valid data", "Valid");
        Exhibit.viewByName("New Exhibit");
        endTest();
        
        test ("3.4.10", "Viewing Exhibit by Part Name with null data", "Invalid");
        Exhibit.viewByPartName(null);
        endTest();
        
        test ("3.4.11", "Viewing Exhibit by Part Name with invalid data type", "Invalid");
        Exhibit.viewByPartName(1);
        endTest();
        
        test ("3.4.12", "Viewing Exhibit by Part Name with non-existant data", "Invalid");
        Exhibit.viewByPartName("abcde");
        endTest();
        
        test ("3.4.13", "Viewing Exhibit by Part Name with valid data", "Valid");
        Exhibit.viewByPartName("New");
        endTest();
        
        test ("3.4.14", "Viewing Exhibit by Engagement Time with null data", "Invalid");
    	Exhibit.viewByEngagementTime(null);
        endTest();
        
        test ("3.4.15", "Viewing Exhibit by Engagement Time with invalid data type", "Invalid");
    	Exhibit.viewByEngagementTime("abcde");
        endTest();
        
        test ("3.4.16", "Viewing Exhibit by Engagement Time with Out of Range data", "Invalid");
    	Exhibit.viewByEngagementTime(-5);
        endTest();
        
        test ("3.4.17", "Viewing Exhibit by Engagement Time with Non-existant data", "Invalid");
    	Exhibit.viewByEngagementTime(999);
        endTest();
        
        test ("3.4.18", "Viewing Exhibit by Engagement Time with valid data", "Valid");
    	Exhibit.viewByEngagementTime(17);
        endTest();
        
        
        
    	// 3.5 UPDATING EXHIBITS
    	// changeName (Object exhibitId, Object name)
    	// changeSign (Object exhibitId, Object artifactId, Object sign)
        // deleteArtifact(Object exhibitId, Object artifactId)
        System.out.println("\n3.5 UPDATING EXHIBITS");
        
        test ("3.5.1", "Updating Exhibit with null ID and valid Name", "Invalid");
        Exhibit.changeName (null, "New Exhibit Name");
        endTest();
        
        test ("3.5.2", "Updating Exhibit with invalid ID data type and valid Name", "Invalid");
        Exhibit.changeName ("abcde", "New Exhibit Name");
        endTest();
        
        test ("3.5.3", "Updating Exhibit with Out of Range ID and valid Name", "Invalid");
        Exhibit.changeName (-5, "New Exhibit Name");
        endTest();
        
        test ("3.5.4", "Updating Exhibit with non-existant ID and valid Name", "Invalid");
        Exhibit.changeName (999, "New Exhibit Name");
        endTest();
        
        test ("3.5.5", "Updating Exhibit with valid ID and null Name", "Invalid");
        Exhibit.changeName (1, null);
        endTest();
        
        test ("3.5.6", "Updating Exhibit with valid ID and invalid Name data type", "Invalid");
        Exhibit.changeName (1, 12345);
        endTest();
        
        test ("3.5.7", "Updating Exhibit with valid ID and valid Name", "Valid");
        Exhibit.changeName (1, "New Exhibit Name");
        endTest();

        test ("3.5.8", "Updating Artifact Sign with null data", "Invalid");
        Exhibit.changeSign (null, null, null);
        endTest();
        
        test ("3.5.9", "Updating Artifact Sign with invalid data type", "Invalid");
        Exhibit.changeSign ("abcde", "abcde", 12345);
        endTest();
        
        test ("3.5.10", "Updating Artifact Sign with non-existant Exhibit ID", "Invalid");
        try {
            Exhibit.changeSign(999, 2, "Updated Sign");
        } catch (Exception e) {
            e.printStackTrace();
        }
        endTest();
        
        test ("3.5.11", "Updating Artifact Sign with non-existant Artifact ID", "Invalid");
        Exhibit.changeSign (1, 999, "Updated Sign");
        endTest();
        
        test ("3.5.12", "Updating Artifact Sign with valid data", "Valid");
        Exhibit.changeSign (1, 2, "Updated Sign");
        endTest();
        
        test ("3.5.13", "Deleting Artifact from Exhibit with null data", "Invalid");
        Exhibit.deleteArtifact(null, null);
        endTest();
    	
        test ("3.5.14", "Deleting Artifact from Exhibit with invalid data type", "Invalid");
        Exhibit.deleteArtifact("abcde", "abcde");
        endTest();
    	
        test ("3.5.15", "Deleting Artifact from Exhibit with non-existant Exhibit ID", "Invalid");
        try {
        	Exhibit.deleteArtifact(999, 2);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        endTest();
    	
        test ("3.5.16", "Deleting Artifact from Exhibit with non-existant Artifact ID", "Invalid");
        Exhibit.deleteArtifact(1, 999);
        endTest();
    	
        test ("3.5.17", "Deleting Artifact from Exhibit with valid data", "Valid");
        Exhibit.deleteArtifact(1, 2);
        endTest();
    	
    	// 3.6 DELETING EXHIBITS
        // deleteExhibit (Object id)
        System.out.println("\n3.6 DELETING EXHIBITS");
        
        test ("3.6.1", "Deleting Exhibit with null data", "Invalid");
    	Exhibit.deleteExhibit (null);
        endTest();
    	
        test ("3.6.2", "Deleting Exhibit with invalid data type data", "Invalid");
    	Exhibit.deleteExhibit ("abcde");
        endTest();
    	
        test ("3.6.3", "Deleting Exhibit with Out of Range data", "Invalid");
    	Exhibit.deleteExhibit (-5);
        endTest();
    	
        test ("3.6.4", "Deleting Exhibit with non-existant data", "Invalid");
    	Exhibit.deleteExhibit (999);
        endTest();
    	
        test ("3.6.5", "Deleting Exhibit with valid data", "Valid");
    	Exhibit.deleteExhibit (1);
        endTest();
    	
    }

    public static void testAnnualPlans() {
    	// 4. ANNUAL PLAN TESTS
    	System.out.println("\n3. ANNUAL PLAN TESTS");
    	
    	// 4.1 CREATING ANNUAL PLANS
        // createAnnualPlan (Object year)
    	System.out.println("\n4.1 CREATING ANNUAL PLANS");
    	
    	test ("4.1.1", "Creating Annual Plan with null data", "Invalid");
        AnnualPlan.createAnnualPlan(null);
        endTest();
        
    	test ("4.1.2", "Creating Annual Plan with invalid data type", "Invalid");
        AnnualPlan.createAnnualPlan("abcde");
        endTest();
        
    	test ("4.1.3", "Creating Annual Plan with Out of Range data", "Invalid");
        AnnualPlan.createAnnualPlan(-5);
        endTest();
        
    	test ("4.1.4", "Creating Annual Plan with valid data", "Valid");
        AnnualPlan.createAnnualPlan(2024);
        endTest();
            	
    	// 4.2 ADDING EXHIBITS TO ANNUAL PLAN
        // addToAnnualPlan (Object year, Object exhibitId, Object month, Object hall)
    	System.out.println("\n4.2 ADDING EXHIBITS TO ANNUAL PLAN");
    	
        // NOTE: ADDING THESE ARTIFACTS TO ADD TO EXHIBITS FOR TESTING
        System.out.println("\n[NOTE FOR 4.2: THESE EXHIBITS ARE CREATED FOR TESTING PURPOSES]");
        Exhibit.createExhibit("Exhibit 1"); // CREATING NEW EXHIBIT FOR TESTING
        Exhibit.createExhibit("Exhibit 2"); // CREATING NEW EXHIBIT FOR TESTING
        Exhibit.createExhibit("Exhibit 3"); // CREATING NEW EXHIBIT FOR TESTING
        System.out.println();
        
    	test ("4.2.1", "Adding to Annual Plan null data", "Invalid");
    	AnnualPlan.addToAnnualPlan(null, null, null, null);
        endTest();
        
    	test ("4.2.2", "Adding to Annual Plan invalid data type", "Invalid");
    	AnnualPlan.addToAnnualPlan("abcde", "abcde", "abcde", "abcde");
        endTest();
        
    	test ("4.2.3", "Adding to Annual Plan Out of Range data", "Invalid");
    	AnnualPlan.addToAnnualPlan(9999, 2, 1, 1);
        endTest();
        
    	test ("4.2.4", "Adding to Annual Plan Out of Range data", "Invalid");
    	AnnualPlan.addToAnnualPlan(2024, 999, 1, 1);
        endTest();
        
    	test ("4.2.5", "Adding to Annual Plan Out of Range data", "Invalid");
    	AnnualPlan.addToAnnualPlan(2024, 2, 999, 1);
        endTest();
        
    	test ("4.2.6", "Adding to Annual Plan Out of Range data", "Invalid");
    	AnnualPlan.addToAnnualPlan(2024, 2, 1, 999);
        endTest();
        
    	test ("4.2.7", "Adding to Annual Plan valid data", "Valid");
    	AnnualPlan.addToAnnualPlan(2024, 2, 1, 1);
        endTest();
    	
    	// 4.3 VIEWING ANNUAL PLAN BY YEAR
    	// viewByYear (Object year)
    	System.out.println("\n4.3 VIEWING ANNUAL PLAN BY YEAR");
    	
    	test ("4.3.1", "Viewing Annual Plan with null Year", "Invalid");
    	AnnualPlan.viewByYear(null);
        endTest();
        
    	test ("4.3.2", "Viewing Annual Plan with invalid Year data type", "Invalid");
    	AnnualPlan.viewByYear("abcde");
        endTest();
        
    	test ("4.3.3", "Viewing Annual Plan with Out of Range Year", "Invalid");
    	AnnualPlan.viewByYear(-5);
        endTest();
        
    	test ("4.3.4", "Viewing Annual Plan with non-existant Year", "Invalid");
    	AnnualPlan.viewByYear(9999);
        endTest();
        
    	test ("4.3.5", "Viewing Annual Plan with valid Year", "Valid");
    	AnnualPlan.viewByYear(2024);
        endTest();
    	
    	// 4.4 DELETING EXHIBITS FROM ANNUAL PLAN
    	// removeFromAnnualPlan (Object year, Object month, Object hall)
    	System.out.println("\n4.4 DELETING EXHIBITS FROM ANNUAL PLAN");
    	
    	test ("4.4.1", "Removing Exhibit from Annual Plan with null data", "Invalid");
    	AnnualPlan.removeFromAnnualPlan(null, null, null);
        endTest();
    	
    	test ("4.4.2", "Removing Exhibit from Annual Plan with invalid data types", "Invalid");
    	AnnualPlan.removeFromAnnualPlan("abcde", "abcde", "abcde");
        endTest();
    	
    	test ("4.4.3", "Removing Exhibit from Annual Plan with Out of Range data", "Invalid");
    	AnnualPlan.removeFromAnnualPlan(9999, 1, 1);
        endTest();
    	
    	test ("4.4.4", "Removing Exhibit from Annual Plan with Out of Range data", "Invalid");
    	AnnualPlan.removeFromAnnualPlan(2024, 999, 1);
        endTest();
    	
    	test ("4.4.5", "Removing Exhibit from Annual Plan with Out of Range data", "Invalid");
    	AnnualPlan.removeFromAnnualPlan(2024, 1, 999);
        endTest();
    	
    	test ("4.4.6", "Removing Exhibit from Annual Plan with valid data", "Valid");
    	AnnualPlan.removeFromAnnualPlan(2024, 1, 1);
        endTest();
    	
    	// 4.5 DELETING AN ANNUAL PLAN
    	// deleteAnnualPlan (Object year)
    	System.out.println("\n4.5 DELETING AN ANNUAL PLAN");
    	
    	test ("4.5.1", "Deleting Annual Plan with null Year", "Invalid");
    	AnnualPlan.deleteAnnualPlan(null);
        endTest();
    	
        test ("4.5.2", "Deleting Annual Plan with invalid Year data type", "Invalid");
    	AnnualPlan.deleteAnnualPlan("abcde");
        endTest();
    	
        test ("4.5.3", "Deleting Annual Plan with Out of Range Year", "Invalid");
    	AnnualPlan.deleteAnnualPlan(-5);
        endTest();
    	
        test ("4.5.4", "Deleting Annual Plan with non-existant Year", "Invalid");
    	AnnualPlan.deleteAnnualPlan(9999);
        endTest();
    	
        test ("4.5.5", "Deleting Annual Plan with valid Year", "Valid");
    	AnnualPlan.deleteAnnualPlan(2024);
        endTest();
    	
    }
}
// change all .contains(), as this is not allowed
// try to implement .indexOf() instead

package part01;

import java.util.Scanner;
import java.util.ArrayList;

public class QUBMuseum {
	
	static Scanner scanner = new Scanner(System.in);

	private static ArrayList<Artifact> artifacts = new ArrayList<>();
	private static ArrayList<Exhibit> exhibits = new ArrayList<>();
	private static ArrayList<AnnualPlan> annualPlans = new ArrayList<>();

    public static ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }
    public static ArrayList<Exhibit> getExhibits() {
        return exhibits;
    }
    public static ArrayList<AnnualPlan> getAnnualPlans() {
        return annualPlans;
    }
	
	public static void main(String[] args) {
		Menu mainMenu = new Menu ("QUB Museum", Resources.mainOptions);
		
		int choice = 0;
		boolean quit = false;
		
		do {
			choice = mainMenu.getUserChoice();
			quit = processChoice(choice);
		} while (!quit);
		
		
		System.out.println("All done - Goodbye!");
		
		scanner.close();
	}

	private static boolean processChoice (int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			manageArtifacts();
			break;
		case 2:
			manageExhibits();
			break;
		case 3:
			manageAnnualSchedule();
			break;
		case 4:
			quit = true;
		}
		return quit;
	}
	
	private static void manageArtifacts() {
		System.out.println();
		Menu artifactMenu = new Menu ("Manage Artifacts", Resources.artifactOptions);
		
	    int choice = 0;
	    boolean quit = false;

	    do {
	        choice = artifactMenu.getUserChoice();
	        quit = processArtifactChoice(choice);
	    } while (!quit);
	}
	
	private static boolean processArtifactChoice (int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			addArtifacts();
			break;
		case 2:
			viewArtifacts();
			break;
		case 3:
			deleteArtifacts();
			break;
		case 4:
			updateArtifacts();
			break;
		case 5:
			quit = true;
		}
		return quit;
	}
	
	private static void addArtifacts() {
		System.out.println();
		System.out.println("Add Artifact");
		
		String name;
		while (true) {
			System.out.print("Enter Artifact Name: ");
			name = scanner.nextLine();
			if (!name.isEmpty()) {
				break;
			} else {
				System.out.println("Invalid Name, Name Cannot be Empty");
			}
		}
		
		System.out.print("Enter Artifact Type: ");
		String tempClassification = scanner.nextLine().toUpperCase();
		Type classification;
		try {
			classification = Type.valueOf(tempClassification);
		} catch (Exception e) {
			System.out.println("Invalid Type Entered, Using OTHER");
			classification = Type.OTHER;
		}
		
		int engagementTime;
		while (true) {
			System.out.print("Enter Engagement Time: ");
			engagementTime = scanner.nextInt();
			scanner.nextLine();
			if (engagementTime >= 0) {
				break;
			} else {
				System.out.println("Invalid Engagement Type Entered");
			}
		}
		
				
		Artifact newArtifact = new Artifact (name, classification, engagementTime);
		
		artifacts.add(newArtifact);
		
		System.out.println("Successfully Added Artifact");
		System.out.println();
	}
	
	public static void addArtifacts(String name, Type classification, int engagementTime) {
		
		if (name == null || name.isEmpty()) {
			System.out.println("Invalid Artifact Name, Cannot be Null or Empty");
			System.out.println("Not Added to Artifacts");
			return;
		}
	    if (classification == null) {
	        System.out.println("Invalid Type Provided, using OTHER");
	        classification = Type.OTHER;
	    }
	    if (engagementTime < 0) {
	    	System.out.println("Invalid Engagement Type Entered");
	    	System.out.println("Not Added to Artifacts");
	    	return;
	    }
			
		Artifact newArtifact = new Artifact (name, classification, engagementTime);
		artifacts.add(newArtifact);
		
		System.out.println("Successfully Added Artifact");
	}
	
	private static void viewArtifacts() { 
	    System.out.println();
	    
	    if (artifacts.size() == 0) {
	        System.out.println("View Artifacts\nArtifact list is empty");
	        System.out.println();
	        return;
	    }
	    
	    for (int i = 0; i < artifacts.size() - 1; i++) {
	        for (int j = 0; j < artifacts.size() - 1 - i; j++) {
	            if (artifacts.get(j).getName().compareTo(artifacts.get(j + 1).getName()) > 0) {
	                Artifact temp = artifacts.get(j);
	                artifacts.set(j, artifacts.get(j + 1));
	                artifacts.set(j + 1, temp);
	            }
	        }
	    }

	    for (int i = 0; i < artifacts.size(); i++) {
	        System.out.println(artifacts.get(i));
	    }
	    
	    System.out.println("\nDo you want to search artifacts? (Yes/No)");
	    String userInput = scanner.nextLine();
	    if (userInput.equalsIgnoreCase("YES")) {
	    	Menu viewArtifactChoice = new Menu ("Search Artifacts", Resources.artifactCriteria);
			
			int choice = 0;
			boolean quit = false;
			
			do {
				choice = viewArtifactChoice.getUserChoice();
				quit = processViewArtifactChoice(choice);
			} while (!quit);
	    }
	}
		
	private static boolean processViewArtifactChoice (int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			viewArtifactById();
			break;
		case 2:
			viewArtifactByName();
			break;
		case 3:
			viewArtifactByPartName();
			break;
		case 4:
			viewArtifactByType();
			break;
		case 5:
			quit = true;
		}
	return quit;
	}
	
	private static void viewArtifactById() {
		System.out.println("\nEnter ID of Artifact you want to see:"); 
		int userInput = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i).getId() == userInput) {
				System.out.println(artifacts.get(i));
				found = true;
				System.out.println();
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + userInput + "\n");
		}
	}
	
	private static void viewArtifactByName() {
		System.out.println("\nEnter Name of the Artifacts you want to see:"); 
		String userInput = scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i).getName().equalsIgnoreCase(userInput)) {
				System.out.println(artifacts.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Artifacts Found with Name: " + userInput + "\n");
	    }
		System.out.println();
	}
	
	private static void viewArtifactByPartName() {
		System.out.println("\nEnter Partially the Name of Artifacts you want to see:"); 
		String userInput = scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i).getName().toUpperCase().contains(userInput.toUpperCase())) {
				System.out.println(artifacts.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Artifacts Found with Name: " + userInput + "\n");
	    }
		System.out.println();
	}
	
	private static void viewArtifactByType() {
		System.out.println("\nEnter Type of Artifact you want to see:");
		String userInput = scanner.nextLine();
		Type typeUserInput;
		boolean found = false;
		try {
			typeUserInput = Type.valueOf(userInput.toUpperCase());
			for (int i = 0; i < artifacts.size(); i++) {
				if (artifacts.get(i).getType() == typeUserInput) {
					System.out.println(artifacts.get(i));
					found = true;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Type Entered\n");
		}
	    if (!found) {
	        System.out.println("No Artifacts Found with Type: " + userInput + "\n");
	    }
		System.out.println();
	}
	
	private static void deleteArtifacts() {
		System.out.println();
		System.out.println("Delete Artifacts");
		if (artifacts.size() == 0) {
			System.out.println("Artifact list is empty\n");
			return;
		}
		
		System.out.print("Enter Artifact ID to Delete: ");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (userInput == artifacts.get(i).getId()) {
				artifacts.remove(i);
				System.out.println("Successfully Removed Artifact");
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Artifacts Found with ID: " + userInput + "\n");
		}
	}
	
	private static void updateArtifacts() {
		System.out.println();
		System.out.println("Update Artifacts");
		if (artifacts.size() == 0) {
			System.out.println("Artifact list is empty");
			System.out.println();
			return;
		}
		System.out.print("Enter Artifact ID to Update: ");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (userInput == artifacts.get(i).getId()) {
				found = true;
				System.out.println(artifacts.get(i));
				
				System.out.println("Enter Artifact Name: ");
				String name = scanner.nextLine();
				
				System.out.print("Enter Artifact Type: ");
				String tempClassification = scanner.nextLine().toUpperCase();
				Type classification;
				try {
					classification = Type.valueOf(tempClassification);
				} catch (Exception e) {
					System.out.println("Invalid type entered, using OTHER");
					classification = Type.OTHER;
				}
				
				System.out.print("Enter Engagement Time: ");
				int engagementTime = scanner.nextInt();
				scanner.nextLine();
				
				artifacts.get(i).setName(name);
				artifacts.get(i).setType(classification);
				artifacts.get(i).setEngagementTime(engagementTime);
				
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID: " + userInput);
		}
	}
	
	private static void manageExhibits() {
		System.out.println();
		Menu exhibitMenu = new Menu ("Manage Exhibits", Resources.exhibitOptions);
		
		int choice = 0;
		boolean quit = false;
		
		do {
			choice = exhibitMenu.getUserChoice();
			quit = processExhibitChoice(choice);
		} while (!quit);
	}
	
	private static boolean processExhibitChoice (int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			addExhibit();
			break;
		case 2:
			viewExhibit();
			break;
		case 3:
			deleteExhibit();
			break;
		case 4:
			updateExhibit();
			break;
		case 5:
			quit = true;
		}
		return quit;
	}
	
	private static void addExhibit() {
		System.out.println();
		System.out.println("Add Exhibit");
		
		System.out.print("Enter Exhibit Name: ");
		String name = scanner.nextLine();
		
		Exhibit newExhibit = new Exhibit (name);
		exhibits.add(newExhibit);
		
		System.out.println("\nDo you want to add an Artifact to this Exhibit? (Yes/No)");
		String userInput = scanner.nextLine();
		while (userInput.equalsIgnoreCase("YES")) {
			addArtifactToExhibit(newExhibit);
			System.out.println("\nDo you want to add another Artifact to this Exhibit? (Yes/No)");
			userInput = scanner.nextLine();
		}
	}
	
	private static void addArtifactToExhibit(Exhibit newExhibit) {
		System.out.println("\nEnter ID of the Artifact you want to add to Exhibits: ");
		int idInput = scanner.nextInt();
		Artifact artifact = null;
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i).getId() == idInput) {
				artifact = artifacts.get(i);
				found = true;
			}
		}
		
		if (found) {
			System.out.println("\nEnter Sign details of the Artifact you want to add to Exhibits: ");
			String signInput = scanner.nextLine();
			
			newExhibit.addArtifact(artifact, signInput);
		} else {
			System.out.println("No Artifact Found with ID: " + idInput);
		}
	}
	
	private static void viewExhibit() {
		System.out.println();
		
		if (exhibits.size() == 0) {
			System.out.println("View Exhibits\nExhibits list is empty");
			System.out.println();
			return;
		}
		
		for (int i = 0; i < exhibits.size() - 1; i++) {
	        for (int j = 0; j < exhibits.size() - 1 - i; j++) {
	            if (exhibits.get(j).getName().compareTo(exhibits.get(j + 1).getName()) > 0) {
	                Exhibit temp = exhibits.get(j);
	                exhibits.set(j, exhibits.get(j + 1));
	                exhibits.set(j + 1, temp);
	            }
	        }
	    }
		
	    for (int i = 0; i < exhibits.size(); i++) {
	        System.out.println(exhibits.get(i));
	    }
	    
	    System.out.println("\nDo you want to search Exhibits? (Yes/No)");
	    String userInput = scanner.nextLine();
	    if (userInput.equalsIgnoreCase("YES")) {
	    	Menu viewExhibitChoice = new Menu ("Search Exhibits", Resources.exhibitCriteria);
			
			int choice = 0;
			boolean quit = false;
			
			do {
				choice = viewExhibitChoice.getUserChoice();
				quit = processViewExhibitChoice(choice);
			} while (!quit);
	    }
	}
	
	private static boolean processViewExhibitChoice (int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			viewExhibitById();
			break;
		case 2:
			viewExhibitByName();
			break;
		case 3:
			viewExhibitByPartName();
			break;
		case 4:
			viewExhibitByEngagementTime();
			break;
		case 5:
			quit = true;
		}
	return quit;
	}
	
	private static void viewExhibitById() {
		System.out.println("\nEnter ID of Exhibit you want to see: ");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getId() == userInput) {
				System.out.println(exhibits.get(i));
				found = true;
				System.out.println();
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + userInput +"\n");
		}
	}
	
	private static void viewExhibitByName() {
		System.out.println("\nEnter Name of Exhibit you want to see:"); 
		String userInput = scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getName().equalsIgnoreCase(userInput)) {
				System.out.println(exhibits.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Exhibit Found with Name: " + userInput + "\n");
	    }
		System.out.println();
	}
	
	private static void viewExhibitByPartName() {
		System.out.println("\nEnter Partially the Name of the Exhibit you want to see:"); 
		String userInput = scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getName().toUpperCase().contains(userInput.toUpperCase())) {
				System.out.println(exhibits.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Exhibits Found with Name: " + userInput + "\n");
	    }
		System.out.println();
	}
	
	private static void viewExhibitByEngagementTime() {
		System.out.println("\nEnter the Engagement Time of the Exhibit you want to see:"); 
		int userInput = scanner.nextInt();
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getTotalTime() == userInput) {
				System.out.println(exhibits.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Exhibits Found with Engagement Time of: " + userInput + "\n");
	    }
		System.out.println();
	}
	
	private static void deleteExhibit() {
		System.out.println();
		System.out.println("Delete Exhibits");
		if (exhibits.size() == 0) {
			System.out.println("Exhibit list is empty\n");
			return;
		}
		System.out.print("Enter Exhibit ID to Delete: ");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (userInput == exhibits.get(i).getId()) {
				exhibits.remove(i);
				System.out.println("Successfully Removed Exhibit\n");
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID: " + userInput + "\n");
		}
	}
	
	private static void updateExhibit() {
		System.out.println();
		System.out.println("Update Exhibits");
		if (exhibits.size() == 0) {
			System.out.println("Exhibit list is empty\n");
			return;
		}
		System.out.print("Enter Exhibit ID to Update: ");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (userInput == exhibits.get(i).getId()) {
				found = true;
				int idExhibit = i;
				System.out.println(exhibits.get(i));
				
				Menu exhibitUpdateMenu = new Menu ("\nUpdate Exhibit", Resources.exhibitUpdate);

				int choice = 0;
				boolean quit = false;
				
				do {
					choice = exhibitUpdateMenu.getUserChoice();
					quit = processExhibitUpdateMenu(choice, idExhibit);
				} while (!quit);
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID: " + userInput);
		}
	}
	
	private static boolean processExhibitUpdateMenu (int choice, int idExhibit) {
		boolean quit = false;
		switch (choice) {
		case 1:
			changeExhibitName(idExhibit);
			break;
		case 2:
			changeArtifactSignInExhibit(idExhibit);
			break;
		case 3:
			appendNewArtifactInExhibit(idExhibit);
			break;
		case 4:
			insertNewArtifactInExhibit(idExhibit);
			break;
		case 5:
			deleteArtifactInExhibit(idExhibit);
			break;
		case 6:
			quit = true;
		}
		return quit;
	}
	
	private static void changeExhibitName(int idExhibit) {
		System.out.println("Change Exhibit Name, Currently: " + exhibits.get(idExhibit).getName());
		System.out.println("Enter New Exhibit Name: ");
		String name = scanner.nextLine();
		exhibits.get(idExhibit).setName(name);
		System.out.println(exhibits.get(idExhibit));
	}
	
	private static void changeArtifactSignInExhibit(int idExhibit) {
	    System.out.println("Change Artifact Sign");
	    System.out.println(exhibits.get(idExhibit));

	    System.out.print("Enter Artifact Name to Update its Sign: ");
	    String userInput = scanner.nextLine();

	    boolean found = false;
	    for (int i = 0; i < exhibits.get(idExhibit).getArtifacts().size(); i++) {
	        Artifact artifact = exhibits.get(idExhibit).getArtifacts().get(i);

	        if (artifact.getName().equalsIgnoreCase(userInput)) {
	            found = true;

	            System.out.print("Enter the New Sign for this Artifact: ");
	            String newSign = scanner.nextLine();

	            exhibits.get(idExhibit).getArtifactSigns().set(i, newSign);
	            System.out.println(exhibits.get(idExhibit));

	            System.out.println("Successfully updated the sign for artifact: " + artifact.getName());
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("No Artifact within this Exhibit Found with Name: " + userInput + "\n");
	    }
	}
	
	private static void appendNewArtifactInExhibit(int idExhibit) {
		System.out.println("\nEnter ID of the Artifact you want to add to Exhibits: ");
		int idInput = scanner.nextInt();
		Artifact artifact = null;
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i).getId() == idInput) {
				artifact = artifacts.get(i);
				found = true;
			}
		}
		
		if (found) {
			System.out.println("\nEnter Sign details of the Artifact you want to add to Exhibits: ");
			String signInput = scanner.nextLine();
			
			exhibits.get(idExhibit).addArtifact(artifact, signInput);
			System.out.println(exhibits.get(idExhibit));
		} else {
			System.out.println("No Artifact Found with ID: " + idInput);
		}
	}
	
	private static void insertNewArtifactInExhibit(int idExhibit) {
		System.out.println("\nEnter ID of the Artifact you want to add to Exhibits: ");
		int idInput = scanner.nextInt();
		Artifact artifact = null;
		scanner.nextLine();
		
		boolean found = false;
		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i).getId() == idInput) {
				artifact = artifacts.get(i);
				found = true;
			}
		}
		
		if (found) {
			System.out.println("\nEnter Sign details of the Artifact you want to add to Exhibits: ");
			String signInput = scanner.nextLine();
			
			System.out.println("\n Enter the Position you want the Artifact to be inserted at: ");
			int positionInput = scanner.nextInt();
			int indexInput = positionInput - 1;
			scanner.nextLine();
			
			exhibits.get(idExhibit).addArtifact(artifact, signInput, indexInput);
			System.out.println(exhibits.get(idExhibit));
			
		} else {
			System.out.println("No Artifact Found with ID: " + idInput);
		}
	}
	
	private static void deleteArtifactInExhibit(int idExhibit) {
	    System.out.println("Delete Artifact from Exhibit");
	    System.out.println(exhibits.get(idExhibit));

	    System.out.print("Enter Artifact Name to Delete: ");
	    String userInput = scanner.nextLine();

	    boolean found = false;
	    for (int i = 0; i < exhibits.get(idExhibit).getArtifacts().size(); i++) {
	        Artifact artifact = exhibits.get(idExhibit).getArtifacts().get(i);

	        if (artifact.getName().equalsIgnoreCase(userInput)) {
	            found = true;

	            exhibits.get(idExhibit).getArtifacts().remove(i);
	            exhibits.get(idExhibit).getArtifactSigns().remove(i);
	            
	            System.out.println(exhibits.get(idExhibit));

	            System.out.println("Successfully deleted the artifact: " + artifact.getName());
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("No Artifact within this Exhibit Found with Name: " + userInput + "\n");
	    }
	}
	
	private static void manageAnnualSchedule() {
		System.out.println();
		Menu annualPlanMenu = new Menu ("Manage Annual Plan", Resources.annualPlanOptions);
		
		int choice = 0;
		boolean quit = false;
		
		do {
			choice = annualPlanMenu.getUserChoice();
			quit = processAnnualPlanChoice(choice);
		} while (!quit);
	}
	
	private static boolean processAnnualPlanChoice (int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			addAnnualPlan();
			break;
		case 2:
			viewAnnualPlan();
			break;
		case 3:
			modifyAnnualPlan();
			break;
		case 4:
			quit = true;
		}
		return quit;
	}

	private static void addAnnualPlan() {
		System.out.println();
		System.out.print("Enter Year to Create Plan: ");
		int year = scanner.nextInt();
		scanner.nextLine();
		
		if (year < 0) {
			System.out.println("Please Enter A Valid Year\n");
			return;
		}
		
		AnnualPlan newAnnualPlan = new AnnualPlan (year);
		annualPlans.add(newAnnualPlan);

		String userInput;
		do {
			System.out.println("Would you like to Add to this Annual Plan now? (Yes/No)");
			userInput = scanner.nextLine();
			if (userInput.equalsIgnoreCase("YES")) {
				addToAnnualPlan(newAnnualPlan);
			}
		} while (userInput.equalsIgnoreCase("YES"));
	}
		
	private static void addToAnnualPlan(AnnualPlan annualPlan) {
		System.out.println("Enter ID of Exhibit you want to Add: ");
		int exhibitId = scanner.nextInt();
		scanner.nextLine();
		
		boolean found = false;
		Exhibit exhibit = null;
		
		for (int i = 0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getId() == exhibitId) {
				found = true;
				exhibit = exhibits.get(i);
				break;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + exhibitId + "\n");
			return;
		}
		
		int hallNumber = -1;
		while (hallNumber < 1 || hallNumber > 3) {
			System.out.println("Which Hall (1-3) should it take place: ");
			hallNumber = scanner.nextInt();
			scanner.nextLine();
			if (hallNumber < 1 || hallNumber > 3) {
				System.out.println("Please Enter a Valid Hall Number (1-3)");
			}
		}

		int monthNumber = -1;
		while (monthNumber < 1 || monthNumber > 12) {
			System.out.println("What Month (1-12) should it take place:  ");
			monthNumber = scanner.nextInt();
			scanner.nextLine();
			if (monthNumber < 1 || monthNumber > 12) {
				System.out.println("Please Enter a Valid Month Number (1-12)");
			}
		}
		
		if (exhibit != null) {
			if (annualPlan.getExhibit(monthNumber, hallNumber) == null) {
				annualPlan.addToAnnualPlan(monthNumber, hallNumber, exhibit);
			} else {
				System.out.println("An Exhibit Already is Here, Do You Want to Overwrite? (Yes/No)");
				String userInput = scanner.nextLine();
				 if (userInput.equalsIgnoreCase("YES")) {
					annualPlan.addToAnnualPlan(monthNumber, hallNumber, exhibit);
					System.out.println("Overwritten Successfully");
				 } else {
					 System.out.println("Data not Overwritten");
				 }
			}
		}
	}
	
	private static void viewAnnualPlan() {
		if (annualPlans.size() == 0) {
			System.out.println("No Years Available\n");
			return;
		}
		System.out.println("List of Years Available: ");
	    for (int i = 0; i < annualPlans.size(); i++) {
	        System.out.print(annualPlans.get(i).getYear() + " ");
	    }
	    System.out.println("\nEnter the Year you Would Like to See");
	    int userInput = scanner.nextInt();
	    scanner.nextLine();
	    for (int i = 0; i < annualPlans.size(); i++) {
	        if (annualPlans.get(i).getYear() == userInput) {
	        	System.out.println(annualPlans.get(i));
	        	return;
	        }
	    }
	}
	
	private static void modifyAnnualPlan() {
		
	    System.out.println("\nEnter the Year you Would Like to Modify");
	    int userInput = scanner.nextInt();
	    scanner.nextLine();
	    
	    boolean found = false;
	    AnnualPlan annualPlan = null;
	    for (int i = 0; i < annualPlans.size(); i++) {
	        if (annualPlans.get(i).getYear() == userInput) {
	        	System.out.println(annualPlans.get(i));
	        	annualPlan = annualPlans.get(i);
	        	found = true;
	        }
	    }
	    if (!found) {
	    	System.out.println("Year Entered Not Found");
	    	return;
	    }
	    
		Menu modifyAnnualPlanChoice = new Menu ("Modify an Annual Plan", Resources.annualPlanModify);
		
		int choice = 0;
		boolean quit = false;
		
		do {
			choice = modifyAnnualPlanChoice.getUserChoice();
			quit = processModifyAnnualPlanChoice(annualPlan, choice);
		} while (!quit);
	}
	
	private static boolean processModifyAnnualPlanChoice (AnnualPlan annualPlan, int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			String userInput;
			do {
				addToAnnualPlan(annualPlan);
				
				System.out.println("Would You Like to Add More to this Annual Plan (Yes/No)");
				userInput = scanner.nextLine();
				if (userInput.equalsIgnoreCase("YES")) {
					addToAnnualPlan(annualPlan);
				}
			} while (userInput.equalsIgnoreCase("YES"));
			break;
		case 2:
			removeFromAnnualPlan(annualPlan);
			break;
		case 3:
			deleteAnnualPlan(annualPlan);
			break;
		case 4:
			quit = true;
		}
	return quit;
	}

	private static void removeFromAnnualPlan (AnnualPlan annualPlan) {
		int monthNumber = -1;
		while (monthNumber < 1 || monthNumber > 12) {
			System.out.println("What Month (1-12) to Edit:  ");
			monthNumber = scanner.nextInt();
			scanner.nextLine();
			if (monthNumber < 1 || monthNumber > 12) {
				System.out.println("Please Enter a Valid Month Number (1-12)");
			}
		}
		
		int hallNumber = -1;
		while (hallNumber < 1 || hallNumber > 3) {
			System.out.println("Which Hall (1-3) to Remove Exhibit: ");
			hallNumber = scanner.nextInt();
			scanner.nextLine();
			if (hallNumber < 1 || hallNumber > 3) {
				System.out.println("Please Enter a Valid Hall Number (1-3)");
			}
		}
		
		if (annualPlan.getExhibit(monthNumber, hallNumber) == null) {
			System.out.println("This is Already Empty, Nothing to Delete\n");
		} else {
			annualPlan.addToAnnualPlan(monthNumber, hallNumber, null);
			System.out.println("Successfully removed Exhibit from Hall " + hallNumber + " in " + Resources.months[monthNumber-1] + "\n");
		}
	}
	
	private static void deleteAnnualPlan (AnnualPlan annualPlan) {
		for (int i = 0; i < annualPlans.size(); i++) {
			if (annualPlan.getYear() == annualPlans.get(i).getYear()) {
				annualPlans.remove(i);
				System.out.println("Successfully Removed " + annualPlan.getYear() + "\n");
			}
		}
	}
}

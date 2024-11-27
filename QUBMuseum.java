package part01;

import java.util.Scanner;
import java.util.ArrayList;

public class QUBMuseum {
	static Scanner scanner = new Scanner(System.in);

	private static ArrayList<Artifact> artifacts = new ArrayList<>();
	private static ArrayList<Exhibit> exhibits = new ArrayList<>();

	public static void main(String[] args) {
		
        artifacts.add(new Artifact("bob", Type.PAINTING, 5));
        artifacts.add(new Artifact("cat", Type.DIGITAL, 6));
        artifacts.add(new Artifact("abbie", Type.DIGITAL, 3));
        artifacts.add(new Artifact("daniel", Type.TACTILE, 4));
        artifacts.add(new Artifact("dan", Type.OTHER, 5));
        artifacts.add(new Artifact("starry night", Type.PAINTING, 10));
        artifacts.add(new Artifact("digital dreams", Type.DIGITAL, 8));
        artifacts.add(new Artifact("ancient vase", Type.TACTILE, 7));
        artifacts.add(new Artifact("modern sculpture", Type.OTHER, 6));
        artifacts.add(new Artifact("mystic forest", Type.PAINTING, 9));
		
        Exhibit exhibit1 = new Exhibit("Historic Paintings");
        exhibit1.addArtifact(artifacts.get(0), "Bob's masterpiece, dated 18th century.");
        exhibit1.addArtifact(artifacts.get(5), "Famous Starry Night painting.");
        exhibit1.addArtifact(artifacts.get(9), "Depiction of a serene mystic forest.");

        Exhibit exhibit2 = new Exhibit("Digital Wonders");
        exhibit2.addArtifact(artifacts.get(1), "An artistic representation in digital form.");
        exhibit2.addArtifact(artifacts.get(2), "A digital masterpiece by Abbie.");
        exhibit2.addArtifact(artifacts.get(6), "A futuristic vision captured digitally.");

        Exhibit exhibit3 = new Exhibit("Tactile Treasures");
        exhibit3.addArtifact(artifacts.get(3), "Tactile artifact by Daniel.");
        exhibit3.addArtifact(artifacts.get(8), "A modern tactile sculpture.");
        exhibit3.addArtifact(artifacts.get(7), "Ancient vase with intricate carvings.");

        Exhibit exhibit4 = new Exhibit("Mixed Collection");
        exhibit4.addArtifact(artifacts.get(4), "A unique and unconventional artifact.");
        exhibit4.addArtifact(artifacts.get(0), "Bob's masterpiece revisited.");
        exhibit4.addArtifact(artifacts.get(8), "Sculpture representing modern creativity.");

        exhibits.add(exhibit1);
        exhibits.add(exhibit2);
        exhibits.add(exhibit3);
        exhibits.add(exhibit4);
        
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
		
		System.out.print("Enter Artifact Name: ");
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
		
		Artifact newArtifact = new Artifact (name, classification, engagementTime);
		artifacts.add(newArtifact);
		
		System.out.println("Successfully Added Artifact");
		System.out.println();
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
		System.out.println("\nEnter Name of Artifacts you want to see:"); 
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
		// "Add Exhibit", "View Exhibit", "Delete Exhibit", "Update Exhibit", "Back"
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
		for (int i = 0; i < exhibits.size(); i++) {
			System.out.println(exhibits.get(i));
		}
		System.out.println();
		// print it in alphabetical order
		// search by id
		// search by name
		// search by part name
		// search by length
		// search by engagement time
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
				System.out.println(exhibits.get(i));
				
				// what do you want to change
				// change name
				// or change artifact details
					// change artifact sign
					// append new artifact/sign
					// insert new artifact/sign
					// delete artifact/sign
					
			}
		}
	}
	
	private static void manageAnnualSchedule() {
		System.out.println("Manage Annual Schedule");
	}
}

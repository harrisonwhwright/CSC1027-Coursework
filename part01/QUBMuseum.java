package part01;

import java.util.Scanner;
import java.util.ArrayList;

public class QUBMuseum {
	
	static Scanner scanner = new Scanner(System.in);

	static ArrayList<Artifact> artifacts = new ArrayList<>();
	static ArrayList<Exhibit> exhibits = new ArrayList<>();
	static ArrayList<AnnualPlan> annualPlans = new ArrayList<>();

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
	
	private static void manageArtifacts () {
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
	
	private static void addArtifacts () {
		System.out.println();
		System.out.println("Add Artifact");
		
		String name;
		while (true) {
			System.out.print("Enter Artifact Name: ");
			name = scanner.nextLine();
			if (!name.isEmpty()) {
				break;
			} else {
				System.out.println("Invalid Name");
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
            try {
                engagementTime = scanner.nextInt();
                scanner.nextLine();
                if (engagementTime >= 0) {
                    break;
                } else {
                    System.out.println("Invalid Engagement Time.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Engagement Time");
                scanner.nextLine();
            }
        }
		
		Artifact.addArtifacts(name, classification, engagementTime);
	}

	private static void viewArtifacts () {
		if (Artifact.isArtifactListEmpty() == true) {
			return;
		}
		
		Artifact.viewAllArtifacts();
		
		int choice = 0;
		boolean quit = false;
    	Menu viewArtifactChoice = new Menu ("Search Artifacts", Resources.artifactCriteria);
		do {
			choice = viewArtifactChoice.getUserChoice();
			quit = processViewArtifactChoice(choice);
		} while (!quit);
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
	
	private static void viewArtifactById () {
	    int id;
	    while (true) {
	        System.out.print("\nEnter ID of Artifact you want to see: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
        Artifact.viewById(id);
	}
	
	private static void viewArtifactByName () {
	    String name;
	    while (true) {
	        System.out.print("\nEnter Name of Artifact you want to see: ");
	        name = scanner.nextLine();
	        if (!(name.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Name");
	            }
	    }
	    Artifact.viewByName(name);
	}

	private static void viewArtifactByPartName () {
	    String partName;
	    while (true) {
	        System.out.print("\nEnter Part Name of Artifact you want to see: ");
	        partName = scanner.nextLine();
	        if (!(partName.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Part Name");
	            }
	    }
	    Artifact.viewByPartName(partName);
	}
	
	private static void viewArtifactByType () {
		Type typeUserInput;
		while (true) {
	        System.out.print("\nEnter Type of Artifact you want to see: ");
	        String type = scanner.nextLine();
	        if (type.isEmpty()) {
	            System.out.println("Invalid Type");
	            continue;
	        }
	        try {
	            typeUserInput = Type.valueOf(type.toUpperCase());
	            break;
	        } catch (Exception e) {
	            System.out.println("Invalid Type");
	        }
	    }
	    Artifact.viewByType(typeUserInput);
	}
	
	
	private static void deleteArtifacts () {
		if (Artifact.isArtifactListEmpty() == true) {
			return;
		}
		
	    int id;
	    while (true) {
	        System.out.print("\nEnter ID of Artifact you want to delete: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
        Artifact.deleteArtifact(id);
	}
	
	private static void updateArtifacts () {
		if (Artifact.isArtifactListEmpty() == true) {
			return;
		}
		
	    int id;
	    while (true) {
	        System.out.print("\nEnter ID of Artifact you want to see: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
	    
	    String name;
	    while (true) {
	        System.out.print("\nEnter Name of Artifact you want to see: ");
	        name = scanner.nextLine();
	        if (!(name.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Name");
	            }
	    }
	    
		Type typeUserInput;
		while (true) {
	        System.out.print("\nEnter Type of Artifact you want to see: ");
	        String type = scanner.nextLine();
	        if (type.isEmpty()) {
	            System.out.println("Invalid Type");
	            continue;
	        }
	        try {
	            typeUserInput = Type.valueOf(type.toUpperCase());
	            break;
	        } catch (Exception e) {
	            System.out.println("Invalid Type");
	        }
	    }
	    
		int engagementTime;
        while (true) {
            System.out.print("Enter Engagement Time: ");
            try {
                engagementTime = scanner.nextInt();
                scanner.nextLine();
                if (engagementTime >= 0) {
                    break;
                } else {
                    System.out.println("Invalid Engagement Time.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Engagement Time");
                scanner.nextLine();
            }
        }
	    
        Artifact.updateArtifact(id, name, typeUserInput, engagementTime);
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
			createExhibit();
			break;
		case 2:
			addExhibitArtifacts();
			break;
		case 3:
			viewExhibit();
			break;
		case 4:
			deleteExhibit();
			break;
		case 5:
			updateExhibit();
			break;
		case 6:
			quit = true;
		}
		return quit;
	}
	
	private static void createExhibit () {
		System.out.println();
		System.out.println("Create New Exhibit");
		
		String name;
		while (true) {
			System.out.print("Enter Exhibit Name: ");
			name = scanner.nextLine();
			if (!name.isEmpty()) {
				break;
			} else {
				System.out.println("Invalid Name");
			}
		}
		
		int exhibitId = Exhibit.createExhibit(name);
		if (exhibitId > 0) {
			System.out.println("\nDo you want to add an Artifact to this Exhibit? (Yes/No)");
			String userInput = scanner.nextLine();
			while (userInput.equalsIgnoreCase("YES")) {
				addArtifactsToExhibit(exhibitId);
				System.out.println("\nDo you want to add another Artifact to this Exhibit? (Yes/No)");
				userInput = scanner.nextLine();
			}
		}
	}
	
	private static void addExhibitArtifacts () {
		if (Exhibit.isExhibitListEmpty() == true) {
			return;
		}
		if (Artifact.isArtifactListEmpty() == true) {
			return;
		}
		
		int id;
	    while (true) {
	        System.out.print("\nEnter ID of Exhibit you want to add to: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
	    
		boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == id) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + id);
			return;
		}
		
	    String userInput = "YES";
	    while (userInput.equalsIgnoreCase("YES")) {
	    	addArtifactsToExhibit(id);
			System.out.println("\nDo you want to add another Artifact to this Exhibit? (Yes/No)");
			userInput = scanner.nextLine();
		}
	}
	
	private static void addArtifactsToExhibit(int exhibitId) {
	    int artifactId;
	    while (true) {
	        System.out.print("\nEnter ID of Artifact you want to Add: ");
	        try {
	        	artifactId = scanner.nextInt();
	            scanner.nextLine();
	            if (artifactId >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
		boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == artifactId) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + artifactId);
			return;
		}
		
		String sign;
	    while (true) {
	        System.out.print("\nEnter Sign to be placed with the Artifact: ");
	        sign = scanner.nextLine();
	        if (!(sign.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Sign");
	            }
	    }
		Exhibit.addArtifact(exhibitId, artifactId, sign);
	}

	private static void viewExhibit() {
		if (Exhibit.isExhibitListEmpty() == true) {
			return;
		}
		
		Exhibit.viewAllExhibits();
		
		int choice = 0;
		boolean quit = false;
		Menu viewExhibitChoice = new Menu ("Search Exhibits", Resources.exhibitCriteria);
		do {
			choice = viewExhibitChoice.getUserChoice();
			quit = processViewExhibitChoice(choice);
		} while (!quit);
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
	
	private static void viewExhibitById () {
		int id;
		while (true) {
	        System.out.print("\nEnter ID of Exhibit you want to see: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
        Exhibit.viewById(id);
	}
	
	private static void viewExhibitByName () {
	    String name;
	    while (true) {
	        System.out.print("\nEnter Name of Exhibit you want to see: ");
	        name = scanner.nextLine();
	        if (!(name.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Name");
	            }
	    }
	    Exhibit.viewByName(name);
	}
	
	private static void viewExhibitByPartName () {
	    String partName;
	    while (true) {
	        System.out.print("\nEnter Part Name of Exhibit you want to see: ");
	        partName = scanner.nextLine();
	        if (!(partName.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Part Name");
	            }
	    }
	    Exhibit.viewByPartName(partName);
	}
	
	private static void viewExhibitByEngagementTime () {
		int engagementTime;
		while (true) {
	        System.out.print("\nEnter Engagement Time of Exhibit you want to see: ");
	        try {
	        	engagementTime = scanner.nextInt();
	            scanner.nextLine();
	            if (!(engagementTime < 1)) {
	                break;
	            } else {
	                System.out.println("Invalid Engagement Time");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Engagement Time");
	            scanner.nextLine();
	        }
	    }
        Exhibit.viewByEngagementTime(engagementTime);
	}
	
	private static void deleteExhibit () {
		if (Exhibit.isExhibitListEmpty() == true) {
			return;
		}
		
	    int id;
	    while (true) {
	        System.out.print("\nEnter ID of Exhibit you want to delete: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
        Exhibit.deleteExhibit(id);
	}
	
	private static void updateExhibit () {
		if (Exhibit.isExhibitListEmpty() == true) {
			return;
		}
		
		int id;
		while (true) {
	        System.out.print("\nEnter ID of Exhibit you want to Update: ");
	        try {
	            id = scanner.nextInt();
	            scanner.nextLine();
	            if (id >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
		
		boolean found = false;
		for (int i = 0; i < exhibits.size(); i++) {
			if (id == exhibits.get(i).getId()) {
				found = true;
				int exhibitId = id;
				System.out.println(exhibits.get(i));
				
				Menu exhibitUpdateMenu = new Menu ("\nUpdate Exhibit", Resources.exhibitUpdate);

				int choice = 0;
				boolean quit = false;
				
				do {
					choice = exhibitUpdateMenu.getUserChoice();
					quit = processExhibitUpdateMenu(choice, exhibitId);
				} while (!quit);
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID: " + id);
		}
	}
	
	private static boolean processExhibitUpdateMenu (int choice, int exhibitId) {
		boolean quit = false;
		switch (choice) {
		case 1:
			changeExhibitName(exhibitId);
			break;
		case 2:
			changeArtifactSignInExhibit(exhibitId);
			break;
		case 3:
			appendNewArtifactInExhibit(exhibitId);
			break;
		case 4:
			insertNewArtifactInExhibit(exhibitId);
			break;
		case 5:
			deleteArtifactInExhibit(exhibitId);
			break;
		case 6:
			quit = true;
		}
		return quit;
	}
	
	private static void changeExhibitName (int exhibitId) {
		System.out.println("Change Exhibit Name, Currently: " + exhibits.get(exhibitId).getName());
		String name;
		while (true) {
			System.out.print("Enter Artifact Name: ");
			name = scanner.nextLine();
			if (!name.isEmpty()) {
				break;
			} else {
				System.out.println("Invalid Name");
			}
		}
		Exhibit.changeName(exhibitId, name);
	}
	
	private static void changeArtifactSignInExhibit (int exhibitId) {
		System.out.println("Exhibit Currently looks like this: ");
		Exhibit.viewById(exhibitId);

		int artifactId;
		while (true) {
	        System.out.print("\nEnter ID of Artifact you want to Update: ");
	        try {
	        	artifactId = scanner.nextInt();
	            scanner.nextLine();
	            if (artifactId >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid Artifact ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Artifact ID");
	            scanner.nextLine();
	        }
	    }
		
		String sign;
		while (true) {
			System.out.print("Enter New Artifact Sign: ");
			sign = scanner.nextLine();
			if (!sign.isEmpty()) {
				break;
			} else {
				System.out.println("Invalid Sign");
			}
		}
		Exhibit.changeSign(exhibitId, artifactId, sign);
	}
	
	private static void appendNewArtifactInExhibit (int exhibitId) {
		addExhibitArtifacts();
	}
	
	private static void insertNewArtifactInExhibit (int exhibitId) {
	    int artifactId;
	    while (true) {
	        System.out.print("\nEnter ID of Artifact you want to Add: ");
	        try {
	        	artifactId = scanner.nextInt();
	            scanner.nextLine();
	            if (artifactId >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
		boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == artifactId) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + artifactId);
			return;
		}
		
		String sign;
	    while (true) {
	        System.out.print("\nEnter Sign to be placed with the Artifact: ");
	        sign = scanner.nextLine();
	        if (!(sign.isEmpty())) {
	        	break;
	        	} else {
	        		System.out.println("Invalid Sign");
	            }
	    }
	    
	    int positionInput;
	    int index;
	    while (true) {
	        System.out.print("\nEnter the Position you want the Artifact to be inserted at: ");
	        try {
	        	positionInput = scanner.nextInt();
	            scanner.nextLine();
	            index = positionInput - 1;
	            break;
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
		Exhibit.addArtifact(exhibitId, artifactId, sign, index);
	}
	
	private static void deleteArtifactInExhibit (int exhibitId) {
	    int artifactId;
	    while (true) {
	        System.out.print("\nEnter ID of Artifact you want to Delete: ");
	        try {
	        	artifactId = scanner.nextInt();
	            scanner.nextLine();
	            if (artifactId >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid ID");
	            scanner.nextLine();
	        }
	    }
		boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == artifactId) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + artifactId);
			return;
		}
		Exhibit.deleteArtifact(exhibitId, artifactId);
	}
	
	private static void manageAnnualSchedule () {
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
			createAnnualPlan();
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
	
	private static void createAnnualPlan () {
	    int year;
	    while (true) {
	        System.out.print("\nEnter Year of the Annual Plan you want to Create: ");
	        try {
	        	year = scanner.nextInt();
	            scanner.nextLine();
	            if (year >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid Year");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Year");
	            scanner.nextLine();
	        }
	    }
	    
	    if (AnnualPlan.createAnnualPlan(year) == true) {
	    	System.out.println("\nDo you want to add an Exhibit to this Annual Plan? (Yes/No)");
			String userInput = scanner.nextLine();
			while (userInput.equalsIgnoreCase("YES")) {
				addToAnnualPlan(year);
				System.out.println("\nDo you want to add another Exhibit to this Annual Plan? (Yes/No)");
				userInput = scanner.nextLine();
			}
	    }
	}
	
	private static void addToAnnualPlan(int year) {
	    int exhibitId;
	    while (true) {
	        System.out.print("\nEnter ID of Exhibit you want to add: ");
	        try {
	            exhibitId = scanner.nextInt();
	            scanner.nextLine();
	            if (exhibitId >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid Exhibit ID");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Exhibit ID");
	            scanner.nextLine();
	        }
	    }

	    Exhibit selectedExhibit = null;
	    for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
	        if (QUBMuseum.exhibits.get(i).getId() == exhibitId) {
	            selectedExhibit = QUBMuseum.exhibits.get(i);
	            break;
	        }
	    }

	    if (selectedExhibit == null) {
	        System.out.println("No Exhibits Found with ID " + exhibitId);
	        return;
	    }

	    int monthNumber;
	    while (true) {
	        System.out.print("\nEnter which Month it should take place (1-12): ");
	        try {
	            monthNumber = scanner.nextInt();
	            scanner.nextLine();
	            if (monthNumber >= 1 && monthNumber <= 12) {
	                break;
	            } else {
	                System.out.println("Invalid Month Number");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Month Number");
	            scanner.nextLine();
	        }
	    }

	    int hallNumber;
	    while (true) {
	        System.out.print("\nEnter which Hall it should take place (1-3): ");
	        try {
	            hallNumber = scanner.nextInt();
	            scanner.nextLine();
	            if (hallNumber >= 1 && hallNumber <= 3) {
	                break;
	            } else {
	                System.out.println("Invalid Hall Number");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Hall Number");
	            scanner.nextLine();
	        }
	    }

	    AnnualPlan selectedPlan = null;
	    for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
	        if (QUBMuseum.annualPlans.get(i).getYear() == year) {
	            selectedPlan = QUBMuseum.annualPlans.get(i);
	            break;
	        }
	    }

	    if (selectedPlan == null) {
	        System.out.println("No Annual Plan Found for Year " + year);
	        return;
	    }

	    Exhibit existingExhibit = selectedPlan.returnExhibit(selectedPlan, monthNumber, hallNumber);
	    if (existingExhibit == null) {
	    	AnnualPlan.addToAnnualPlan(year, exhibitId, monthNumber, hallNumber);
	        System.out.println("Exhibit added successfully");
	    } else {
	        System.out.println("An Exhibit already exists: " + existingExhibit.getName());
	        System.out.println("Do you want to overwrite? (Yes/No)");
	        String userInput = scanner.nextLine();
	        if (userInput.equalsIgnoreCase("YES")) {
	        	AnnualPlan.addToAnnualPlan(year, exhibitId, monthNumber, hallNumber);
	            System.out.println("Overwritten successfully");
	        } else {
	            System.out.println("Data not Overwritten");
	        }
	    }
	}

	
	private static void viewAnnualPlan () {
		AnnualPlan.listAllAnnualPlans();
		
	    int year;
	    while (true) {
	        System.out.print("\nEnter Year of the Annual Plan you want to View in detail: ");
	        try {
	        	year = scanner.nextInt();
	            scanner.nextLine();
	            if (year >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid Year");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Year");
	            scanner.nextLine();
	        }
	    }
	    AnnualPlan.viewByYear(year);
	}
	
	private static void modifyAnnualPlan () {
		if (AnnualPlan.isAnnualPlanListEmpty() == true) {
			return;
		}
		
		int year;
		while (true) {
	        System.out.print("\nEnter Year of Annual Plan you want to Update: ");
	        try {
	        	year = scanner.nextInt();
	            scanner.nextLine();
	            if (year >= 1) {
	                break;
	            } else {
	                System.out.println("Invalid Year");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Year");
	            scanner.nextLine();
	        }
	    }
		
		boolean found = false;
		for (int i = 0; i < annualPlans.size(); i++) {
			if (annualPlans.get(i).getYear() == year) {
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Annual Plan Found with Year " + year);
			return;
		}
		
		Menu modifyAnnualPlanChoice = new Menu ("Modify an Annual Plan", Resources.annualPlanModify);
		
		int choice = 0;
		boolean quit = false;
		
		do {
			choice = modifyAnnualPlanChoice.getUserChoice();
			quit = processModifyAnnualPlanChoice(year, choice);
		} while (!quit);
	}
	
	private static boolean processModifyAnnualPlanChoice (int year, int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			addToAnnualPlan(year);
			break;
		case 2:
			removeFromAnnualPlan(year);
			break;
		case 3:
			AnnualPlan.deleteAnnualPlan(year);
			break;
		case 4:
			quit = true;
		}
	return quit;
	}
	
	private static void removeFromAnnualPlan (int year) {
	    int monthNumber;
	    while (true) {
	        System.out.print("\nEnter which Month to remove Exhibit (1-12): ");
	        try {
	            monthNumber = scanner.nextInt();
	            scanner.nextLine();
	            if (monthNumber >= 1 && monthNumber <= 12) {
	                break;
	            } else {
	                System.out.println("Invalid Month Number");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Month Number");
	            scanner.nextLine();
	        }
	    }

	    int hallNumber;
	    while (true) {
	        System.out.print("\nEnter which Hall to remove Exhibit (1-3): ");
	        try {
	            hallNumber = scanner.nextInt();
	            scanner.nextLine();
	            if (hallNumber >= 1 && hallNumber <= 3) {
	                break;
	            } else {
	                System.out.println("Invalid Hall Number");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Hall Number");
	            scanner.nextLine();
	        }
	    }
	    
	    AnnualPlan.removeFromAnnualPlan(year, monthNumber, hallNumber);
	}
	
}

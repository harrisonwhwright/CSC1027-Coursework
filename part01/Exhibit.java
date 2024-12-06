package part01;

import java.util.ArrayList;

public class Exhibit {
	static int nextId = 1;
	
	private int id;
	private String name;
    private ArrayList<Artifact> artifacts;
    private ArrayList<String> signs;
	
	public Exhibit (String name) {
		setId();
		setName(name);
		this.artifacts = new ArrayList<>();
        this.signs = new ArrayList<>();
	}
	
	// SETTERS
	public void setId () {
		this.id = nextId;
		nextId += 1;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	// GETTERS
	public int getId () {
		return this.id;
	}
	
	public String getName () {
		return this.name;
	}
	
    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    public ArrayList<String> getArtifactSigns() {
        return signs;
    }
    
    public int getTotalTime() {
    	int totalTime = 0;
		for (int i = 0; i < artifacts.size(); i++) {
	        Artifact artifact = artifacts.get(i);
	        totalTime += artifact.getEngagementTime();
	    }
		return totalTime;
    }
    
	//METHODS
	public String getDetails() {
	    String result = "ID: " + getId() + ", Name: " + getName() + ", Total Time: " + getTotalTime();
		
	    int count = 1;
	    for (int i = 0; i < artifacts.size(); i++) {
	        Artifact artifact = artifacts.get(i);
	        result += "\n       " + count + ". (ID: " + artifact.getId() + ") Name: " + artifact.getName() + ", Time: " + artifact.getEngagementTime() + ", Sign: " + signs.get(i);
	        count += 1;
	    }
	    return result;
	}
	
	public String toString() {
		return getDetails();
	}
	
	public static int createExhibit (Object name) {
	    if (name == null || !(name instanceof String) || ((String) name).isEmpty()) {
	        System.out.println("Invalid Exhibit Name, Not Added to Exhibits");
	        return 0;
	    }
	    String validName = (String) name;
	    
		Exhibit newExhibit = new Exhibit (validName);
		QUBMuseum.exhibits.add(newExhibit);
		
		System.out.println("Successfully Added Exhibit");
		
		int exhibitId = newExhibit.getId();
		return exhibitId;
	}
	
	public static void addArtifact (Object exhibitId, Object artifactId, Object sign) {
		if (Artifact.isArtifactListEmpty() == true) {
			return;
		}
		
		if (exhibitId == null || !(exhibitId instanceof Integer) || (int) exhibitId < 1) {
	        System.out.println("Invalid Exhibit ID, Can't add Artifact to Exhibit");
	        return;
		}
		int validExhibitId = (int) exhibitId;
		
		if (artifactId == null || !(artifactId instanceof Integer) || (int) artifactId < 1) {
	        System.out.println("Invalid Artifact ID, Can't add Artifact to Exhibit");
	        return;
		}
		int validArtifactId = (int) artifactId;
		
	    if (sign == null || !(sign instanceof String) || ((String) sign).isEmpty()) {
	        System.out.println("Invalid Sign, Can't add to Exhibit");
	        return;
	    }
	    String validSign = (String) sign;
	    
	    Exhibit exhibit = null;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
				found = true;
				exhibit = QUBMuseum.exhibits.get(i);
				break;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + exhibitId);
			return;
		}
		
		Artifact artifact = null;
		found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == validArtifactId) {
				artifact = QUBMuseum.artifacts.get(i);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + artifactId);
			return;
		}
		
		found = false;
		for (int i = 0; i < exhibit.artifacts.size(); i++) {	
			if (validArtifactId == exhibit.artifacts.get(i).getId()) {
				found = true;
			}
		}
		if (found) {
			System.out.println("\nArtifact with that ID " + artifactId + " already exists in this Exhibit");
			return;
		}
		
		exhibit.artifacts.add(artifact);
		exhibit.signs.add(validSign);
        System.out.println("\nSuccessfully Added Artifact & Sign to Exhibit");
	}
	
	public static void addArtifact (Object exhibitId, Object artifactId, Object sign, Object index) {
		if (Artifact.isArtifactListEmpty() == true) {
			return;
		}
		
		if (exhibitId == null || !(exhibitId instanceof Integer) || (int) exhibitId < 1) {
	        System.out.println("Invalid Exhibit ID, Can't add Artifact to Exhibit");
	        return;
		}
		int validExhibitId = (int) exhibitId;
		
		if (artifactId == null || !(artifactId instanceof Integer) || (int) artifactId < 1) {
	        System.out.println("Invalid Artifact ID, Can't add Artifact to Exhibit");
	        return;
		}
		int validArtifactId = (int) artifactId;
		
	    if (sign == null || !(sign instanceof String) || ((String) sign).isEmpty()) {
	        System.out.println("Invalid Sign, Can't add to Exhibit");
	        return;
	    }
	    String validSign = (String) sign;
	    
		if (index == null || !(index instanceof Integer)) {
	        System.out.println("Invalid Index, Can't add Artifact to Exhibit");
	        return;
		}
		int validIndex = (int) index;
	    
		Exhibit exhibit = null;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
				found = true;
				exhibit = QUBMuseum.exhibits.get(i);
				break;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + exhibitId);
			return;
		}
		
		Artifact artifact = null;
		found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == validArtifactId) {
				artifact = QUBMuseum.artifacts.get(i);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + artifactId);
			return;
		}
		
		found = false;
		for (int i = 0; i < exhibit.artifacts.size(); i++) {	
			if (validArtifactId == exhibit.artifacts.get(i).getId()) {
				found = true;
			}
		}
		if (found) {
			System.out.println("\nArtifact with that ID " + artifactId + " already exists in this Exhibit");
			return;
		}
		
		if (validIndex < 0 || validIndex > exhibit.artifacts.size()) {
            System.out.println("Invalid Index, Adding Artifact to End");
            exhibit.artifacts.add(artifact);
            exhibit.signs.add(validSign);
            System.out.println("\nSuccessfully Added Artifact & Sign to Exhibit");
            return;
        } else {
        	exhibit.artifacts.add(validIndex, artifact);
        	exhibit.signs.add(validIndex, validSign);
        }
        System.out.println("\nSuccessfully Added Artifact & Sign to Exhibit at Index " + validIndex);
	}
	
	static boolean isExhibitListEmpty () {
		if (QUBMuseum.exhibits.size() == 0) {
			System.out.println("Exhibit list is empty");
			return true;
		}
		return false;
	}
	
	public static void viewAllExhibits () {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
		for (int i = 0; i < QUBMuseum.exhibits.size() - 1; i++) {
	        for (int j = 0; j < QUBMuseum.exhibits.size() - 1 - i; j++) {
	            if (QUBMuseum.exhibits.get(j).getName().compareTo(QUBMuseum.exhibits.get(j + 1).getName()) > 0) {
	                Exhibit temp = QUBMuseum.exhibits.get(j);
	                QUBMuseum.exhibits.set(j, QUBMuseum.exhibits.get(j + 1));
	                QUBMuseum.exhibits.set(j + 1, temp);
	            }
	        }
	    }
	    for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
	        System.out.println(QUBMuseum.exhibits.get(i));
	    }
	}
	
	public static void viewById (Object id) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
		if (id == null || !(id instanceof Integer) || (int) id < 1) {
	        System.out.println("Invalid ID, Nothing to View");
	        return;
		}
		int validId = (int) id;
		
		boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validId) {
				System.out.println(QUBMuseum.exhibits.get(i));
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Exhibits Found with ID " + id);
		}
	}
	
	public static void viewByName (Object name) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
	    if (name == null || !(name instanceof String) || ((String) name).isEmpty()) {
	        System.out.println("Invalid Name, Nothing to View");
	        return;
	    }
	    String validName = (String) name;
	    
	    boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getName() == validName) {
				System.out.println(QUBMuseum.exhibits.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Exhibits Found with Name: " + name);
	    }
	}

	public static void viewByPartName (Object partName) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
	    if (partName == null || !(partName instanceof String) || ((String) partName).isEmpty()) {
	        System.out.println("Invalid Part Name, Nothing to View");
	        return;
	    }
	    String valiPartdName = (String) partName;
	    
	    boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getName().toUpperCase().contains(valiPartdName.toUpperCase())) {
				System.out.println(QUBMuseum.exhibits.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Exhibits Found with Part Name: " + partName);
	    }
	}
	
	public static void viewByEngagementTime (Object engagementTime) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
		if (engagementTime == null || !(engagementTime instanceof Integer) || (int) engagementTime < 1) {
	        System.out.println("Invalid ID, Nothing to View");
	        return;
		}
		int validEngagementTime = (int) engagementTime;
		
		boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getTotalTime() == validEngagementTime) {
				System.out.println(QUBMuseum.exhibits.get(i));
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Exhibits Found with Engagement Time " + engagementTime);
		}
	}

	public static void deleteExhibit (Object id) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
		if (id == null || !(id instanceof Integer) || (int) id < 1) {
	        System.out.println("Invalid ID, Nothing Deleted");
	        return;
		}
		int validId = (int) id;
		
		boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validId) {
				QUBMuseum.exhibits.remove(i);
				System.out.println("Successfully Removed Exhibit");
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + id);
		}
	}
	
	public static void changeName (Object exhibitId, Object name) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
		if (exhibitId == null || !(exhibitId instanceof Integer) || (int) exhibitId < 1) {
	        System.out.println("Invalid ID, Nothing Changed");
	        return;
		}
		int validId = (int) exhibitId;
		
	    if (name == null || !(name instanceof String) || ((String) name).isEmpty()) {
	        System.out.println("Invalid Name, Nothing Changed");
	        return;
	    }
	    String validName = (String) name;
	    	    
	    Exhibit exhibit = null;
	    boolean found = false;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validId) {
				exhibit = QUBMuseum.exhibits.get(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + exhibitId);
			return;
		}
		
		exhibit.setName(validName);
		System.out.println("Successfully Updated Exhibit");
	}
	
	public static void changeSign (Object exhibitId, Object artifactId, Object sign) {
		if (isExhibitListEmpty() == true) {
			return;
		}
		
		if (exhibitId == null || !(exhibitId instanceof Integer) || (int) exhibitId < 1) {
	        System.out.println("Invalid Exhibit ID, Nothing Changed");
	        return;
		}
		int validExhibitId = (int) exhibitId;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Exhibit Found with ID " + exhibitId);
			return;
		}
		if (artifactId == null || !(artifactId instanceof Integer) || (int) artifactId < 1) {
	        System.out.println("Invalid Artifact ID, Nothing Changed");
	        return;
		}
		int validArtifactId = (int) artifactId;
		
	    if (sign == null || !(sign instanceof String) || ((String) sign).isEmpty()) {
	        System.out.println("Invalid Sign, Nothing Changed");
	        return;
	    }
	    String validSign = (String) sign;
	    
	    Exhibit exhibit = null;
	    for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
	        if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
	            exhibit = QUBMuseum.exhibits.get(i);
	            break;
	        }
	    }
	    if (exhibit == null) {
	        System.out.println("No Exhibit Found with ID " + exhibitId);
	        return;
	    }

	    found = false;
	    for (int i = 0; i < exhibit.getArtifacts().size(); i++) {
	        if (exhibit.getArtifacts().get(i).getId() == validArtifactId) {
	            exhibit.getArtifactSigns().set(i, validSign);
	            System.out.println("Successfully Updated Sign for Artifact ID " + artifactId);
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("No Artifact Found with ID " + artifactId + " in Exhibit ID " + exhibitId);
	    }
	}	
	
	public static void deleteArtifact(Object exhibitId, Object artifactId) {
	    if (isExhibitListEmpty() == true) {
	        return;
	    }

	    if (exhibitId == null || !(exhibitId instanceof Integer) || (int) exhibitId < 1) {
	        System.out.println("Invalid Exhibit ID, Nothing Changed");
	        return;
	    }
	    int validExhibitId = (int) exhibitId;

	    boolean found = false;
	    for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
	        if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("No Exhibit Found with ID " + exhibitId);
	        return;
	    }

	    if (artifactId == null || !(artifactId instanceof Integer) || (int) artifactId < 1) {
	        System.out.println("Invalid Artifact ID, Nothing Changed");
	        return;
	    }
	    int validArtifactId = (int) artifactId;

	    Exhibit exhibit = null;
	    for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
	        if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
	            exhibit = QUBMuseum.exhibits.get(i);
	            break;
	        }
	    }
	    if (exhibit == null) {
	        System.out.println("No Exhibit Found with ID " + exhibitId);
	        return;
	    }

	    found = false;
	    for (int i = 0; i < exhibit.getArtifacts().size(); i++) {
	        if (exhibit.getArtifacts().get(i).getId() == validArtifactId) {
	            exhibit.getArtifacts().remove(i);
	            exhibit.getArtifactSigns().remove(i);
	            System.out.println("Successfully Removed Artifact ID " + artifactId + " from Exhibit ID " + exhibitId);
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("No Artifact Found with ID " + artifactId + " in Exhibit ID " + exhibitId);
	    }
	}

}


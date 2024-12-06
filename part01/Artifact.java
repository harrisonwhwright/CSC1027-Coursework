package part01;

public class Artifact {
	static int nextId = 1;
	
	private int id;
	private String name;
	private Type classification;
	private int engagementTime;
	
	public Artifact (String name, Type classification, int engagementTime) {
		setId();
		setName(name);
		setType(classification);
		setEngagementTime(engagementTime);
	}
	
	// SETTERS
	public void setId () {
		this.id = nextId;
		nextId += 1;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setType (Type classification) {
		this.classification = classification;
	}
	
	public void setEngagementTime (int engagementTime) {
		this.engagementTime = engagementTime;
	}
	
	// GETTERS
	public int getId () {
		return this.id;
	}
	
	public String getName () {
		return this.name;
	}
	
	public Type getType () {
		return this.classification;
	}
	
	public int getEngagementTime () {
		return this.engagementTime;
	}
	
	//METHODS
	public String getDetails () {
		String result = "ID: " + getId() + ", Name: " + getName() + ", Type: " + getType() + ", Engagement Time: " + getEngagementTime();
		return result;
	}
	
	public String toString () {
		return getDetails();
	}
	
	public static void addArtifacts (Object name, Object classification, Object engagementTime) {
	    if (name == null || !(name instanceof String) || ((String) name).isEmpty()) {
	        System.out.println("Invalid Artifact Name, Not Added to Artifacts");
	        return;
	    }
	    String validName = (String) name;
	    
	    if (!(classification instanceof Type)) {
	        System.out.println("Invalid Type Provided, using OTHER");
	        classification = Type.OTHER;
	    }
	    Type validClassification = (Type) classification;
	    
	    if (engagementTime == null || !(engagementTime instanceof Integer) || (int) engagementTime < 0) {
	        System.out.println("Invalid Engagement Time Entered, Not Added to Artifacts");
	        return;
	    }
	    int validEngagementTime = (int) engagementTime;
	    
		Artifact newArtifact = new Artifact (validName, validClassification, validEngagementTime);
		QUBMuseum.artifacts.add(newArtifact);
		
		System.out.println("Successfully Added Artifact");
	}
	
	static boolean isArtifactListEmpty () {
		if (QUBMuseum.artifacts.size() == 0) {
			System.out.println("Artifact list is empty");
			return true;
		}
		return false;
	}
	
	public static void viewAllArtifacts () {
		if (isArtifactListEmpty() == true) {
			return;
		}
	    
	    for (int i = 0; i < QUBMuseum.artifacts.size() - 1; i++) {
	        for (int j = 0; j < QUBMuseum.artifacts.size() - 1 - i; j++) {
	            if (QUBMuseum.artifacts.get(j).getName().compareTo(QUBMuseum.artifacts.get(j + 1).getName()) > 0) {
	            	Artifact temp = QUBMuseum.artifacts.get(j);
	            	QUBMuseum.artifacts.set(j, QUBMuseum.artifacts.get(j + 1));
	            	QUBMuseum.artifacts.set(j + 1, temp);
	            }
	        }
	    }
	    for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
	        System.out.println(QUBMuseum.artifacts.get(i));
	    }
	}
	
	public static void viewById (Object id) {
		if (isArtifactListEmpty() == true) {
			return;
		}
		
		if (id == null || !(id instanceof Integer) || (int) id < 1) {
	        System.out.println("Invalid ID, Nothing to View");
	        return;
		}
		int validId = (int) id;
		
		boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == validId) {
				System.out.println(QUBMuseum.artifacts.get(i));
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + id);
		}
	}
	
	public static void viewByName (Object name) {
		if (isArtifactListEmpty() == true) {
			return;
		}
		
	    if (name == null || !(name instanceof String) || ((String) name).isEmpty()) {
	        System.out.println("Invalid Name, Nothing to View");
	        return;
	    }
	    String validName = (String) name;
	    
	    boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getName() == validName) {
				System.out.println(QUBMuseum.artifacts.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Artifacts Found with Name: " + name);
	    }
	}

	public static void viewByPartName (Object partName) {
		if (isArtifactListEmpty() == true) {
			return;
		}
		
	    if (partName == null || !(partName instanceof String) || ((String) partName).isEmpty()) {
	        System.out.println("Invalid Part Name, Nothing to View");
	        return;
	    }
	    String valiPartdName = (String) partName;
	    
	    boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getName().toUpperCase().contains(valiPartdName.toUpperCase())) {
				System.out.println(QUBMuseum.artifacts.get(i));
				found = true;
			}
		}
	    if (!found) {
	        System.out.println("No Artifacts Found with Part Name: " + partName);
	    }
	}
	
	public static void viewByType (Object type) {
	    if (isArtifactListEmpty()) {
	        return;
	    }

	    if (type == null) {
	        System.out.println("Invalid Type");
	        return;
	    }

	    Type validType = null;
	    if (type instanceof String) {
	        try {
	            validType = Type.valueOf(((String) type).toUpperCase());
	        } catch (Exception e) {
	            System.out.println("Invalid Type");
	            return;
	        }
	    } 
	    else if (type instanceof Type) {
	        validType = (Type) type;
	    } else {
	        System.out.println("Invalid Type");
	        return;
	    }

	    boolean found = false;
	    for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
	        if (QUBMuseum.artifacts.get(i).getType() == validType) {
	        	System.out.println(QUBMuseum.artifacts.get(i));
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No Artifacts Found with Type: " + validType);
	    }
	}

	public static void deleteArtifact (Object id) {
		if (isArtifactListEmpty() == true) {
			return;
		}
		
		if (id == null || !(id instanceof Integer) || (int) id < 1) {
	        System.out.println("Invalid ID, Nothing Deleted");
	        return;
		}
		int validId = (int) id;
		
		boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (QUBMuseum.artifacts.get(i).getId() == validId) {
				QUBMuseum.artifacts.remove(i);
				System.out.println("Successfully Removed Artifact");
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Artifact Found with ID " + id);
		}
	}
	
	public static void updateArtifact (Object id, Object name, Object classification, Object engagementTime) {
		if (isArtifactListEmpty() == true) {
			return;
		}
		
		if (id == null || !(id instanceof Integer) || (int) id < 1) {
	        System.out.println("Invalid ID, Nothing Updated");
	        return;
		}
		int validId = (int) id;
		
	    if (name == null || !(name instanceof String) || ((String) name).isEmpty()) {
	        System.out.println("Invalid Artifact Name, Nothing Updated");
	        return;
	    }
	    String validName = (String) name;
	    
	    if (!(classification instanceof Type)) {
	        System.out.println("Invalid Type Provided, using OTHER");
	        classification = Type.OTHER;
	    }
	    Type validClassification = (Type) classification;
	    
	    if (engagementTime == null || !(engagementTime instanceof Integer) || (int) engagementTime < 0) {
	        System.out.println("Invalid Engagement Time Entered, Nothing Updated");
	        return;
	    }
	    int validEngagementTime = (int) engagementTime;
		
	    boolean found = false;
		for (int i = 0; i < QUBMuseum.artifacts.size(); i++) {
			if (validId == QUBMuseum.artifacts.get(i).getId()) {
				found = true;
				QUBMuseum.artifacts.get(i).setName(validName);
				QUBMuseum.artifacts.get(i).setType(validClassification);
				QUBMuseum.artifacts.get(i).setEngagementTime(validEngagementTime);
				System.out.println("Successfully Updated Artifact");
			}
			if (!found) {
				System.out.println("No Artifact Found with ID: " + id);
			}
		}
	}
}
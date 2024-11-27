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
	
	//METHODS
	public String getDetails() {
	    String result = "ID: " + getId() + ", Name: " + getName() + ", Total Time: " + getTotalTime();
		
	    for (int i = 0; i < artifacts.size(); i++) {
	        Artifact artifact = artifacts.get(i);
	        result += "\n       Name: " + artifact.getName() + ", Time: " + artifact.getEngagementTime() + ", Sign: " + signs.get(i);
	    }
	    return result;
	}
	
	public String toString() {
		return getDetails();
	}
	
    public void addArtifact(Artifact artifact, String signText) {
        artifacts.add(artifact);
        signs.add(signText);
    }
    
    public int getTotalTime() {
    	int totalTime = 0;
		for (int i = 0; i < artifacts.size(); i++) {
	        Artifact artifact = artifacts.get(i);
	        totalTime += artifact.getEngagementTime();
	    }
		return totalTime;
    }
    
    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    public ArrayList<String> getArtifactSigns() {
        return signs;
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
}

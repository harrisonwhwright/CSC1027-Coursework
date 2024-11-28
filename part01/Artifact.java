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
	
	//METHODS
	public String getDetails() {
		String result = "ID: " + getId() + ", Name: " + getName() + ", Type: " + getType() + ", Engagement Time: " + getEngagementTime();
		return result;
	}
	public String toString() {
		return getDetails();
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
}

package part03;

public enum Type {
	PAINTING("Painting"), SCULPTURE("Sculpture"), DIGITAL("Digital"), TACTILE("Tactile"), OTHER("Other");
	
	private String name;
	
	private Type (String str) {
		name = str;
	}
	
	public String toString() {
		return name;
	}
}

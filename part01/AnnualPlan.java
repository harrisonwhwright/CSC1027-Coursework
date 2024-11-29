package part01;

public class AnnualPlan {
	int year;
    private Exhibit[] hall1;
    private Exhibit[] hall2;
    private Exhibit[] hall3;

    public AnnualPlan (int year) {
    	setYear(year);
    	createHalls();
    }
    
    // METHODS
    public void createHalls () {
    	hall1 = new Exhibit[12];
    	hall2 = new Exhibit[12];
    	hall3 = new Exhibit[12];
    }
    public void addToAnnualPlan(int monthNumber, int hallNumber, Exhibit exhibit) {
        if (hallNumber == 1) {
            hall1[monthNumber - 1] = exhibit;
        } else if (hallNumber == 2) {
            hall2[monthNumber - 1] = exhibit;
        } else if (hallNumber == 3) {
            hall3[monthNumber - 1] = exhibit;
        }
    }
    public String getDetails() {
        String result = "\nAnnual Plan for " + getYear() + ":";
        
        for (int i = 0; i < 12; i++) {
            result += "\n" + (i + 1) + ". " + Resources.months[i] + "\n";
            
            if (hall1[i] != null) {
                result += "   Hall 1: " + hall1[i].getName() + "\n";
            } else {
                result += "   Hall 1: N/A\n";
            }
            
            if (hall2[i] != null) {
                result += "   Hall 2: " + hall2[i].getName() + "\n";
            } else {
                result += "   Hall 2: N/A\n";
            }

            if (hall3[i] != null) {
                result += "   Hall 3: " + hall3[i].getName() + "\n";
            } else {
                result += "   Hall 3: N/A\n";
            }
        }
        return result;
    }
    public String toString() {
        return getDetails();
    }
    
    // SETTERS
    public void setYear (int year) {
    	this.year = year;
    }
    // GETTERS
    public int getYear () {
    	return this.year;
    }
    public Exhibit getExhibit(int monthNumber, int hallNumber) {
        if (hallNumber == 1) {
            return hall1[monthNumber - 1];
        } else if (hallNumber == 2) {
        	return hall2[monthNumber - 1];
        } else if (hallNumber == 3) {
        	return hall3[monthNumber - 1];
        }
		return null;
    }
}
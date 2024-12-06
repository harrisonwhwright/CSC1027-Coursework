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
    
    // SETTERS
    public void setYear (int year) {
    	this.year = year;
    }
    
    // GETTERS
    public int getYear () {
    	return this.year;
    }
    
    public void getExhibit(Object year, Object monthNumber, Object hallNumber) {
    	if (year == null || !(year instanceof Integer) || (int) year < 1) {
            System.out.println("Invalid Year, Can't Create Annual Plan");
            return;
    	}
    	int validYear = (int) year;
    	
		AnnualPlan annualPlan = null;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
			if (QUBMuseum.annualPlans.get(i).getYear() == validYear) {
				annualPlan = QUBMuseum.annualPlans.get(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Annual Plan Found with Year " + year);
			return;
		}
    	
    	if (monthNumber == null || !(monthNumber instanceof Integer) || (int) monthNumber < 1) {
            System.out.println("Invalid Year, Can't Create Annual Plan");
            return;
    	}
    	int validMonthNumber = (int) monthNumber;
    	
    	if (hallNumber == null || !(hallNumber instanceof Integer) || (int) hallNumber < 1) {
            System.out.println("Invalid Year, Can't Create Annual Plan");
            return;
    	}
    	int validHallNumber = (int) hallNumber;
    	
    	returnExhibit(annualPlan, validMonthNumber, validHallNumber);
    }
    
    public Exhibit returnExhibit (AnnualPlan annualPlan, int monthNumber, int hallNumber) {		
        if (hallNumber == 1) {
            return annualPlan.hall1[monthNumber - 1];
        } else if (hallNumber == 2) {
        	return annualPlan.hall2[monthNumber - 1];
        } else if (hallNumber == 3) {
        	return annualPlan.hall3[monthNumber - 1];
        }
		return null;
    }
    
    
    // METHODS
    public void createHalls () {
    	this.hall1 = new Exhibit[12];
    	this.hall2 = new Exhibit[12];
    	this.hall3 = new Exhibit[12];
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
    
    public static boolean createAnnualPlan (Object year) {
    	if (year == null || !(year instanceof Integer) || (int) year < 1) {
            System.out.println("Invalid Year, Can't Create Annual Plan");
            return false;
    	}
    	int validYear = (int) year;

		boolean found = false;
		for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
			if (QUBMuseum.annualPlans.get(i).getYear() == validYear) {
				found = true;
				System.out.println("Invalid, Annual Plan with year " + year + " already exists");
				return false;
			}
		}
		if (!found) {
			AnnualPlan newAnnualPlan = new AnnualPlan (validYear);
			QUBMuseum.annualPlans.add(newAnnualPlan);
			
			System.out.println("Successfully Added Annual Plan");
			return true;
		}
		return false;
    }
    
    
    public static void addToAnnualPlan (Object year, Object exhibitId, Object month, Object hall) {
		if (year == null || !(year instanceof Integer) || (int) year < 1) {
	        System.out.println("Invalid Year");
	        return;
		}
		int validYear = (int) year;
		
		AnnualPlan annualPlan = null;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
			if (QUBMuseum.annualPlans.get(i).getYear() == validYear) {
				annualPlan = QUBMuseum.annualPlans.get(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Annual Plan Found with Year " + year);
			return;
		}
		
		if (exhibitId == null || !(exhibitId instanceof Integer) || (int) exhibitId < 1) {
	        System.out.println("Invalid Exhibit");
	        return;
		}
		int validExhibitId = (int) exhibitId;
		
		found = false;
		Exhibit exhibit = null;
		for (int i = 0; i < QUBMuseum.exhibits.size(); i++) {
			if (QUBMuseum.exhibits.get(i).getId() == validExhibitId) {
				found = true;
				exhibit = QUBMuseum.exhibits.get(i);
			}
		}
		if (!found) {
			System.out.println("No Exhibits Found with ID " + exhibitId);
			return;
		}
		
		if (month == null || !(month instanceof Integer) || (int) month < 1) {
	        System.out.println("Invalid Month");
	        return;
		}
		int validMonth = (int) month;
		
		if (validMonth < 1 || validMonth > 12) {
			System.out.println("Invalid, Month Number but be between 1-12");
			return;
		}
		
		if (hall == null || !(hall instanceof Integer) || (int) hall < 1) {
	        System.out.println("Invalid Hall Number");
	        return;
		}
		int validHall = (int) hall;
		
		if (validHall < 1 || validHall > 3) {
			System.out.println("Invalid, Hall Number but be between 1-3");
			return;
		}
		
		if (validHall == 1) {
			annualPlan.hall1[validMonth - 1] = exhibit;
		} else if (validHall == 2) {
			annualPlan.hall2[validMonth - 1] = exhibit;
		} else if (validHall == 3) {
			annualPlan.hall3[validMonth - 1] = exhibit;
	    }
		System.out.println("Successfully added Exhibit " + validExhibitId + " to Month " + validMonth + " in Hall " + validHall);
	}
		
    public static boolean isAnnualPlanListEmpty () {
		if (QUBMuseum.annualPlans.size() == 0) {
			System.out.println("Annual Plan list is empty");
			return true;
		}
		return false;
	}
    
    public static void listAllAnnualPlans () {
		if (isAnnualPlanListEmpty() == true) {
			return;
		}
		
		System.out.println("List of Years Available: ");
	    for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
	        System.out.print(QUBMuseum.annualPlans.get(i).getYear() + " ");
	    }
	    System.out.println();
    }
    
    public static void viewByYear (Object year) {
		if (isAnnualPlanListEmpty() == true) {
			return;
		}

		if (year == null || !(year instanceof Integer) || (int) year < 1) {
	        System.out.println("Invalid Year, Nothing to View");
	        return;
		}
		int validYear = (int) year;
		
		boolean found = false;
		for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
			if (QUBMuseum.annualPlans.get(i).getYear() == validYear) {
				System.out.println(QUBMuseum.annualPlans.get(i));
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Annual Plan Found with Year " + year);
			return;
		}
    }
    
    public static void deleteAnnualPlan (Object year) {
		if (year == null || !(year instanceof Integer) || (int) year < 1) {
	        System.out.println("Invalid Year");
	        return;
		}
		int validYear = (int) year;
		
		AnnualPlan annualPlanToRemove = null;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
			if (QUBMuseum.annualPlans.get(i).getYear() == validYear) {
				annualPlanToRemove = QUBMuseum.annualPlans.get(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Annual Plan Found with Year " + year);
			return;
		}
		
		QUBMuseum.annualPlans.remove(annualPlanToRemove);
	    System.out.println("Successfully deleted Annual Plan for year " + validYear);

    }
    
    public static void removeFromAnnualPlan (Object year, Object month, Object hall) {
		if (year == null || !(year instanceof Integer) || (int) year < 1) {
	        System.out.println("Invalid Year, Nothing to View");
	        return;
		}
		int validYear = (int) year;
		
		AnnualPlan annualPlan = null;
		boolean found = false;
		for (int i = 0; i < QUBMuseum.annualPlans.size(); i++) {
			if (QUBMuseum.annualPlans.get(i).getYear() == validYear) {
				annualPlan = QUBMuseum.annualPlans.get(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Annual Plan Found with Year " + year);
			return;
		}
		
		if (month == null || !(month instanceof Integer) || (int) month < 1) {
	        System.out.println("Invalid Month");
	        return;
		}
		int validMonth = (int) month;
		
		if (validMonth < 1 || validMonth > 12) {
			System.out.println("Invalid, Month Number but be between 1-12");
			return;
		}
		
		if (hall == null || !(hall instanceof Integer) || (int) hall < 1) {
	        System.out.println("Invalid Hall Number");
	        return;
		}
		int validHall = (int) hall;
		
		if (validHall < 1 || validHall > 3) {
			System.out.println("Invalid, Hall Number but be between 1-3");
			return;
		}
		
		
		if (validHall == 1) {
			annualPlan.hall1[validMonth - 1] = null;
		} else if (validHall == 2) {
			annualPlan.hall2[validMonth - 1] = null;
		} else if (validHall == 3) {
			annualPlan.hall3[validMonth - 1] = null;
	    }
		System.out.println("Successfully removed Exhibit at Month " + validMonth + " in Hall " + validHall);
	}  
}


package part03;

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

}

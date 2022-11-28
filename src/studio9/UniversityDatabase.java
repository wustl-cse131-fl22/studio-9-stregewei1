package studio9;

import assignment7.Student;
import java.util.HashMap;

public class UniversityDatabase {
	private final HashMap<String, Student> UniDatabase;
	//private String accountName;
	//private String student;

	public UniversityDatabase() {
		UniDatabase = new HashMap<String, Student>();
	}
	public void addStudent(String accountName, Student student) {
		UniDatabase.put(accountName, student);
	}

	public int getStudentCount() {
		return UniDatabase.size();
	}

	public String lookupFullName(String accountName) {
		if (UniDatabase == null) {
			return "Not found";
		}
		if(UniDatabase.size() > 0) {
			return UniDatabase.get(accountName).getFullName();
		}else {
			return "Not Found";
		}
	}

	public double getTotalBearBucks() {
		int sumBucks = 0;
		for(Student oneStudent : UniDatabase.values()) {
			sumBucks += oneStudent.getBearBucksBalance();
		}
		
		return sumBucks;
	}
}

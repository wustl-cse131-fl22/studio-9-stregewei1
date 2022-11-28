package assignment7;

import static org.junit.Assert.assertArrayEquals;

public class Student { //list as private to allow for access only within 'Student' class
	
	private String firstName;
	private String lastName;
	private int studentNumber;
	private int attemptedCredits = 0;
	private int passingCredits = 0;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	

	public Student(String initFirstName, String initLastName, int initStudentNumber) {
		firstName = initFirstName;
		lastName = initLastName;
		studentNumber = initStudentNumber;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public int getId() {
		return studentNumber;
	}
	
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / (double)attemptedCredits;
	}
		
	public void submitGrade(double grade, int credits) {
		attemptedCredits += credits;
		if (grade >= 1.7) {
			passingCredits += credits;
		}
		totalGradeQualityPoints += grade * credits;
		}
	
	public String getClassStanding() {
		if (passingCredits < 30) {
			return "First Year";
		}else if (passingCredits >= 30 && passingCredits < 60) {
			return "Sophomore";
		}else if (passingCredits >= 60 && passingCredits < 90) {
			return "Junior";
		}else {
			return "Senior";
		}
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		if (passingCredits >= 98 && this.calculateGradePointAverage() >= 3.60) {
			return true;
		}else if (passingCredits >= 75 && this.calculateGradePointAverage() >= 3.80) {
			return true;
		}else {
			return false;
		}
	}
	
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	
	public double cashOutBearBucks() {
		double amount = bearBucksBalance - 10.00;
		bearBucksBalance = 0.00;
		if (amount > 0.00) {
			return amount;
		}else {
			return 0.00;
		}
	}
	
	public String getLastName() {//getter for createLegacy (last name of second 'other' parent)
		return lastName;
	}
	
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String legacyLastName = lastName;
		if (isHyphenated == true) {
			legacyLastName += "-" + other.getLastName();
		}
		Student legacy = new Student(firstName, legacyLastName, id);
		double legacyBalance = this.cashOutBearBucks() + other.cashOutBearBucks(); //calculate total BearBucks from parents
		legacy.depositBearBucks(legacyBalance); //transfer parents' BearBucks to legacy
		return legacy;
	}
	
	public String toString() {
		return firstName + " " + lastName + " " + studentNumber;
	}
}
	

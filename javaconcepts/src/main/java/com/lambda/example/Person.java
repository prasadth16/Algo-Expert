package com.lambda.example;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String mStatus;

	public Person(String firstName, String lastName, int age, String mStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mStatus = mStatus;
	}

	public Person() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	public String toString() {

		return firstName + "-" + lastName + "-" + age + "-" + mStatus;
	}
	public boolean equals(Object o) {
		Person p=null;
		if(o==this) {
			return true;
		}
		if((o instanceof Person)) {
			p=(Person)o;
			if(p.getFirstName().equalsIgnoreCase(this.firstName)&&p.getLastName().equals(this.lastName)&&p.getAge()==this.age&&p.mStatus.equalsIgnoreCase(this.mStatus)) {
				return true;
			}
		}
		return false;
	}

}

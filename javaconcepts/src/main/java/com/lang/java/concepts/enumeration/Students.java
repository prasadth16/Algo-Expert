package com.lang.java.concepts.enumeration;

public enum Students implements EnumParentInterface {

	MECH_ENGINEERING(40, "MECH_ENGINEERING") {
		@Override
		public void printName() {
			System.out.println("MECH_ENGINEERING");

		}

	},
	COMP_ENGINEERING(78, "COMP_ENGINEERING") {
		@Override
		public void printName() {

			System.out.println("COMP_ENGINEERING");
		}
	},
	CHEM_ENGINEERING(32, "CHEM_ENGINEERING") {
		@Override
		public void printName() {
			System.out.println("CHEM_ENGINEERING");

		}
	},
	SIVIL_ENGINEERING(56, "SIVIL_ENGINEERING") {
		@Override
		public void printName() {
			
			System.out.println("SIVIL_ENGINEERING"+numberOfStudents);

		}
		public boolean pName() {
			return 56>numberOfStudents;
		}
	};
	protected int numberOfStudents;
	protected String branchName;

	private Students(int numberOfStudents, String branchName) {
		this.numberOfStudents = numberOfStudents;
		this.branchName = branchName;
	}

	// instance method
	public String getName() {
		return branchName;
	}

//Method from interface implemented
	@Override
	public void printSomething() {
		System.out.println("Number Of Students are: " + numberOfStudents);
	}

	// abstract method

	abstract void printName();

}

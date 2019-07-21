package com.lambda.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**This class demonstrates flatMap() in Stream class.
 * 
 * **/
public class TestFlatMap {
	class Teacher {
		private String teacherName;
		private String schoolName;
		private List<Student> students;

		public Teacher(String name, String schoolName, List<Student> students) {
			this.teacherName = name;
			this.schoolName = schoolName;
			this.students = students;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		public String getSchoolName() {
			return schoolName;
		}

		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}

		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}

	}

	class Student {
		private String studentName;
		private Map<String, Integer> subjectMarks;

		public Student(String name, Map<String, Integer> marks) {
			studentName = name;
			subjectMarks = marks;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public Map<String, Integer> getSubjectMarks() {
			return subjectMarks;
		}

		public void setSubjectMarks(Map<String, Integer> subjectMarks) {
			this.subjectMarks = subjectMarks;
		}

	}

	public static void main(String[] args) {
		Map<String, Integer> markMap1 = new HashMap<>();
		Map<String, Integer> markMap2 = new HashMap<>();

		markMap1.put("Marathi", 87);
		markMap1.put("English", 97);
		markMap1.put("Calulas", 98);
		markMap1.put("Science", 95);

		markMap2.put("Marathi", 99);
		markMap2.put("English", 92);
		markMap2.put("Calulas", 94);
		markMap2.put("Science", 96);
		TestFlatMap tfm = new TestFlatMap();
		Student student1 = tfm.new Student("Prasad", markMap1);
		Student student2 = tfm.new Student("Shubham", markMap2);
		Teacher teacher1 = tfm.new Teacher("Kelly", "Ronald MCnair", Arrays.asList(student1));
		Teacher teacher2 = tfm.new Teacher("Frie", "Ronald MCnair", Arrays.asList(student2));
		printSubjectsAbove96(Arrays.asList(teacher1, teacher2));
	}

	public static void printSubjectsAbove96(List<Teacher> teachers) {
		List<String> subjectName = teachers.stream().map(tch -> tch.getStudents().stream())
				.flatMap(stdStream -> stdStream.map(std -> std.getSubjectMarks().entrySet().stream())
						.flatMap(entstr -> entstr.filter(entr -> entr.getValue() > 96).map(ent -> ent.getKey())))
				.collect(Collectors.toList());
		subjectName.forEach(System.out::println);
	}

}

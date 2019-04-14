package com.category.simple.project.euler;

/**
 * This can be done with Arithmatic progression as well... Formula: =>For 3's
 * multiple- a=3*(999/3)*((999/3)+1)/2 =>For 5's multiple- b=5*(999/5)*((999/5)+1)/2
 * =>15 is LCM of 3 and 5. So it's multiples are added twice and hence should be
 * substratced once c=15*(999/15)*((999/15)+1)/2 Final answer=a+b-c
 * 3*int(999/3)*(1+int(999/3))/2 + 5*int(999/5)*(1+int(999/5))/2 - 15*int(999/15)*(1+int(999/15))/2
 * =233168
 **/

public class EularProblem1 {
	public static void main(String[] args) {
		int i = 3;
		int sum = 0;
		while (i < 1000) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum = sum + i;
			}
			i++;
		}
		System.out.println(sum);
	}

}

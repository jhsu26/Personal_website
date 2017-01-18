package MissingElement;
/*KL Software Technologies - Solve a Programming Challenge:
 * Task: Find the missing term in an Arithmetic Progression - An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms of a given series of numbers. You are provided with consecutive elements of an Arithmetic Progression. There is however one hitch: Exactly one term from the original series is missing from the set of numbers which have been given to you. The rest of the given series is the same as the original AP. Find the missing term. 

Input Format: The first line contains an Integer N, which is the number of terms which will be provided as input. This is followed by N consecutive Integers, with a space between each pair of integers. All of these are on one line, and they are in AP (other than the point where an integer is missing). 

Output Format: One Number which is the missing integer from the series. 

Sample Input: 
1 3 5 9 11 

Sample Output: 
7 

Explanation: You are provided with 5 integers. As you can can observe, they have been picked from a series, in which the starting term is 1 and the common difference is 2. The only abberration, i.e. the missing term (7), occurs between 5 and 9. This is the missing element which you need to find. 

Constraints: 3 <= N <= 2500. All integers in the series will lie in the range [-10^6,+10^6]. 

All candidates should submit their responses to careers@klstinc.com.
 */
import java.util.Scanner;

public class MissingElement {
	public static void main(String[] args) {
		Scanner input1 = new Scanner(System.in); //scanner for number of terms
		Scanner input2 = new Scanner(System.in);
		System.out.print("Enter number of terms: ");
		int numTerms = input1.nextInt();
		if (numTerms < 3 || numTerms > 2500) {
			System.out.println("Please enter a number from 3 to 2500.");
			System.exit(0);
		} else {
		System.out.print("Enter series with space in between each integer: ");
		String numbers = input2.nextLine();
		
		
			
		//splitting string of integers & inserting to array
		String split_here = " ";
		String[] all_terms = numbers.split(split_here);
		
		//making new array to hold integer version of the terms
		int[] the_terms = new int[numTerms];
		for (int i=0; i<numTerms; i++) {
			the_terms[i] = Integer.parseInt(all_terms[i]);
		}
		
		//calculating common difference
		int missing = 0; //the missing term
		int dif = 0; //real common difference
		int a=0;
		int b=0;
		int c=0;
		
		if (numTerms == 3) {
			a = the_terms[1] - the_terms[0];
			b = the_terms[2] - the_terms[1];
			if (a==b) {
				dif = a;
				missing = the_terms[2] + dif;
			} else if (a != b) {
				int m = the_terms[1] - Math.min(a, b);
				int m1 = the_terms[1] + Math.min(a, b);
				if ( m == the_terms[0]) {
					missing = m1;
				} else if (m1 == the_terms[2]) {
					missing = m;
				}
			}
		} else if (numTerms > 3) {
			 a = the_terms[1] - the_terms[0]; 
			 b = the_terms[2] - the_terms[1];
			 c = the_terms[3] - the_terms[2];
		
			if (a==b) {
				dif = a;
			} else if (a != b && a == c) {
				dif = a;
			} else if (a!=b && b == c) {
				dif = b;
			}
		
			//finding the missing term
			for (int j=0; j<numTerms-1; j++) {
				int e = the_terms[j+1] - the_terms[j];
					if (e != dif) {
						missing = the_terms[j] + dif;
						break;
					} else {
						missing = the_terms[numTerms-1] + dif;
					}
			}
		
		}
		System.out.println("Input: " + numbers + "\n" + "Missing term: " + missing);
		}
	}
}

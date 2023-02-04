import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Map;

public class StringMatch {
	String fName;
	String data;
	public StringMatch(String fName) {
		this.fName = fName;
		this.data = readFile(); 
	}

	private String readFile() {
		String dataOutput = "";
		try {
			File myObj = new File(fName + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				dataOutput = dataOutput + myReader.nextLine();
				// //System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			//System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return dataOutput;
	}

	public int bruteForce(String pat) {
		//System.out.println("Brute Force: ");
		//String data = readFile();
		pat = pat.toLowerCase();
		int counter = 0;
		int l1 = data.length();
		int l2 = pat.length();
		int i = 0, j = l2 - 1;

		for (i = 0, j = l2 - 1; j < l1;) { // for loop from i = 0 until pattern length - 1 while the j is less than data length
			
			if (pat.equals(data.substring(i, j + 1))) { // if the pattern found we will increase the counter by 1 
				//System.out.println("Pattern found at index " + i);
				counter++;
			}
			i++;
			j++;
		}
		if (counter == 0) { //To print how many matches we found
			//System.out.println("No match found!");
		} else {
			//System.out.println(counter + " matches found!");
		}
		return counter; // return how many times we found a match 
	}

	public int KMPSearch(String pattern) {
		String text = data;
		int counter = 0;
		//System.out.println("KPM Algorithm: ");
		int M = pattern.length();
		int N = text.length();

		
		// prefix suffix values for pattern
		int lp[] = new int[M]; // create lps[] that will hold the longest
		int pat_index = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[] array)
		
		computeLPSArray(pattern, M, lp);

		int text_index = 0; // index for txt[]
		while ((N - text_index) >= (M - pat_index)) { // while text length - index for txt[] >= pattern length - index for pat[]
			if (pattern.charAt(pat_index) == text.charAt(text_index)) { //if the pattern found at pattern index and it's equal to text at the text index we will incraese both indexs
				pat_index++;
				text_index++;
			}
			if (pat_index == M) { // if the pattern index equals the pattern length it means that we found a pattern at index (text index - pattern index) aslo we will increase the counter
				//System.out.println("Found pattern " + "at index: " + (text_index - pat_index));
				pat_index = lp[pat_index - 1];
				counter++;
			}

			// mismatch after j matches
			else if (text_index < N && pattern.charAt(pat_index) != text.charAt(text_index)) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (pat_index != 0)
					pat_index = lp[pat_index - 1];
				else
					text_index = text_index + 1;
			}
		}
		if (counter == 0) { //To print how many matches we found
			//System.out.println("No match found!");
		} else {
			//System.out.println(counter + " matches found!");
		}
		return counter;  // return how many times we found a match
	}

	void computeLPSArray(String pat, int M, int lps[]) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				} else { // if ( len == 0 )
					lps[i] = len;
					i++;

				}
			}
		}
	}

	static int NO_OF_CHARS = 256;

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static void badCharHeuristic(char[] str, int size, int badchar[]) {
		int i;
		for (i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;
		for (i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

	public int Boyersearch(String toMatch) {
		//System.out.println("BoyerMoore: ");
		char[] txt = data.toCharArray();
		char[] pat = toMatch.toCharArray();
		int counter = 0;
		int m = pat.length;
		int n = txt.length;
		int badchar[] = new int[NO_OF_CHARS];
		// function calling
		badCharHeuristic(pat, m, badchar);
		int s = 0; // s is shift of the pattern with respect to text
		while (s <= (n - m)) { // there are n-m+1 potential alignments 
			int j = m - 1; //Start with the end of the pattern aligned at index m-1 in the text
			while (j >= 0 && pat[j] == txt[s + j])
				
				j--; // keep reducing index j of pattern while characters of pattern and text are matching at this shift s
			
			if (j < 0) {
				//System.out.println("Found pattern at index: " + s);
										//Shift the pattern so that the next character in text aligns with the last occurrence of it in pattern.
				s += (s + m < n) ? m - badchar[txt[s + m]] : 1; //The condition s+m < n is necessary for the case when pattern occurs at the end of text
				
				counter++;
			} else //Shift the pattern so that the bad character in text aligns with the last occurrence of it in the pattern 
				
				s += max(1, j - badchar[txt[s + j]]); //The max function is used to make sure that we get a positive shift we may get a negative shift if the last occurrence of bad character in pattern is on the right side of the current character 
		}
		if (counter == 0) {            //To print how many matches we found 
			//System.out.println("No match found!");
		} else {
			//System.out.println(counter + " matches found!");
		}
		return counter;
	}

}

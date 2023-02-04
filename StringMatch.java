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

		for (i = 0, j = l2 - 1; j < l1;) {
			
			if (pat.equals(data.substring(i, j + 1))) {
				//System.out.println("Pattern found at index " + i);
				counter++;
			}
			i++;
			j++;
		}
		if (counter == 0) {
			//System.out.println("No match found!");
		} else {
			//System.out.println(counter + " matches found!");
		}
		return counter;
	}

	public int KMPSearch(String pattern) {
		String text = data;
		int counter = 0;
		//System.out.println("KPM Algorithm: ");
		int M = pattern.length();
		int N = text.length();

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int lp[] = new int[M];
		int pat_index = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[]
		// array)
		computeLPSArray(pattern, M, lp);

		int text_index = 0; // index for txt[]
		while ((N - text_index) >= (M - pat_index)) {
			if (pattern.charAt(pat_index) == text.charAt(text_index)) {
				pat_index++;
				text_index++;
			}
			if (pat_index == M) {
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
		if (counter == 0) {
			//System.out.println("No match found!");
		} else {
			//System.out.println(counter + " matches found!");
		}
		return counter;
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
				} else {
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
		int s = 0;
		while (s <= (n - m)) {
			int j = m - 1;
			while (j >= 0 && pat[j] == txt[s + j])
				j--;
			if (j < 0) {
				//System.out.println("Found pattern at index: " + s);
				s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
				counter++;
			} else
				s += max(1, j - badchar[txt[s + j]]);
		}
		if (counter == 0) {
			//System.out.println("No match found!");
		} else {
			//System.out.println(counter + " matches found!");
		}
		return counter;
	}

}


public class TestClass {
	public static enum algorithm{
		bruteForce,
		knuthMorris,
		boyerMoors,
	}
//	public static void main(String[] args) {
//		TestFileBuilder F1 = new TestFileBuilder();
//		String fName = "F1";
//		F1.buildTestFile(10000000, fName);
//		//System.out.println("Data written: \'" + F1.+"\'");
//		StringMatch obj = new StringMatch(fName);
//		obj.bruteForce("ddddd");
//	}
	
	public long performTest(algorithm algo, int n, String fName, String toMatch,int avgN) {
		
		TestFileBuilder F1 = new TestFileBuilder();
		F1.buildTestFile(n, fName);
		StringMatch obj = new StringMatch(fName);
		//start caculate time
		long totalTime = 0;
		for(int i=0 ; i < avgN; i++) {
			long startTime = System.nanoTime();
			switch(algo) {
			case bruteForce:
				obj.bruteForce(toMatch);
				break;
			case knuthMorris:
				obj.KMPSearch(toMatch);
				break;
			case boyerMoors:
				obj.Boyersearch(toMatch);
				break;
			}
			long endTime   = System.nanoTime();
			long localTotTime = (endTime - startTime);
			System.out.println("Time of turn "+i+" is "+localTotTime);
			totalTime = totalTime + localTotTime;
		}
		 totalTime = totalTime/avgN;
		return totalTime;//in nanoSec
	}
	
}

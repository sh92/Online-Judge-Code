
public class L771 {
	static int numJewelsInStones(String J, String S) {
		int cnt = 0;
		char[] jewels = J.toCharArray();
		char[] stones = S.toCharArray();
		for(char j : jewels) {
			for(char s :stones) {
				if(s==j) {
					cnt++;
				}
			}
		}
		return cnt;
	}
//	public static void main(String[] args) {
//		String J="z";
//		String S="ZZ";
//		
//		System.out.println(numJewelsInStones(J,S));
//	}
}

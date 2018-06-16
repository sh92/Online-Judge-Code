
public class L657 {
	public static boolean judgeCircle(String moves) {
		int UD=0;
		int LR=0;
		char[] move = moves.toCharArray();
		for(char x : move) {
			if(x=='U')
				UD++;
			else if(x=='D')
				UD--;
			else if(x=='R')
				LR++;
			else if(x=='L')
				LR--;
		}
        return UD==0 && LR==0;
    }
//	public static void main(String[] args) {
//		System.out.println(judgeCircle("UDDURLR"));
//	}
}

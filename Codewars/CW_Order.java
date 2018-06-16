
public class CW_Order {
	 public static String order(String words) {
		String[] word = words.split(" ");
		int[] index = new int[word.length];
		for(int i=0;i< word.length;i++) {
			for (char w : word[i].toCharArray()) {
				if(java.lang.Character.isDigit(w)) {
					index[i] = Integer.parseInt(String.valueOf(w));
				}
			}
		}
		String[] reordered = new String[word.length];
		String result = "";
		for(int i = 0; i<word.length;i++) {
			reordered[i] = word[index[i]-1];
		}
		result = String.join(" ", reordered);
		System.out.println(result);
		return result;
	  }
	public static void main(String[] args) {
		System.out.println(order("is2 Thi1s T4est 3a").equals("Thi1s is2 3a T4est"));
	}
}

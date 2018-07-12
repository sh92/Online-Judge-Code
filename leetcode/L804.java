class Solution { 
   public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{
                         ".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        Set<String> bag = new HashSet();
        for (String word: words) {
            StringBuilder mlist = new StringBuilder();
            for(char c: word.toCharArray())
                mlist.append(MORSE[c - 'a']);
            bag.add(mlist.toString());
        }
        return bag.size();
   }
}

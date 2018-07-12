class Solution:
    def uniqueMorseRepresentations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        morseMap = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        bag = set()
        for word in words:
            mlist = [morseMap[ord(c)-97] for c in word]
            mword = ''.join(mlist)
            bag.add(mword)
        return len(bag)

s = Solution()
words = ["gin", "zen", "gig", "msg"];
print(s.uniqueMorseRepresentations(words))

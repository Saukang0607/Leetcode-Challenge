from collections import Counter
from typing import List

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []
        
        word_len = len(words[0])
        num_words = len(words)
        total_len = word_len * num_words
        n = len(s)
        
        if n < total_len:
            return []
            
        word_count = Counter(words)
        res = []
        
        # Iterate over all possible starting offsets (0 to word_len - 1)
        for i in range(word_len):
            left = i
            right = i
            curr_count = Counter()
            matched_words = 0
            
            while right + word_len <= n:
                word = s[right:right + word_len]
                right += word_len
                
                if word in word_count:
                    curr_count[word] += 1
                    matched_words += 1
                    
                    # Shrink window from the left if current word frequency exceeds target
                    while curr_count[word] > word_count[word]:
                        left_word = s[left:left + word_len]
                        curr_count[left_word] -= 1
                        matched_words -= 1
                        left += word_len
                        
                    # Record starting index when all words are matched
                    if matched_words == num_words:
                        res.append(left)
                else:
                    # Reset window completely on invalid word
                    curr_count.clear()
                    matched_words = 0
                    left = right
                    
        return res
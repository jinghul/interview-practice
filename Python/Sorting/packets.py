word_map = {}

words = sorted(words, key = len)

def check_word(word):
    if not word or word not in word_map:
        return 0
    else:
        return word_map[word]

max_count = 1
for word in words:
    if len(word) == 1:
        word_map[word] = 1
    else:
        for i in range(len(word)):
            new_word = word[:i] + word[i+1:]
            if new_word in word_map:
                word_map[word] = word_map[new_word] + 1
                max_count = word_map[new_word] + 1
                i = len(word)

return max_count



    

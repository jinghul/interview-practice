def find(elem, seq):
    if seq == "" or seq == []:
        return -1
    elif elem == seq[0]:
        return 0
    else:
        result = find(elem, seq[1:])
        if result == -1:
            return -1
        else:
            return 1 + result

def lcs(s1, s2):
    if s1 == "" or s2 == "":
        return ""
    elif s1[0] == s2[0]:
        return s1[0] + lcs(s1[1:], s2[1:])
    else:
        result1 = lcs(s1[1:], s2)
        result2 = lcs(s1, s2[1:])
        if (len(result1) > len(result2)):
            return result1
        return result2

# s2 is larger than s1
# s1 is the pattern and s2 is the text to match
def anagrams(s1, s2): 
    result = []
    counts = {}
    text = {}
    for s in s1:
        if s in counts:
            counts[s] += 1
        else:
            counts[s] = 1
            text[s] = 0
    
    for i in range(len(s2)):
        print(text)
        if s2[i] in counts:
            text[s2[i]] += 1
        if i - len(s1) >= 0:
            if s2[i-len(s1)] in counts:
                text[s2[i-len(s1)]] -= 1
        match = True
        for key in counts:
            match = counts[key] == text[key] and match
            if not match:
                break
        if match:
            result +=[i - len(s1) + 1] # permutation includes current element

    return result
    

def main():
    s2 = "ABFADCAFDGACFDACDDDAC"
    s1 = "ADC"
    print(anagrams(s1, s2))
    print("should be: " + "[3,4,13,14,18]")

main()
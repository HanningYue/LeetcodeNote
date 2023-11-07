/*
.substring is exclusive // Remember to reset index
1. Encode, use stringbuilder, construct str in strs in the form 
    (5/hello) -> (str.length(), '/' and str)
2. Decode, find index of slash from current index, take length 
    (index)int length, (index)int slash, String str
    user index to find int length, String str// Hint: use Integer.valueOf and substring
*/
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < s.length()) {
            int slash = s.indexOf('/', index);
            int length = Integer.valueOf(s.substring(index, slash));
            String str = s.substring(slash + 1, slash + 1 + length);
            index = slash + 1 + length;
            result.add(str);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
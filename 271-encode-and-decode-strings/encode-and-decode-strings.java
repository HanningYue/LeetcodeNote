public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int index = 0;
        while (index < s.length()) {
            int slashIndex = s.indexOf("/", index);
            int length = Integer.parseInt(s.substring(index, slashIndex));
            String originalString = s.substring(slashIndex + 1, slashIndex + 1 + length);
            index = slashIndex + length + 1;

            result.add(originalString);
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
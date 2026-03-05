import java.util.StringTokenizer;

public class StringSplitter {
    String input;
    public StringSplitter(String input) {
        this.input = input;
    }
    
    public String[] splitByDot() {
        return input.split("\\.");
    }

    public String[] tokenizeByDot() {
        StringTokenizer tokenizer = new StringTokenizer(input, ".");
        String[] tokens = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            tokens[i++] = tokenizer.nextToken();
        }
        return tokens;
    }

    public String[] subStringsAndIndex() {
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                count++;
            }
        }
        String[] result = new String[count];
        int start = 0;
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                result[index++] = input.substring(start, i);
                start = i + 1;
            }
        }
        result[index] = input.substring(start);
        return result;

}

    }
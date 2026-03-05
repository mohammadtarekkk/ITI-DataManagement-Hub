public class Stars {
    public static void main(String[] args) {
        int rows = 4;
        String left = "";
        String right = "";
        String spaceBank = new String(new char[rows]).replace('\0', ' ');
        for (int i = 1; i <= rows; i++) {
            left += "*";
            right += "* ";
            String currentIndent = spaceBank.substring(0, rows - i);
            System.out.println(left + "\t\t" + currentIndent + right);
        }
    }
}
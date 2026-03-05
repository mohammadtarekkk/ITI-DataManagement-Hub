public class App {
    public static void main(String[] args) throws Exception {
        StringSplitter s1 = new StringSplitter("154.686.656.454.121.999");
        String[] parts = s1.splitByDot();
        for (String part : parts) {
            System.out.println(part);
        }

        System.out.println("----------------------------");

        String[] tokenizedParts = s1.tokenizeByDot();
        for (String part : tokenizedParts) {
            System.out.println(part);
        }

        System.out.println("----------------------------");

        String[] subStrings = s1.subStringsAndIndex();
        for (String part : subStrings) {
            System.out.println(part);
        }
    }
}

        public class App {
            public static void main(String[] args) throws Exception {
                Parent p = new Parent(10, 20);
                Child c = new Child(10, 20, 30);
                System.out.println("Parent sum: " + p.sum());
                System.out.println("Child sum: " + c.sum());
            }
}

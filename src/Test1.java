public class Test1 {
    public static void main(String[] args) {
        intArray();
        System.out.println(find(0));
    }

    private static int[] intArray() {
        char[] ch = new char[3];
        System.out.println(ch.length);
        return new int[]{1, 2};

    }

    private static int find(int i) {
        while (i < 10) {
            i++;
        }
        return i;
    }
}

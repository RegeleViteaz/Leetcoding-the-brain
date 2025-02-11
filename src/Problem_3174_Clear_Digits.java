public class Problem_3174_Clear_Digits {
    public static void main(String[] args) {
        String s = "abc";
        String b = "cb34";
        String c = "a3b4d5";
        String d = "a3b4d55";

        System.out.println(clearDigits(s));
        System.out.println(clearDigits(b));
        System.out.println(clearDigits(c));
        System.out.println(clearDigits(d));

    }

    public static String clearDigits(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                if (i >= 1) {
                    sb.delete(i - 1, i + 1); // Delete the character before the digit and the digit itself (inluded, excluded)
                    i -= 2; // Adjust the index after deletion
                } else {
                    sb.delete(i, i + 1); // If the digit is at the start, just remove the digit
                    i -= 1; // Adjust the index after deletion
                }
            }
        }
        return sb.toString();
    }
}

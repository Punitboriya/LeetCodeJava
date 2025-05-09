package Others;
//Input: s = "A man, a plan, a canal: Panama"

//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.

public class LC_125VP {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

//		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s2 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s2 += s.charAt(i);
        }
        if (s.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        if (isPalindrome(s)) {
            System.out.println("Pelindrom");

        } else {
            System.out.println("Not Pelindrom");
        }

    }

}

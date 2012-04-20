package fb.string;

public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) return 0;
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') end--;
    if (end == -1) return 0;
    int start = end - 1;
    while (start >= 0 && s.charAt(start) != ' ') start--;
    return end - start;
  }
}
package src;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Junjie Bu
 * @since 05/11/2012
 */
public class MorseCode {

    // we could use tries to improve matching speed for both morse code and word context,
    // for simplicity, I use hash in this program

    private final Map<String, Character> morse = new HashMap<String, Character>();
    private final Set<String> context = new HashSet<String>();
//    private final Tries<Character> morseTries = new Tries<Character>();

    public boolean addToMorseTable(String input) {
        String[] s = input.split("\\s+");
        if (s.length != 2 || s[0].length() != 1) {
            return false; // skip error input
        }
        morse.put(s[1], s[0].charAt(0));
//        morseTries.put(s[1], s[0].charAt(0));
        return true;
    }

    public boolean addToContext(String input) {
        if (input == null || input.isEmpty()) {
            return false; //skip empty lines
        }
        context.add(input);
        return true;
    }

    public String decodeMorse(String input) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Boolean> results = new HashMap<String, Boolean>();
        doDecodeMorse(input, 0, sb, results, false);
        int min = Integer.MAX_VALUE;

        String minWord = null;
        for (String s : results.keySet()) {
            if (context.contains(s) && s.length() <= min) {
                minWord = s;
                if (results.get(s)) {
                    minWord += "?";
                }
                if (s.length() == min) {
                    minWord += "!";
                }
                min = s.length();
            }
        }
        System.out.println(minWord);
        return minWord;
    }

    private void doDecodeMorse(String input, int pos, StringBuilder word, HashMap<String, Boolean> results,
                               boolean hasError)
    {
        if (pos == input.length()) {
            results.put(word.toString(), hasError);
            return;
        }

        boolean foundMorseLetter = false;
        for (int i = 1; i <= 6 && pos + i <= input.length(); i++) {
            String part = input.substring(pos, pos + i);
            if (morse.containsKey(part)) {
                foundMorseLetter = true;
                word.append(morse.get(part));
                doDecodeMorse(input, pos + i, word, results, false);
                word.setLength(word.length() - 1);
            }
        }

        if (!foundMorseLetter && pos + 7 >= input.length()) {
            String remaining = input.substring(pos);
            String[] fuzzy = {remaining.substring(0, remaining.length() - 1), remaining + '.', remaining + "-"};
            for (String s : fuzzy) {
                if (morse.containsKey(s)) {
                    word.append(morse.get(s));
                    doDecodeMorse(input, pos + remaining.length(), word, results, true);
                    word.setLength(word.length() - 1);
                }
            }
        }
    }

    public void processMorseFile(String input, String output) throws IOException {
        Scanner in = new Scanner(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.equals("*")) {
                break;
            }
            addToMorseTable(s);
        }
        System.out.println(morse);
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.equals("*")) {
                break;
            }
            addToContext(s);
        }
        System.out.println(context);
        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("*")) {
                break;
            }
            String word = decodeMorse(s);
            if (word != null) {
                bw.write(word);
            }
        }
        bw.close();
    }

    public static void main(String args[]) {
        MorseCode m = new MorseCode();
        String input = "/Users/junjie.bu/Downloads/problemc.in.txt";
        String output = "/Users/junjie.bu/Downloads/results.txt";
        try {
            m.processMorseFile(input, output);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

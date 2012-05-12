package cp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mind.power
 * @since 05/10/2012 09:29pm
 */
public class CommandProcessor {

    private HashMap<String, Set<String>> dependency = new HashMap<String, Set<String>>();
    private Map<String, Boolean> installed = new HashMap<String, Boolean>();

    private void install(String software, boolean explict) {
        if (installed.containsKey(software)) {
            return;
        }
        if (dependency.containsKey(software)) {
            for (String dep : dependency.get(software)) {
                install(dep, false);
            }
        }
        System.out.println("\t"+"Installing "+software);
        installed.put(software, explict);
    }

    private void remove(String software, boolean explicit) {
        // we could use another hash map to remember all software depends on each software
        boolean beenDepended = false;
        boolean installedExplicitly = installed.get(software);
        for (String s : installed.keySet()) {
            if (s.equalsIgnoreCase(software)) {
                continue;
            }
            if (dependency.containsKey(s) && dependency.get(s).contains(software)) {
                beenDepended = true;
            }
        }
        if (beenDepended) {
            if (explicit) System.out.println("\t"+software + " is still needed");
        } else if (explicit || !installedExplicitly) {
            System.out.println("\t"+"Removing "+software);
            installed.remove(software);
            if (dependency.containsKey(software)) {
                for (String s : dependency.get(software)) {
                    if (installed.containsKey(s)) remove(s, false);
                }
            }

        }
    }

    private boolean processCommand(String command) {
        System.out.println(command);
        String[] words = command.split("\\s+");
        if (words.length >= 1) {
            if (words[0].equalsIgnoreCase("DEPEND")) {
                // the second word is the depend
                for (int i = 2; i < words.length; i++) {
                    if (!dependency.containsKey(words[1])) {
                        Set<String> items = new HashSet<String>();
                        items.add(words[i]);
                        dependency.put(words[1], items);
                    }
                    else {
                        dependency.get(words[1]).add(words[i]);
                    }
                }
            }
            else if (words[0].equalsIgnoreCase("INSTALL")) {
                String name = words[1];
                if (installed.containsKey(name)) {
                    System.out.println("\t"+name + " already installed");
                }
                else {
                    install(name, true);
                }
            }
            else if (words[0].equalsIgnoreCase("REMOVE")) {
                String name = words[1];
                if (!installed.containsKey(name)) {
                    System.out.println("\t"+name + " is not installed");
                }
                else {
                    remove(name, true);
                }
            }
            else if (words[0].equalsIgnoreCase("LIST")) {
                for (String s: installed.keySet()) {
                    System.out.println("\t"+s);
                }
            }
            else if (words[0].equalsIgnoreCase("END")) {

            }
        }
        return false;
    }

    public void processCommands(String... commands) {
        if (commands == null) {
            return;
        }
        for (String line : commands) {
            processCommand(line);
        }
    }

    public void processCommands(BufferedReader bf) {
        if (bf == null) {
            return;
        }
        String line = null;
        try {
            while ((line = bf.readLine()) != null) {
                processCommand(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class CommandProcessorTest {
    public static void main(String[] args) {
        CommandProcessor dp = new CommandProcessor();
        try {
            BufferedReader f = new BufferedReader(new FileReader("//Volumes/JUNJIE/IntelliJ/java/cp/install.txt"));
            dp.processCommands(f);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            System.exit(1);
        }
        catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

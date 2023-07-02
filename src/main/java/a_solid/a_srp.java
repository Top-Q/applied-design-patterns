package a_solid;

// SRP - Single Responsibility Principle (SOLID)
// We will create a journal call that breaks the SRP and fix it by adding persistence class.

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {

    private final List<String> entries = new ArrayList<>();

    private static int count = 0;

    /**
     * This method will add an entry to the journal
     * @param text
     */
    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    /**
     * This method will remove an entry from the journal
     * @param index
     */
    public void removeEntry(int index) {
        entries.remove(index);
    }

    // So far we are keeping SRP

    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

}

class Persistence {

    public void saveToFile(Journal j, String filename, boolean overwrite) throws Exception {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(j.toString());
            }

        }
    }

    public void load(String filename) {}

    public void load(URL url) {}


}

class SrpDemo {

    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "c:\\temp\\journal.txt";
        p.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);

    }


}

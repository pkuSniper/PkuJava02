import java.io.*;
import java.util.*;

public class FileHandling {
    public static void main(String args[]) {
        
        //file storage path(Korry is the name of my MAC)
        String filepath1 = "/Users/Korry/Desktop/A.txt";
        String filepath2 = "/Users/Korry/Desktop/B.txt";
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);
        
        String line = "";
        String string1 = "";
        String string2 = "";
        
        //read the file and store the words in String
        try {
            BufferedReader bf1 = new BufferedReader(new FileReader(file1));
            while(true) {
                try {
                    line = bf1.readLine();
                    if(line == null) break;
                    string1 += line;
                } catch(IOException e) {
                    return;
                }
            }
        } catch(FileNotFoundException e) {
                return;
        }
        
        try {
            BufferedReader bf2 = new BufferedReader(new FileReader(file2));
            while(true) {
                try {
                    line = bf2.readLine();
                    if(line == null) break;
                    string2 += line;
                } catch(IOException e) {
                    return;
                }
            }
        } catch(FileNotFoundException e) {
                return;
        }
        
        //extract the words and store them with HashMap
        String[] list1 = string1.split(" ");
        String[] list2 = string2.split(" ");
        Map<String, Integer> hash1 = new HashMap<String, Integer>();
        Map<String, Integer> hash2 = new HashMap<String, Integer>();
        Map<String, Integer> hash3 = new HashMap<String, Integer>();
        Map<String, Integer> hash4 = new HashMap<String, Integer>();
        
        for(int i=0; i<list1.length; i++) {
            if(hash1.get(list1[i]) == null)
                hash1.put(list1[i], 1);
        }
        for(int i=0; i<list2.length; i++) {
            if(hash2.get(list2[i]) == null)
                hash2.put(list2[i], 1);
        }
        
        //calculate the union and intersection of words
        int size1 = hash1.size();
        int size2 = hash2.size();
        Iterator it1 = hash1.entrySet().iterator();
        Iterator it2 = hash2.entrySet().iterator();

        while(it1.hasNext()) {
            Map.Entry entry = (Map.Entry)it1.next();
            String key = (String)entry.getKey();
            if(hash2.get(key) == null)
                hash3.put(key, 1);
            else
                hash4.put(key, 1);
        }
        while(it2.hasNext()) {
            Map.Entry entry = (Map.Entry)it2.next();
            String key = (String)entry.getKey();
            hash3.put(key, 1);
        }

        //display the results of file handling
        int union = hash3.size();
        int intersection = hash4.size();
        double percent1 = (double)(size1-intersection)/(double)size1;
        double percent2 = (double)(size2-intersection)/(double)size2;
        System.out.println("Word Amount of A: " + size1);
        System.out.println("Word Amount of B: " + size2);
        System.out.println("Word Amount of Union: " + union);
        System.out.println("Word Amount of Intersection: " + intersection);
        System.out.println(String.format("Unique Word Percentage of A: %.2f%%", 100.0*percent1));
        System.out.println(String.format("Unique Word Percentage of B: %.2f%%", 100.0*percent2));
    }
}
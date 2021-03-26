import java.io.*;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class main{

    public static void main(String[] args) {
        
        String buff = null ;
        ArrayList myList = new ArrayList<>();
        Object[] words = new String[600];
        String[] parts = new String[2];
        HashMap<String, String> hash = new HashMap<String, String>();
        try{
            File f = new File("/Users/anthonyaboukhalil/Desktop/GitFiles/COSC-320/slangs.txt");
            Scanner input = new Scanner(f).useDelimiter("\\s+");
            
            while (input.hasNextLine()) {
    
              buff = input.nextLine();
                myList.add(buff);
           }
           input.close();

        words = myList.toArray();
      
    }
    catch(FileNotFoundException e){
        System.out.println("File not found");
        e.printStackTrace();
    }

    for (int i = 0; i < words.length; i+=2) {
       parts = ((String) words[i]).split("\\s+",2);
        String part1 = parts[0];
         String part2 = parts[1];
         hash.put(part1,part2);
    }
    

    System.out.println(hash);
  
  }



}

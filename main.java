import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;





public class main{
  static String temp = null;
  static int n = 0;
  static Object midscan = null;
  static ArrayList inputlist = new ArrayList<>();
  static HashMap<String, String> hash = new HashMap<String, String>();

  static void initHash(String filename){
  
    String buff = null ;
    ArrayList myList = new ArrayList<>();
    Object[] words = new String[600];
    String[] parts = new String[2];
    
    try{
      File f = new File(filename);
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
  }
  static void readFile(String filename){

    // run through sample text and add values to an array

    File in = new File(filename);
    try {
      Scanner scanin = new Scanner(in).useDelimiter("\\s");
    while(scanin.hasNext()){
      temp = scanin.next();
      inputlist.add(temp);
     
    }
    scanin.close();
    //close the scanner 
    } catch (FileNotFoundException e) {
      System.out.println("No input found");;
      e.printStackTrace();
    } 
  }  
  static void replaceSlang(){
     //for each word try to use it as a key in the hashmap, if it returns a value replace the string in the array
    //else keep going
    try{
      int i = 0;
      while(i<inputlist.size()){
        midscan = inputlist.get(i);
        //if statement
        if(hash.get(midscan)!=null){
          //replaces the value of the string in teh array list
          inputlist.set(i,hash.get(midscan));
          //System.out.println(inputlist);
        }
        i++;
    }
    }catch(Exception e){
      System.out.println("whoops");
    }
  }
  static void writeFile(String filename){
    //recompile the string array with a space seperating each value
    //print it to the result txt to make life easier
    try {
      PrintWriter pw = new PrintWriter(filename);
      // ObjectOutputStream oos = new ObjectOutputStream(fos);

      String result = String.join(" ", inputlist);

      pw.println(result);
      pw.close();
      // oos.close();
    } catch (IOException e) {
      System.out.println("whoopsie");
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {

  
       
    // initializes hash map with keys being the slang words and values being the full word
       initHash("slangs.txt");
    // reads the text file that needs to be edited 
       readFile("realtest.txt");
    // iterated through each word and determines which word is a slang word 
       replaceSlang();
    // write a new file with the slang words replaced 
       writeFile("realoutput.txt");
  
    
    
  

  
  }

  



}

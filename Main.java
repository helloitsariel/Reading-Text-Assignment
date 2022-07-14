import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //Method to return the index of the ArrayList of a word
    public static String search(ArrayList text, String wordInLowerCase){
        //A string to store which indexes the word appears in, aka the result
        String indexPosition = "";
        //Going through each index of the ArrayList
        for (int i = 0; i< text.size(); i++) {
            //Getting the string from that index of the ArrayList
            String line = (text.get(i)).toString();
            //Converting all letters to lowercase
            line = line.toLowerCase();
            //Checking if that index contains the word
            if (line.contains(wordInLowerCase)){
                //if it does, adds index number to indexPosition and comma and a space to separate from the next index
                indexPosition = indexPosition + i + ", ";
            }
        }
        //After getting all indexes, if indexPosition is empty then it will say not in text otherwise removes the last comma and space
        if (indexPosition.equals("")){
            indexPosition = "not in text";
        } else{
            int last = indexPosition.length() - 2;
            indexPosition = indexPosition.substring(0, last);
        }
        //returns the result
        return indexPosition;
    }

    public static void main(String[] args) throws IOException {
        //Copying each line of the text file into an ArrayList
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            lines.add(line);
        }
        //Seeing if method works with given text
        String one = search(lines, "computer");
        String two = search(lines, "pretty");
        System.out.println(one);
        System.out.println(two);
    }
}

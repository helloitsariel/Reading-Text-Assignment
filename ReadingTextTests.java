import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ReadingTextTests {
    ArrayList<String> testing;
    @Before
    public void setup (){
        testing = new ArrayList<>();
        testing.add("how are you");
        testing.add("'are' you 'okay'");
        testing.add("you \"look\" sick");
        testing.add("how's life");
        testing.add("bats bat bats");
        testing.add("HELLO THERE");
        testing.add("applebottomjeans");
    }

    @Test
    public void testWordInText(){
        String actual = Main.search(testing, "you");
        String expected = "0, 1, 2";
        assertEquals(expected, actual);
    }

    @Test
    public void testWordWithApostrophe(){
        String actual = Main.search(testing, "look");
        String expected = "2";
        assertEquals(expected, actual);
    }
    @Test
    public void testMultipleWords(){
        String actual = Main.search(testing, "bat");
        String expected = "4";
        assertEquals(expected, actual);
    }
    @Test
    public void testWordInCaps(){
        String actual = Main.search(testing, "hello");
        String expected = "5";
        assertEquals(expected, actual);
    }

    @Test
    public void testWordInTheMiddle(){
        String actual = Main.search(testing, "bottom");
        String expected = "6";
        assertEquals(expected, actual);
    }

    @Test
    public void testWordNotInText(){
        String actual = Main.search(testing, "pots");
        String expected = "not in text";
        assertEquals(expected, actual);
    }
}

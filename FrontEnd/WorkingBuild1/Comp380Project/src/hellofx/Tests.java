package hellofx;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tests {

    @Test
    public void testAccountManager(){ //Checks if AccountManager can return the correct Account object given email and password (uses default account)
        assertEquals(AccountManager.getDefaultAccount(), AccountManager.getAccount("DonutLover@duffbeer.com","donuts123"));
        assertEquals(AccountManager.getDefaultAccount().getFirstName(), "Homer");
        assertEquals(AccountManager.getDefaultAccount().getLastName(), "Simpson");
    }

    @Test
    public void testReadFileCompare(){ //checks if ReadFile can read and detect an entire line in a .txt file
        assertEquals(true, ReadFile.Compare("This line is only a test.", 
                                    "F:\\Comp380Project\\src\\TextFiles\\TestFile.txt"));
    }

    @Test
    public void testReadFileFindAndReturn(){ //checks if ReadFile can detect substrings in a .txt file
        assertEquals("line", ReadFile.FindAndReturn("line",
                                            "F:\\Comp380Project\\src\\TextFiles\\TestFile.txt"));
    }
}

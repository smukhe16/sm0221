package rentalProject;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.rules.ExpectedException;

public class Test1 {
	public class ApplicationTest extends checkout {

	    @After
	    public void tearDown() throws Exception {
	        instance = null;
	    }
	    
	    @Rule
	    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	    @Test
	    public void testMain() {
	        instance = new CrashAndBurn();
	        String [] args = { "JAKR", "9/3/15", "5", "101" };
	        exit.expectSystemExitWithStatus(1);
	        main(args);
	    }
	    
	    private static class CrashAndBurn extends checkout {
	        @Override
	        protected void run(String string) throws Exception { 
	            throw new Exception();
	        }
	    }
	    
	}
}


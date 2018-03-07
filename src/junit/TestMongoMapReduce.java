package junit;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import mongo.QueryMongoMapReduce;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests Mongo queries performed using MapReduce.
 */
public class TestMongoMapReduce
{
	/**
	 * Class being tested
	 */
	private static QueryMongoMapReduce q;
			
	
	/**
	 * Requests a connection to the Mongo server.
	 * 
	 * @throws Exception
	 * 		if an error occurs
	 */
	@BeforeClass
	public static void init() throws Exception 
	{		
		q = new QueryMongoMapReduce();		
		q.connect();
	}		
		       
    /**
     * Tests query #1. 
     */
    @Test
    public void testQuery1() throws SQLException
    {       
    	// Load data 
    	q.load();
    	
    	// Perform query to get data
    	String result = QueryMongoMapReduce.toString(q.query1());
    	
    	String answer = "Rows:"    			
    			+"\n{ \"_id\" : \"AB\", \"value\" : 2.0 }"
    			+"\n{ \"_id\" : \"BC\", \"value\" : 3.0 }"
    			+"\n{ \"_id\" : \"MB\", \"value\" : 1.0 }"
    			+"\n{ \"_id\" : \"ON\", \"value\" : 3.0 }"
    			+"\n{ \"_id\" : \"SK\", \"value\" : 1.0 }"    				
				+"\nNumber of rows: 5";    					
				
    	System.out.println("\nResult for query 1:\n"+result);
    	assertEquals(answer, result);    	    	  
    }
    
    /**
     * Tests query #2.  
     */
    @Test
    public void testQuery2() throws SQLException
    {       	    	
    	// Load data
    	q.load();
    	
    	// Perform query to get data
    	String result = QueryMongoMapReduce.toString(q.query2());
    	        	
    	System.out.println("\nResult for query 2:\n"+result);
    	
    	// Verify result - Note that may have a rounding difference if do not sum in map so two separate checks
    	
    	// Sum in Map answer
    	String answer1 = "Rows:"
				+"\n{ \"_id\" : \"totalOfAllOrders\", \"value\" : 14535.1 }"				
				+"\nNumber of rows: 1";    				
    	
    	// Do not sum in Map answer
    	String answer2 = "Rows:"
				+"\n{ \"_id\" : \"totalOfAllOrders\", \"value\" : 14535.099999999999 }"
    			+"\nNumber of rows: 1";    	
    	
    	boolean passed = (answer1.equals(result) || answer2.equals(result));
    	
    	if (!passed)
    	{	// Do regular assert so visible to user what the difference is
    		assertEquals(answer1, result);
    	}    	    	       	
    }
    
    /**
     * Tests query #3.  
     */
    @Test
    public void testQuery3() throws SQLException
    {       	    	
    	// Load data
    	q.load();
    	
    	// Perform query to get data
    	String result = QueryMongoMapReduce.toString(q.query3());
    	
    	String answer = "Rows:"
				+"\n{ \"_id\" : \"AB\", \"value\" : 1448.33 }"
				+"\n{ \"_id\" : \"BC\", \"value\" : 164.8 }"
				+"\n{ \"_id\" : \"MB\", \"value\" : 5835.0 }"
				+"\n{ \"_id\" : \"ON\", \"value\" : 7086.969999999999 }"
				+"\n{ \"_id\" : \"SK\", \"value\" : 0.0 }"		
				+"\nNumber of rows: 5";    				
    	
    	System.out.println("\nResult for query 3:\n"+result);
    	
    	// Verify result
    	assertEquals(answer, result);    	       	
    }
    
    /**
     * Tests query #4.  
     */
    @Test
    public void testQuery4() throws SQLException
    {       	    	
    	// Load data
    	q.load();
    	
    	// Perform query to get data
    	String result = QueryMongoMapReduce.toString(q.query4());
    	
    	String answer = "Rows:"
				+"\n{ \"_id\" : \"AB\", \"value\" : 25.5 }"
				+"\n{ \"_id\" : \"BC\", \"value\" : 0.0 }"
				+"\n{ \"_id\" : \"MB\", \"value\" : 5.0 }"
				+"\n{ \"_id\" : \"ON\", \"value\" : 7.857142857142857 }"
				+"\n{ \"_id\" : \"SK\", \"value\" : 0.0 }"			
				+"\nNumber of rows: 5";    				
    	
    	System.out.println("\nResult for query 4:\n"+result);
    	
    	// Verify result
    	assertEquals(answer, result);    	       	
    }
    
    /**
     * Tests query #5.  
     */
    @Test
    public void testQuery5() throws SQLException
    {       	    	
    	// Load data
    	q.load();
    	
    	// Perform query to get data
    	String result = QueryMongoMapReduce.toString(q.query5());
    	
    	String answer = "Rows:"
				+"\n{ \"_id\" : \"max\", \"value\" : { \"num\" : 120, \"items\" : 50, \"total\" : 1023.89 } }"				
				+"\nNumber of rows: 1";    				
    	
    	System.out.println("\nResult for query 5:\n"+result);
    	
    	// Verify result
    	assertEquals(answer, result);    	       	
    }
    
    /**
     * Tests query #6.  
     */
    @Test
    public void testQuery6() throws SQLException
    {       	    	
    	// Load data
    	q.load();
    	
    	// Perform query to get data
    	String result = QueryMongoMapReduce.toString(q.query6());
    	
    	String answer = "Rows:"
				+"\n{ \"_id\" : \"firstlonger\", \"value\" : 4.0 }"
				+"\n{ \"_id\" : \"firstshorter\", \"value\" : 5.0 }"
				+"\n{ \"_id\" : \"same\", \"value\" : 1.0 }"				
				+"\nNumber of rows: 3";    				
    	
    	System.out.println("\nResult for query 6:\n"+result);
    	
    	// Verify result
    	assertEquals(answer, result);    	       	
    }
}

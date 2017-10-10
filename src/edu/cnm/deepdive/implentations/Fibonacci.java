/**
 * 
 */
package edu.cnm.deepdive.implentations;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * @author paulaschultz
 *
 */
public class Fibonacci implements Iterable<BigInteger> {

  private static final int DEFAULT_UPPER = -1; //-1 interpreted as "there is no limit"
  private final int upper;
  
  //empty constructor
  public Fibonacci() {
    this(DEFAULT_UPPER);
  }
  
  
  //Anonymous class implementing the Iterator<BigInteger>interface
  public Iterator<BigInteger> iterator() {
   // return new FibIterator();
    return new Iterator<BigInteger>() {
      private BigInteger previous = BigInteger.valueOf(-1);
      private BigInteger current = BigInteger.ONE;
      private int index = 0;
      
      
      @Override
      //if either true will stop, evaluates upper < 0 first (short circuit)
      public boolean hasNext() {
        return upper < 0 || index < upper;
      }

      @Override
      //Creating a new value called next
      public BigInteger next() {
        BigInteger next = previous.add(current);
        previous = current;
        current = next;
        index++;
        return current;
      }
      
    };
  }
  
  //constructor that takes upper limit
  public Fibonacci(int upper) {
    this.upper = upper; 
  }
  
  //inner class created inside closing class...no "static" keyword, has access to instance of enclosing class
  /**private class FibIterator implements Iterator<BigInteger>{

    private BigInteger previous = BigInteger.valueOf(-1);
    private BigInteger current = BigInteger.ONE;
    private int index = 0;
    
    
    @Override
    //if either true will stop, evaluates upper < 0 first (short circuit)
    public boolean hasNext() {
      return upper < 0 || index < upper;
    }

    @Override
    //Creating a new value called next
    public BigInteger next() {
      BigInteger next = previous.add(current);
      previous = current;
      current = next;
      index++;
      return current;
    }
    
  }*/
  

}




























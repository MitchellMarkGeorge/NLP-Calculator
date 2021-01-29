/** This class represents the base for an Operator. This includes a field for the operator precedence
 * and a method that evaluates two doubles and returns the result (to be implementd by subclasses)
 * @author
 */

package internals.operators;
public abstract class Operator {
    // precedence of th operator
   public int precedence;
    
   /**
    *  A method that evaluates two doubles and returns the result (to be implementd by subclasses)
    * @param first first number 
    * @param second second number 
    * @return result of evaluation
    */
    public abstract double evaluate(double first, double second);

    

   
}

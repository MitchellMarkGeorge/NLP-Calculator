/** This class repretenst a token of a operator. It extends the Token abstract class, making it visitable for a Visitor
 * It internally stores the appropriate Operator accosiated to with the token.
 * @author Mitchell Mark-George
 */


package internals.tokens;
import internals.TokenVisitor;
// import internals.Visitor;
import internals.operators.*;
public class OperatorToken extends Token {
    // the operator accosiated with the token
    private Operator operator;

    /**
     * A constructor that recives the approprite operator for the token
     * @param operator approprite operator for the token
     */
    public OperatorToken(Operator operator) {
        
        this.operator = operator; 
       
    }
    /**
     * A constructor that recieves string representation the opperator. 
     * The construnctor then creates the needed Operator object based on the given string value
     * @param operator string value of the operator
     */
    public OperatorToken(String operator) {
        this.stringValue = operator;
        switch (operator) {
            case "+":
                this.operator = new AddOperator();
                break;
            case "-":
                this.operator = new MinusOperator();
                break;
            
            case "*":
                this.operator = new ProductOperator();
                break;

            case "/":
                this.operator = new DivisionOperator();
            default:
                break;
        }
    }

    /**
     * A method that returns the accossiated Operator Object
     * @return accossiated Operator Object
     */
    public Operator getOperator() {
        
        return this.operator;
    }

      /**
     * @return the string respresentation of the value of the operator
     */
    @Override
    public String getValue() {
        return stringValue;
    }

    /**The inherited accept method to work with the visitor
     * @param visitor The token visitor that will visit the token
     */
    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * @return the string respresentation of the Operator. Mostly used for printing
     */
    @Override
    public String toString() {
        // if the local stringValue is not set, 
        //it will retun the string representation from the accossiated Operator class.
        if (stringValue != null) {
            return stringValue;
        } else {
            return operator.toString();
        }
        
    }
}

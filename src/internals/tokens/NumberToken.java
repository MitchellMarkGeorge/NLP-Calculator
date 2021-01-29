/** This class repretenst a token of a Number. It extends the Token abstract class, making it visitable for a Visitor
 * @author Mitchell Mark-George
 */

package internals.tokens;
import internals.TokenVisitor;

public class NumberToken extends Token {
    double value;

    /**
     * A constructor for the NumberToken class that recieves a string
     * @param value The string representation of the number
     */
    public NumberToken(String value) {
        this.stringValue = value;
        this.value = Double.parseDouble(value);
    }

    /**
     * A constructor for the NumberToken class that recieves a double
     * @param value The double representation of the number
     */

    public NumberToken(double value) {
        this.value = value;
        this.stringValue = Double.toString(value);
    }

    /**The inherited accept method to work with the visitor
     * @param visitor The token visitor that will visit the token
     */

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * @return the string respresentation of the value of the number
     */
    @Override
    public String getValue() {
        return stringValue;
    }

    /**
     * @return the string respresentation of the Number. Mostly used for printing
     */
    @Override
    public String toString() {
        return getValue();
    }
}

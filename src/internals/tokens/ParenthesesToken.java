/** This class repretenst a token of a Parentheses. It extends the Token abstract class, making it visitable for a Visitor
 * It is used to represent both the right (")") and left ("(") parentheses, adn aare designated using the ParenType enum
 * @author Mitchell Mark-George
 */

package internals.tokens;

import internals.TokenVisitor;

public class ParenthesesToken extends Token {
    // The enum used to designate the types of parentheses
    public enum ParenType {
        LEFT, RIGHT
    }

    private ParenType type;

    /**
     * A constructor that receives a the parentheses type
     * 
     * @param type the parentheses type
     */
    public ParenthesesToken(ParenType type) {
        this.type = type;
    }

    /**
     * A getter for the parentheses type
     * 
     * @return the parentheses type
     */
    public ParenType getType() {
        return type;
    }

    /**
     * @return the string respresentation of the parentheses
     */
    @Override
    public String getValue() {
        // retuns the string value based on the type
        if (this.type == ParenType.LEFT) {
            return "(";
        } else {
            return ")";
        }
    }

    /**
     * @return the string respresentation of the parentheses. Mostly used for printing
     */
    @Override
    public String toString() {
        return getValue();
    }

    /**The inherited accept method to work with the visitor
     * @param visitor The token visitor that will visit the token
     */
    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}

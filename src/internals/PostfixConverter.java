/**
 * This is a class that takes a array of takens and converts them to post fix notation for evaluation.
 * This is done by using the TokenVisitor class.
 * @author Mitchell Mark-George
 */

package internals;

// All neccessary imports
import java.util.ArrayList;
import internals.tokens.Token;

public class PostfixConverter {
    // Creates an instace of the TokenVisitor
    private TokenVisitor visitor = new TokenVisitor();

    /**
     * A method that takes the given array and converts it to postfix notation
     * @param tokens the tokens list that should be "rearranged"
     * @return the rearranged token list
     */
    public ArrayList<Token> convert(ArrayList<Token> tokens) {
        for (Token token : tokens) {
            // this calls the accociated visit() method in the TokenVisitor for the given token type/ class
            token.accept(this.visitor);
        }

        return visitor.getResult();
    }

}
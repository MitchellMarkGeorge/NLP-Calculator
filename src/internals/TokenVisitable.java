/**
 * This interface represents represents the basic functionality of a visitable Token. The token implimnts the 
 * accept method, which in turn works with the TokenVisitor class
 */

package internals;

public interface TokenVisitable {
    /**a method that will call the approriat visit method for the accosiated token type/ subclass
     * @param visitor The token visitor that will "visit" the token
     */
    public void accept(TokenVisitor visitor);
}

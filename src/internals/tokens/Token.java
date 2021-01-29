/** This abstract class represents the basic properties of a Token, which includes a field of the string value of the token and a method retreive said field 
* The class also implements the TokenVisitable interface, making the Token visitable. 
* @author Mitchell Mark-George
 */

package internals.tokens;

import internals.TokenVisitable;

public abstract class Token implements TokenVisitable {
    // field representing string value of token
    protected String stringValue; 
 
    /**
     * A method to get the string value of the token (to be implementd by subclasses)
     * @return string value of the token
     */
    public abstract String getValue();
    
}


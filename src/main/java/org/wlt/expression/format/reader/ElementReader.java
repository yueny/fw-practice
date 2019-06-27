/**
 * 
 */
package org.wlt.expression.format.reader;

import org.wlt.expression.format.Element;
import org.wlt.expression.format.ExpressionReader;
import org.wlt.expression.format.FormatException;

import java.io.IOException;

/**
 * @author 林良益，卓诗垚
 * @version 2.0 
 * Oct 9, 2008
 */
public interface ElementReader {
	Element read(ExpressionReader sr) throws FormatException, IOException;
}

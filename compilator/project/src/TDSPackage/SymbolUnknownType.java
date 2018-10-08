package TDSPackage;

import Parsers.SemanticParser;

/**
 * Used to fill TDS when an error occurs, or when we want to create a symbol in order to store information for later use
 * @author Gold
 *
 */
public class SymbolUnknownType extends Symbol{

	public SymbolUnknownType(String idf) {
		super(idf);
	}

	@Override
	public String getType() {
		return SemanticParser.TYPE_NULL;
	}

	
	
}

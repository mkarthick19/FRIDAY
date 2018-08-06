package com.friday.challenge.addressprovider.factory;

import com.friday.challenge.addressprovider.parser.AddressProviderParser;
import com.friday.challenge.addressprovider.parser.impl.CommaAddressParserImpl;
import com.friday.challenge.addressprovider.parser.impl.NumberAddressParserImpl;
import com.friday.challenge.addressprovider.parser.impl.PlainAddressParserImpl;
import com.friday.challenge.addressprovider.util.AddressProviderUtil;

/**
 * Address Provider Factory that supplies parser instance based on the input
 * address.
 */
public class AddressProviderFactory {
    public AddressProviderParser getParser(String address) {
        if (AddressProviderUtil.hasComma(address)) {
            return new CommaAddressParserImpl();
        } else if (AddressProviderUtil.hasNoAsSubstring(address)) {
            return new NumberAddressParserImpl();
        } else {
            return new PlainAddressParserImpl();
        }
    }
}

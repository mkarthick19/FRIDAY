package com.friday.challenge.addressprovider.client;

import com.friday.challenge.addressprovider.exceptions.InvalidInputException;
import com.friday.challenge.addressprovider.factory.AddressProviderFactory;
import com.friday.challenge.addressprovider.parser.AddressProviderParser;

/**
 * Address Provider Client obtains a parser instance based on the given input
 * address. Then it retrieves the required Street address and Street name from
 * the input address.
 */
public class AddressProviderClient {

    private AddressProviderParser addressProviderParser;
    private AddressProviderFactory addressProviderFactory;
    private String[] streetDetails;

    public String[] getAddress(String address) throws InvalidInputException {
        streetDetails = new String[2];
        if (address == null || address.length() == 0) {
            return streetDetails;
        }
        addressProviderFactory = new AddressProviderFactory();
        address = address.trim().replaceAll(" +", " ");
        addressProviderParser = addressProviderFactory.getParser(address);
        try {
            streetDetails = addressProviderParser.parse(address);
        } catch (InvalidInputException ex) {
            throw new InvalidInputException(ex.getLocalizedMessage());
        }
        return streetDetails;
    }
}

package com.friday.challenge.addressprovider.parser;

import com.friday.challenge.addressprovider.exceptions.InvalidInputException;

/**
 * Interface for Address Provider Parser
 */
public interface AddressProviderParser {
    public String[] parse(String address) throws InvalidInputException;
}

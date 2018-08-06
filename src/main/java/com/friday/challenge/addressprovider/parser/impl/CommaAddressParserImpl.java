package com.friday.challenge.addressprovider.parser.impl;

import com.friday.challenge.addressprovider.exceptions.InvalidInputException;
import com.friday.challenge.addressprovider.parser.AddressProviderParser;
import com.friday.challenge.addressprovider.util.AddressProviderUtil;

/**
 * Address Parser Implementation that splits the input address based on comma
 * delimiter and then extracts the street name and street number.
 */
public class CommaAddressParserImpl implements AddressProviderParser {

    public String[] parse(String address) throws InvalidInputException {
        String[] streetDetails = new String[2];
        streetDetails = address.split(",");
        // If there are more than 1 comma in input address or if comma doesn't separate
        // the address into 2 words, then throw Invalid Input Exception
        if (streetDetails.length < 2 || address.replaceAll("[^,]", "").length() > 1) {
            throw new InvalidInputException("The given address structure is invalid");
        }
        boolean isSwapRequired = false;
        // If the street number appears first followed by street name, we have to swap
        // the street name and number.
        if (AddressProviderUtil.hasNoAsSubstring(address)) {
            if (AddressProviderUtil.hasNoAsSubstring(streetDetails[0])) {
                isSwapRequired = true;
            }
        } else if (AddressProviderUtil.hasDigits(streetDetails[0])) {
            isSwapRequired = true;
        }
        if (isSwapRequired) {
            String temp = streetDetails[0];
            streetDetails[0] = streetDetails[1];
            streetDetails[1] = temp;
        }
        streetDetails[0] = streetDetails[0].trim();
        streetDetails[1] = streetDetails[1].trim();
        if ("".equals(streetDetails[0]) || "".equals(streetDetails[1])
                || !AddressProviderUtil.hasDigits(streetDetails[1])) {
            throw new InvalidInputException("The given address structure is invalid.");
        }
        return streetDetails;
    }
}

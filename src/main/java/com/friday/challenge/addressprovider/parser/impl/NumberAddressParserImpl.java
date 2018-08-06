package com.friday.challenge.addressprovider.parser.impl;

import com.friday.challenge.addressprovider.exceptions.InvalidInputException;
import com.friday.challenge.addressprovider.parser.AddressProviderParser;
import com.friday.challenge.addressprovider.util.AddressProviderUtil;

/**
 * Address Parser Implementation that parses the input address based on keyword
 * "No" ignoring case and then extracts the street name and street number.
 */
public class NumberAddressParserImpl implements AddressProviderParser {
    public String[] parse(String address) throws InvalidInputException {
        String[] words = address.split(" ");
        if (words.length < 2) {
            throw new InvalidInputException("The given address structure is invalid");
        }
        String[] streetDetails = new String[2];
        String streetAddress = "";
        String streetNumber = "";
        for (int i = 0; i < words.length; i++) {
            if ("no".equalsIgnoreCase(words[i])) {
                streetNumber += words[i] + " " + words[i + 1];
                i++;
                if (i + 1 < words.length && words[i + 1].length() == 1) {
                    streetNumber += " " + words[i + 1];
                    i++;
                }
            } else {
                streetAddress += ("".equals(streetAddress)) ? words[i] : " " + words[i];
            }
        }
        streetDetails[0] = streetAddress.trim();
        streetDetails[1] = streetNumber.trim();
        if ("".equals(streetDetails[0]) || "".equals(streetDetails[1])
                || !AddressProviderUtil.hasDigits(streetDetails[1])) {
            throw new InvalidInputException("The given address structure is invalid.");
        }
        return streetDetails;
    }
}

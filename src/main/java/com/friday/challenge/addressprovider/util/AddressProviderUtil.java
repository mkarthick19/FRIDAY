package com.friday.challenge.addressprovider.util;

/**
 * Address Provider Utility helper methods
 */
public class AddressProviderUtil {

    public AddressProviderUtil() {
    }

    public static boolean hasComma(String address) {
        return address.contains(",");
    }

    public static boolean hasDigits(String word) {
        return word.matches(".*\\d+.*");
    }

    public static boolean hasNoAsSubstring(String word) {
        return word.toLowerCase().matches(".*\\bno\\b.*");
    }
}

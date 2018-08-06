package com.friday.challenge.addressprovider.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.friday.challenge.addressprovider.exceptions.InvalidInputException;
import com.friday.challenge.addressprovider.util.AddressProviderUtil;

/**
 * JUnit test cases for Address Provider Client
 */
public class AddressProviderClientTest {

    private AddressProviderClient addressProvider;
    private AddressProviderUtil addressProviderUtil;

    private String[] streetDetails;

    @Before
    public void setup() {
        addressProvider = new AddressProviderClient();
        addressProviderUtil = new AddressProviderUtil();
    }

    @Test
    public void testGetAddressWithNullInput() throws InvalidInputException {
        streetDetails = addressProvider.getAddress(null);
        assertNotNull(streetDetails);
    }

    @Test
    public void testGetAddressWithEmptyInput() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("");
        assertNotNull(streetDetails);
    }

    @Test
    public void testGetAddressWithLeadingAndTrailingSpaces() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("   43 Hello  ");
        assertNotNull(streetDetails);
        assertEquals("Hello", streetDetails[0]);
        assertEquals("43", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input1() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Winterallee 3");
        assertNotNull(streetDetails);
        assertEquals("Winterallee", streetDetails[0]);
        assertEquals("3", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input2() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Musterstrasse 45");
        assertNotNull(streetDetails);
        assertEquals("Musterstrasse", streetDetails[0]);
        assertEquals("45", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input3() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Blaufeldweg 123B");
        assertNotNull(streetDetails);
        assertEquals("Blaufeldweg", streetDetails[0]);
        assertEquals("123B", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input4() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Am Bächle 23");
        assertNotNull(streetDetails);
        assertEquals("Am Bächle", streetDetails[0]);
        assertEquals("23", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input5() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Auf der Vogelwiese 23 b");
        assertNotNull(streetDetails);
        assertEquals("Auf der Vogelwiese", streetDetails[0]);
        assertEquals("23 b", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input6() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("4, rue de la revolution");
        assertNotNull(streetDetails);
        assertEquals("rue de la revolution", streetDetails[0]);
        assertEquals("4", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input7() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("200 Broadway Av");
        assertNotNull(streetDetails);
        assertEquals("Broadway Av", streetDetails[0]);
        assertEquals("200", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input8() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Calle Aduana, 29");
        assertNotNull(streetDetails);
        assertEquals("Calle Aduana", streetDetails[0]);
        assertEquals("29", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input9() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Calle 39 No 1540");
        assertNotNull(streetDetails);
        assertEquals("Calle 39", streetDetails[0]);
        assertEquals("No 1540", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input10() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("123B Blaufeldweg");
        assertNotNull(streetDetails);
        assertEquals("Blaufeldweg", streetDetails[0]);
        assertEquals("123B", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input11() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("23 b Auf der Vogelwiese");
        assertNotNull(streetDetails);
        assertEquals("Auf der Vogelwiese", streetDetails[0]);
        assertEquals("23 b", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input12() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("No 1540, Calle 39");
        assertNotNull(streetDetails);
        assertEquals("Calle 39", streetDetails[0]);
        assertEquals("No 1540", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input13() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Calle 39, No 1540");
        assertNotNull(streetDetails);
        assertEquals("Calle 39", streetDetails[0]);
        assertEquals("No 1540", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input14() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("no 1540, Calle 39");
        assertNotNull(streetDetails);
        assertEquals("Calle 39", streetDetails[0]);
        assertEquals("no 1540", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input15() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("29, Calle Aduana");
        assertNotNull(streetDetails);
        assertEquals("Calle Aduana", streetDetails[0]);
        assertEquals("29", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input16() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("No 1540 b, Calle 39");
        assertNotNull(streetDetails);
        assertEquals("Calle 39", streetDetails[0]);
        assertEquals("No 1540 b", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input17() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("No 1540 b Calle 39");
        assertNotNull(streetDetails);
        assertEquals("Calle 39", streetDetails[0]);
        assertEquals("No 1540 b", streetDetails[1]);
    }

    @Test
    public void testGetAddress_Input18() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("No 1540 bc Calle 39");
        assertNotNull(streetDetails);
        assertEquals("bc Calle 39", streetDetails[0]);
        assertEquals("No 1540", streetDetails[1]);
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress1() throws InvalidInputException {
        streetDetails = addressProvider.getAddress(",");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress2() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Germany,");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress3() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("43,");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress4() throws InvalidInputException {
        streetDetails = addressProvider.getAddress(",43");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress5() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Berlin, FRIDAY");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress6() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Berlin,23,a");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress7() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("No");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress8() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("No Calle");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress9() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Berlin ");
    }

    @Test(expected = InvalidInputException.class)
    public void testGetAddress_InvalidInputAddress10() throws InvalidInputException {
        streetDetails = addressProvider.getAddress("Germany Berlin");
    }
}


CODE CHALLENGE

We kindly ask you to solve the following code challenge as part of our selection process.
Addressline

An address provider returns addresses only with concatenated street names and numbers. Our own system on the other hand has separate fields for street name and street number.

Input: string of address

Output: string of street and string of street-number


Input Assumptions:

As the input address structure is unknown, we have made the following assumptions based on the examples mentioned in the challenge.

1. Address containing Comma:

* There can be at maximum of one comma present in the input address, which divides the address into street name and street number.
* There can be at maximum of one string containing digits, unless there is a "No" (Ignore case) substring present in the input address.

Input examples : "Calle Aduana, 29", "29, Calle Aduna", "Calle 30B, No 40"

2. Address containing "No" Substring (Without Comma):

*  In this case, there can at maximum of 1 "No" substring present in the address.

Input examples : "Calle Aduana No 29", "No 29 Calle Aduna", "No  40, Calle 300B"

3. Plain Address (Without Comma and without "No" substring):

*  In this case, there can be at maximum of one substring that contains digits.

Input examples: "Winterallee 3” , "Musterstrasse 45", "Blaufeldweg 123B”


Proposed Solution:

The input address is parsed using the parser that is obtained by using Regular Expressions. For each of the above scenarios, we use regex and obtain the appropriate parser. Then, the parser extracts the street name and street number from the input address.

Implementation Details:

We have used the following languages, tools and design patterns.

Language:         Java

Build Tool:       Maven

Repository:       Git

Code Coverage:    Jacoco

Design Patterns : Factory, Strategy

Testing Details:

Please follow the steps mentioned below to clone the git repository, then build and execute the tests

$ git clone git@github.com:mkarthick19/master.git

$ cd master/

$ mvn clean install

Code Coverage Report:

The Java code coverage report is obtained as follows:

$ open target/jacoco-ut/index.html












package com.mikeleitz.example.service;

/**
 * @author Mike Leitz
 */
public interface ExampleService {

    /**
     * A service that takes the input and reverses it.
     *
     * e.g. "My String" returns "gnirtS yM"
     *
     * @param input the String value to reverse
     * @return the reverse of the input
     */
    String reverseMyInput(String input);
}

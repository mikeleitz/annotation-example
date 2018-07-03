package com.mikeleitz.example.annotation.service;

/**
 * This service and its implementation are the same as ExampleService.  The only difference
 * is the method in AnnotatedExampleService has the @Notify annotation attached to it.
 *
 * If you call reverseMyInput in ExampleService, the annotation code won't be executed.
 * If you call reverseMyInput in AnnotatedExampleService, the annotation code will be executed.
 *
 * @author Mike Leitz
 */
public interface AnnotatedExampleService {

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

// Copyright (C) 2020 Jack Woodger
// SPDX-License-Identifier: MPL-2.0
package jwoodger.dottedline;

/**
 * Signifies when the post-condition of a method is violated by the code.
 */
public class PostconditionViolationException extends RuntimeException {

    /**
     * Signals a postcondition violation.
     * @param message The detail message illustrating the postcondition.
     */
    public PostconditionViolationException(String message) {
        super(message);
    }

    /**
     * Signals a precondition violation with {@code null} as its message.
     */
    public PostconditionViolationException() {
        super();
    }
}

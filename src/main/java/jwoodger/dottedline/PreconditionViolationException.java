// Copyright (C) 2020 Jack Woodger
// SPDX-License-Identifier: MPL-2.0
package jwoodger.dottedline;

/**
 * Signifies when a client violates the precondition of a method.
 */
public class PreconditionViolationException extends RuntimeException {

    /**
     * Signals a precondition violation.
     * @param message The detail message illustrating the precondition.
     */
    public PreconditionViolationException(String message) {
        super(message);
    }

    /**
     * Signals a precondition violation with {@code null} as its message.
     */
    public PreconditionViolationException() {
        super();
    }
}

// Copyright (C) 2020 Jack Woodger
// SPDX-License-Identifier: MPL-2.0
package jwoodger.dottedline;

/**
 * Contains utility methods for expressing contracts in code.
 */
public final class Contracts {

    private Contracts() {
    }

    /**
     * Used to express a pre-condition, which is to say a condition imposed on the client of a
     * method. Note that if assertions are disabled, this method does nothing.
     *
     * @param condition The condition which must be fulfilled.
     * @param message A message to explain the condition. This is displayed in the
     * {@link PreconditionViolationException} that is thrown.
     * @throws PreconditionViolationException if the condition is not met.
     */
    public static void requires(boolean condition, String message)
        throws PreconditionViolationException {
        try {
            assert condition;
        } catch (AssertionError err) {
            if (message != null) {
                throw new PreconditionViolationException(message);
            }
            throw new PreconditionViolationException();
        }
    }

    /**
     * Variant of "requires" that does not need a message.
     *
     * @see #requires(boolean, String)
     */
    public static void requires(boolean condition) throws PreconditionViolationException {
        requires(condition, null);
    }

    /**
     * Used to express a post-condition, which is to say a condition imposed on the result of a
     * method. Note that if assertions are disabled, this method does nothing.
     *
     * @param condition The condition which must be fulfilled.
     * @param message A message to explain the condition. This is displayed in the
     * {@link PostconditionViolationException} that is thrown.
     * @throws PostconditionViolationException if the condition is not met.
     */
    public static void ensures(boolean condition, String message)
        throws PostconditionViolationException {
        try {
            assert condition;
        } catch (AssertionError err) {
            if (message != null) {
                throw new PostconditionViolationException(message);
            }
            throw new PostconditionViolationException();
        }
    }

    /**
     * Variant of "ensures" that does not require a message.
     *
     * @see #ensures(boolean, String)
     */
    public static void ensures(boolean condition) throws PostconditionViolationException {
        ensures(condition, null);
    }
}

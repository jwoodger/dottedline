// Copyright (C) 2020 Jack Woodger
// SPDX-License-Identifier: MPL-2.0
package jwoodger.dottedline;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static jwoodger.dottedline.Contracts.*;

// Tests for the Contracts class.
public class ContractsTest {

    @DisplayName("requires does not throw given a passed condition.")
    @Test
    public void requiresDoesNotThrowOnSuccess() {
        assertDoesNotThrow(() -> requires(true));
    }

    @DisplayName("requires throws a PreconditionViolationException given a failed condition")
    @Test
    public void requiresThrowsOnFailedCondition() {
        assertThrows(PreconditionViolationException.class, () -> requires(false));
    }

    @DisplayName("ensures does not throw given a passed condition.")
    @Test
    public void ensuresDoesNotThrowOnSuccess() {
        assertDoesNotThrow(() -> ensures(true));
    }

    @DisplayName("ensures throws a PostconditionViolationException given a failed condition.")
    @Test
    public void ensuresThrowsOnFailedCondition() {
        assertThrows(PostconditionViolationException.class, () -> ensures(false));
    }
}

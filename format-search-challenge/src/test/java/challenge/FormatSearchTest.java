package challenge;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Challenge skeleton: implement tests as you implement FormatSearch.")
class FormatSearchTest {

    @Test
    void findsOneBoldCell() {
        // TODO: Arrange sheet/query/scope and assert one match.
    }

    @Test
    void findsMultipleBoldCells() {
        // TODO: Arrange sheet/query/scope and assert multiple matches.
    }

    @Test
    void matchesBoldAndFillTogether() {
        // TODO: Assert combined-property query behavior.
    }

    @Test
    void ignoresFormattingPropertiesAbsentFromTheQuery() {
        // TODO: Assert unspecified query properties do not constrain matches.
    }

    @Test
    void nextFollowsDeterministicOrder() {
        // TODO: Assert deterministic NEXT ordering over matches.
    }

    @Test
    void nextWrapsCorrectly() {
        // TODO: Assert NEXT wraps to the beginning.
    }

    @Test
    void previousReversesNavigation() {
        // TODO: Assert PREVIOUS mirrors NEXT in reverse.
    }

    @Test
    void zeroMatchesBehavesSafely() {
        // TODO: Assert no-match traversal behavior is safe.
    }

    @Test
    void changingAMatchIntoANonMatchDoesNotProduceStaleNavigation() {
        // TODO: Assert traversal updates after format changes.
    }
}

package challenge;

import java.util.Optional;

public class FormatSearch {
    public SearchResult search(Sheet sheet, FormatQuery query, SearchScope scope) {
        if (sheet == null) {
            throw new IllegalArgumentException("sheet cannot be null");
        }
        if (query == null) {
            throw new IllegalArgumentException("query cannot be null");
        }
        if (scope == null) {
            throw new IllegalArgumentException("scope cannot be null");
        }

        // TODO: Implement format matching and initial result traversal state.
        throw new UnsupportedOperationException("TODO: implement search");
    }

    public Optional<Position> next() {
        // TODO: Implement deterministic traversal over current matches.
        throw new UnsupportedOperationException("TODO: implement next");
    }

    public Optional<Position> previous() {
        // TODO: Implement reverse traversal over current matches.
        throw new UnsupportedOperationException("TODO: implement previous");
    }

    public void onCellFormatChanged(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("position cannot be null");
        }

        // TODO: Decide mutation/update semantics for search state.
        throw new UnsupportedOperationException("TODO: implement onCellFormatChanged");
    }
}

package challenge;

import java.util.List;

public record SearchResult(List<Position> matches) {
    public SearchResult {
        if (matches == null) {
            throw new IllegalArgumentException("matches cannot be null");
        }
        matches = List.copyOf(matches);
    }
}

package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FormatSearch {

    private List<Position> matches;
    private int currentIndex = -1;

    private boolean matches(CellFormat format, FormatQuery query) {
        if (query.bold().isPresent() && query.bold().get() != format.bold()) { 
            return false;
        }

        if (query.italic().isPresent() && query.italic().get() != format.italic()) { 
            return false;
        }

        if (query.textColor().isPresent() && !Objects.equals(query.textColor().get(), format.textColor())) { 
            return false;
        }

        if (query.fillColor().isPresent() && !Objects.equals(query.fillColor().get(), format.fillColor())) { 
            return false;
        }

        if (query.horizontalAlignment().isPresent() && query.horizontalAlignment().get() != format.horizontalAlignment()) { 
            return false;
        }

        return true;

    }

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
        List<Position> result = new ArrayList<>();
        Position start = scope.topLeft();
        Position end = scope.bottomRight();

        for (int r=start.row(); r<=end.row(); r++) {
            for (int c=start.column(); c<=end.column(); c++) {
                sheet.getCell(new Position(r,c)).ifPresent(cell -> 
                    {
                        if (matches(cell.format(), query)) {
                            result.add(cell.position());
                        }
                    }
                );
            }
        }
        this.matches = List.copyOf(result);
        return new SearchResult(result);
    }

    /*
    In search(sheet, query, scope):

validate inputs
scan only cells in scope (row-major is a good deterministic order: top-to-bottom, left-to-right)
for each position, check if cell exists and matches query
store ordered matches
reset navigation cursor
return SearchResult
Matching rule for FormatQuery:

for each query property:
if unspecified → ignore it
if specified → candidate must equal it
this is the most important part of correctness

In next():

if no matches, return Optional.empty()
advance cursor with wrap-around ((index + 1) % size)
return that position

In previous():

if no matches, return Optional.empty()
decrement cursor with wrap-around ((index - 1 + size) % size)
return that position
In onCellFormatChanged(position):

use stored last search context
re-evaluate results so stale matches are removed/added
keep navigation behavior predictable after refresh (decide and stick to one policy)

    */

    public Optional<Position> next() {
        // TODO: Implement deterministic traversal over current matches.
        if (this.matches.isEmpty()){
            return Optional.empty();
        }
        this.currentIndex = (this.currentIndex + 1) % this.matches.size();
        return Optional.of(this.matches.get(this.currentIndex));
    }

    public Optional<Position> previous() {
        // TODO: Implement reverse traversal over current matches.
        if (this.matches.isEmpty()){
            return Optional.empty();
        }

        if (this.currentIndex == -1) {
            this.currentIndex = this.matches.size() - 1;
        } else {
            this.currentIndex = Math.abs(this.currentIndex - 1 + this.matches.size()) % this.matches.size();
        }
        return Optional.of(this.matches.get(this.currentIndex));
    }

    public void onCellFormatChanged(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("position cannot be null");
        }

        // TODO: Decide mutation/update semantics for search state.
        throw new UnsupportedOperationException("TODO: implement onCellFormatChanged");
    }
}

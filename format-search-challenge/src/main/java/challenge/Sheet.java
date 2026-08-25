package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Sheet {
    private final int rowCount;
    private final int columnCount;
    private final Map<Position, Cell> cellsByPosition = new HashMap<>();

    public Sheet(int rowCount, int columnCount) {
        if (rowCount < 0) {
            throw new IllegalArgumentException("rowCount must be >= 0");
        }
        if (columnCount < 0) {
            throw new IllegalArgumentException("columnCount must be >= 0");
        }
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public int rowCount() {
        return rowCount;
    }

    public int columnCount() {
        return columnCount;
    }

    public void putCell(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("cell cannot be null");
        }
        cellsByPosition.put(cell.position(), cell);
    }

    public Optional<Cell> getCell(Position position) {
        return Optional.ofNullable(cellsByPosition.get(position));
    }
}

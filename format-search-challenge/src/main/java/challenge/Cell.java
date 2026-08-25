package challenge;

public record Cell(Position position, CellFormat format) {
    public Cell {
        if (position == null) {
            throw new IllegalArgumentException("position cannot be null");
        }
        if (format == null) {
            throw new IllegalArgumentException("format cannot be null");
        }
    }
}

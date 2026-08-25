package challenge;

public record SearchScope(Position topLeft, Position bottomRight) {
    public SearchScope {
        if (topLeft == null) {
            throw new IllegalArgumentException("topLeft cannot be null");
        }
        if (bottomRight == null) {
            throw new IllegalArgumentException("bottomRight cannot be null");
        }
        if (topLeft.row() > bottomRight.row() || topLeft.column() > bottomRight.column()) {
            throw new IllegalArgumentException("topLeft must be above and left of bottomRight");
        }
    }

    public boolean contains(Position position) {
        if (position == null) {
            return false;
        }
        return position.row() >= topLeft.row()
                && position.row() <= bottomRight.row()
                && position.column() >= topLeft.column()
                && position.column() <= bottomRight.column();
    }
}

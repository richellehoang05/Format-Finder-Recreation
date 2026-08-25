package challenge;

public record CellFormat(
        boolean bold,
        boolean italic,
        String textColor,
        String fillColor,
        HorizontalAlignment horizontalAlignment
) {
    public enum HorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }
}

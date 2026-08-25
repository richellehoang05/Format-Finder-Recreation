package challenge;

import java.util.Optional;

public final class FormatQuery {
    private final Boolean bold;
    private final Boolean italic;
    private final String textColor;
    private final String fillColor;
    private final CellFormat.HorizontalAlignment horizontalAlignment;

    private FormatQuery(Builder builder) {
        this.bold = builder.bold;
        this.italic = builder.italic;
        this.textColor = builder.textColor;
        this.fillColor = builder.fillColor;
        this.horizontalAlignment = builder.horizontalAlignment;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Optional<Boolean> bold() {
        return Optional.ofNullable(bold);
    }

    public Optional<Boolean> italic() {
        return Optional.ofNullable(italic);
    }

    public Optional<String> textColor() {
        return Optional.ofNullable(textColor);
    }

    public Optional<String> fillColor() {
        return Optional.ofNullable(fillColor);
    }

    public Optional<CellFormat.HorizontalAlignment> horizontalAlignment() {
        return Optional.ofNullable(horizontalAlignment);
    }

    public static final class Builder {
        private Boolean bold;
        private Boolean italic;
        private String textColor;
        private String fillColor;
        private CellFormat.HorizontalAlignment horizontalAlignment;

        public Builder bold(Boolean value) {
            this.bold = value;
            return this;
        }

        public Builder italic(Boolean value) {
            this.italic = value;
            return this;
        }

        public Builder textColor(String value) {
            this.textColor = value;
            return this;
        }

        public Builder fillColor(String value) {
            this.fillColor = value;
            return this;
        }

        public Builder horizontalAlignment(CellFormat.HorizontalAlignment value) {
            this.horizontalAlignment = value;
            return this;
        }

        public FormatQuery build() {
            return new FormatQuery(this);
        }
    }
}

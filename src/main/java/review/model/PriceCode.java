package review.model;

public enum PriceCode {
    REGULAR(0),
    NEW_RELEASE(1),
    CHILDRENS(2);

    private final int code;

    PriceCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PriceCode fromCode(int code) {
        for (PriceCode priceCode : values()) {
            if (priceCode.code == code) {
                return priceCode;
            }
        }
        throw new IllegalArgumentException("Invalid price code");
    }
}
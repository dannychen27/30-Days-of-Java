package Constructs.Medium.Enum;

public enum DiffuserScent {
    LAVENDER, SWEET_ORANGE, LEMONGRASS,
    PEPPERMINT, EUCALYPTUS, TEA_TREE_OIL;

    public String toString() {
        switch (this) {
            case LAVENDER:
                return "Lavender";
            case SWEET_ORANGE:
                return "Sweet Orange";
            case LEMONGRASS:
                return "Lemongrass";
            case PEPPERMINT:
                return "Peppermint";
            case EUCALYPTUS:
                return "Eucalyptus";
            case TEA_TREE_OIL:
                return "Tea Tree Oil";
            default:
                return null;
        }
    }

    public void printValues() {
        for (DiffuserScent diffuserScent : DiffuserScent.values()) {
            System.out.println(diffuserScent);
        }
    }
}

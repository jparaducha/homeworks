package homework2.enums;

public enum BuildingType {
    INDUSTRIAL, PUBLIC, HOUSING, UNDEFINED;

    public String getType() {
        String data = "";
        switch (this) {
            case PUBLIC:
                data = "Public";
                break;
            case INDUSTRIAL:
                data = "Industrial";
                break;
            case HOUSING:
                data = "Housing";
                break;
            default:
                data = "Undefined";
        }
        return data;
    }
}

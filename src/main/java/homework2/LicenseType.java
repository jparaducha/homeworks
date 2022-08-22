package homework2;

public enum LicenseType {
    HEAVYLOAD, FORKLIFT, TRANSPORT, CRANE, BACKHOE, BULLDOZER, DUMPTRUCK, GRADER, STEAMROLLER;

    public String getVehicle() {
        String data = "";
        switch (this) {
            case HEAVYLOAD:
                data = "Heavy load truck";
                break;
            case FORKLIFT:
                data = "Forklift";
                break;
            case TRANSPORT:
                data = "Transport bus";
                break;
            case CRANE:
                data = "Crane";
                break;
            case BACKHOE:
                data = "Backhoe";
                break;
            case BULLDOZER:
                data = "Bulldozer";
                break;
            case DUMPTRUCK:
                data = "Dump truck";
                break;
            case GRADER:
                data = "Grader";
                break;
            case STEAMROLLER:
                data = "Steamroller";
                break;
            default:
                data = null;
        }

        return data;
    }
}

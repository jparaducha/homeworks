package homework2.enums;

public enum LicenseType {
    HEAVYLOAD("Heavy load truck", true), FORKLIFT("Forklift", false), TRANSPORT("Transport bus", false), CRANE("Crane", true), BACKHOE("Backhoe", true), BULLDOZER("Bulldozer", true), DUMPTRUCK("Dump truck", false), GRADER("Grader", true), STEAMROLLER("Steamroller", true);

    private String s;
    private boolean isConstructionMachinery;

    LicenseType(String s, boolean isConstructionMachinery) {
        this.s = s;
        this.isConstructionMachinery = isConstructionMachinery;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public boolean isConstructionMachinery() {
        return isConstructionMachinery;
    }

    public void setConstructionMachinery(boolean constructionMachinery) {
        isConstructionMachinery = constructionMachinery;
    }

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

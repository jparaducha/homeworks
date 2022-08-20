package homework2;

import java.util.Date;

public class Permit extends Company {

    private boolean isApproved;
    private Date expiry;

    public Permit() {
    }

    public Permit(boolean status) {
        this.isApproved = status;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }

    public boolean getApproval() {
        return isApproved;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date date) {
        this.expiry = date;
    }
}

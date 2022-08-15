package homework2;

import java.util.Date;

public class Permit extends Company {

    private boolean isApproved;
    private Date expiry;

    public void setApproved(boolean approved){
        this.isApproved = approved;
    }

    public boolean getApproval(){
        return isApproved;
    }

    public void setExpiry(Date date){
        this.expiry = date;
    }

    public Date getExpiry(){
        return expiry;
    }
}

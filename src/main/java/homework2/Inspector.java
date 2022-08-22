package homework2;

public class Inspector extends Worker {

    public void approvePermit(Permit permit) {
        permit.setApproved(true);
    }

    public void disapprovePermit(Permit permit) {
        permit.setApproved(false);
    }

    @Override
    public double totalSalary() {
        return 1200;
    }
}

package constants;

public enum ComplianceStatus {
    ALL("Pending,Action Required,Compliant,Non-Compliant,Needs Review"),
    PENDING("Pending"),
    ACTION_REQUIRED("Action Required"),
    NON_COMPLIANT("Non-Compliant"),
    NEEDS_REVIEW("Needs Review"),
    COMPLIANT("Compliant");
    private final String complianceStatus;
    ComplianceStatus(String complianceStatus){
        this.complianceStatus=complianceStatus;
    }
    public String toString(){
        return complianceStatus;
    }
}

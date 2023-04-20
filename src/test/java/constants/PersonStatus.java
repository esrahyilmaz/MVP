package constants;

public enum PersonStatus {
    ALL("Active,Inactive,Terminated"),
    ACTIVE("Pending"),
    TERMINATED("Terminated"),
    INACTIVE("Inactive");
    private final String personStatus;
    PersonStatus(String personStatus){
        this.personStatus =personStatus;
    }
    public String toString(){
        return personStatus;
    }
}

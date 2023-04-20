package constants;

public enum ScreeningStatus {
    ALL("Pending,Completed,Action Required"),
    ACTION_REQUIRED("Action Required"),
    PENDING("Pending"),
    COMPLETED("Completed");
    private final String screeningStatus;
    ScreeningStatus(String screeningStatus){
        this.screeningStatus =screeningStatus;
    }
    public String toString(){
        return screeningStatus;
    }
}


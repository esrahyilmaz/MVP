package constants;

//todo add colors to class and implement a list that will go through colors in people page
public enum PeopleSearchColors {
    ACTIVE("Active","#37a47a"),  
    COMPLIANT("Compliant","#37a47a"),
    NON_COMPLIANT("Non-Compliant","#e00000"),
    TERMINATED("Terminated","#e00000"),
    INACTIVE("Inactive","#838383"),
    PENDING("Pending","#3e82c8"),
    NEEDS_REVIEW("Needs Review","#f18a00"),
    ACTION_REQUIRED("Action Required","#f18a00"),
    COMPLETED("Completed","#37a47a,#e00000");
    private final String status;
    private final String color;


    PeopleSearchColors(String status, String color) {
        this.status=status;
        this.color=color;
    }

    public String getStatus(){
        return status;
    }
    public String getColor(){
        return color;
    }
}

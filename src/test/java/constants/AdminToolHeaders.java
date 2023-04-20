package constants;

public enum AdminToolHeaders {
    ACTION_UPDATE("Update+Property"),
    USER_AGENT("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.62 Safari/537.36"),
    HOST("qcsa-admin.fadv.net");
    private final String HEADER;

    AdminToolHeaders(String header){
        this.HEADER=header;
    }
    public String toString(){
        return HEADER;
    }
}

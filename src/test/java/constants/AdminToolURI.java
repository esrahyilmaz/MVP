package constants;

public enum AdminToolURI {
    COOKIES_URI("https://qcsa-admin.fadv.net/veva_Customer/index"),
    POSTLOGIN_URI(" https://qcsa-admin.fadv.net/veva_User/login"),
    BASE_URI("https://qcsa-admin.fadv.net"),
    LOGIN_URI("https://qcsa-admin.fadv.net/veva_Customer/list"),
    UPDATE_URI("https://qcsa-admin.fadv.net/veva_Cust_Property/save");
    private final String uri;

    AdminToolURI(String uri){
        this.uri=uri;
    }
    public String toString(){
        return uri;
    }
}

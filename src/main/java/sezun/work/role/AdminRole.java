package sezun.work.role;

public enum AdminRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    AdminRole(String value){
        this.value = value;
    }
    private String value;

    public String getValue() {
        return value;
    }
}

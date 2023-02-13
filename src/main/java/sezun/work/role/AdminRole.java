package sezun.work.role;

public enum AdminRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;
    AdminRole(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

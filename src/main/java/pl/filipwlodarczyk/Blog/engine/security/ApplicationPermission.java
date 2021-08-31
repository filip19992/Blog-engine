package pl.filipwlodarczyk.Blog.engine.security;

public enum ApplicationPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;


    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

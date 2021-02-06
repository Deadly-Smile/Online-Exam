package controller;

public class SignInInfoCollector {
    private String name;
    private String handle;
    private String password;

    public SignInInfoCollector() {
    }

    public SignInInfoCollector(String name, String handle, String password) {
        this.name = name;
        this.handle = handle;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

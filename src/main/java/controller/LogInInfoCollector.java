package controller;

public class LogInInfoCollector {
    private String handle;
    private String password;

    public LogInInfoCollector() {
    }

    public LogInInfoCollector(String handle, String password) {
        this.handle = handle;
        this.password = password;
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
        this.password =password;
    }
}

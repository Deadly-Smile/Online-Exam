package model;

import java.util.Stack;

public class User {
    private String name;
    private String handle;
    private String password;
    private Stack<Result> history;

    public User() {
    }

    public User(String name, String handle, String password) {
        this.name = name;
        this.handle = handle;
        this.password = password;
        history = new Stack<>();
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

    public Stack<Result> getHistory() {
        return history;
    }

    public void addResult(Result latestResult) {
        history.add(latestResult);
    }
}

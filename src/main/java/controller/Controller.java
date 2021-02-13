package controller;

import model.User;
import model.UserDataBase;
import view.homepage.HomePage;
import view.register.LogIn;
import view.register.SignIn;

import javax.swing.*;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private static final UserDataBase dataBase = new UserDataBase();
    private static LogInInfoCollector userLog = null;
    public Controller(){

    }

    public boolean isLogInDefault() {
        userLog = getLogInData("src/main/resources/User Log In Info.txt");
        return userLog != null;
    }

    /* getting user info from the User Log In Info file */
    private LogInInfoCollector getLogInData(String url){
        LogInInfoCollector userLogInfoFromFile = null;
        try (Scanner scanner = new Scanner(new BufferedReader(
                new FileReader(url)
        ))) {
            userLogInfoFromFile = new LogInInfoCollector(scanner.nextLine(),scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Couldn't load " + url);
        } catch (NoSuchElementException e){
            return null;
        }
        return userLogInfoFromFile;
    }

    private void writeFile(String url) throws IOException {
        try(FileWriter fileWriter = new FileWriter(url)) {
            fileWriter.write(userLog.getHandle() + "\n" + userLog.getPassword());
        } catch (IOException e) {
            throw new IOException("Could not open " + url);
        }
    }

    /* checking handle and password and its next step */
    public void setLogInDataUI(String handle, String password,
                               boolean isRemembered, HomePage homePage, LogIn source)
            throws IOException {
        if(userLog != null) {
            System.err.println("We already have data");
        } else {
            if(handle.length() <= 3 || password.length() <= 5){
                source.setMassage(true);
            }else{
                if (dataBase.verifyUser(handle,password)){
                    userLog = new LogInInfoCollector(handle,password);
                    if (isRemembered){
                        writeFile("src/main/resources/User Log In Info.txt");
                    }
                    source.setVisible(false);
                    homePage.addHistoryTable(getUser());
                    homePage.setVisible(true);
                } else {
                    source.setMassage(true);
                }
            }
        }
    }

    public User getUser(){
        User user;
        user = dataBase.getUser(userLog.getHandle());
        return user;
    }

    /* Attempting to create new user */
    public void createUser(String name, String handle, String password, SignIn source) {
        if(handle.length() <= 3 || password.length() <= 5){
            source.setTooShortVisible();
        }
        else {
            User newUser = new User(name, handle, password);
            // this goes to database
            if (dataBase.addUser(newUser)){
                source.setSuccessVisible();
            } else {
                source.setAlreadyVisible();
            }
        }
    }

}

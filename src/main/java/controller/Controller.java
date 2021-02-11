package controller;

import model.User;
import model.UserDataBase;
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
        userLog = getLogInDataFile();
        return userLog != null;
    }

    /* getting user info from the User Log In Info file */
    private LogInInfoCollector getLogInDataFile(){
        LogInInfoCollector userLogInfoFromFile = new LogInInfoCollector();
        try (Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("src/main/resources/User Log In Info.txt")
        ))) {
            userLogInfoFromFile.setHandle(scanner.nextLine());
            userLogInfoFromFile.setPassword(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Couldn't load " + "src/main/resources/User Log In Info.txt");
        } catch (NoSuchElementException e){
            return null;
        }
        return userLogInfoFromFile;
    }

    /* checking handle and password and its next step */
    public void setLogInDataUI(String handle, String password,
    boolean isRemembered, JFrame caller, LogIn source)
            throws IOException {
        if(userLog != null) {
            System.err.println("We already have data");
        } else {
            if(handle.length() <= 3 || password.length() <= 5){
                source.setMassage(true);
            }else{
                if (dataBase.verifyUser(handle,password)){
                    source.setVisible(false);
                    caller.setVisible(true);
                    if (isRemembered){
                        System.out.println(password);
                        userLog = new LogInInfoCollector(handle,password);
                        try(FileWriter fileWriter = new FileWriter("src/main/resources/User Log In Info.txt")) {
                            fileWriter.write(handle + "\n" + password);
                        } catch (IOException e) {
                            throw new IOException("Could not open " + "src/main/resources/User Log In Info.txt");
                        }
                    }
                } else {
                    source.setMassage(true);
                }
            }
        }
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

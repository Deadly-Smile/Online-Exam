package controller;

import view.homepage.HomePage;
import view.register.LogIn;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private static LogInInfoCollector userLog = null;
    public Controller(){

    }

    public boolean isLogInDefault() {
        userLog = getLogInDataFile();
        return userLog != null;
    }

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

    public void setLogInDataUI(String handle, String password,
                               boolean isRemembered, JFrame caller, JFrame source)
            throws IOException {
        if(userLog != null) {
            System.err.println("We already have data");
        } else {
            if(handle.length() <= 2 || password.length() <= 4){
                return;
            }
            if (isRemembered){
                System.out.println(password);
                userLog = new LogInInfoCollector(handle,password);
                try(FileWriter fileWriter = new FileWriter("src/main/resources/User Log In Info.txt")) {
                    fileWriter.write(handle + "\n" + password);
                } catch (IOException e) {
                    throw new IOException("Could not open " + "src/main/resources/User Log In Info.txt");
                }
            }
            source.setVisible(false);
            caller.setVisible(true);
        }
    }

    public void createUser(String name, String handle, String password,
                           JFrame caller, JFrame source) {
        if(name.length() <= 2 || handle.length() <= 3){
            return;
        }
        SignInInfoCollector newUser = new SignInInfoCollector(name, handle, password);
        // this goes to database

        caller.setVisible(true);
        source.setVisible(false);
    }

}

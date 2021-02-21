package controller;

import model.*;
import view.homepage.HomePage;
import view.register.LogIn;
import view.register.SignIn;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private static final UserDataBase userDateBase = new UserDataBase();
    private static final ExamDataBase examDataBase = new ExamDataBase();
    private static LogInInfoCollector userLog = null;
    private static final String fileUrl = "src/main/resources/User Log In Info.txt";
    public Controller(){

    }

    public boolean isLogInDefault() {
        userLog = getLogInData();
        if(userLog == null) return false;
        return userDateBase.verifyUser(userLog.getHandle(),userLog.getPassword());
    }

    /* getting user info from the User Log In Info file */
    private LogInInfoCollector getLogInData(){
        LogInInfoCollector userLogInfoFromFile = null;
        try (Scanner scanner = new Scanner(new BufferedReader(
                new FileReader(fileUrl)
        ))) {
            userLogInfoFromFile = new LogInInfoCollector(scanner.nextLine(),scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Couldn't load " + fileUrl);
        } catch (NoSuchElementException e){
            return null;
        }
        return userLogInfoFromFile;
    }

    private void writeFile(String handle, String password) throws IOException {
        try(FileWriter fileWriter = new FileWriter(fileUrl)) {
            fileWriter.write(handle + "\n" + password);
        } catch (IOException e) {
            throw new IOException("Could not open " + fileUrl);
        }
    }

    /* checking handle and password and its next step */
    public void setLogInDataUI(String handle, String password, boolean isRemembered,
                               HomePage homePage, LogIn source, boolean isStart) throws IOException
    {
        if(handle.length() <= 3 || password.length() <= 5){
            source.setMassage(true);
        } else {
            if (userDateBase.verifyUser(handle,password)){
                userLog = new LogInInfoCollector(handle,password);
                if (isRemembered){
                    writeFile(handle, password);
                }
                source.dispose();
                if(!isStart) {
                    homePage.dispose();
                    homePage = new HomePage("Home", false);
                }
                homePage.setExams(getExams());
                homePage.setUser(getUser(handle));
                homePage.lateSetting();
                homePage.setVisible(true);
            } else {
                source.setMassage(true);
            }
        }
    }

    public User getUser(String handle){
        User user;
        user = userDateBase.getUser(handle);
        if(user == null){
            System.err.println("User " + handle + " doesn't exist");
        }
        return user;
    }

    public List<Exam> getExams(){
        return examDataBase.getAllExams();
    }

    /* Attempting to create new user */
    public void createUser(String name, String handle, String password, SignIn source) {
        if(handle.length() <= 3 || password.length() <= 5){
            source.setTooShortVisible();
        }
        else {
            User newUser = new User(name, handle, password);
            // this goes to database
            if (userDateBase.addUser(newUser)){
                source.setSuccessVisible();
            } else {
                source.setAlreadyVisible();
            }
        }
    }

    public void forgetLogInData() {
        try(FileWriter fileWriter = new FileWriter(fileUrl)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createANewExam(Exam newExam) {
        boolean returnValue = examDataBase.addExam(newExam);
        ExamInfo examInfo = new ExamInfo(newExam.getExamName(),
                                        newExam.getId(),
                                        newExam.getExamStartingTime(),
                                        newExam.getExamDuration());
        userDateBase.addExamToUser(examInfo,userDateBase.getUser(userLog.getHandle()));
        return returnValue;
    }

    public User getCurrentUser() {
        return getUser(userLog.getHandle());
    }
}

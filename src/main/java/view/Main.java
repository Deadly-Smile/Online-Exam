package view;

import view.add_exam.AddExam;
import view.attend_exam.ExamRoom;
import view.homepage.HomePage;
import view.register.LogIn;
import view.register.SignIn;

public class Main {
    public static void main(String[] args){
///*      For later use
        new LogIn("Log In");
        new SignIn("Sign In");
        new HomePage("Home Page");
        new AddExam();
//*/
        new ExamRoom();
    }
}

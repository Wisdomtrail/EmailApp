package EmailSystem;

import EmailSystem.EmailSystem;
import EmailSystem.User;

import javax.swing.*;

public class Main {
    static User user;
    static EmailSystem emailSystem = new EmailSystem();

    public static void main(String[] args){
        loginPage();
    }

    private static void loginPage(){
        String menu = """
                1.Register
                2.login
                3.exit app""";
        String userInput = input(menu);
        switch (userInput){
            case "1": registerEmail();
            case "2": loginEmail();
            case "3": exitApp();
            default:loginPage();
        }
        mainMenu();
    }

    private static void loginEmail() {

        try {
            String input = input("""
                    enter your email to login
                    enter back go to to login page""");

            if (input.equalsIgnoreCase("back")){
                loginPage();
            }
            else {
                user = emailSystem.getUserByEmail(input);
                display("welcome " + user.getName());
                mainMenu();
            }
        }
        catch (NullPointerException e){display("incorrect email");}
        loginPage();

    }

    private static void registerEmail() {
        String name = input("enter your name");
        String email = input("enter your email");
        user = new User(name,email);
        emailSystem.addUser(user);
        display("successfully created");
        loginEmail();
    }

    private static void mainMenu() {
        String menu = """
                1.send message
                2.check inbox
                3.logout
                4.exit app""";
        String userInput = input(menu);
        switch (userInput){
            case "1": sendMessage();
            case "2": checkInbox();
            case "3": logOut();
            case "4": exitApp();
            default:mainMenu();
        }
    }

    private static void logOut() {
        loginPage();
    }

    private static void exitApp() {
        display("thank you for using our app");
        System.exit(1);
    }

    private static void checkInbox() {
        try{
            int id = Integer.parseInt(input("enter message Id"));
            String body = user.getInbox().get(id-1).getBody();
            String subject = user.getInbox().get(id-1).getSubject();
            display(body + """
                """+subject);
        }catch (IndexOutOfBoundsException e){display("""
                """);}
        mainMenu();

    }

    private static void sendMessage(){
        String from = input("enter your email");
        String to = input("which email are you send message to");
        String subject = input("Subject");
        String body = input("Body");
        emailSystem.sendEmail(from,to,subject,body);
    }

    private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
    }

    private static void display(String message){
        JOptionPane.showMessageDialog(null,message);
    }
}
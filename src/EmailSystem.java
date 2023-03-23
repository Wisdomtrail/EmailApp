import Controllers.EmailController;
import Controllers.UserController;
import Dto.Request.CreateUserRequest;
import Dto.Request.EmailRequest;
import Dto.response.UserResponse;
import Dto.util.Mapper;
import Services.EmailServices;
import Services.EmailServicesImpl;
import Services.UserServices;
import Services.UserServicesImpl;
import data.models.User;

import javax.swing.*;
import java.util.Random;

public class EmailSystem {

     private static final CreateUserRequest request = new CreateUserRequest();
     private static final EmailRequest  emailRequest = new EmailRequest();
     private static final EmailController emailController = new EmailController();
     private static final UserController userController = new UserController();
     public static void main(String[] args) {
        startApp();
    }

    private static void startApp(){
        String mainMenu = """
             ###############
             ==>1.Login  <==
             ==>2.SignUp  <==
             ==>3.Exit app <==
             ###############""";
        String userInput = sout(mainMenu);
        switch (userInput){
            case "1":login();
            case "2":signUp();
            case "3":exitApp();
            default:startApp();
        }
    }

    private static void exitApp() {
         display("Thanks for using our app");
         System.exit(1);
    }

    private static void signUp() {
         String firstName = sout("enter your firstName");
         String lastName = sout("Enter your lastName");
         request.setLastName(lastName);
         request.setFirstName(firstName);
         String emailValid = """
            1.create an email address
            2.generate an Email address""";
         String input = sout(emailValid);
         switch (input) {
            case "1" -> askForEmail();
            case "2" -> generateEmail();

        }
        String phoneNumber = sout("Enter your PhoneNumber");
        request.setPhoneNumber(phoneNumber);

        userController.register(request);
        info();
        webPage();
    }

    private static void askForEmail() {
        String email = sout("Create an email Address");
        while (!Mapper.isValidEmail(email)){
            email = sout("Create an email Address");
            display("email must look like this 'sunday01@gmail.com'");
        }
        request.setEmail(email);
    }

    private static void generateEmail() {
         String firstName = EmailSystem.request.getFirstName();
         String lastName = EmailSystem.request.getLastName();
         String email = firstName+lastName+ generateNumbers()+"@gmail.com";
         request.setEmail(email);
    }

    private static int generateNumbers() {
        Random random = new Random();
        return random.nextInt(90)+10;
    }

    private static void info() {
         display(userController.login(request));
    }

    private static void webPage() {
        String webPage = """
            1. Send mail
            2. Check mail
            3. Delete mail
            4. Mail size
            5. delete Account!!
            6. LogOut""";
        String input = sout(webPage);
        switch (input) {
            case "1" -> sendMail();
            case "2" -> checkMail();
            case "3" -> deleteMail();
            case "4" -> mailSize();
            case "5" -> deleteUser();
            case "6" -> startApp();
            default -> {
                display("Invalid input. Please try again.");
                webPage();
            }
        }
    }

    private static void deleteUser() {
         try {
             int id = Integer.parseInt(sout("enter your id"));
             userController.deleteUser(id);
         }
         catch (IllegalArgumentException e){display("Invalid id");}
    }


    private static void sendMail(){
         String recipientEMail = sout("Enter the Email of the User you want to send a mail to");
         if (userController.findByEmail(recipientEMail) == null){
             display("user does not exist");
             webPage();
         }
         String subject = sout("Enter the subject of your mail");
         String body = sout("Enter the body of your mail");
         emailRequest.setSubject(subject);
         emailRequest.setBody(body);
         emailRequest.setReceiver(recipientEMail);
         display("sent");
         display(emailController.sendMail(emailRequest));
         webPage();
    }

    private static void checkMail(){
         int id = Integer.parseInt(sout("enter mail id"));
         display(emailController.checkMail((id)));
         webPage();
    }


    private static void deleteMail(){
         try {
             int id = Integer.parseInt(sout("enter mail id"));
             emailController.deleteMail(id);
             display("successfully deleted");
             webPage();
         }
         catch (IllegalArgumentException e){display("not found");}
         webPage();
    }

    private static void mailSize(){
         display(String.valueOf(emailController.mailSize()));
         webPage();
    }

    private static void login(){
         String email = sout("Enter your email");
         User user = userController.findByEmail(email);
         if (user == null) {
             display("You have not signed Up please sign up");
             startApp();
         }
         else {
             display("welcome " + user.getFirstName());
             webPage();
         }
    }

    private static String sout(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

}
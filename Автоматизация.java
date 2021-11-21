import java.io.*;
import java.lang.*;
import java.util.*; 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
public static void main(String[] args){
        HashMap<String, String> passportsAndNames = new HashMap<>();
        Auth auth = new Server(passportsAndNames);
        auth.Registrate();
        auth.Sign_In();
    }
}

class Auth {
    HashMap<String, String> passportsAndNames;
    
    public Auth(HashMap<String, String> passportsAndNames){
        this.passportsAndNames = passportsAndNames;
    }
    
    public void Registrate(){
        Pattern pattern1 = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Pattern pattern2 = Pattern.compile("^\\+?[0-9\\-\\s]*$");
        if (passportsAndNames.isEmpty()) {
            System.out.print("Вы ещё не зарегестрированы!\n");
            Scanner sc = new Scanner(System.in);
            String login, password;
            
            System.out.print("Введите почту или телефон: ");
            login = sc.nextLine();
            Matcher matcher1 = pattern1.matcher(login);
            Matcher matcher2 = pattern2.matcher(login);
            
            boolean matches1 = matcher1.matches();
            boolean matches2 = matcher2.matches();
            if (matches1 == true) {
                System.out.print("Введите пароль: ");
                password = sc.nextLine();
            
                this.passportsAndNames.put(login, password);
                System.out.print(this.passportsAndNames);
            }
            else if (matches2 == true){
                System.out.print("Введите пароль: ");
                password = sc.nextLine();
            
                this.passportsAndNames.put(login, password);
                System.out.print(this.passportsAndNames);
            } 
            else { System.out.println("Ошибка"); }
        }
        else {System.out.println("Вы уже зарегестрированы");}
    }
        
        public void Sign_In(){
            Pattern pattern1 = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
            Pattern pattern2 = Pattern.compile("^\\+?[0-9\\-\\s]*$");
            Scanner sc = new Scanner(System.in);
            String login, password;
            
            System.out.print("Введите почту или телефон: ");
            login = sc.nextLine();
            Matcher matcher1 = pattern1.matcher(login);
            Matcher matcher2 = pattern2.matcher(login);
            
            boolean matches1 = matcher1.matches();
            boolean matches2 = matcher2.matches();
            if (matches1 == true) {
                System.out.print("Введите пароль: ");
                password = sc.nextLine();
                for (String keys : this.passportsAndNames.keySet()) {
                    String key = keys;
                }
                for (String values : this.passportsAndNames.values()) {
                    String value = values;
                }
                if (login == key && password == value){
                    System.out.print("Вход успешно выполнен!");
                } else {System.out.print("Ошибка входа");}
            }
            else if (matches2 == true){
                System.out.print("Введите пароль: ");
                password = sc.nextLine();
                for (String keys : this.passportsAndNames.keySet()) {
                    String key = keys;
                }
                for (String values : this.passportsAndNames.values()) {
                    String value = values;
                }
                if (login == key && password == value){
                    System.out.print("Вход успешно выполнен!");
                } else {System.out.print("Ошибка входа");}
            } 
            else { System.out.println("Ошибка"); }
        }
    }
    
   class Server extends Auth{
          public Server(HashMap<String, String> passportsAndNames) {
              super(passportsAndNames);
          }
    } 

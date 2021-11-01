import java.io.*;
import java.lang.*;
import java.util.*; 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
public static void main(String[] args){
        HashMap<String, String> passportsAndNames = new HashMap<>();
        Add hub = new Add(passportsAndNames);
        hub.sign_in();
        hub.sign_in();
    }
}

class Hublist {
    HashMap<String, String> passportsAndNames;
    
    public Hublist(HashMap<String, String> passportsAndNames){
        this.passportsAndNames = passportsAndNames;
    }
    
    public void sign_in(){
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
        else {
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
}
    
   class Add extends Hublist{
          public Add(HashMap<String, String> passportsAndNames) {
              super(passportsAndNames);
          }
    } 

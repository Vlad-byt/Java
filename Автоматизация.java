import java.io.*;
import java.lang.*;
import java.util.*; 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashMap<String, byte []> reg = new HashMap<>();
        Server server = new ServerImpl(reg);
        Auth auth = new AuthImpl(reg);
        auth.Registrate();
        auth.SignIn(server.TakeAccount());
        auth.ChangePassword(server.TakeAccount());
        auth.DeleteAccount(server.TakeAccount());
        server.Display();
}
}

class Auth {
    HashMap<String, byte []> reg;
    
    public Auth(HashMap<String, byte []> reg){
        this.reg = reg;
    }
    
     public void Registrate(){
         Pattern pattern1 = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
         Server server = new ServerImpl(reg);
         
             System.out.println("Хотите зарегестрироваться? Если да напишите Y");
             Scanner sc = new Scanner(System.in);
             String login, password, answer;
             answer = sc.nextLine();
             
             if (answer.toUpperCase().equals("Y")) {
                  System.out.println("Введите свой email: ");
                  login = sc.nextLine();
                  Matcher matcher1 = pattern1.matcher(login);
                  boolean matches1 = matcher1.matches();
             
                   if (matches1 == true) {
                   System.out.println("Введите пароль: ");
                   password = sc.nextLine();
                   byte[] byt = password.getBytes();
                   this.reg.put(login, byt);
                   server = new ServerImpl(reg);
                   server.Display();
                } else {System.out.println("Почта не найдена!");}
         
         }
             else {
                  System.out.println("Имеете учётную запись? Пройдите регистрацию: ");
                  Auth auth = new AuthImpl(reg);
                  auth.SignIn(server.TakeAccount());
             }
     }
     
     public void SignIn(HashMap<String, byte []> log){
         Scanner sc = new Scanner(System.in);
         String login, password;
         System.out.println("Введите логин: ");
         login = sc.nextLine();
         System.out.println("Введите пароль: ");
         password = sc.nextLine();
         try {
              byte [] key = reg.get(login);
              String string = new String(key);
           if (string.equals(password)) {
               System.out.println("Добро пожаловать!");
             } else {System.out.print("Неверный логин или пароль!");}
             
         }
         catch (Exception exception) {
             System.out.println("Неверный логин или пароль!");
         }
        
    }
     
     public void ChangePassword(HashMap<String, byte []> dict){
         Scanner sc = new Scanner(System.in);
         String password;
         System.out.println("Введите старый пароль: ");
         password = sc.nextLine();
         
         Set<String> keys = dict.keySet();
         ArrayList<byte []> values = new ArrayList<>(dict.values());
         
         Iterator<String> it = keys.iterator();
         Iterator<byte []> it2 = values.iterator();
         
         while(it.hasNext()){
           String key = it.next();
           
           while(it2.hasNext()){
           byte[] value = it2.next();
           String string = new String(value);
           
           if (string.equals(password)){
               System.out.println("Введите новый парль: ");
               String newpassword = sc.nextLine();
               byte[] byt = newpassword.getBytes();
               dict.put(key, byt);
               Server server = new ServerImpl(dict);
               System.out.println("Пароль успешно изменён!");
               break;
           }
           else {System.out.println("Неверный старый пароль!"); break;}
             
            }
         }
     }
     
     public void DeleteAccount(HashMap<String, byte []> dict){
         Scanner sc = new Scanner(System.in);
         Server server = new ServerImpl(dict);
         String login;
         System.out.println("Введите логин: ");
         login = sc.nextLine();
         try {
             Set<String> keys = dict.keySet();
             Iterator<String> it = keys.iterator();
             while(it.hasNext()){
                 String key = it.next();
                 if (key.equals(login)) {
                      server.Remove(key);
                      System.out.println("Запись успешно удалена!");
                 }
         }
         }
         catch (Exception exception) {
             System.out.println("Неверный логин!");
         }
    }
}

class AuthImpl extends Auth {
    
    public AuthImpl(HashMap<String, byte []> reg) {
              super(reg);
          }
}


class Server {
    HashMap<String, byte []> reg;
    
    public Server(HashMap<String, byte []> reg){
        this.reg = reg;
    }
    
    public boolean IsNull(){
        if (this.reg.isEmpty()){
            return false;
        } else { return true;}
    }
    
    public HashMap<String, byte []> TakeAccount(){
        return this.reg;
    }
    
     public void Display(){
         if (this.reg.isEmpty()){ 
             System.out.println("Создайте аккаунт!");
         }
    else {
        Set<String> keys = this.reg.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
           String key = it.next();
           System.out.println("Логин: " + key + " Пароль: *****");
        }
    }
        
}

    public void Remove(String name){
        this.reg.remove(name);
    }
}

class ServerImpl extends Server {
   /*
    private static Server _instance = null;

    public static Server getInstance() {
        if (_instance == null)
            _instance = new ServerImpl();
        return _instance;
    }*/
    public ServerImpl(HashMap<String, byte []> reg) {
              super(reg);
          }
}

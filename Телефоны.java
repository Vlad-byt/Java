import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Math.*;


public class Main
{
public static void main(String[] args) {
String email = "vlad_ste@mail.ru";
String telephone_number = "+7 926 122 96 39";
Coder coder = new Coder();
int code = coder.Send_code();
Auth auth = new Auth(email, telephone_number, code);
auth.Check_Login();
auth.Check_Code();

}
}

class Coder {
   public static int Send_code(){
       int random_number = 000000 + (int) (Math.random() * 999999);
       return random_number;
   }
}

class Auth {
String email;
String telephone_number;
int code;

public Auth(String email, String telephone_number, int code) {
this.email = email;
this.telephone_number = telephone_number;
this.code = code;
}

public void Check_Login() {
Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
Matcher matcher = pattern.matcher(this.email);
Pattern pattern1 = Pattern.compile("^\\+?[0-9\\-\\s]*$");
Matcher matcher1 = pattern.matcher(this.telephone_number);

boolean matches = matcher.matches();
boolean matches1 = matcher.matches();

if (matches == true) {
System.out.println(matches);
}
if (matches1 == true){
System.out.println(matches1);
} else { System.out.println("Ошибка"); }
}

public void Check_Code() {
    if (String.valueOf(this.code).length() == 6){
       System.out.println("Correct!");
    }
    else {System.out.println("Uncorrect!");}
}

}

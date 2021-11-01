public class Main {
    
}
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main
{
public static void main(String[] args) {
String email = "vlad_ste@mail.ru";
String telephone_number = "+7 926 122 96 39";
int code = 1231;
Author author = new Author(email, telephone_number, code);
author.Check_Login();

}
}

class Author {
String email;
String telephone_number;
int code;


public Author(String email, String telephone_number, int code) {
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

} 

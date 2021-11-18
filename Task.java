

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
       Map<String, Integer> map = new HashMap<>();
       map.put("Пётр", 0);
       map.put("Ваня", 0);
       map.put("Кирилл", 0);
       Scanner sc = new Scanner(System.in);
       
       for(Map.Entry<String, Integer> entry: map.entrySet()) {
           String key = entry.getKey();
           System.out.println("введите оценку");
           
           if (sc.hasNextInt()) {
           int number = sc.nextInt();
           map.put(key, number);
           } 
           else {
               System.out.println(map);
           }

           
       }
    }
}

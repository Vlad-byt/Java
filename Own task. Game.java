

/*

Игра угадай число. В диапозоне от -10 до 10 игрок должен угадать число. 
У него есть три попытки.
Если число не угадано, то программа должна подсказать больше нужно или меньше, а также знак числа.
Неверно введённый символ также должнен отнимать попытки.

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		String symbol;
        int system_number = 0;
        int user_number = 0;
        int i = 3;

		while(system_number == 0) {
			system_number = (int) (Math.random() * 10) + -10;
		}
        System.out.println(system_number);
        while((user_number != system_number) && (i != 0))  {
			i--;
			System.out.print("\ninput your number: ");
            Scanner input = new Scanner(System.in);
            
			if(input.hasNextInt()) {
				user_number = input.nextInt();
				if(user_number == system_number) {
					System.out.println("You win!");
					System.out.println("^-^");
				} else {
					if (i != 0) {
						System.out.println("Try again:");
						if(user_number>0 && system_number < 0) {
							System.out.println("Need negative number");
						} else if(user_number< 0 && system_number > 0) {
							System.out.println("Need positive number");
						}
						if(system_number < user_number) {
							System.out.println("Need less");
						} else {
							System.out.println("Need more");
						}
					} else {
						System.out.print("you lose, it is:");
						System.out.print(system_number);
						System.out.println("(×﹏×)");
					}
				}
			} else {
			System.out.println("Unccorret input");
			}
        }
    }
}
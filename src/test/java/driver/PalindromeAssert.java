package driver;

import java.util.Scanner;

public class PalindromeAssert {

        public static void main(String args[]){
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            String reverseWord = new StringBuilder(word).reverse().toString();

            if(word.equals(reverseWord) ){
                System.out.println("Cлово " + word + " является палиндромом");
            }
            else{
                System.out.println("Cлово " + word + " не является палиндромом");
            }

        }
}


import java.util.Random;
import java.util.Scanner;

public class Password {
    static int numberLetters;
    static boolean hasLowerCase;
    static boolean containsNumber;
    static boolean containsSpecial;

    static char[] tempPassword;
    public Password(int numberLetters, boolean hasLowerCase, boolean containsNumber, boolean containsSpecial){
         this.numberLetters = numberLetters;
         this.hasLowerCase = hasLowerCase;
         this.containsNumber = containsNumber;
         this.containsSpecial = containsSpecial;
    }

    public char[] charactersReq(int numberLetters){
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        tempPassword = new char[numberLetters];
        for(int i = 0; i < tempPassword.length; i++){
            Random random = new Random();
            int x = random.nextInt(numberLetters + 1);
            tempPassword[i] = alphabet[x];
        }
        return tempPassword;

    }

    public char[] toLowerCase(boolean haslowerCase) {

        if (haslowerCase) {
            Random random = new Random();
            int numberOfUpperCase = random.nextInt(numberLetters - 1);
            for (int i = 0; i < numberOfUpperCase; i++) {
                int indexNumber = random.nextInt(tempPassword.length);
                tempPassword[indexNumber] = Character.toLowerCase(tempPassword[indexNumber]);
            }

        }
        return tempPassword;
    }

    public char[] addNumbers(boolean containsNumber){
        if (containsNumber) {
            Random random = new Random();
            int numberOfNumbers = random.nextInt(numberLetters - 1);
            for (int i = 0; i < numberOfNumbers; i++) {
                int indexNumber = random.nextInt(tempPassword.length);
                String number = String.valueOf(random.nextInt(9));
                tempPassword[indexNumber] = number.charAt(0);
            }

        }
        return tempPassword;

    }

    public char[] addSpecial(boolean containsSpecial){
        if (containsSpecial) {
            Random random = new Random();
            int numberOfSpecial = random.nextInt(numberLetters - 1);
            for (int i = 0; i < numberOfSpecial; i++) {
                int indexNumber = random.nextInt(tempPassword.length);
                String symbol = "~`!@#$%^&*()-_+={}[]|:<>.?/";
                int randomSymbol = random.nextInt(symbol.length()-1);
                tempPassword[indexNumber] = symbol.charAt(randomSymbol);
            }

        }
        return tempPassword;
    }

public static void main(String[] args){


        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to PasswordGenerator\n");

        System.out.println("How many symbols Your password needs ?");
        numberLetters = scan.nextInt();

        System.out.println("Do you need lower case letters ? yes/no");
        String answer = scan.next();
        if(answer.equalsIgnoreCase("yes")) {
            hasLowerCase = true;
        }
        else{
            hasLowerCase = false;
        }

        System.out.println("Do you need numbers ? yes/no");
        String answer2 = scan.next();
        if(answer2.equalsIgnoreCase("yes")) {
            containsNumber = true;
        }
        else{
            containsNumber = false;
        }

        System.out.println("Do you need special symbols ? yes/no");
        String answer3 = scan.next();
        if(answer3.equalsIgnoreCase("yes")) {
            containsSpecial = true;
        }
        else{
            containsSpecial = false;
        }

        Password password = new Password(numberLetters, hasLowerCase, containsNumber, containsSpecial);

        password.charactersReq(numberLetters);
        password.toLowerCase(hasLowerCase);
        password.addNumbers(containsNumber);
        password.addSpecial(containsSpecial);

        System.out.println("Your password: \n");
        System.out.println(tempPassword);


}
}


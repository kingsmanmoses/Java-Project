package com.company;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
//        This is for the user to select which binary operation he/she wants to perform
        System.out.printf("Choose the base you want to convert to:\r\n");
        System.out.printf("1: Convert any integer to binary.\r\n");
        System.out.printf("2: Convert any binary number to decimal.\r\n");
        System.out.printf("3: Convert any decimal number to binary.\r\n");
        System.out.printf("4: Convert any decimal number to hexadecimal.\r\n");
        System.out.printf("5: Convert any hexadecimal number to decimal.\r\n");
        System.out.printf("6: Convert any binary number to hexadecimal.\r\n");
        System.out.printf("7: Convert any hexadecimal number to binary.\r\n");
        System.out.printf("8: To perform binary Addition of two binary numbers.\r\n");
        System.out.printf("Now choose:");
        int math = user.nextInt();
        switch (math) {
            case 1:
//                This is to convert integer values to binary
                System.out.printf("Integer to binary:\r\n");
                int num1 = user.nextInt();
                // Function to print integer to binary using inbuilt toBinaryString method
                System.out.println(Integer.toBinaryString(num1));
                break;
            case 2:
//                This is to convert binary to decimal
                System.out.printf("Binary to decimal format:\r\n");
                int no1 = user.nextInt();
                int num = no1;
                int dec_value = 0;

                int base = 1;
                int temp = num;
                while (temp > 0) {
                    int last_digit = temp % 10;
                    temp = temp / 10;

                    dec_value += last_digit * base;

                    base = base * 2;
                }
                System.out.println(dec_value);
                break;
            case 3:
//                Is the same as case 1
//                in converting any number to binary
//                you could also use the same method to convert decimal to binary
                System.out.printf("decimal to binary:\r\n");
                System.out.printf("You can still use the same method in case 1 to convert a decimal value to binary:\r\n");
                break;
            case 4:
//                This is to convert decimal to hexadecimal
                System.out.printf("Decimal to Hexadecimal:\r\n");
                int x = user.nextInt();
                // Function to print decimal to hexadecimal using inbuilt toHexString method
                System.out.println(Integer.toHexString(x));
                break;
            case 5:
//                This is to convert hexadecimal to decimal
                System.out.printf("Hexadecimal to decimal:\r\n");
                String n = user.next();
                // Function to print hexadecimal to decimal using inbuilt parseInt method
                System.out.println(Integer.parseInt(n, 16));
                break;
            case 6:
//                This is to convert binary to hexadecimal
                System.out.printf("binary to hexadecimal:\r\n");
                long binary = user.nextInt();
                int decimalNumber = 0, i = 0;
                // loop to extract digits of the binary
                while (binary > 0) {
                    // extracting each digit of the binary by getting the remainder of division by 10 and multiplying it by increasing integral powers of 2
                    decimalNumber += Math.pow(2, i++) * (binary % 10);
                    // update condition of dividing the binary by 10
                    binary /= 10;
                }
                // converting the integer to the desired hex string using toHexString() method
                String hexNumber = Integer.toHexString(decimalNumber);
                // converting the string to uppercase for uniformity
                hexNumber = hexNumber.toUpperCase();
                System.out.println(hexNumber);
                break;
            case 7:
//                This is to convert hexadecimal to binary
                System.out.printf("hexadecimal to binary:\r\n");
                String hex = user.next();
                String binary2 = "";
                hex = hex.toUpperCase();
                // initializing the HashMap class
                HashMap<Character, String> hashMap = new HashMap<Character, String>();
                // storing the key value pairs
                hashMap.put('0', "0000");
                hashMap.put('1', "0001");
                hashMap.put('2', "0010");
                hashMap.put('3', "0011");
                hashMap.put('4', "0100");
                hashMap.put('5', "0101");
                hashMap.put('6', "0110");
                hashMap.put('7', "0111");
                hashMap.put('8', "1000");
                hashMap.put('9', "1001");
                hashMap.put('A', "1010");
                hashMap.put('B', "1011");
                hashMap.put('C', "1100");
                hashMap.put('D', "1101");
                hashMap.put('E', "1110");
                hashMap.put('F', "1111");

                int a;
                char ch;
                // loop to iterate through the length of the Hexadecimal String
                for (a = 0; a < hex.length(); a++) {
                    ch = hex.charAt(a);
                    // checking if the character is present in the keys
                    if (hashMap.containsKey(ch))
                        // adding to the Binary Sequence the corresponding value of the key
                        binary2 += hashMap.get(ch);
                    else {
                        binary2 = "Invalid Hexadecimal String";
                        System.out.println(binary2);
                    }
                }
                System.out.println(binary2);
                break;
            case 8:
//                This is Perform Binary Addition of two binary number
                System.out.printf("Binary Addition of two binary number:\r\n");
                System.out.printf("Add the first number:\r\n");
                String b = user.next();
                System.out.printf("Add the second number:\r\n");
                String c = user.next();
                String result = "";
                int s = 0;
                // Traverse both strings starting from last characters
                int k = b.length() - 1, j = c.length() - 1;
                while (k >= 0 || j >= 0 || s == 1)
                {
                    // Compute sum of last digits and carry
                    s += ((k >= 0)? b.codePointAt(k) - '0': 0);
                    s += ((j >= 0)? c.codePointAt(j) - '0': 0);

                    // If current digit sum is 1 or 3, add 1 to result
                    result = (char)(s % 2 + '0') + result;
                    // Compute carry
                    s /= 2;
                    // Move to next digits
                    k--; j--;
                }
                System.out.println(result);
                break;
        }
    }
}

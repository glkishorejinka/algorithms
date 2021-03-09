package com.algorithms.secondanswers.strings;

public class RotationalCipher {

    String rotationalCipher(String input, int rotationFactor) {
        char[] inputChars = input.toCharArray();
        for(int i=0; i<inputChars.length; i++){
            int intChar = inputChars[i];
            if(intChar >= 97 && intChar <= 122){
                intChar = intChar + rotationFactor%26;
                if(intChar > 122) intChar = intChar - 26;
            }else if(intChar >= 65 && intChar <= 90){
                intChar = intChar + rotationFactor%26;
                if(intChar > 90) intChar = intChar - 26;
            }else if(inputChars[i] >= 48 && intChar <= 57){
                intChar = intChar + rotationFactor%10;
                if(intChar > 57) intChar = intChar - 10;
            }
            inputChars[i] = (char) intChar;
        }
        return new String(inputChars);
    }

    public void run() {
        //TEST CASE 1
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);
        //TEST CASE 2
        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);
    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }

    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        String rightTick = "CORRECT";
        String wrongTick = "WRONG";
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }
}

package com.example.dmitriy.myapplication;

/**
 * Created by dmitriy on 1/27/18.
 */
public class Morse{
    private String text;
    private String morseText;
    public String getText(){
        return this.text;
    }
    public void setText(String text){
        this.text = text;
    }
    public String MorseImp(String str){
        morseText = "";
        for (int i = 0; i < str.length();i++){
            String temp = charToMorse(str.charAt(i));
            if( i != str.length() -1){
                morseText = morseText + temp + " ";
            }else{
                morseText = morseText+temp;
            }
        }
//        for (char c : str.toCharArray()){
//            String temp = charToMorse(c);
//            morseText = morseText +temp +" ";
//        }
        return morseText;
    }
    public String getMorse(){
        return morseText;
    }
    public String charToMorse(char c) {
        switch(c) {
            case 'a': case 'A':
                return ".-";
            case 'b': case 'B':
                return "-...";
            case 'c': case 'C':
                return "-.-.";
            case 'd': case 'D':
                return "--..";
            case 'e': case 'E':
                return ".";
            case 'f': case 'F':
                return "..-.";
            case 'g': case 'G':
                return "--.";
            case 'h': case 'H':
                return "....";
            case 'i': case 'I':
                return "..";
            case 'j': case 'J':
                return ".---";
            case 'k': case 'K':
                return "-.-";
            case 'l': case 'L':
                return ".-..";
            case 'm': case 'M':
                return "--";
            case 'n': case 'N':
                return "-.";
            case 'o': case 'O':
                return "---";
            case 'p': case 'P':
                return ".--.";
            case 'q': case 'Q':
                return "--.-";
            case 'r': case 'R':
                return ".-.";
            case 's': case 'S':
                return "...";
            case 't': case 'T':
                return "-";
            case 'u': case 'U':
                return "..-";
            case 'v': case 'V':
                return "...-";
            case 'w': case 'W':
                return ".--";
            case 'x': case 'X':
                return "-..-";
            case 'y': case 'Y':
                return "-.--";
            case 'z': case 'Z':
                return "--..";
            case '0':
                return "-----";
            case '1':
                return ".----";
            case '2':
                return "..---";
            case '3':
                return "...--";
            case '4':
                return "....-";
            case '5':
                return ".....";
            case '6':
                return "-....";
            case '7':
                return "--...";
            case '8':
                return "---..";
            case '9':
                return "----.";
            case '.':
                return ".-.-.-";
            case '?':
                return "..--..";
            case ',':
                return "--..--";
            case ' ':
                return " ";
            default:
                return null;
        }

    }
}


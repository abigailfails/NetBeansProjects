package com.github.abigailfails.treegenerator;

public class TreeGenerator {

    private static void outputTree(int numberOfLines){
        //TODO: find more efficient solution with "String s = new String(new char[n]).replace("\0", s))"
        for(int i=1; i<=numberOfLines; i++){
            String output = "";
            int starNumber = i+(i-1);
            int whitespace = ((numberOfLines + (numberOfLines-1)) - starNumber)/2;
            for(int j=0; j<whitespace; j++) {
                output += " ";
            }
            for(int j=0; j<starNumber; j++) {
                output += "*";
            }
            for(int j=0; j<whitespace; j++) {
                output += " ";
            }
            System.out.println(output);
        }

    }

    public static void main(String[] args) {
        outputTree(5);
    }
    
}

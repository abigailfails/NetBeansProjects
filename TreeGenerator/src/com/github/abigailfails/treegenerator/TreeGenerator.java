package com.github.abigailfails.treegenerator;

public class TreeGenerator {

    private static void outputTree(int numberOfLines, String treeCharacter){
        for(int i=1; i<=numberOfLines; i++){
            String output = "";
            int starNumber = i+(i-1);
            int whitespace = ((numberOfLines + (numberOfLines-1)) - starNumber)/2;
            String whitespaceStr = new String(new char[whitespace]).replace("\0", " ");
            output = whitespaceStr + new String(new char[starNumber]).replace("\0", "*") + whitespaceStr;
            System.out.println(output);
        }

    }

    public static void main(String[] args) {
        outputTree(5,"*");
    }
    
}

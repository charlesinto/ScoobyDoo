/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoobydoo;


import java.util.regex.Pattern;

/**
 *
 * @author Charles 30th April,2018
 */
public class Translator {
    private String mWord;
    private String[] mArray;
    //get the word user inputs
    public Translator(String word){
        this.mWord = word;
    }
    //splits the word into array of indvidual word, eg my name = [my, name]
    private  void splitWord(){
        this.mArray = mWord.split(" ");
    }
    //performs scoobyDoo 
    public String scoobyWord(){
        String  w = "";
        int count = 0;
        StringBuilder s = new StringBuilder();
        String scoobySays = "";
        this.splitWord();
        //ignore case and test for vowels
        String pattern = "(?i)[aeiou]";
        //pattern for vowel
        Pattern tester = Pattern.compile(pattern);
        try{
            //for each elemeny in array eg [my, name, is, charles]
            for (int k = 0 ; k < this.mArray.length; k++){
                String fragment = this.mArray[k];
                count = 0;
                //loop through each subb element
                for(int i = 0 ; i < fragment.length(); i++){
                    //when the first vowel is met in the array break
                    if((tester.matcher("" +fragment.charAt(i)).matches())){
                        break;
                    }else{
                        //counts the number of cosonants met until the first vowel
                        count++;
                    }
                }
                if(count > 0){
                    //obtain substring from the first vowel to the last element in the word
                    w = fragment.substring(count, fragment.length());
                    //initialize a string builder containing the sub string
                    s = new StringBuilder(w);
                    //inserts r to the 0th position in the substring
                    s.insert(0, "r");
                }else{
                    //if word contains all vowels just return the word
                    s = new StringBuilder(fragment);
                }
                //concatenats each word in the array back to a string
                scoobySays = scoobySays + " " + s;
            }
       }catch(NullPointerException e){
           System.out.println(e.getMessage());
       }
        //returns the scoobDooed word
       return  scoobySays;
    }
}

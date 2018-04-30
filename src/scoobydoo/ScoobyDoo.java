/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoobydoo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kazom
 */
public class ScoobyDoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        instructions();
      
      Scanner sc = new Scanner(System.in);
      String userResponse;
      
      try{ 
          promptUser();
          userResponse = sc.nextLine();
          while(!userResponse.equalsIgnoreCase("q")){
               Translator translate = new Translator(userResponse);
               System.out.print("Scooby says: ");
               System.out.println(translate.scoobyWord());
               promptUser(); 
               userResponse = sc.nextLine();
          }
          
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
       
    }
    public static void instructions(){
        System.out.println("Welcome to Scooby Doo\n scooby doo is going to replace all word you give it \n"
                + "with r until it mets the first vowel in the word\n"
                + "Have fun");
    }
    public static void promptUser(){
        System.out.println("Enter word or sentence. Q to quit: ");
    }
}

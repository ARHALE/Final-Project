/*
* Final Project
* Group #2: Adam James, Anthony Hale, Najee Robinson
* Date: 4/19/21
* This program is a java swing GUI that lets the user play a trivia game and earn points based on correct answers
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/*
* this method runs the trivia game
*/

class Main {
 public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new Game();
     }
   });
 }
} 
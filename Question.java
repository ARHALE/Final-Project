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


//create question class
class Question {
  //instance variables
  String txtQuestion;
  String txtAnswer1;
  String txtAnswer2;
  String txtAnswer3;
  String txtAnswer4;
  String txtAnswer5;
  int intAnswerWin;
  int intQuestionPoints;

  //question constructor
  Question (String atxtQuestion, String atxtAnswer1, String atxtAnswer2, String atxtAnswer3, String atxtAnswer4, int aintAnswerWin, int aintQuestionPoints) {
    txtQuestion = atxtQuestion;
     txtAnswer1 = atxtAnswer1;
    txtAnswer2 = atxtAnswer2;
    txtAnswer3 = atxtAnswer3;
    txtAnswer4 = atxtAnswer4;
    intAnswerWin = aintAnswerWin;
    intQuestionPoints = aintQuestionPoints;
  }

  //accessor methods
  String getQuestion() {
    return txtQuestion;
  }

  String getAnswer1() {
    return txtAnswer1;
  }

  String getAnswer2() {
    return txtAnswer2;
  }

  String getAnswer3() {
    return txtAnswer3;
  }

  String getAnswer4() {
    return txtAnswer4;
  }

  int getAnswerWin() {
    return intAnswerWin;
  }

  int getPoints() {
    return intQuestionPoints;
  }
}
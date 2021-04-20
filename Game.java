
  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;



public class Game implements ActionListener{



//declares a buttons for: submitting, continuing, 
JButton btnSubmit;
JButton btnNext;
JButton btnName;
JButton btnExit;
JRadioButton btnAnswer1; 
JRadioButton btnAnswer2; 
JRadioButton btnAnswer3; 
JRadioButton btnAnswer4; 
JLabel lblName, lblWelcome, lblPrompt, lblResponse, lblTotalScore;
JTextField nameField;
ButtonGroup group;
JPanel pnl1;
JPanel pnl2;
JPanel pnl3;
JPanel pnlOuter;



  
int intScore;

//This is the declaration and initialization of the questions ArrayList
ArrayList <Question> triviaQuestions = new ArrayList<Question>();

/*
This Game method reads the data from the trivia.txt to create the game.The method sets up the frame with the labels and buttons that allow the user to play.
*/
Game(){

intScore =0; 


String filename;
FileReader myFile;
/*
* This reads through the Trivia.txt file to get the trivia questions and answer choices and set them equal to their respective variables
*/
filename = "Trivia.txt";
String question = "", txtAnswer1 = "", txtAnswer2 = "", txtAnswer3 = "", txtAnswer4 = "", intAnswerWin = "", intPoints = "";
   

      try 
      {
        myFile = new FileReader(filename);
        BufferedReader reader = new BufferedReader(myFile);
     
           
       while (reader.ready()) //reads through the lines and sets the question and answer choices
        {
          question = reader.readLine();
          txtAnswer1 = reader.readLine();
          txtAnswer2 = reader.readLine();
          txtAnswer3 = reader.readLine();
          txtAnswer4 = reader.readLine();
          intAnswerWin = reader.readLine();
          intPoints = reader.readLine();
       
        
       
          Question theQuestion = new Question(question, txtAnswer1, txtAnswer2, txtAnswer3, txtAnswer4, Integer.parseInt(intAnswerWin), Integer.parseInt(intPoints));

          triviaQuestions.add(theQuestion);
            
       } 
       
       reader.close();
       } 

       catch (IOException exception) {
         System.out.println("An error occurred: " + exception);}

      FileWriter toWriteFile; 
    try
      { 
        toWriteFile = new FileWriter("Score.txt"); 
        BufferedWriter output = new BufferedWriter(toWriteFile); 

        output.flush();
        output.close(); 
      } 
      catch (IOException excpt) 
      { 
        excpt.printStackTrace(); 
      }

    
    try
      { 
        toWriteFile = new FileWriter("Score.txt"); 
        BufferedWriter output = new BufferedWriter(toWriteFile); 
        output.write("player Score =" + intScore);
        output.newLine();

        output.flush();
        output.close(); 
      } 
      catch (IOException excpt) 
      { 
        excpt.printStackTrace(); 
      }
      
/*
* This sets up the frame layout and adds the design specifications
*/
JFrame frame = new JFrame("Slogan Trivia");
  frame.setUndecorated(true);
  frame.setResizable(true);
  frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
  frame.setLayout(new FlowLayout());
  frame.setVisible(true); 

JPanel pnl1 = new JPanel(new FlowLayout());
pnl1.setPreferredSize(new Dimension(700,100));
pnl1.setBackground(Color.GRAY);
JPanel pnl2 = new JPanel();
pnl2.setPreferredSize(new Dimension(500,30));
pnl2.setBackground(Color.GRAY);
JPanel pnl3 = new JPanel();
pnl3.setPreferredSize(new Dimension(500,30));
pnl3.setBackground(Color.GRAY);


JPanel pnlOuter = new JPanel(new BorderLayout());
 pnlOuter.add(pnl1, BorderLayout.NORTH);
 pnlOuter.add(pnl2,  BorderLayout.CENTER);
 pnlOuter.add(pnl3, BorderLayout.SOUTH);

 Container contentPane = frame.getContentPane();
 contentPane.add(pnlOuter);
 contentPane.setBackground(Color.GRAY);
 frame.pack();
  

btnAnswer1 = new JRadioButton(triviaQuestions.get(0).getAnswer1());
btnAnswer2 = new JRadioButton(triviaQuestions.get(0).getAnswer2());
btnAnswer3 = new JRadioButton(triviaQuestions.get(0).getAnswer3());
btnAnswer4 = new JRadioButton(triviaQuestions.get(0).getAnswer4());

/*
* these setting are used to design the look of the GUI
*/
btnAnswer1.setBackground(Color.GRAY);
btnAnswer2.setBackground(Color.GRAY);
btnAnswer3.setBackground(Color.GRAY);
btnAnswer4.setBackground(Color.GRAY);

btnAnswer1.setForeground(Color.WHITE);
btnAnswer2.setForeground(Color.WHITE);
btnAnswer3.setForeground(Color.WHITE);
btnAnswer4.setForeground(Color.WHITE);

group = new ButtonGroup();
group.add(btnAnswer1);
group.add(btnAnswer2);
group.add(btnAnswer3);
group.add(btnAnswer4);
//These are the buttons displayed once users enter's slogan guessing game
btnName = new JButton("Submit Name");
btnSubmit = new JButton("Submit Answer");
btnNext = new JButton("Continue");
btnExit = new JButton("Leave Game");

btnName.addActionListener(this);
btnSubmit.addActionListener(this);
btnNext.addActionListener(this);
btnExit.addActionListener(this);

//this is for the user to leave the game
btnExit.setBackground(Color.RED);
btnExit.setForeground(Color.WHITE);
btnSubmit.setBackground(Color.GREEN);
btnNext.setBackground(Color.GRAY);
btnNext.setForeground(Color.WHITE);

nameField = new JTextField(10);
nameField.setActionCommand("myTF");
nameField.addActionListener(this);

lblName = new JLabel("Please enter your name:");
lblName.setForeground(Color.WHITE);
lblName.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 30));

//sets up and design the welcome label
lblWelcome = new JLabel("");
lblWelcome.setFont(new Font("SanSerif", Font.BOLD, 25));
lblWelcome.setForeground(Color.WHITE);

//updates the total points label to display accurate points after each question
lblTotalScore = new JLabel("Total Points: " + intScore);
lblTotalScore.setFont(new Font("Monospaced", Font.ITALIC, 20));
lblTotalScore.setForeground(Color.GREEN);

JLabel html = new JLabel("<html><br><br>I am <font color='red' size='30'>blue</font></html>");

lblPrompt = new JLabel(triviaQuestions.get(0).getQuestion());
lblPrompt.setForeground(Color.WHITE);

lblResponse = new JLabel("");
lblResponse.setForeground(Color.ORANGE);

pnl1.add(lblName);
pnl2.add(nameField);
pnl2.add(btnName);
pnl1.add(lblWelcome);
pnl1.add(lblTotalScore);
pnl2.add(lblPrompt);
pnl2.add(btnAnswer1);
pnl2.add(btnAnswer2);
pnl2.add(btnAnswer3);
pnl2.add(btnAnswer4);
pnl2.add(lblResponse);
pnl3.add(btnSubmit);
pnl3.add(btnNext);
pnl3.add(btnExit);



frame.setVisible(true);
lblPrompt.setVisible(false);
lblWelcome.setVisible(false);
lblTotalScore.setVisible(false);
btnAnswer1.setVisible(false);
btnAnswer2.setVisible(false);
btnAnswer3.setVisible(false);
btnAnswer4.setVisible(false);
lblResponse.setVisible(false);
btnSubmit.setVisible(false);
btnNext.setVisible(false);
}

int i = 0;

/*
*This uses a loop to bring up the next trivia question and resets the buttons for the corresponding answer choices. When there are no more questions the game is then over
*/
void NextQuestion(){
  if (i < triviaQuestions.size()) {
   
    lblPrompt.setText("");
    btnAnswer1.setText("");
    btnAnswer2.setText("");
    btnAnswer3.setText("");
    btnAnswer4.setText("");
    lblResponse.setText("");
    
    i++;

    lblPrompt.setText(triviaQuestions.get(i).getQuestion());
    btnAnswer1.setText(triviaQuestions.get(i).getAnswer1());
    btnAnswer2.setText(triviaQuestions.get(i).getAnswer2());
    btnAnswer3.setText(triviaQuestions.get(i).getAnswer3());
    btnAnswer4.setText(triviaQuestions.get(i).getAnswer4());

	  System.out.println(triviaQuestions.get(i).getQuestion());
    System.out.println(triviaQuestions.get(i).getAnswer1());
    System.out.println(triviaQuestions.get(i).getAnswer2());
    System.out.println(triviaQuestions.get(i).getAnswer3());
    System.out.println(triviaQuestions.get(i).getAnswer4());

    btnSubmit.setVisible(true);
  }

//if there are no more questions the game is over
  else {
      lblWelcome.setText("GAME OVER");
      lblWelcome.setVisible(true);
      lblPrompt.setVisible(false);
      btnAnswer1.setVisible(false);
      btnAnswer2.setVisible(false);
      btnAnswer3.setVisible(false);
      btnAnswer4.setVisible(false);
      lblResponse.setVisible(false);
      btnSubmit.setVisible(false);
      btnNext.setVisible(false);
      btnExit.setVisible(false);

  }

}
/*
this give the buttons functionality and determines whether or not the player has selected the correct answer, if the corrrect answer is selected the user gets points added to their score.
*/

public void actionPerformed(ActionEvent ae)
{
  int txtAnswer1 = 1;
  int txtAnswer2 = 2;
  int txtAnswer3 = 3;
  int txtAnswer4 = 4;

  if(ae.getActionCommand().equals("Submit Answer"))
    {

      if (btnAnswer1.isSelected() && triviaQuestions.get(i).getAnswerWin() == 1)
      {
         lblResponse.setText("Correct! You earned 2 Points");
         intScore += triviaQuestions.get(i).getPoints();
         btnSubmit.setVisible(false);
         btnNext.setVisible(true);
       
     }   
    
      else if (btnAnswer2.isSelected() && triviaQuestions.get(i).getAnswerWin() == 2)
      {
        
          lblResponse.setText("Correct! You earned 2 Points");
          intScore += triviaQuestions.get(i).getPoints();
          btnSubmit.setVisible(false);
  
      }

      else if(btnAnswer3.isSelected()&& triviaQuestions.get(i).getAnswerWin() == 3 )
        {
    
          lblResponse.setText("Correct! You earned 2 Points");
          intScore += triviaQuestions.get(i).getPoints();
          btnSubmit.setVisible(false);
          
        }

       else if (btnAnswer4.isSelected() && triviaQuestions.get(i).getAnswerWin() == 4)
        {
          lblResponse.setText("Correct! You earned 2 Points");
          intScore += triviaQuestions.get(i).getPoints();
          btnSubmit.setVisible(false);
        }

        else 
        {
          lblResponse.setText("incorrect.");
          btnSubmit.setVisible(false);
          btnNext.setVisible(true);
        } 
      

      lblTotalScore.setText("Total Points: " + intScore);
    }


  else if (ae.getActionCommand().equals("Continue"))
  {
    btnNext.setVisible(false);
    group.clearSelection();
       
     
     NextQuestion();
     triviaQuestions.get(i).getAnswerWin();
     triviaQuestions.get(i).getPoints();
    
   }
//This actions allows user to enter the game
else if (ae.getActionCommand().equals("Submit Name")) 
   
   {

    String userName = nameField.getText();
    lblWelcome.setText("Welcome " + userName + " to the Slogan Guessing Game!");

    lblName.setVisible(false);
    nameField.setVisible(false);
    btnName.setVisible(false);
    lblPrompt.setVisible(true);
    lblWelcome.setVisible(true);
    lblTotalScore.setVisible(true);
    btnAnswer1.setVisible(true);
    btnAnswer2.setVisible(true);
    btnAnswer3.setVisible(true);
    btnAnswer4.setVisible(true);
    lblResponse.setVisible(true);
    btnSubmit.setVisible(true);
    btnNext.setVisible(false);
    btnExit.setVisible(true);
   }

   //exits the game if the user hits the leave game button
   else if (ae.getActionCommand().equals("Leave Game"))
   {
      System.exit(0);
   }
    
  else
  {
    lblResponse.setText("Please click submit or continue");
  }
}
}
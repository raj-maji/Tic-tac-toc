import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9];
    boolean player1_turn;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font ("Int Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,1000);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for( int i=0;i<9;i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV Boli",Font.BOLD,120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);

        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

    }
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<9; i++){
            if(e.getSource()==button[i]){
                if(player1_turn){
                    if(button[i].getText()==""){
                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("X");
                        player1_turn=false;
                        textfield.setText("o turn");
                        check();
                    }
                }
                else{
                    if(button[i].getText()==""){
                        button[i].setForeground(new Color(0,0,255));
                        button[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void fristTurn(){

        try{
        Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        }
        else{
            player1_turn=false;
            textfield.setText("o turn");
        }
    }
    public void check(){
        if((button[0].getText()=="X" && button[1].getText()=="X") && button[2].getText()=="X"){
            xWins(0,1,2);
        }
        if((button[3].getText()=="X" && button[4].getText()=="X") && button[5].getText()=="X"){
            xWins(3,4,5);
        }
        if((button[6].getText()=="X" && button[7].getText()=="X") && button[8].getText()=="X"){
            xWins(6,7,8);
        }
         if((button[0].getText()=="X" && button[3].getText()=="X") && button[6].getText()=="X"){
            xWins(0,3,6);
        }
         if((button[1].getText()=="X" && button[4].getText()=="X") && button[7].getText()=="X"){
            xWins(1,4,7);
        }
         if((button[2].getText()=="X" && button[5].getText()=="X") && button[8].getText()=="X"){
            xWins(2,5,8);
        }
         if((button[0].getText()=="X" && button[4].getText()=="X") && button[8].getText()=="X"){
            xWins(0,4,8);
        }
         if((button[0].getText()=="X" && button[1].getText()=="X") && button[3].getText()=="X"){
            xWins(0,1,2);
        } 
        if((button[2].getText()=="X" && button[4].getText()=="X") && button[6].getText()=="X"){
            xWins(2,4,6);
        }


        //
         if((button[0].getText()=="O" && button[1].getText()=="O") && button[2].getText()=="O"){
            oWins(0,1,2);
        }
        if((button[3].getText()=="O" && button[4].getText()=="O") && button[5].getText()=="O"){
            oWins(3,4,5);
        }
        if((button[6].getText()=="O" && button[7].getText()=="O") && button[8].getText()=="O"){
            oWins(6,7,8);
        }
         if((button[0].getText()=="O" && button[3].getText()=="O") && button[6].getText()=="O"){
            oWins(0,3,6);
        }
         if((button[1].getText()=="O" && button[4].getText()=="O") && button[7].getText()=="O"){
            oWins(1,4,7);
        }
         if((button[2].getText()=="O" && button[5].getText()=="O") && button[8].getText()=="O"){
            oWins(2,5,8);
        }
         if((button[0].getText()=="O" && button[4].getText()=="O") && button[8].getText()=="O"){
            oWins(0,4,8);
        }
         if((button[0].getText()=="O" && button[1].getText()=="O") && button[3].getText()=="O"){
            oWins(0,1,2);
        } 
        if((button[2].getText()=="O" && button[4].getText()=="O") && button[6].getText()=="O"){
            oWins(2,4,6);
        }
        
    }
    public void xWins(int a,int b,int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
    
        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }
    public void oWins(int a,int b,int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
    
        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }

}
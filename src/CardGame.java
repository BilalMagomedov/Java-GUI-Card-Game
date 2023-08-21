import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Bilal Magomedov
// 200201107
// Computer science

public class CardGame implements ActionListener {

    ImageIcon ico;

    JFrame frame;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel nameLabel;

    JRadioButton rb1;
    JRadioButton rb2;
    JRadioButton rb3;
    JRadioButton rb4;

    JButton button;

    ButtonGroup btn;

    ImageIcon image1;
    ImageIcon image2;

    JComboBox jcb;

    protected String cardImg;

    protected String[] suitsArr = {"c", "s", "d", "h"};

    protected String[] CardsArr = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "ace", "jack", "king", "queen"};

    int score = 10;

    public CardGame() {
        frame = new JFrame("Card Game");

        ico = new ImageIcon("src/Cards/card-icon.png");
        frame.setIconImage(ico.getImage());

        label1 = new JLabel("Your score is 10 ");
        label1.setBounds(130, 20, 400, 100);
        label1.setFont(new Font("Montserrat", Font.BOLD, 40));
        label1.setForeground(new Color(31,31,31));

        // ComboBox
        jcb = new JComboBox(CardsArr);
        jcb.setBounds(100, 220, 60, 20);

        // Radio buttons suits of cards
        rb1 = new JRadioButton("Club");
        rb1.setBounds(100, 140, 80, 30);
        rb1.setFont(new Font("Montserrat", Font.BOLD + Font.ITALIC, 15));
        rb1.setForeground(Color.white);
        rb1.setBackground(new Color(51,51,51));

        rb2 = new JRadioButton("Spade");
        rb2.setBounds(180, 140, 100, 30);
        rb2.setFont(new Font("Montserrat", Font.BOLD + Font.ITALIC, 15));
        rb2.setForeground(Color.white);
        rb2.setBackground(new Color(51,51,51));

        rb3 = new JRadioButton("Diamond");
        rb3.setBounds(280, 140, 120, 30);
        rb3.setFont(new Font("Montserrat", Font.BOLD + Font.ITALIC, 15));
        rb3.setForeground(new Color(51,51,51));
        rb3.setBackground(new Color(214, 97,66));

        rb4 = new JRadioButton("Heart");
        rb4.setBounds(400, 140, 80, 30);
        rb4.setFont(new Font("Montserrat", Font.BOLD + Font.ITALIC, 15));
        rb4.setForeground(new Color(51,51,51));
        rb4.setBackground(new Color(214, 97,66));

        // To do not allow select several radio buttons at the same time
        btn = new ButtonGroup();
        btn.add(rb1);
        btn.add(rb2);
        btn.add(rb3);
        btn.add(rb4);

        // Player's card image
        image1 = new ImageIcon("src/Cards/back.png");
        label2 = new JLabel();
        label2.setBounds(190, 210, 150, 180);
        label2.setIcon(image1);

        // Computer's card image
        image2 = new ImageIcon("src/Cards/back.png");
        label3 = new JLabel();
        label3 = new JLabel(image2);
        label3.setBounds(340, 210, 150, 180);

        // Label for Player
        label4 = new JLabel("Player's card");
        label4.setBounds(210, 330, 150, 140);
        label4.setFont(new Font("Montserrat", Font.BOLD + Font.PLAIN, 15));
        label4.setForeground(Color.white);

        // Label for Computer
        label5 = new JLabel("Computer's card");
        label5.setBounds(350, 330, 150, 140);
        label5.setFont(new Font("Montserrat", Font.BOLD + Font.PLAIN, 15));
        label5.setForeground(Color.white);

        // Button for checking
        button = new JButton("Check the cards!");
        button.setFont(new Font("Montserrat", Font.BOLD + Font.ITALIC, 15));
        button.setBounds(100, 450, 380, 30);

        // Signature label
        nameLabel = new JLabel("Made by Bilal Magomedov - ( 200201107 ) - CS 201");
        nameLabel.setBounds(105, 460, 400, 100);
        nameLabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        nameLabel.setForeground(Color.black);

        // Adding all components into frame
        frame.add(jcb);

        frame.add(rb1);
        frame.add(rb2);
        frame.add(rb3);
        frame.add(rb4);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(nameLabel);

        frame.add(button);

        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);

        jcb.addActionListener(this);

        button.addActionListener(this);

        frame.getContentPane().setBackground(new Color(12, 99, 57));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Rules message
        JOptionPane.showMessageDialog(frame,
                "1. If the suits are the same (3 points)\n" +
                        "2. If the ranks are the same (5 points)\n" +
                        "3. If the suits and ranks are the same (10 points)\n" +
                        "4. To win the game you must gain more than 24 points\n" +
                        "5. Otherwise, you will lose\n" +
                        "GOOD LUCK!",
                "Rules",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void actionPerformed(ActionEvent e) {
        // Random card number and suit generator
        int n = (int) (Math.random() * 13); // from 0 to 12 (both inclusive)
        int s = (int) (Math.random() * 4);

        // rb1 - Club    (0)
        // rb2 - Spade   (1)
        // rb3 - Diamond (2)
        // rb4 - Heart   (3)

        int suits = 0;
        int cardNum = 0;

        if (rb1.isSelected()) {
            suits = 0;
            cardNum = jcb.getSelectedIndex();
            label2.setIcon(new ImageIcon("src/Cards/"+CardsArr[jcb.getSelectedIndex()]+"c.png"));
        } else if (rb2.isSelected()) {
            suits = 1;
            label2.setIcon(new ImageIcon("src/Cards/"+CardsArr[jcb.getSelectedIndex()]+"s.png"));
        } else if (rb3.isSelected()) {
            suits = 2;
            cardNum = jcb.getSelectedIndex();
            label2.setIcon(new ImageIcon("src/Cards/"+CardsArr[jcb.getSelectedIndex()]+"d.png"));
        } else {
            suits = 3;
            cardNum = jcb.getSelectedIndex();
            label2.setIcon(new ImageIcon("src/Cards/"+CardsArr[jcb.getSelectedIndex()]+"h.png"));
        }

        // Score Logic
        if (score < 25 && score > 0){
            if (e.getSource() == button && score > 0 && score < 25) {
                cardImg = "src/Cards/" + CardsArr[n] + suitsArr[s] + ".png";
                label3.setIcon(new ImageIcon(cardImg));

                if (n == cardNum && s == suits){
                    score+=10;
                    label1.setText("Your score is " + Integer.toString(score));
                } else if (s == suits){
                    score+=3;
                    label1.setText("Your score is " + Integer.toString(score));

                } else if (n == cardNum){
                    score+=5;
                    label1.setText("Your score is " + Integer.toString(score));
                } else {
                    score--;
                    label1.setText("Your score is " + Integer.toString(score));
                }
            }
        } else if (score >= 25) {
            JOptionPane.showMessageDialog(frame, "                You won! \nPress OK to restart the game.");
            score = 10;

            label1.setText("Your score is 10 ");
            label2.setIcon(new ImageIcon("src/Cards/back.png"));
            label3.setIcon(new ImageIcon("src/Cards/back.png"));
        } else {
            JOptionPane.showMessageDialog(frame, "                You lost! \nPress OK to restart the game.");
            score = 10;

            label1.setText("Your score is 10 ");
            label2.setIcon(new ImageIcon("src/Cards/back.png"));
            label3.setIcon(new ImageIcon("src/Cards/back.png"));
        }

    }

    public static void main(String[] args) {
        new CardGame();
    }

}


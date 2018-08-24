package odeh;

import java.awt.*;
import javax.swing.*;

public class Calc
{
    protected JFrame frame; 
    protected JTextField screen; 
    
    Eh obj = new Eh(this);    
    Calc()
    {
        frame =  new JFrame("Calculator");
        frame.setSize(new Dimension(350,450));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(2);
        frame.setLocation(400,200);
        frame.setResizable(true);
        
        screen = new JTextField("0");
        screen.setPreferredSize(new Dimension(0,70));
        screen.setFont(new Font("sherif", Font.PLAIN,20));
        JPanel panel1 = new JPanel(new GridLayout(4,3,10,15));
        panel1.setPreferredSize(new Dimension(220,350));
        
        for (short x = 1; x < 10; x++)
        {
            JButton b = new JButton(""+x);
            b.setFont(new Font("sherif", Font.BOLD,16));
            b.setPreferredSize(new Dimension(50,30));
            b.addActionListener(obj);
            panel1.add(b);
        }
            JButton b00 = new JButton("00");
            b00.setPreferredSize(new Dimension(50,30));
            b00.setFont(new Font("sherif", Font.BOLD,16));
            b00.addActionListener(obj);
            panel1.add(b00);
            
            JButton b0 = new JButton("0");
            b0.setFont(new Font("sherif", Font.BOLD,16));
            b0.setPreferredSize(new Dimension(50,30));
            b0.addActionListener(obj);
            panel1.add(b0);
            
            JButton bp = new JButton(".");
            bp.setFont(new Font("sherif", Font.BOLD,18));
            bp.setPreferredSize(new Dimension(50,30));
            bp.addActionListener(obj);
            panel1.add(bp);
            
            JPanel panel2 = new JPanel(new GridLayout(4,1,10,20));
            panel2.setPreferredSize(new Dimension(80,350));
            String[] op = {"+","-","x","/"};
            
            for (short x = 0; x < 4; x++)
            {
                JButton ARb = new JButton(op[x]);
                ARb.setFont(new Font("Tahoma", Font.BOLD,20));
                ARb.setPreferredSize(new Dimension(40,60));
                ARb.addActionListener(obj);
                panel2.add(ARb);
            }
            JPanel panel3 = new JPanel(new FlowLayout());
            String[] obtns = {"C","clear","=","ans"};
            
            for (short x = 0; x < 4; x++)
            {
                JButton Sbtns = new JButton(obtns[x]);
                Sbtns.setFont(new Font("serif", Font.PLAIN, 14));
                Sbtns.setPreferredSize(new Dimension(70,50));
                Sbtns.addActionListener(obj);
                panel3.add(Sbtns);
            }
            frame.add(screen, BorderLayout.NORTH);
            frame.add(panel1, BorderLayout.WEST);
            frame.add(panel2, BorderLayout.EAST);
            frame.add(panel3, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
    }
    public static void main(String[] args) 
    {
       Calc obj = new Calc();
    }
    
}

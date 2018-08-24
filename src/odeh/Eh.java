package odeh;

import java.awt.event.*;
import javax.swing.*;

public class Eh implements ActionListener
{
    private boolean eb = false;
    Adop obj2 = new Adop();
    Calc obj;
    Eh(Calc obj)
    {
        this.obj = obj;
    }
    
    public void displayAnswer()
    {
        int intAns; String ians;
        ians = ""+obj2.ans;
        if(ians.charAt(ians.length()-1) != '0')
             obj.screen.setText(""+obj2.ans);
         else
         {
             intAns = (int) obj2.ans;
             obj.screen.setText(""+intAns);
         }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String bt;
        JButton b = (JButton) e.getSource();
        switch (b.getText()) {
             case "clear":
                 String s = obj2.clear(obj.screen.getText());
                 obj.screen.setText(s);
                 break;
             case "C":
                 obj.screen.setText("0");
                 obj2.nums.clear();
                 break;
             case "=":
                 String t = obj.screen.getText();
                 obj2.expParse(t);
                 obj2.calcHp();
                 obj2.calcLp();
                 displayAnswer();
                 obj2.nums.clear();
                 break;
             case "ans":
                 displayAnswer();
                 break;
             default:
                 if (eb)
                 {
                     if(obj2.isOperator(b))
                         bt = obj.screen.getText() + b.getText();
                     else
                         bt = b.getText();
                 }
                 else if ((obj2.isOperator(b))||(!(obj.screen.getText().equals("0"))))
                bt = obj.screen.getText() + b.getText();
             else 
                bt = b.getText();
                obj.screen.setText(bt);
                 break;
    }
        eb = ("=".equals(b.getText())||"ans".equals(b.getText()));
}
}
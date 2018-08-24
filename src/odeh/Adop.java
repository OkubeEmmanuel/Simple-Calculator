package odeh;

import javax.swing.*;
import java.util.*;

public class Adop 
{
     protected ArrayList<String> nums = new ArrayList<>();
     private ArrayList<String> op = new ArrayList<>(); double ans; 
     
    public String clear(String txt)
    {
        String s = "";
        for (short x = 0; x < (txt.length()-1); x++)
            s = s + txt.charAt(x);
        if (s.isEmpty())
            s = "0";
        return(s);
    }
     public void expParse(String exp)
    {
        String t = ""; 
        for (int x = 0; x < exp.length(); x++)
        {
            if((exp.charAt(x) == 'x')||(exp.charAt(x) == '/')||(exp.charAt(x) == '+')||(exp.charAt(x) == '-'))
            {
                op.add((""+exp.charAt(x)));
                nums.add(t);
                t = "";
            }
            else
            {
                t = t + exp.charAt(x);
                if ((x+1)==exp.length()) nums.add(t);
            }
        }
    }
    public void calcHp()
    {
        if (op.isEmpty())
            ans = Double.parseDouble(nums.get(0));
        else
        {
        double n1, n2;
            OUTER:
            for (short x = 0; x < op.size();) 
            {
                switch (op.get(x)) 
                {
                    case "x":
                        n1 = Double.parseDouble(nums.get(x));
                        n2 = Double.parseDouble(nums.get(x+1));
                        ans = n1 * n2;
                        op.remove(x);
                        if (op.isEmpty()) {
                            break OUTER;
                        }
                        nums.remove(x);
                        nums.set(x, ""+ans);
                        break;
                    case "/":
                        n1 = Double.parseDouble(nums.get(x));
                        n2 = Double.parseDouble(nums.get(x+1));
                        try{
                            ans = n1 / n2;
                        }
                        catch(Exception e){}
                        op.remove(x);
                        if (op.isEmpty()) {
                            break OUTER;
                        }
                        nums.remove(x);
                        nums.set(x, ""+ans);
                        break;
                    default:
                        ++x;
                        break;
                }
            }
    }
    }
    public void calcLp()
    {
        if(!op.isEmpty())
        {
        double n1, n2;
            OUTER:
            for (short x = 0; x < op.size();) {
                switch (op.get(x))
                {
                    case "+":
                        n1 = Double.parseDouble(nums.get(x));
                        n2 = Double.parseDouble(nums.get(x+1));
                        ans = n1 + n2;
                        op.remove(x);
                        if (op.isEmpty()) {
                            break OUTER;
                        }
                        nums.remove(x);
                        nums.set(x, ""+ans);
                        break;
                    case "-":
                        n1 = Double.parseDouble(nums.get(x));
                        n2 = Double.parseDouble(nums.get(x+1));
                        ans = n1 - n2;
                        op.remove(x);
                        if (op.isEmpty()) {
                            break OUTER;
                        }
                        nums.remove(x);
                        nums.set(x, ""+ans);
                        break;
                    default:
                        x++;
                        break;
                }
            }
        }
    }
    public boolean isOperator(JButton b)
    {
        if ((b.getText().equals("+"))||(b.getText().equals("-"))||(b.getText().equals("x"))||(b.getText().equals("/")))
            return(true);
        else
            return(false);
    }
    }


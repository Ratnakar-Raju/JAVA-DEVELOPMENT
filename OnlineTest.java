/*Online Java Paper Test*/  
  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Q1: What is the default value of a local variable in Java?");  
            jb[0].setText("0");jb[1].setText("null");jb[2].setText("undefined");jb[3].setText("depends on the data");   
        }  
        if(current==1)  
        {  
            l.setText("Q2: Which of the following is a primitive data type in Java?");  
            jb[0].setText("String");jb[1].setText("Integer");jb[2].setText("boolean");jb[3].setText("ArrayList");  
        }  
        if(current==2)  
        {  
            l.setText("Q3: What is the output of the following code: `int x = 5; int y = x++;");  
            jb[0].setText("x = 5, y = 5");jb[1].setText("x = 6, y = 5");jb[2].setText("x = 5, y = 6");jb[3].setText("x = 6, y = 6");  
        }  
        if(current==3)  
        {  
            l.setText("Q4: What is the purpose of the `break` statement in a Java loop?");  
            jb[0].setText("to skip the current iteration");jb[1].setText("to exit the loop");jb[2].setText("to continue to the next iteration");jb[3].setText("to restart the loop");  
        }  
        if(current==4)  
        {  
            l.setText("Q5: What is the return type of a method that does not return any value?");  
            jb[0].setText("void");jb[1].setText("int");jb[2].setText("boolean");jb[3].setText("String");  
        }  
        if(current==5)  
        {  
            l.setText("Q6: How do you declare an array of integers in Java?");  
            jb[0].setText("int[] myArray;");jb[1].setText("int myArray[];");jb[2].setText("Integer myArray[];");jb[3].setText("Array myArray[];");  
        }  
        if(current==6)  
        {  
            l.setText("Q7: What is the purpose of a constructor in a Java class?");  
            jb[0].setText("to create an object");jb[1].setText("to initialize an object");jb[2].setText("to destroy an object");  
                        jb[3].setText("to modify an object");  
        }  
        if(current==7)  
        {  
            l.setText("Q8: What is the keyword used to inherit a class in Java?");  
            jb[0].setText("extends");jb[1].setText("implements");jb[2].setText("inherits");  
                        jb[3].setText("superclass");         
        }  
        if(current==8)  
        {  
            l.setText("Q9: Which one of the following is not a Java feature?");  
            jb[0].setText("Object-oriented");jb[1].setText("Use of pointers");jb[2].setText("Portable");jb[3].setText(" Dynamic and Extensible");  
        }  
        if(current==9)  
        {  
            l.setText("Q10: What is the purpose of the `try`-`catch` block in Java?");  
            jb[0].setText("to handle runtime errors");jb[1].setText("to handle compile-time errors");jb[2].setText("to handle logical errors");  
                        jb[3].setText("to handle syntax errors");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[3].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[0].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  
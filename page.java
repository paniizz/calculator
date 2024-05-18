import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class page implements ActionListener{

    JButton b11,b44,b22,b33,b55,b66,b77,b88;
    JButton b[] =new JButton[10];
    JFrame box = new JFrame("calculator");
    JTextArea erea;
    public String show = "";
    public int alr = 0;

    public page(){
        Dimension  size = new Dimension(265, 220);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b11 = new JButton("✚");
        b22 = new JButton("-");
        b33 = new JButton("x");
        b44= new JButton("÷");
        b55 = new JButton("=");
        b66 = new JButton("C");
        b77 = new JButton(".");
        b88 = new JButton("R");

        
        
        for(int p=2, i = 0; p<=178 && i < 5; p+=44, i++){
            b[i]=new JButton(i+"");
            b[i].setBounds(p, 90, 40, 40);
            box.add(b[i]);
            b[i].addActionListener(this);

            b[i+5]=new JButton((i+5)+"");
            b[i+5].setBounds(p, 140, 40, 40);
            box.add(b[i+5]);
            b[i+5].addActionListener(this);
        }
            

        erea = new JTextArea();

        
        b11.setBounds(2, 50, 40, 40);
        b22.setBounds(46, 50, 40, 40);
        b33.setBounds(90, 50, 40, 40);
        b44.setBounds(134, 50, 40, 40);
        b55.setBounds(178, 50, 40, 40);
        b66.setBounds(222, 50, 40, 40);
        b77.setBounds(222, 90, 40, 40);
        b88.setBounds(222, 140, 40, 40);
        erea.setBounds(10, 2,250, 40);

      

        box.add(b11);
        box.add(b22);
        box.add(b33);
        box.add(b44);
        box.add(b55);
        box.add(b66);
        box.add(b77);
        box.add(b88);
        box.add(erea);

        

        b11.addActionListener(this);
        b22.addActionListener(this);
        b33.addActionListener(this);
        b44.addActionListener(this);
        b55.addActionListener(this);
        b66.addActionListener(this);
        b77.addActionListener(this);
        b88.addActionListener(this);
         

        box.setVisible(true);

}

public void calans(int u){
    if(u == 1){
        String showsplit[] = show.split("✚");
        show = (Double.parseDouble(showsplit[0])+Double.parseDouble(showsplit[1]))+"";
    }
    else if(u == 2){
        String showsplit[] = show.split("-");
        show = (Double.parseDouble(showsplit[0])-Double.parseDouble(showsplit[1]))+"";
    }
    else if(u == 3){
        String showsplit[] = show.split("x");
        show = (Double.parseDouble(showsplit[0])*Double.parseDouble(showsplit[1]))+"";
    }
    else if(u == 4){
        String showsplit[] = show.split("÷");
        show = (Double.parseDouble(showsplit[0])/Double.parseDouble(showsplit[1]))+"";
    }
    alr = 0;
    erea.setText(show);
}
// erea.setText(show);



@Override
public void actionPerformed(ActionEvent e) {
    
    if(e.getSource() == b11){
        calans(alr);
        show += '✚';
        alr = 1;
    }
    else if(e.getSource() == b22){
        calans(alr);
        show += '-';
        alr = 2;
    }
    else if(e.getSource() == b33){
        calans(alr);
        show += 'x';
        alr = 3;
    }
    else if(e.getSource() == b44){
        calans(alr);
        show += '÷';
        alr = 4;
    }
    else if(e.getSource() == b55){
        calans(alr);
        alr = 0;
    }
    else if(e.getSource() == b66){
        show = "";
        alr = 0;
    }
    else if(e.getSource() == b77)  show += '.';
    else if(e.getSource() == b[0]) show += '0';
    else if(e.getSource() == b[1]) show += '1';
    else if(e.getSource() == b[2]) show += '2';
    else if(e.getSource() == b[3]) show += '3';
    else if(e.getSource() == b[4]) show += '4';
    else if(e.getSource() == b[5]) show += '5';
    else if(e.getSource() == b[6]) show += '6';
    else if(e.getSource() == b[7]) show += '7';
    else if(e.getSource() == b[8]) show += '8';
    else if(e.getSource() == b[9]) show += '9';

    else if(e.getSource() == b88){
        if(show.charAt(show.length()-1) == '✚') alr = 0;
        if(show.charAt(show.length()-1) == '-') alr = 0;
        if(show.charAt(show.length()-1) == 'x') alr = 0;
        if(show.charAt(show.length()-1) == '÷') alr = 0;
        String show1 = "";
        for(int i =0; i < (show.length()-1);i++){
            show1 += show.charAt(i);
        }
        show = show1;
    }
    
    erea.setText(show);
        
}

}
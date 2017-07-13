package EvacGUI;
//******************************************************************** import part
import javax.swing.*;

import EvacGUI.canvas.ball;

import java.awt.*;
import java.awt.event.*;
//******************************************************************** import part


//******************************************************************** jframe part
public class base_frame extends JFrame implements ActionListener
{
	//******************************************************************** define 
    canvas draw_panel;
    JButton b_changebg,b_add,b_remove;
    static int agent_num = 0;
    JPanel ui_panel;
    JLabel agent_number = new JLabel("total agent number :");
    static JLabel agent_number2 = new JLabel("0");
    //******************************************************************** define
    base_frame()
    {
        super("Ball Bounds");
 
        //our UI panel which contains gui comps
        ui_panel=new JPanel();
        b_changebg=new JButton("Change Background");
        b_add=new JButton("Add");
        b_remove=new JButton("Remove");
 
        //add listeners
        b_changebg.addActionListener(this);
        b_add.addActionListener(this);
        b_remove.addActionListener(this);
 
        setLayout(new FlowLayout());
        draw_panel=new canvas();
 
        //adding to UI panel
        ui_panel.add(b_changebg);
        ui_panel.add(b_add);
        ui_panel.add(b_remove);
        ui_panel.add(agent_number);
        ui_panel.add(agent_number2);
        //adding to our JFrame
        add(draw_panel);
        add(ui_panel);
 
        setSize(1200,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args)
    {
        new base_frame();
    }
  //******************************************************************** button settings
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b_changebg)
        {
                draw_panel.changeBGcolor();
        }
        else
        if(ae.getSource()==b_add)
        {
            //adds a ball of size 20;
            draw_panel.addBall(20);
            System.out.println("Added a ball");
        }
        else
        if(ae.getSource()==b_remove)
        {
                draw_panel.removeBall();
                System.out.println("Removed a ball");
        }
    }

    public static void balladded(){
    	agent_num=agent_num + 1;
    	agent_number2.setText(Integer.toString(agent_num));
    }
}
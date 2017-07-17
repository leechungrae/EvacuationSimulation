package EvacGUI;
//******************************************************************** import part
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import EvacGUI.canvas.ball;
import java.awt.*;
import java.awt.event.*;
//******************************************************************** import part
//******************************************************************** jframe part
public class base_frame extends JFrame implements ActionListener, ChangeListener {
    // ********************************************************************
    // define
    canvas draw_panel;
    JButton b_changebg, b_add, b_remove, b_start, b_doorAdd;
    static int agent_num = 0;
    static int agent_eva = 0;
    JPanel ui_panel,ui_panel1,ui_panel2,ui_panel3;
    JLabel agent_number = new JLabel("total agent number :");
    static JLabel agent_number2 = new JLabel("0");
    static JLabel agent_number3 = new JLabel("0");
    JLabel layout_agentNum = new JLabel("Input the agent number : ");
    JTextField agent_total_num = new JTextField(5);
    JTextField door_total_num = new JTextField(5);
    
    static int timepassed=0;
    static int startflag=0;
    
    int door_x = 0;
    int door_y = 0;
    int door_slideValue = 0;
    static JLabel timerLabel = new JLabel("timer :");
    static JLabel timerLabel2 = new JLabel("0");
    
    static final int SDOOR_MAX = 1200; //슬라이더의 최대값 (아래 포지션에 따라 최대값은 달라짐)
    
    JRadioButton b_top = new JRadioButton("TOP");
    JRadioButton b_right = new JRadioButton("RIGHT");
    JRadioButton b_bottom = new JRadioButton("BOTTOM");
    JRadioButton b_left = new JRadioButton("LEFT");
    ButtonGroup group = new ButtonGroup();
    
    JSlider slider = new JSlider(JSlider.HORIZONTAL,0,SDOOR_MAX,0); // 0~50까지 초기값 10
    
    // ********************************************************************
    // define
    base_frame() {
        super("Evacuation Simulation Based on Agent System");
        //set slider additional setting
        slider.setPaintLabels(true); // slider에 글자 표시
    	slider.setPaintTicks(true); // 눈금표시
    	slider.setPaintTrack(true); // slider box 표시
    	
    	slider.setMajorTickSpacing(200); // 큰 눈금 단위
    	slider.setMajorTickSpacing(100); // 작은 눈금 단위
    	
        // our UI panel which contains gui comps
        ui_panel = new JPanel();
        ui_panel1 = new JPanel();
        ui_panel2 = new JPanel();
        ui_panel3 = new JPanel();
        
        b_changebg = new JButton("Change Background");
        b_add = new JButton("Add");
        b_remove = new JButton("Remove");
        b_start = new JButton("Start!");
        
        b_doorAdd = new JButton("Add door");
        
        // add listeners
        slider.addChangeListener(this);
        b_changebg.addActionListener(this);
        b_doorAdd.addActionListener(this);
        b_add.addActionListener(this);
        b_remove.addActionListener(this);
        b_start.addActionListener(this);
        b_top.addActionListener(this);
        b_right.addActionListener(this);
        b_bottom.addActionListener(this);
        b_left.addActionListener(this);
        setLayout(new FlowLayout());
        draw_panel = new canvas();
        //adding timer
    
        // add ui_panel1 which incudes buttons
        ui_panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        ui_panel1.add(layout_agentNum);
        ui_panel1.add(agent_total_num);
        ui_panel1.add(b_start);
        //ui_panel1.add(b_changebg);
        //ui_panel1.add(b_add);
        //ui_panel1.add(b_remove);
        
        //add ui_panel2 which is information
        ui_panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        ui_panel2.add(agent_number);
        ui_panel2.add(agent_number2);
        ui_panel2.add(timerLabel);
        ui_panel2.add(timerLabel2);
        
        //add ui_panel3 which decide the num & position the doors
        group.add(b_top);
        group.add(b_right);
        group.add(b_bottom);
        group.add(b_left);
        
        ui_panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        ui_panel3.add(new JLabel("Press the button to make door -> "));
        ui_panel3.add(b_top);
        ui_panel3.add(b_right);
        ui_panel3.add(b_bottom);
        ui_panel3.add(b_left);
        ui_panel3.add(slider);
        ui_panel3.add(b_doorAdd);
        
        
        //ui_panel3.add(door_total_num);
        
        //add ui_panel which is the basic UI
        ui_panel.setLayout(new GridLayout(3,1));
        ui_panel.add(ui_panel2);
        ui_panel.add(ui_panel1);
        ui_panel.add(ui_panel3);
        // adding to our JFrame
        add(draw_panel);
        add(ui_panel);
        
        
        setSize(1200, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new base_frame();
    }
    // ********************************************************************
    // button settings
    @Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==slider){
			door_slideValue = slider.getValue();
			System.out.println("slider의 값 : " + door_slideValue);
		}
		
	}
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b_changebg)
        {
                draw_panel.changeBGcolor();
        }else if(e.getSource()==b_add)
        {
            //adds a ball of size 20;
            draw_panel.addBall();
            System.out.println("Added a ball");
        }else if(e.getSource()==b_remove)
        {
                draw_panel.removeBall();
                System.out.println("Removed a ball");
        }else if(e.getSource()==b_start){
            draw_panel.removeAll();
            for(int i=0;i<Integer.parseInt(agent_total_num.getText());i++){
                    draw_panel.addBall();
                    startflag=1;
            }
        }
        if(e.getSource() == b_top){
    		System.out.println("top buttom clicked!");
    		
    	}else if(e.getSource() == b_right){
    		
    		
    	}else if(e.getSource() == b_bottom){
    		
    		
    	}else if(e.getSource() == b_left){
    		
    		
    	}
    }
    
    public static void balladded() {
        agent_num = agent_num + 1;
        agent_number2.setText(Integer.toString(agent_num));
    }
    
    public static void ballremoved(){
        agent_num = agent_num - 1;
        agent_number2.setText(Integer.toString(agent_num));
        
    }
    
    public static void timercount() {
        timepassed = timepassed + 1;
        timerLabel2.setText(Integer.toString(timepassed));
    }
}
package EvacGUI;
import java.awt.*;
import java.awt.event.*;
class My_box extends Rectangle
{
    //default vars
    /*
     * x,y,width,height
     */
    My_box(int x1,int y,int width,int height)
    {
        super(x1,y,width,height);
    }
 
    public void drawBox(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guı;

import java.awt.Color;
public class Function_Color {
    GUI gui;
    
    public Function_Color(GUI gui){
        this.gui=gui;
    }
    
    public void changeColor(String color){
        switch(color){
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;
                case "Black":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                break;
                case "Blue":
                gui.window.getContentPane().setBackground(new Color(28,186,186));
                gui.textArea.setBackground(new Color(28,186,186));
                gui.textArea.setForeground(Color.white);
                break;
                
                
        }
    }
}

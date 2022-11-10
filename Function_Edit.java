/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guı;


public class Function_Edit {
    GUI gui;
    
    public Function_Edit(GUI gui){
        this.gui = gui;
        
    }

   
    public void undo(){
        gui.um.undo();
    }
    public void redo(){
        gui.um.redo();
    }
}

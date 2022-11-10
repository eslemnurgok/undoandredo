/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guı;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;


public class GUI implements ActionListener {

  JFrame window;
  //TEXT AREA
  JTextArea textArea;
  JScrollPane scrollPane;
  boolean wordWrapOn = false;
  
  //EDIT MENU
  JMenuItem iUndo,iRedo;
//TOP MENU BAR
  JMenuBar menuBar;
  JMenu menuEdit,menuFormat,menuColor;
  //FORMAT 
  JMenuItem iWrap,iFontArial,iFontItalic,iFontBold,iFontCSMS,iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
  JMenu menuFont,menuFontSize;
  JMenuItem iColor1,iColor2,iColor3;
  
  Function_Format format = new Function_Format(this);
  Function_Color color = new Function_Color(this);
  Function_Edit edit = new Function_Edit(this);
  
  KeyHandler kHandler = new KeyHandler(this);
  UndoManager um = new UndoManager();
    public static void main(String[] args) {
        
        new GUI();       
    }
    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFormatMenu();
        createEditMenu();
        format.selectedFont="Arial";
        format.createFont(16);
        format.wordWrap();
        color.changeColor("Black");
        
        window.setVisible(true);
    }
    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea(){
        textArea = new JTextArea();
        textArea.setFont(format.arial);
        
        textArea.addKeyListener(kHandler);
        
        textArea.getDocument().addUndoableEditListener(
        new UndoableEditListener(){
            public void undoableEditHappened(UndoableEditEvent e){
                um.addEdit(e.getEdit());
            }
        });
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
        
    }
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add("iUndo");
        
        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add("iRedo");
        
    }
    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);
        
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        
        iFontItalic = new JMenuItem("Italic");
        iFontItalic.addActionListener(this);
        iFontItalic.setActionCommand("Italic");
        menuFont.add(iFontItalic);
        
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);
        
        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);
        
        iFontBold = new JMenuItem("Bold");
        iFontBold.addActionListener(this);
        iFontBold.setActionCommand("Bold");
        menuFont.add(iFontBold);
        
        
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);
        
        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize8.setActionCommand("size12");
        menuFontSize.add(iFontSize12);
        
        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize8.setActionCommand("size16");
        menuFontSize.add(iFontSize16);
        
        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize8.setActionCommand("size20");
        menuFontSize.add(iFontSize20);
        
        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize8.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
        
        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize8.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
        
    }
    public void creareColorMenu(){
        iColor1= new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);
        iColor2= new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);
        iColor3= new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command =e.getActionCommand();
        
        switch(command){
            case "Undo":edit.undo();break;
            case "Redo":edit.redo();break;
            case "Word Wrap":format.wordWrap();break;
            case "Arial":format.setFont(command);break;
            case "Comic Sans MS":format.setFont(command);break;
            case "Times New Roman":format.setFont(command);break;
            case "Italic":format.setFont(command);break;
            case "Bold":format.setFont(command);break;
            case "size8":format.createFont(8);break;
            case "size12":format.createFont(12);break;
            case "size16":format.createFont(16);break;
            case "size20":format.createFont(20);break;
            case "size24":format.createFont(24);break;
            case "size28":format.createFont(28);break;
            case "White":color.changeColor(command);break;
            case "Black":color.changeColor(command);break;
            case "Blue":color.changeColor(command);break;


            
        }
    }
}

package project3;

import javax.swing.JFrame;  
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WordGUI extends JFrame{
	
	public WordGUI() {
		guiProperties(); // calls guiProperties method
	}   
	
	public void guiProperties() {
		setSize(400,400);                        // set the size of JFrame window
	    setLocation(200, 200);                   // set the location of JFrame window
	    setTitle("Vowel & Consonant Separator"); // create title for JFrame
	    buildMenu();                             // calls buildMenu method          
	    setDefaultCloseOperation(EXIT_ON_CLOSE); // system exits once JFrame is closed
	    setVisible(true);
	} 
	
	public void buildMenu() {
		JMenuItem menuItem;                              // initialize menuItem
		JMenu menu = new JMenu("File");                  // initialize menu
		JMenuBar menuBar = new JMenuBar();               // initialize menuBar
		
		FileMenuHandler fmh = new FileMenuHandler(this); // initialize FileMenuHandler (fmh)
		
		menuItem = new JMenuItem("Open File");           // create menuItem "Open File"
		menuItem.addActionListener(fmh);                 // executes action when clicked
		menu.add(menuItem);                              // add "Open File" to menu
		menuItem = new JMenuItem("Exit");                // create menuItem "Exit"
		menuItem.addActionListener(fmh);                 // executes action when clicked
		menu.add(menuItem);                              // add "Exit" to menu
		
		setJMenuBar(menuBar);                            // set menuBar
		menuBar.add(menu);                               // add menuBar to menu
	}
}
	  
	   

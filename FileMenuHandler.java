package project3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class FileMenuHandler implements ActionListener {
		static JFrame frame;                       // static JFrame frame (javax.swing.JFrame)
		static TextArea a, e, i, o, u, consonants; // static TextArea a,e,i,o,u,consonants (java.awt.TextArea)
		static Container contentPane;              // static Container contentPane (java.awt.Container)
	
		static TreeMap <Word, Word> sortedWord = new TreeMap <Word, Word>(); // initialize sortedWord
	
		public FileMenuHandler(JFrame f) {
			frame = f;
		}
		
		public static void initialize() {
			a = new TextArea();                 // initialize TextArea for words starting with A/a
			e = new TextArea();				    // initialize TextArea for words starting with E/e
			i = new TextArea();                 // initialize TextArea for words starting with I/i
			o = new TextArea();                 // initialize TextArea for words starting with O/o
			u = new TextArea();                 // initialize TextArea for words starting with U/u
			consonants = new TextArea();        // initialize TextArea for words starting with consonants
			
		}
		public static void build() {
			initialize();                         // calls initialize method
			
			a.setEditable(false);                 // do not allow user to edit TextArea a
			e.setEditable(false);                 // do not allow user to edit TextArea e
		    i.setEditable(false);                 // do not allow user to edit TextArea i
			o.setEditable(false);                 // do not allow user to edit TextArea o
		    u.setEditable(false);                 // do not allow user to edit TextArea u
		    consonants.setEditable(false);        // do not allow user to edit TextArea consonants
		    
			frame.setLayout(new GridLayout(2,3));   // creating 2 rows and 3 columns (java.awt.GridLayout)
		    
			contentPane = frame.getContentPane();   // retrieves ContentPane to allow textAreas to be added
		    
			contentPane.add(a);                          // adds TextArea a to contentPane(Container)   (r 0, c 0)
			contentPane.add(i);                          // adds TextArea i to contentPane              (r 0, c 1)
			contentPane.add(u);                          // adds TextArea u to contentPane              (r 0, c 2)
			contentPane.add(e);                          // adds TextArea e to contentPane              (r 1, c 0)
			contentPane.add(o);                          // adds TextArea o to contentPane              (r 1, c 1)
			contentPane.add(consonants);            	 // adds TextArea consonants to contentPane     (r 1, c 2)
	   
			a.append("Words starting with A/a:"+"\n\n"); // appends(adds) text to TextArea a
			e.append("Words starting with E/e:"+"\n\n"); // appends text to TextArea e
			i.append("Words starting with I/i:"+"\n\n"); // appends text to TextArea i
			o.append("Words starting with O/o:"+"\n\n"); // appends text to TextArea o
			u.append("Words starting with U/u:"+"\n\n"); // appends text to TextArea u
			consonants.append("Words starting with non-vowel(consonant) letters or numbers:"+"\n\n"); // appends text to TextArea consonant_Nums
		
			frame.setVisible(true); // set the JFrame to be visible
			
			vowelSeparater(); // calls vowelSeparater method
		}
	
		public void fileOpen() { // fileOpen Method
			JFileChooser fileChooser; // create fileChooser variable
			int condition;            // initialize variable that keeps track of condition
			
			fileChooser = new JFileChooser(); // initialize fileChooser
			condition = fileChooser.showOpenDialog(null); 
			
			if (condition == JFileChooser.APPROVE_OPTION) { // if condition is approved
				read(fileChooser.getSelectedFile());        // read the selected file
			}
			else {                                          // otherwise
				JOptionPane.showMessageDialog(null, "Aborted"); // says "Aborted"
			}
		}
		
		public void actionPerformed(ActionEvent event) { // actionPerformed method
			String menuOption; // initialize menuOption
			menuOption = event.getActionCommand(); // menuOption equals option is picked
			
			if (menuOption.equals("Open File"))  // if "Choose a file" is chosen
				fileOpen();                           // call fileOpen method
			
			else if (menuOption.equals("Exit")) // if "Exit menu" is chosen
				System.exit(0);                       // exit program
			
		}
		
		private void read(File userFile) {        // read method
			String fileName = userFile.getName(); // fileName equals to name of chosen file
			TextFileInput file = new TextFileInput(fileName); 
			String input = file.readLine();       // String input equal to first line of file
			
			while (input != null) {               // while current line is not null
				try {
					sortedWord.put(new Word(input), null); // try every word in file
				}
				catch(IllegalWordException e) {
					System.out.println("Error: " + input); // Error: (word) is printed in console if exception is caught
				}
				finally {
					input = file.readLine(); // read next line, then loop repeats until null is reached
				}
			}
			build();      // call build method
		}
	
	public static void vowelSeparater(){ // vowelSeparater method
		for (Map.Entry <Word, Word> entry : sortedWord.entrySet()) { // declaring tree map
		
			String line = entry.getKey().getWord();
		
			if (line.charAt(0) == 'A' || line.charAt(0) == 'a') {      //if word's first letter is A or a
				a.append(line+"\n");                                   //append word to TextArea a
			}
			else if (line.charAt(0) == 'E' || line.charAt(0) == 'e') { //if word's first letter is E or e
				e.append(line+"\n");                                   //append word to TextArea e
			}
			else if (line.charAt(0) == 'I' || line.charAt(0) == 'i') { //if word's first letter is I or i
				i.append(line+"\n");                                   //append word to TextArea i
			}
			else if (line.charAt(0) == 'O' || line.charAt(0) == 'o') { //if word's first letter is O or o
				o.append(line+"\n");                                   //append word to TextArea o
			}
			else if (line.charAt(0) == 'U' || line.charAt(0) == 'u') { //if word's first letter is U or u
				u.append(line+"\n");                                   //append word to TextArea u
			}
			else {                                                     //otherwise, 
				consonants.append(line+"\n");                          //append word to TextArea consonants
			}
		}
	}
}


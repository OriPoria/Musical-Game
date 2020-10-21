import javax.swing.SwingUtilities;

import database.Database;
import gui.GUI;
//https://courses.cs.washington.edu/courses/cse331/13sp/lectures/lect23-graphics.pdf
public class Main {
	public static void main(String [] args) {
		System.out.println("welcome!");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
		try {
		//	Database.post("ori", 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

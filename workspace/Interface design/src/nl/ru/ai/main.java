package nl.ru.ai;
/*
 * main.java file
 */


/*
 * Package location
 */


/*
 * Import package
 */
import javax.swing.SwingUtilities;

/*
 * Start main class
 */
public class main {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new Window();
			}			
		});		
	}
}
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class s�zdekod implements ActionListener {
	int say = 6;
	int aktif = 0;
	public static Timer zaman1;
	public s�zdekod() {
		zaman1 = new Timer(1000, this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if (say == 6) {
			S�zdeKodForm.szdlbl[6].setForeground(Color.GREEN);
			S�zdeKodForm.szdlbl[2].setForeground(Color.BLACK);
			S�zdeKodForm.szdlbl[3].setForeground(Color.BLACK);
			S�zdeKodForm.szdlbl[4].setForeground(Color.BLACK);
			S�zdeKodForm.szdlbl[5].setForeground(Color.BLACK);
			aktif = 1;
		} else if (say == 7) {
			S�zdeKodForm.szdlbl[7].setForeground(Color.RED);
			aktif = 1;
		} else if (say == 8) {
			S�zdeKodForm.szdlbl[8].setForeground(Color.YELLOW);
			aktif = 1;
		} else if (say == 9) {
			S�zdeKodForm.szdlbl[9].setForeground(Color.RED);
			
		
			say = 5;
			zaman1.stop();
			main.zaman.start();
			aktif = 0;
		}
		say++;
	}
}

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class s�zdekod2 implements ActionListener {

	int say1 = 2;
	int aktif2 = 0;

	public static Timer zaman2;

	public s�zdekod2() {
		zaman2 = new Timer(1000, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if (say1 == 2) {
			S�zdeKodForm.szdlbl[2].setForeground(Color.GREEN);
			S�zdeKodForm.szdlbl[6].setForeground(Color.BLACK);
			S�zdeKodForm.szdlbl[7].setForeground(Color.BLACK);
			S�zdeKodForm.szdlbl[8].setForeground(Color.BLACK);
			S�zdeKodForm.szdlbl[9].setForeground(Color.BLACK);
			aktif2 = 1;
		} else if (say1 == 3) {
			S�zdeKodForm.szdlbl[3].setForeground(Color.RED);
			aktif2 = 1;
		} else if (say1 == 4) {
			S�zdeKodForm.szdlbl[4].setForeground(Color.YELLOW);
			aktif2 = 1;
		} else if (say1 == 5) {
			S�zdeKodForm.szdlbl[5].setForeground(Color.RED);
			
			say1 = 1;
		
			zaman2.stop();
			main.zaman.start();
			aktif2 = 0;
		}
		say1++;
	}
}

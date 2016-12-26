import java.awt.Color;
import java.awt.Container;
import java.awt.Font;


import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class SözdeKodForm extends JFrame {
	
	
	public static SözdeKodForm star1 = new SözdeKodForm();

	public static JLabel szdlbl[] = new JLabel[12];

	public static JLabel degerlbl[] = new JLabel[3];

	public SözdeKodForm() {
		setTitle("Sözde Kod");
		setLayout(null);
		setResizable(false);
		setVisible(false);
		setSize(270, 350);
		getContentPane().setBackground(Color.BLACK);// Arka plan rengi
		setUndecorated(true);
	}

	public static void Form() {
		
		FormuHizala();

		

		for (int i = 0; i < szdlbl.length; i++) { // Sözde Labeller
			szdlbl[i] = new JLabel("Mevcut Eleman : Deger[i]");
			szdlbl[i].setSize(300, 50);
			szdlbl[i].setLocation(0, 50 + 20 * i);
			szdlbl[i].setVisible(true);
			szdlbl[i].setForeground(Color.WHITE);
			szdlbl[i].setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
			star1.add(szdlbl[i]);
		}
		for (int i = 0; i < degerlbl.length; i++) {
			degerlbl[i] = new JLabel("Deger[i-1]");

			degerlbl[i].setLocation(20 + i * 80, 0);
			degerlbl[i].setVisible(true);
			degerlbl[i].setForeground(Color.WHITE);
			degerlbl[i].setFont(new Font("Serif", Font.ROMAN_BASELINE, 25));
			star1.add(degerlbl[i]);
		}

		degerlbl[1].setText("?");
		degerlbl[2].setText("Deger[i]");

		degerlbl[0].setSize(150, 50);
		degerlbl[1].setLocation(125, 0);
		degerlbl[1].setSize(20, 50);
		degerlbl[2].setSize(90, 50);

		szdlbl[1].setText("Bir öncekinden Küçük Mü?");
		szdlbl[2].setText("Evet");
		szdlbl[3].setText("{");
		szdlbl[4].setText("Yer Degiþtir!");
		szdlbl[5].setText("}");
		szdlbl[6].setText("Hayir");
		szdlbl[7].setText("{");
		szdlbl[8].setText("Degerin Ýndisini Arttir!");
		szdlbl[9].setText("}");
		szdlbl[10].setText("Siralama Bitti mi?");
		szdlbl[11].setText("Hepsini Kirmiziya Boya!");
		
		

		star1.repaint();
	}
	
	public static void FormuHizala()
	{
		Timer myTimer1231=new Timer();
        TimerTask gorev =new TimerTask() {

               @Override
               public void run() {
            	   star1.setLocation(main.form.getX() + 810, main.form.getY());
                     
                    
               }
        };

        myTimer1231.schedule(gorev,10,10);
	}

}

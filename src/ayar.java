import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ayar extends JFrame {

	public static ayar star2 = new ayar();
	public static JLabel lbl[] = new JLabel[3];
	public static JTextField txt[] = new JTextField[3];
	public static JButton mbt1[] = new JButton[3];

	public ayar() {
		setTitle("Ayar");
		setLayout(null);
		setResizable(false);
		setVisible(false);
		setSize(200, 170);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);// Çerceveleri kaldýrýyor

		getRootPane().setBorder(
				BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));

	}

	public static void ayarla() {

		ayarlaFormHizala();

		for (int i = 0; i < lbl.length; i++) { // Labelleriimizi oluþturduk
			lbl[i] = new JLabel("Dizinin Uzunlugu :");
			lbl[i].setSize(200, 20);
			lbl[i].setLocation(0, 10 + i * 50);

			star2.add(lbl[i]);
		}

		lbl[1].setText("1 .Elemani Giriniz :");
		lbl[2].setText("Sona Eleman Ekle : ");

		for (int i = 0; i < txt.length; i++) { // Text Kutumuzu oluþturduk
			txt[i] = new JTextField();
			txt[i].setSize(30, 30);
			txt[i].setEnabled(false);
			txt[i].setLocation(110, 5 + i * 50);
			star2.add(txt[i]);
		}

		// Menü butonlarý1
		ImageIcon myico1 = new ImageIcon(".\\ico\\okBLUE.png");// menü butonlarý
																// icin resim
		for (int i = 0; i < 3; i++) {
			mbt1[i] = new JButton();
			mbt1[i].setSize(40, 37);
			mbt1[i].setLocation(150, i * 50);
			mbt1[i].setIcon(myico1);
			mbt1[i].setEnabled(false);
			mbt1[i].setVisible(true);
			star2.add(mbt1[i]);
		}
		mbt1[0].addActionListener(new ActionListener() { // Dizinin uzunlugunu
															// belirledik

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					main.dizi_lenght = Integer.parseInt(ayar.txt[0].getText());
					main.dizi = new int[main.dizi_lenght];
					main.dizikopya = new int[main.dizi.length];
					mbt1[0].setEnabled(false);
					ayar.txt[0].setEnabled(false);
					mbt1[1].setEnabled(true);
					ayar.txt[1].setEnabled(true);
					main.ekle_indis = 0;
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Lütfen Sayi Giriniz! Hata Kodu : " + e2);
					txt[0].setText("");
				}
			}
		});
		mbt1[1].addActionListener(new ActionListener() { // Ekleme butonu

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (main.ekle_indis < main.dizi_lenght) {
						main.dizi[main.ekle_indis] = Integer.parseInt(txt[1]
								.getText());
						main.bt[main.ekle_indis].setText(ayar.txt[1].getText());
						main.bt[main.ekle_indis].setVisible(true);
						main.dizikopya[main.ekle_indis] = main.dizi[main.ekle_indis];
						main.form.mbt[7].setEnabled(true);
						main.form.mbt[4].setEnabled(true);
						if ((main.ekle_indis + 1) == main.dizi_lenght) {
							mbt1[1].setEnabled(false);
							mbt1[2].setEnabled(true);
							txt[1].setEnabled(false);
							txt[2].setEnabled(true);
							mbt1[4].setEnabled(true);
						} else {
							lbl[1].setText((main.ekle_indis + 2)
									+ " .Elemani Giriniz : ");
							main.ekle_indis++;
							System.out.println("ekle indisi" + main.ekle_indis);
							System.out.println("main dizi" + main.dizi_lenght);
						}
					}
				} catch (Exception e2) {

					if (main.ekle_indis + 1 == main.dizi_lenght) {
						JOptionPane.showMessageDialog(null,
								"Ekleme Ýþlemi Tamamlandi!");
					} else {
						JOptionPane.showMessageDialog(null,
								"Lütfen Sayi Giriniz! Hata Kodu : " + e2);
					}
				}
				txt[1].setText("");
			}
		});
		mbt1[2].addActionListener(new ActionListener() { // Sona Ekle
			@Override
			public void actionPerformed(ActionEvent e) {
				main.SonaEkle();
				main.form.repaint();
			}
		});

	}

	public static void ayarlaFormHizala() {
		Timer myTimer1231 = new Timer();
		TimerTask gorev = new TimerTask() {

			@Override
			public void run() {
				star2.setLocation(main.form.getX(), main.form.getY() + 180);

			}
		};

		myTimer1231.schedule(gorev, 10, 10);
	}
}

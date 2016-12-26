import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.util.Random;//random sýnýfýný cagýrdýk
import java.util.TimerTask;

public class main extends JFrame implements ActionListener {
	static JButton bt[] = new JButton[9];
	static JButton mbt[] = new JButton[13];
	public static int dizi[], Eklemeli_dizi[], dizikopya[];
	static Border maviborder = new LineBorder(Color.BLUE, 4);
	static Border yesilborder = new LineBorder(Color.GREEN, 4);
	static Border kirmiziborder = new LineBorder(Color.RED, 5);
	static Border mbtborder = new LineBorder(Color.LIGHT_GRAY, 1);
	public static boolean durdevam = false;
	static String sayi = "";
	public static int ekle_indis, sayac, deger = 1, kontrol, mevcut, j,
			sonindex, kirmizi, dur_devam_tekrar, durum, durum2, kontrol1,
			dizi_lenght;
	static Timer zaman;// Timer i tanýmladýk.
	static ImageIcon Stopico = new ImageIcon(".\\ico\\stop1.png");// Stop ico
	static ImageIcon Playico = new ImageIcon(".\\ico\\play1.png");// Play ico
	static ImageIcon Tryico = new ImageIcon(".\\ico\\try1.png");// Try ico
	static ImageIcon visibleicon_true = new ImageIcon(".\\ico\\v_true.png");
	static ImageIcon visibleicon_false = new ImageIcon(".\\ico\\v_false.png");
	static ImageIcon ayaricon = new ImageIcon(".\\ico\\settings.png");// ayariconu
	static ImageIcon azalticon = new ImageIcon(".\\ico\\azalt.png");// azaltma
																	// iconu
	static ImageIcon arttiricon = new ImageIcon(".\\ico\\arttir.png");// arttirma

	static ImageIcon exiticon = new ImageIcon(".\\ico\\Exit.png");

	public static main form;
	static ayar ayar_class_nesne = new ayar();
	static SözdeKodForm sözdeKodForm_class_nesne = new SözdeKodForm();
	static sözdekod nesne = new sözdekod();
	static sözdekod2 nesne1 = new sözdekod2();

	// Hýzlandýrma yavaþlatma degiþkenim

	public static int zamanlayici = 1000;

	public static int zamanlayici_kontrol = 0;

	public static int saniye = 1;

	public static JLabel saniyelabel = new JLabel("Saniye");

	public main() {
		setTitle("INSERT SORT");
		setLayout(null);
		setResizable(false);
		setSize(800, 170);
		setUndecorated(true);
		setLocation(200, 150);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getRootPane().setBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));

		zaman = new Timer(1000, this);// Timer in süresini ve paremetresýný
	}

	public static void main(String[] args) {
		form = new main();

		for (int i = 0; i < bt.length; i++) {// Yukardaki butonlarýmý burda
												// oluþturduk.
			bt[i] = new JButton("bt" + i);
			bt[i].setSize(50, 80);
			bt[i].setEnabled(false);
			bt[i].setVisible(false);
			bt[i].setFont(new Font("Serif", Font.BOLD, 25));
			bt[i].setPreferredSize(new Dimension(50, 30));
			bt[i].setBackground(Color.DARK_GRAY);

			bt[i].setBorder(yesilborder);
			bt[i].setLocation(10 + i * 80, 10);
			form.add(bt[i]);
		}

		RastDizi();

		// Menü butonlari2

		for (int i = 3; i < 5; i++) {
			mbt[i] = new JButton();
			mbt[i].setSize(50, 50);
			mbt[i].setLocation(350, 90);
		}
		ImageIcon myico3 = new ImageIcon(".\\ico\\close_red.png");
		mbt[3].setIcon(myico3);

		ImageIcon myico2 = new ImageIcon(".\\ico\\start.png");

		mbt[4].setIcon(myico2);

		mbt[4].setLocation(400, 90);

		// Menü butonlar3
		for (int i = 5; i < 7; i++) {
			mbt[i] = new JButton();
			mbt[i].setSize(50, 50);
			mbt[i].setLocation(0, 90);
			mbt[i].setBorder(mbtborder);
		}
		mbt[6].setLocation(50, 90);

		mbt[5].setIcon(arttiricon);
		mbt[6].setIcon(azalticon);

		// zamanlayici iciin label

		JLabel lbl1 = new JLabel();
		lbl1.setSize(150, 50);
		lbl1.setLocation(100, 90);
		form.add(lbl1);

		// Saniye icin label

		// zamanlayici iciin label

		saniyelabel.setSize(150, 50);
		saniyelabel.setLocation(120, 120);
		form.add(saniyelabel);

		// Timeri azaltan buton
		//
		mbt[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (zamanlayici - 1000 > 0) {

					zamanlayici -= 1000;
					// zamanlayici_kontrol = 0;
					lbl1.setText("Ýþleyiþ Hizlandirildi : "
							+ (zamanlayici / 1000) + " sn");
				}
			}
		});

		// Timeri yavaslatan buton

		mbt[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				zamanlayici += 1000;
				// zamanlayici_kontrol = 0;
				lbl1.setText("Ýþleyiþ Yavaþlatildi : " + (zamanlayici / 1000)
						+ " sn");

			}
		});

		mbt[7] = new JButton();
		mbt[7].setSize(50, 50);
		mbt[7].setLocation(300, 90);

		// Exit -- Cýkiþ tuþu

		mbt[12] = new JButton();
		mbt[12].setVisible(true);
		mbt[12].setSize(45, 45);
		mbt[12].setLocation(718, 120);
		mbt[12].setIcon(exiticon);
		mbt[12].setBorder(mbtborder);

		mbt[12].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ayar_class_nesne.star2.dispose();
				sözdeKodForm_class_nesne.star1.dispose();
				form.dispose();
			}
		});

		// Durdur baþlat tekrar oynat butonu

		mbt[8] = new JButton();
		mbt[8].setSize(50, 50);
		mbt[8].setLocation(720, 30);
		mbt[8].setVisible(false);
		mbt[8].setBorder(mbtborder);
		mbt[8].setIcon(Stopico);

		// Visible butonu
		mbt[10] = new JButton();
		mbt[10].setSize(50, 30);
		mbt[10].setLocation(720, 85);
		mbt[10].setVisible(true);
		mbt[10].setBorder(mbtborder);
		mbt[10].setIcon(visibleicon_false);

		SözdeKodForm.Form();

		ayar.ayarla();

		mbt[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (durum == 0) {

					mbt[10].setIcon(visibleicon_true);

					SözdeKodForm.star1.setVisible(true);

					durum = 1;
				} else {
					mbt[10].setIcon(visibleicon_false);
					SözdeKodForm.star1.setVisible(false);
					durum = 0;

				}

			}
		});

		// Ayar Butonu

		mbt[11] = new JButton();
		mbt[11].setSize(60, 49);
		mbt[11].setLocation(450, 90);
		mbt[11].setVisible(true);
		mbt[11].setBorder(mbtborder);
		mbt[11].setIcon(ayaricon);

		mbt[11].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (durum2 == 0) {
					ayar.star2.setVisible(true);
					durum2 = 1;
				} else {
					ayar.star2.setVisible(false);
					durum2 = 0;
				}

			}
		});

		// Menü butonlari ortak olanlari burda topladým
		for (int i = 3; i < mbt.length; i++) {
			if (i != 9) {
				mbt[i].setEnabled(false);
				mbt[i].setBackground(Color.LIGHT_GRAY);
				form.add(mbt[i]);
			}

		}
		mbt[7].setEnabled(true);
		mbt[3].setEnabled(true);
		mbt[4].setEnabled(true);

		// Yenile butonu
		ImageIcon myico = new ImageIcon(".\\ico\\r.png");
		mbt[7].setIcon(myico);
		mbt[7].setBorder(mbtborder);
		mbt[3].setBorder(mbtborder);
		mbt[4].setBorder(mbtborder);
		mbt[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reset();

				RastDizi();

				mbt[8].setIcon(Stopico);
				mbt[8].setVisible(false);
				mbt[4].setEnabled(true);
				ayar.txt[0].setEnabled(false);
				ayar.txt[1].setEnabled(false);
				ayar.txt[2].setEnabled(false);
				ayar.mbt1[0].setEnabled(false);
				ayar.mbt1[1].setEnabled(false);
				ayar.mbt1[2].setEnabled(false);

			}
		});
		// Sýfýrlama butonu
		mbt[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				zaman.stop();

				Sifirla();

				mbt[4].setEnabled(false);

			}
		});

		mbt[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mbt[8].setVisible(true);
				mbt[4].setEnabled(false);
				mbt[7].setEnabled(false);
				mbt[8].setIcon(Stopico);
				durdevam = true;
				zaman.start();
			}
		});
		// Dur_Devam_Tekrar butonu

		mbt[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dur_devam_tekrar == 0) {

					durdevam = false;

					System.out.println(nesne.aktif);

					// tutulan=nesne.say;

					if (nesne.aktif == 1 || nesne1.aktif2 == 0) {
						nesne.zaman1.stop();

					} else if (nesne.aktif == 0 || nesne1.aktif2 == 1) {
						nesne1.zaman2.stop();

					}

					dur_devam_tekrar = 1;
					mbt[8].setIcon(Playico);
				} else if (dur_devam_tekrar == 1) {

					if (nesne.aktif == 1 || nesne1.aktif2 == 0) {

						System.out.println("Hayir Aktif");
						nesne.zaman1.start();

					} else if (nesne.aktif == 0 || nesne1.aktif2 == 1) {

						System.out.println("Hayir Aktif Degil");
						nesne1.zaman2.start();

					}

					durdevam = true;

					dur_devam_tekrar = 0;
					mbt[8].setIcon(Stopico);
				} else if (dur_devam_tekrar == 2) {
					dur_devam_tekrar = 0;
					mbt[8].setIcon(Stopico);
					Kopyala();
					Yenile();
					durdevam = true;
					zaman.start();
				}
			}
		});

		// Sona Ekle

		mbt[8].setEnabled(true);

		mbt[10].setEnabled(true);
		mbt[11].setEnabled(true);
		mbt[5].setEnabled(true);
		mbt[6].setEnabled(true);

		mbt[12].setEnabled(true);
		form.repaint();

		// Main bitiþ.
	}

	public static void SonaEkle() {

		try {
			Eklemeli_dizi = new int[dizi.length + 1];
			if (Eklemeli_dizi.length <= bt.length) {

				System.out.println("eklemelýnýn uzunlugu : "
						+ Eklemeli_dizi.length);

				System.out.println("bt.lenght : " + Eklemeli_dizi.length);
				for (int i = 0; i < Eklemeli_dizi.length - 1; i++) {
					Eklemeli_dizi[i] = dizi[i];
				}
				Eklemeli_dizi[Eklemeli_dizi.length - 1] = Integer
						.parseInt(ayar.txt[2].getText());

				dizi = new int[Eklemeli_dizi.length];
				dizikopya = new int[Eklemeli_dizi.length];
				for (int i = 0; i < Eklemeli_dizi.length; i++) {
					dizi[i] = Eklemeli_dizi[i];
					dizikopya[i] = Eklemeli_dizi[i];
				}
				bt[Eklemeli_dizi.length - 1].setVisible(true);
				bt[Eklemeli_dizi.length - 1].setText(ayar.txt[2].getText());
				JOptionPane.showMessageDialog(null, "Sona Eleman Eklendi!");
				ayar.txt[2].setText("");

			} else if (Eklemeli_dizi.length - 1 == bt.length) {
				JOptionPane.showMessageDialog(null,
						"Program Bundan Fazlasina Hazir Degil :)");
				ayar.mbt1[2].setEnabled(false);
				ayar.txt[2].setEnabled(false);
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,
					"Lütfen Sayi Giriniz! Hata Kodu : " + e);

		}

	}

	public static void Yenile() {
		durdevam = false;
		sayac = 0;
		deger = 1;
		kontrol = 0;
		mevcut = 0;
		j = 0;
		sonindex = 0;
		sayi = "";
		kirmizi = 0;

		for (int i = 0; i < bt.length; i++) {
			bt[i].setBorder(yesilborder);
		}
		ayar.lbl[1].setText("1 .Elemani Giriniz : ");
		labelleri_sifila();

	}

	public static void Kopyala() {
		for (int i = 0; i < dizi.length; i++) {
			dizi[i] = dizikopya[i];
			bt[i].setText(String.valueOf(dizi[i]));
			bt[i].setVisible(true);

		}
	}

	public static void RastDizi() {
		for (int i = 0; i < bt.length; i++) {
			bt[i].setVisible(false);
		}

		System.out.println("rast dizi");
		Random length_random = new Random();
		int a = length_random.nextInt(7) + 2;
		dizi = new int[a];
		dizikopya = new int[dizi.length];
		Random rast = new Random();
		for (int i = 0; i < a; i++) {
			dizi[i] = rast.nextInt(999);
			dizikopya[i] = dizi[i];
			bt[i].setText(String.valueOf(dizi[i]));
			bt[i].setVisible(true);
		}

	}

	public static void Sifirla() {
		mbt[7].setEnabled(true);
		ayar.txt[0].setEnabled(true);
		ayar.mbt1[0].setEnabled(true);
		mbt[4].setEnabled(true);
		ayar.mbt1[1].setEnabled(false);
		ayar.txt[1].setEnabled(false);
		ayar.txt[2].setEnabled(false);
		ayar.mbt1[2].setEnabled(false);
		mbt[8].setVisible(false);
		mbt[8].setIcon(Stopico);

		kontrol1 = 0;

		reset();

		for (int i = 0; i < bt.length; i++) {
			bt[i].setVisible(false);
		}
		ayar.lbl[1].setText("1 .Elemani Giriniz : ");

		durdevam = false;

		if (nesne.aktif == 1 || nesne1.aktif2 == 0) {
			nesne.aktif = 0;
			nesne.zaman1.stop();
			nesne.say = 6;
		} else if (nesne.aktif == 0 || nesne1.aktif2 == 1) {
			nesne1.aktif2 = 0;
			nesne1.zaman2.stop();
			nesne1.say1 = 2;

		}

	}

	public static void reset()

	{
		sayac = 0;
		deger = 1;
		kontrol = 0;
		mevcut = 0;
		j = 0;
		sonindex = 0;
		sayi = "";
		kirmizi = 0;

		for (int i = 0; i < bt.length; i++) {
			bt[i].setBorder(yesilborder);
		}

		labelleri_sifila();

	}

	public static void mevcut_degeri_yazdir(int value) {
		SözdeKodForm.degerlbl[2].setText(String.valueOf(value));
	}

	public static void mevcut_degeri_sol_yazdir(int value) {
		SözdeKodForm.degerlbl[0].setText(String.valueOf(value));
	}

	public static void kucuk_buyuk(char value) {
		if (value == 'k') {
			SözdeKodForm.degerlbl[1].setText(">");
		} else if (value == 'b') {
			SözdeKodForm.degerlbl[1].setText("<");
		} else {
			SözdeKodForm.degerlbl[0].setText("Null");
			SözdeKodForm.degerlbl[1].setText("<");
		}

	}

	public static void labelleri_sifila() {
		for (int i = 0; i < 12; i++) {
			SözdeKodForm.szdlbl[i].setForeground(Color.WHITE);
		}
		for (int i = 0; i < 3; i++) {
			SözdeKodForm.degerlbl[i].setForeground(Color.WHITE);
		}
	}

	public static void Evet_Siyah() {
		SözdeKodForm.szdlbl[2].setForeground(Color.BLACK);
		SözdeKodForm.szdlbl[3].setForeground(Color.BLACK);
		SözdeKodForm.szdlbl[4].setForeground(Color.BLACK);
		SözdeKodForm.szdlbl[5].setForeground(Color.BLACK);

	}

	public static void Hayir_Siyah() {
		SözdeKodForm.szdlbl[6].setForeground(Color.BLACK);
		SözdeKodForm.szdlbl[7].setForeground(Color.BLACK);
		SözdeKodForm.szdlbl[8].setForeground(Color.BLACK);
		SözdeKodForm.szdlbl[9].setForeground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (zamanlayici > zamanlayici_kontrol) {

			System.out.println(zamanlayici + ">=" + zamanlayici_kontrol);

			zamanlayici_kontrol += 1001;

			System.out.println("zamanlayici arttirildi..");

			saniyelabel.setText("Saniye : " + saniye);
			saniye++;

		} else {

			SözdeKodForm.szdlbl[0].setForeground(Color.BLUE);
			SözdeKodForm.szdlbl[1].setForeground(Color.YELLOW);
			SözdeKodForm.degerlbl[0].setForeground(Color.YELLOW);
			SözdeKodForm.degerlbl[2].setForeground(Color.BLUE);

			SözdeKodForm.degerlbl[0].setFont(new Font("Serif", Font.BOLD, 35));
			SözdeKodForm.degerlbl[2].setFont(new Font("Serif", Font.BOLD, 35));
			if (durdevam) {

				if (sayac != dizi.length) {

					sayac++;

					if (deger < dizi.length) {

						if (kontrol == 0) {

							j = deger;
							mevcut = dizi[deger];
							sonindex = j + 1;

							// szdlbl[0].setText(String.valueOf("Mevcut Eleman : Deger[i] --- "+
							// mevcut));

							mevcut_degeri_yazdir(mevcut);

						}
						if (j > 0 && mevcut < dizi[j - 1]) {

							dizi[j] = dizi[j - 1];
							j--;
							deger--;
							kontrol = 1;
							sayac = 0;

							if (j - 1 >= 0) {
								bt[j - 1].setBorder(yesilborder);
								mevcut_degeri_sol_yazdir(Integer
										.valueOf(bt[j - 1].getText()));
								// SözdeKodForm.szdlbl[1].setText("Bir öncekinden Küçük Mü? --- "+
								// bt[j - 1].getText());

								// szdlbl[2].setText("Kucuk");

								if (j - 2 >= 0 && mevcut > dizi[j - 1]) {

									// sözde kod
									Hayir_Siyah();
									kucuk_buyuk('b');
									zaman.stop();

									nesne.zaman1.start();

								} else if (j - 1 == 0 && mevcut > dizi[0]) {
									// szdlbl[2].setText("Buyuk");
									Hayir_Siyah();
									kucuk_buyuk('b');
									zaman.stop();

									nesne.zaman1.start();
								} else {
									Evet_Siyah();
									kucuk_buyuk('k');
									zaman.stop();

									nesne1.zaman2.start();
								}

							} else {
								// szdlbl[1].setText("yok");
								Hayir_Siyah();
								kucuk_buyuk('d');
								zaman.stop();

								nesne.zaman1.start();

							}
							if (j + 1 < dizi.length) {
								bt[j + 1].setBorder(yesilborder);
							}

							bt[j].setBorder(maviborder);

						} else {

							if (sonindex < dizi.length && sonindex - 1 >= 0) {
								bt[sonindex].setBorder(maviborder);

								mevcut_degeri_yazdir(Integer
										.valueOf(bt[sonindex].getText()));
								mevcut_degeri_sol_yazdir(Integer
										.valueOf(bt[sonindex - 1].getText()));

								int sayi1 = Integer.valueOf(bt[sonindex]
										.getText());
								int sayi2 = Integer.valueOf(bt[sonindex - 1]
										.getText());
								if (sayi1 > sayi2) {
									// szdlbl[2].setText("Buyuk");
									Hayir_Siyah();
									kucuk_buyuk('b');
									zaman.stop();

									nesne.zaman1.start();

								} else if (sayi2 > sayi1) {
									// szdlbl[2].setText("Kucuk");
									Evet_Siyah();
									kucuk_buyuk('k');

									zaman.stop();

									nesne1.zaman2.start();

								}

							}

							bt[j].setBorder(yesilborder);

							kontrol = 0;

						}

						dizi[j] = mevcut;
						deger++;

						for (int z = 0; z < dizi.length; z++) {
							sayi = String.valueOf(dizi[z]);
							bt[z].setText(sayi);

						}

					} else {
						kontrol1 = 1;
						// durdevam = false;
					}
				}

				if (kontrol1 == 1) {

					labelleri_sifila();
					SözdeKodForm.szdlbl[10].setForeground(Color.GREEN);
					SözdeKodForm.szdlbl[11].setForeground(Color.RED);
					bt[kirmizi].setBorder(kirmiziborder);
					kirmizi++;
					if (kirmizi == dizi.length) {
						mbt[7].setEnabled(true);
						mbt[8].setIcon(Tryico);
						dur_devam_tekrar = 2;
						kontrol1 = 0;
						durdevam = false;
						zaman.stop();
					}
				}
			}
			zamanlayici_kontrol = 0;
			saniye = 1;
			System.out.println("Zamanlayici sifirlandi");

		}
	}
}

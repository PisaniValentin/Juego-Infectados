package Juego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	protected JPanel calle;
	protected Mapa mapa;
	private CustomPanel contentPane;

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 541);
		contentPane = new CustomPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);

	}

	public void setMapa(Mapa m) {
		mapa = m;
	}
}

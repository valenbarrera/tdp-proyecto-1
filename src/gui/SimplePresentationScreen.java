package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.SystemColor;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextPane lu_textPane, apellido_textPane, nombre_textPane, mail_textPane, git_textPane;
	private JLabel LU_label, apellido_label, nombre_label, mail_label, git_label;
	private JTextPane hora_textPane;
	private JLabel foto_label;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");

		//Icono de la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(630, 277));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		// Etiquetas
		LU_label = new JLabel("LU");
		LU_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LU_label.setBounds(20, 24, 45, 13);
		tabInformation.add(LU_label);
		
		apellido_label = new JLabel("Apellido");
		apellido_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		apellido_label.setBounds(20, 54, 66, 13);
		tabInformation.add(apellido_label);
		
		nombre_label = new JLabel("Nombre");
		nombre_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombre_label.setBounds(20, 85, 66, 13);
		tabInformation.add(nombre_label);
		
		mail_label = new JLabel("E-mail");
		mail_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mail_label.setBounds(20, 116, 45, 13);
		tabInformation.add(mail_label);
		
		git_label = new JLabel("Github URL");
		git_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		git_label.setBounds(20, 147, 66, 13);
		tabInformation.add(git_label);
		
		// Paneles de texto con la informacion del alumno
		lu_textPane = new JTextPane();
		lu_textPane.setBounds(96, 21, 307, 19);
		lu_textPane.setText(""+studentData.getId());
		tabInformation.add(lu_textPane);
		
		apellido_textPane = new JTextPane();
		apellido_textPane.setBounds(96, 52, 307, 19);
		apellido_textPane.setText(""+studentData.getLastName());
		tabInformation.add(apellido_textPane);
		
		nombre_textPane = new JTextPane();
		nombre_textPane.setBounds(96, 83, 307, 19);
		nombre_textPane.setText(""+studentData.getFirstName());
		tabInformation.add(nombre_textPane);
		
		mail_textPane = new JTextPane();
		mail_textPane.setBounds(96, 114, 307, 19);
		mail_textPane.setText(""+studentData.getMail());
		tabInformation.add(mail_textPane);
		
		git_textPane = new JTextPane();
		git_textPane.setBounds(96, 145, 307, 19);
		git_textPane.setText(""+studentData.getGithubURL());
		tabInformation.add(git_textPane);
		
		contentPane.add(tabbedPane);
		
		// Fecha y hora de apertura de la ventana
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		String time = format.format(LocalTime.now());
		LocalDate date = LocalDate.now();
		hora_textPane = new JTextPane();
		hora_textPane.setBounds(5, 216, 601, 19);
		hora_textPane.setBackground(SystemColor.menu);
		hora_textPane.setText("Esta ventana fue generada el "+date+" a las: "+time);
		contentPane.add(hora_textPane);
		
		// Etiqueta con foto del alumno
		foto_label = new JLabel("New label");
		foto_label.setBounds(445, 36, 161, 161);
		contentPane.add(foto_label);
		ImageIcon foto = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Image fotoRedimensionada = foto.getImage().getScaledInstance(foto_label.getWidth(), foto_label.getHeight(), Image.SCALE_AREA_AVERAGING);
		foto = new ImageIcon(fotoRedimensionada);
		foto_label.setIcon(foto);
		
	}
}

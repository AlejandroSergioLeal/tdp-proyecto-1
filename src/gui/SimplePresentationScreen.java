package gui;


import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblEMail;
	private JLabel lblGH;
	private JTextField LUText;
	private JTextField apellidoText;
	private JTextField nombreText;
	private JTextField mailText;
	private JTextField ghText;
	private Integer legajoInteger;
	private JLabel labelFoto;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 265));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 202);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 14, 37, 14);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 42, 53, 14);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 73, 53, 14);
		
		lblEMail = new JLabel("E-Mail");
		lblEMail.setBounds(10, 104, 53, 14);
		
		lblGH = new JLabel("Github URL");
		lblGH.setBounds(10, 136, 65, 14);
		
		
		LUText = new JTextField();
		LUText.setBounds(89, 11, 300, 20);
		LUText.setColumns(10);
		legajoInteger = studentData.getId();
		contentPane.setLayout(null);
		LUText.setText(legajoInteger.toString());
		
		apellidoText = new JTextField();
		apellidoText.setBounds(89, 39, 300, 20);
		apellidoText.setColumns(10);
		apellidoText.setText(studentData.getLastName());
		
		nombreText = new JTextField();
		nombreText.setBounds(89, 70, 300, 20);
		nombreText.setColumns(10);
		nombreText.setText(studentData.getFirstName());
		
		mailText = new JTextField();
		mailText.setBounds(89, 101, 300, 20);
		mailText.setColumns(10);
		mailText.setText(studentData.getMail());
		
		ghText = new JTextField();
		ghText.setBounds(89, 133, 300, 20);
		ghText.setColumns(10);
		ghText.setText(studentData.getGithubURL());
		
		tabInformation.setLayout(null);
		tabInformation.add(lblGH);
		tabInformation.add(ghText);
		tabInformation.add(lblLU);
		tabInformation.add(lblApellido);
		tabInformation.add(lblNombre);
		tabInformation.add(lblEMail);
		tabInformation.add(mailText);
		tabInformation.add(nombreText);
		tabInformation.add(apellidoText);
		tabInformation.add(LUText);
		
		contentPane.add(tabbedPane);
		
		JLabel lblInfo = new JLabel("Esta ventana fue creada el " + getFechaHora());
		lblInfo.setBounds(5, 207, 589, 14);
		contentPane.add(lblInfo);
		
		labelFoto = new JLabel("New label");
		labelFoto.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));
		labelFoto.setBounds(452, 29, 130, 150);
		contentPane.add(labelFoto);
	}
	
	private String getFechaHora() {
		Calendar calendario = new GregorianCalendar();
		Integer dia = calendario.get(Calendar.DAY_OF_MONTH);
		Integer mes = calendario.get(Calendar.MONTH) + 1;
		Integer anio = calendario.get(Calendar.YEAR);
		Integer hora = calendario.get(Calendar.HOUR_OF_DAY);
		Integer minutos = calendario.get(Calendar.MINUTE);
		Integer segundos = calendario.get(Calendar.SECOND);
		String fecha = dia.toString() +"/"+ mes.toString()+"/"+anio.toString();
		String reloj;
		
		reloj = hora<10 ? "0" : ""; 
		reloj += hora.toString();
		
		reloj += minutos<10? ":0" : ":";
		reloj += minutos.toString();
		
		reloj += segundos<10 ? ":0" : ":";
		reloj += segundos.toString();
		
		return fecha +" a las: " + reloj;
	}

}

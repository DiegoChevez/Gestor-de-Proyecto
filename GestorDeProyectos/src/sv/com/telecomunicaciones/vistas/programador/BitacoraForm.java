package sv.com.telecomunicaciones.vistas.programador;

import javax.swing.*;
import java.awt.*;

public class BitacoraForm extends JFrame{
	private JPanel pnlBitacoras;
	private JTable table1;
	private JTextField textField1;
	private JTextField textField2;
	private JButton agregrarButton;
	private JButton limpiarButton;
	private JButton marcasComoCompletoButton;

	public BitacoraForm(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlBitacoras);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(getParent());
	}
}

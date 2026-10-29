import javax.swing.*;
import java.awt.*;

public class PRUEBA extends JFrame {

	private final JTextField nombre = new JTextField(20);
	private final JTextField correo = new JTextField(20);

	public PRUEBA() {
		super("Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));
		formulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		formulario.add(new JLabel("Nombre:"));
		formulario.add(nombre);
		formulario.add(new JLabel("Correo electrónico:"));
		formulario.add(correo);

		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(event -> JOptionPane.showMessageDialog(
				this, "Formulario enviado para " + nombre.getText()));
		formulario.add(new JLabel());
		formulario.add(enviar);

		add(formulario);
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new PRUEBA().setVisible(true));
	}
}
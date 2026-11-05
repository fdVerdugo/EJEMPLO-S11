import javax.swing.*;
import java.awt.*;

public class InspectorDeDatos extends JFrame {

    public InspectorDeDatos() {
        setTitle("Inspector de Datos");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelEntrada = new JPanel(new FlowLayout());
        JLabel lblInstruccion = new JLabel("Ingrese un dato (texto o número):");
        JTextField campoEntrada = new JTextField(20);
        campoEntrada.setPreferredSize(new Dimension(300, 100));
        panelEntrada.add(lblInstruccion);
        panelEntrada.add(campoEntrada);

        JPanel panelAcciones = new JPanel(new FlowLayout());
        JButton btnAnalizarTexto = new JButton("Analizar como Texto");
        JButton btnOperarNumero = new JButton("Operar como Número");
        JButton btnJuegoAdivina = new JButton("¡Adivina el Número!");
        panelAcciones.add(btnAnalizarTexto);
        panelAcciones.add(btnOperarNumero);
        panelAcciones.add(btnJuegoAdivina);

        JPanel panelResultados = new JPanel(new GridLayout(6, 1, 5, 5));
        JLabel labelLargo = new JLabel("Largo: ...");
        JLabel labelMayus = new JLabel("Mayúsculas: ...");
        JLabel labelRaiz = new JLabel("Raíz Cuadrada: ...");
        JLabel labelPotencia = new JLabel("Al Cuadrado: ...");
        JLabel labelJuego = new JLabel("Resultado del Juego: ...");
        JLabel labelError = new JLabel("", SwingConstants.CENTER);
        labelError.setForeground(Color.RED); 

        panelResultados.add(labelLargo);
        panelResultados.add(labelMayus);
        panelResultados.add(labelRaiz);
        panelResultados.add(labelPotencia);
        panelResultados.add(labelJuego);
        panelResultados.add(labelError);

        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(panelAcciones, BorderLayout.CENTER);
        panelPrincipal.add(panelResultados, BorderLayout.SOUTH);
        add(panelPrincipal);

        btnAnalizarTexto.addActionListener(e -> {
            labelError.setText("");
            String texto = campoEntrada.getText();
            int largo = texto.length();
            String mayus = texto.toUpperCase();

            labelLargo.setText("Largo: " + largo);
            labelMayus.setText("Mayúsculas: " + mayus);
        });

   
        btnOperarNumero.addActionListener(e -> {
            labelError.setText("");
            try {
                double numero = Double.parseDouble(campoEntrada.getText().trim());
                double raiz = Math.sqrt(numero);
                double potencia = Math.pow(numero, 2);

                labelRaiz.setText("Raíz Cuadrada: " + String.valueOf(raiz));
                labelPotencia.setText("Al Cuadrado: " + String.valueOf(potencia));
            } catch (NumberFormatException error) {
                labelError.setText("Error: Debes ingresar un número válido para operar.");
            }
        });

        
        btnJuegoAdivina.addActionListener(e -> {
            labelError.setText("");
            int secreto = (int) (Math.random() * 10) + 1;

            try {
                int intento = Integer.parseInt(campoEntrada.getText().trim());
                if (intento == secreto) {
                    labelJuego.setText("¡Ganaste! El número secreto era " + secreto);
                } else {
                    labelJuego.setText("Perdiste. Era " + secreto + ", tú dijiste " + intento);
                }
            } catch (NumberFormatException error) {
                labelError.setText("Error: Debes ingresar un número entero (1-10).");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InspectorDeDatos().setVisible(true));
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author Jose Luis Luengo Ramos
 **
 */
public class ActionBoton implements ActionListener{

	private VentanaPrincipal ventana;
	private int i;
	private int j;

	public ActionBoton(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public ActionBoton(VentanaPrincipal ventana, int i, int j){
		this.ventana=ventana;
		this.i=i;
		this.j=j;
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton jbAux = (JButton) e.getSource();

		if(jbAux.getText().equals("Go!")){
			ventana.getJuego().inicializarPartida();
			ventana.ventana.setContentPane(new JPanel(new BorderLayout()));
			ventana.inicializar();
			ventana.refrescarPantalla();
		} else {
			if(ventana.getJuego().abrirCasilla(this.i,this.j)){
				ventana.mostrarNumMinasAlrededor(this.i,this.j);
				ventana.actualizarPuntuacion();
				ventana.refrescarPantalla();
				if(ventana.getJuego().getPuntuacion()==80)
				ventana.mostrarFinJuego(ventana.getJuego().esFinJuego());
			} else {
				ventana.mostrarFinJuego(ventana.getJuego().esFinJuego());
				ventana.refrescarPantalla();
			}

		}

	}

}

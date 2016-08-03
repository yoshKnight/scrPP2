package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import pp2.scrum.app.AppScrum;
import pp2.scrum.controller.ProyectoController;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.ProyectoNuevo;

public class ProyectoNuevoView extends JDialog
{
   private ProyectoController controller;
   private ProyectoNuevo nuevoProyecto;
   private final JPanel contentPanel = new JPanel();
   private JTextField titulo;
   private JList<Miembro> miembrosCombo;
   private JButton siguientebtn, cancelButton;
   private JComboBox<Integer> comboduracionIteraciones,combocantidadIteraciones ;

   /**
    * Launch the application.
    */

   /**
    * Create the dialog.
    */
   public ProyectoNuevoView(ProyectoController proyectoController,ProyectoNuevo newProyecto)
   {
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      setModalityType(ModalityType.APPLICATION_MODAL);
      this.controller = proyectoController;
      nuevoProyecto= newProyecto;
      setTitle("Nuevo Proyecto");
      setBounds(100, 100, 450, 300);
      setLocationRelativeTo(null);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      
      JLabel lblNombreDelProyecto = new JLabel("Nombre del Proyecto:");
      lblNombreDelProyecto.setBounds(10, 11, 134, 14);
      contentPanel.add(lblNombreDelProyecto);
      
      titulo = new JTextField();
      titulo.setBounds(181, 8, 134, 20);
      contentPanel.add(titulo);
      titulo.setColumns(10);
      
          
      JLabel lblFechaInicio = new JLabel("Cantidad de Iteraciones:");
      lblFechaInicio.setBounds(10, 36, 161, 32);
      contentPanel.add(lblFechaInicio);
      
      JLabel lblFechaFin = new JLabel("Duración Iteracion (Dias):");
      lblFechaFin.setBounds(10, 83, 161, 29);
      contentPanel.add(lblFechaFin);
      
      JLabel lblLiderResponsable = new JLabel("Miembros");
      lblLiderResponsable.setBounds(10, 133, 113, 20);
      contentPanel.add(lblLiderResponsable);
      
      combocantidadIteraciones = new JComboBox<Integer>();
      combocantidadIteraciones.setBounds(181, 42, 41, 20);
      // TODO levantar estos numeros desde la configuracion
      combocantidadIteraciones.addItem(1);
      combocantidadIteraciones.addItem(2);
      combocantidadIteraciones.addItem(3);
      combocantidadIteraciones.addItem(4);
      combocantidadIteraciones.addItem(5);
      combocantidadIteraciones.addItem(6);
      combocantidadIteraciones.addItem(7);
      contentPanel.add(combocantidadIteraciones);
      
      comboduracionIteraciones = new JComboBox<Integer>();
      comboduracionIteraciones.setBounds(181, 87, 41, 20);
      // TODO levantar estos numeros desde la configuracion
      comboduracionIteraciones.addItem(14);
      comboduracionIteraciones.addItem(21);
      contentPanel.add(comboduracionIteraciones);
      DefaultListModel<Miembro> miembros =new DefaultListModel<Miembro>();
      // TODO Pedir al proyectoController
      miembros.addElement(new Miembro("Jose"));
      miembros.addElement(new Miembro("Ivo"));
      miembros.addElement(new Miembro("Julian"));
      miembros.addElement(new Miembro("Marcelo"));
      miembros.addElement(new Miembro("Javier"));
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(181, 133, 113, 68);
      contentPanel.add(scrollPane);
      
      
      
      miembrosCombo = new JList<Miembro>();
      scrollPane.setViewportView(miembrosCombo);
      miembrosCombo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
      miembrosCombo.setVisibleRowCount(10);
      miembrosCombo.setModel(miembros);
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      siguientebtn = new JButton("Crear");
      siguientebtn.setActionCommand("OK");
      siguientebtn.addActionListener( new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              nuevoProyecto.setNombre(titulo.getText());
              Proyecto proyecto = controller.save(nuevoProyecto);
              if (proyecto != null)
                  JOptionPane.showMessageDialog(null, "Proyecto guardado Correctamente", "Pproyecto guardado", JOptionPane.INFORMATION_MESSAGE);
              else
                  JOptionPane.showMessageDialog(null, "No se pudo guardar el proyecto", "Error guardando proyecto", JOptionPane.ERROR_MESSAGE);
          }
      });
      buttonPane.add(siguientebtn);
      cancelButton = new JButton("Cancel");
      cancelButton.setActionCommand("Cancel");
      buttonPane.add(cancelButton);
   }
   
   public void addsiguienteBtnListener(ActionListener listener) {
//      siguientebtn.addActionListener(listener);
   }
   
   public void addcancelBtnListener(ActionListener listener) {
      cancelButton.addActionListener(listener);
   }
   
   public String getTitulo(){
      return titulo.getText();
   }
   
   public int getDuracionIteraciones(){
      return (int)comboduracionIteraciones.getSelectedItem();
   }
   
   public int getCantidadIteraciones(){
      return (int)combocantidadIteraciones.getSelectedItem();
   }
   
   public List<Miembro> getMiembros(){
      return miembrosCombo.getSelectedValuesList();
   }
   
   public void limpiarPantalla()
   {
      titulo.setText("");
      comboduracionIteraciones.setSelectedIndex(0);
      combocantidadIteraciones.setSelectedIndex(0);
      miembrosCombo.clearSelection();
   }
}

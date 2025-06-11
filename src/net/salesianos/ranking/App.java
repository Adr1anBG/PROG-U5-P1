package net.salesianos.ranking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Clase principal de la aplicación.
 * Implementa una interfaz gráfica con Swing para gestionar deportistas.
 */
public class App extends JFrame {

    // =========================
    // Atributos de la interfaz
    // =========================

    private SportsmanManager manager;   // Clase que gestiona la lista de deportistas
    private JTextArea displayArea;      // Área para mostrar información

    // =========================
    // Constructor
    // =========================

    public App() {
        manager = new SportsmanManager();  // Inicializa el gestor
        setupUI();                          // Configura la interfaz gráfica
    }

    // =========================
    // Configuración de la UI
    // =========================

    private void setupUI() {
        setTitle("Ranking Deportistas");                 // Título de la ventana
        setSize(600, 400);                               // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);         // Cierra la app al cerrar la ventana
        setLocationRelativeTo(null);                     // Centra la ventana
        setLayout(new BorderLayout());                   // Usa BorderLayout para organizar componentes

        // ---- Área de texto central ----
        displayArea = new JTextArea();                   // Crea el área de texto
        displayArea.setEditable(false);                  // Solo lectura
        JScrollPane scrollPane = new JScrollPane(displayArea);  // Añade scroll
        add(scrollPane, BorderLayout.CENTER);            // Añade al centro de la ventana

        // ---- Panel con botones ----
        JPanel buttonPanel = new JPanel(new FlowLayout()); // Panel inferior con botones

        // Botones para las acciones principales
        JButton addButton = new JButton("Añadir");
        JButton editButton = new JButton("Editar");
        JButton deleteButton = new JButton("Eliminar");
        JButton showButton = new JButton("Mostrar Todo");
        JButton exitButton = new JButton("Salir");

        // Añade los botones al panel
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH); // Coloca el panel en la parte inferior

        // ---- Asignación de acciones a botones ----
        addButton.addActionListener(this::onAdd);       // Acción para añadir
        editButton.addActionListener(this::onEdit);     // Acción para editar
        deleteButton.addActionListener(this::onDelete); // Acción para eliminar
        showButton.addActionListener(this::onShowAll);  // Acción para mostrar todos
        exitButton.addActionListener(e -> System.exit(0)); // Cierra el programa

        setVisible(true); // Muestra la ventana
    }

    // =========================
    // Acción: Añadir deportista
    // =========================

    private void onAdd(ActionEvent e) {
        try {
            String name = JOptionPane.showInputDialog(this, "Nombre:");
            if (name == null || name.trim().isEmpty()) return;

            int age = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));

            String sport = JOptionPane.showInputDialog(this, "Deporte:");
            if (sport == null || sport.trim().isEmpty()) return;

            int rating = Integer.parseInt(JOptionPane.showInputDialog(this, "Rating (1-5):"));

            // Validación del rating
            if (rating < 1 || rating > 5) {
                displayArea.setText("El rating debe estar entre 1 y 5.\n");
                return;
            }

            // Crea el deportista y lo añade
            Sportsman newS = new Sportsman(name, age, sport, rating);
            manager.addSportsman(newS);
            displayArea.setText("Deportista añadido correctamente.\n");

        } catch (Exception ex) {
            displayArea.setText("Error al añadir deportista. Verifica los datos.\n");
        }
    }

    // =========================
    // Acción: Editar deportista
    // =========================

    private void onEdit(ActionEvent e) {
        try {
            String name = JOptionPane.showInputDialog(this, "Nombre del deportista a editar:");
            if (name == null || name.trim().isEmpty()) return;

            int age = Integer.parseInt(JOptionPane.showInputDialog(this, "Nueva Edad:"));

            String sport = JOptionPane.showInputDialog(this, "Nuevo Deporte:");
            if (sport == null || sport.trim().isEmpty()) return;

            int rating = Integer.parseInt(JOptionPane.showInputDialog(this, "Nuevo Rating (1-5):"));

            // Validación del rating
            if (rating < 1 || rating > 5) {
                displayArea.setText("El rating debe estar entre 1 y 5.\n");
                return;
            }

            // Intenta editar el deportista
            boolean result = manager.editSportsman(name, age, sport, rating);
            displayArea.setText(result ? "Deportista editado correctamente.\n" : "Deportista no encontrado.\n");

        } catch (Exception ex) {
            displayArea.setText("Error al editar deportista. Verifica los datos.\n");
        }
    }

    // =========================
    // Acción: Eliminar deportista
    // =========================

    private void onDelete(ActionEvent e) {
        String name = JOptionPane.showInputDialog(this, "Nombre del deportista a eliminar:");
        if (name == null || name.trim().isEmpty()) return;

        boolean result = manager.removeSportsman(name);
        displayArea.setText(result ? "Deportista eliminado correctamente.\n" : "Deportista no encontrado.\n");
    }

    // =========================
    // Acción: Mostrar todos los deportistas ordenados
    // =========================

    private void onShowAll(ActionEvent e) {
        ArrayList<Sportsman> list = manager.getAllSportsmenOrderedByRating();

        if (list.isEmpty()) {
            displayArea.setText("No hay deportistas registrados.\n");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Sportsman s : list) {
                sb.append(s).append("\n--------------------\n");
            }
            displayArea.setText(sb.toString());
        }
    }

    // =========================
    // Punto de entrada del programa
    // =========================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new); // Lanza la interfaz en el hilo de eventos de Swing
    }
}


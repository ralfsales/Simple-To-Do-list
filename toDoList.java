/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rafae
 */
public class toDoList {

    
    // Main frame
    private JFrame frame;
    private JTextField taskField;
    private JList<String> taskList;
    private DefaultListModel<String> taskListModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                toDoList window = new toDoList();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor to initialize the GUI
    public toDoList() {
        frame = new JFrame("To-Do List Application");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel for the input field and buttons
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout());

        // Text field for task input
        taskField = new JTextField(20);
        panel.add(taskField);

        // Button to add task
        JButton addButton = new JButton("Add Task");
        panel.add(addButton);

        // Button to remove selected task
        JButton removeButton = new JButton("Remove Task");
        panel.add(removeButton);

        // Create the list model and add it to JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Add action listener to the Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task); // Add the task to the list
                    taskField.setText(""); // Clear the text field
                }
            }
        });

        // Add action listener to the Remove button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected task index
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex); // Remove the selected task
                }
            }
        });
    }
}

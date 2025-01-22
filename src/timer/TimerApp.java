package timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main class for the Lab06 Timer application.
 * This class provides a simple timer GUI application that calculates
 * the elapsed time between pressing "Start" and "Stop".
 * @author Chang Hsin Yu
 * @version 1.0
 */

public class TimerApp {

    // Variables to store the start and stop time
    private long startTime;
    private long stopTime;

    /**
     * The main method serves as the entry point for the Timer application
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Run the application in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new TimerApp().createAndShowGUI());
    }

    /**
     * Creates and displays the GUI for the TimerApp.
     * The GUI includes two buttons: start and stop
     */
    public void createAndShowGUI() {
        // Create the main application frame
        JFrame frame = new JFrame("Timer Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create buttons
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        // Panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(startButton);
        panel.add(stopButton);

        // Add panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Add action listeners to the buttons
        startButton.addActionListener(new ActionListener() {
            /**
             * Handles the action event for the "Start" button.
             * Records the current system time as the start time and
             * displays a confirmation dialog.
             * @param e the action event triggered by the "Start" button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Record the start time
                startTime = System.currentTimeMillis();
                JOptionPane.showMessageDialog(frame, "Timer started!", "Start", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        stopButton.addActionListener(new ActionListener() {

            /**
             * Handles the action event for the "Stop" button.
             * Records the current system time as the stop time, calculates
             * the elapsed time, and displays the result in a dialog box.
             * @param e the action event triggered by the "Stop" button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Record the stop time and calculate elapsed time
                stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                // Show the elapsed time in a dialog box
                JOptionPane.showMessageDialog(frame,
                        "Elapsed time: " + elapsedTime + " milliseconds",
                        "Stop",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
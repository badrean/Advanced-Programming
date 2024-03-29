package lab6.compulsory;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);

        //invoke the layout manager
        pack();
    }
}

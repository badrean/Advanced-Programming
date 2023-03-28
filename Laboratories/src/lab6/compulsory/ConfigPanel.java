package lab6.compulsory;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel, dotsField;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 1, 100, 1));
        linesLabel = new JLabel("Line probability:");

        String[] probabilities = {Double.toString(1.00), Double.toString(0.75), Double.toString(0.5), Double.toString(0.25)};
        linesCombo = new JComboBox(probabilities);

        createButton = new JButton("Create new game");

        dotsSpinner.setValue(6); //default number of sides

        //create the rest of the components
        add(dotsLabel);
        add(dotsSpinner); //JPanel uses FlowLayout by default
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }

    public JSpinner getDotsSpinner() {
        return dotsSpinner;
    }

    public JComboBox getLinesCombo() {
        return linesCombo;
    }

    public JButton geCreateButton() {
        return createButton;
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterView implements ActionListener {

    private JLabel label = new JLabel("Empty fields above");
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

	private JTextField redTextField = new JTextField(5);
	private JTextField greenTextField = new JTextField(5);
	private JTextField blueTextField = new JTextField(5);

	
    public ConverterView() {
    	frame.setTitle("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	buildPanel();
        frame.add(panel, BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
    public void buildPanel() {
    	// we could still create a method for doing this and add the text field later here
    	JPanel redPanel = createColorInputPanel("Red");
    	redPanel.add(redTextField);
    	
    	JPanel greenPanel = createColorInputPanel("Green");
    	greenPanel.add(greenTextField);
    	
    	JPanel bluePanel = createColorInputPanel("Blue");
    	bluePanel.add(blueTextField);
    	
        JButton button = new JButton("Convert");
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        
        panel.add(redPanel);
        panel.add(greenPanel);
        panel.add(bluePanel);
        panel.add(button);
        panel.add(label);
    }
    
    
    public JPanel createColorInputPanel(String color) {
    	JPanel colorPanel = new JPanel();
    	JLabel colorLabel = new JLabel(color + ":");
    	colorPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    	colorPanel.setLayout(new GridLayout(1, 0));
    	colorPanel.add(colorLabel);
    	return colorPanel;
    }
    

    public void actionPerformed(ActionEvent e) {
    	// handle errors
    	int redInput = Integer.parseInt(redTextField.getText());
    	int greenInput = Integer.parseInt(greenTextField.getText());
    	int blueInput = Integer.parseInt(blueTextField.getText());
    	
        label.setText("#" + Integer.toString(redInput, 16) + "" + Integer.toString(greenInput, 16) + "" + Integer.toString(blueInput, 16));
        label.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
    }
    

    // create one Frame
    public static void main(String[] args) {
        new ConverterView();
    }
}
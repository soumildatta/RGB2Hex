import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterView implements ActionListener {

    private JTextPane hexPane = new JTextPane();
    private JTextPane UIColorPane = new JTextPane();
    
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

	private JTextField redTextField = new JTextField(5);
	private JTextField greenTextField = new JTextField(5);
	private JTextField blueTextField = new JTextField(5);

	
    public ConverterView() {
    	frame.setTitle("RGB To UIColor Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	buildPanel();
        frame.add(panel, BorderLayout.CENTER);
        
        frame.setSize(600, 450);
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
    	
    	JPanel UIColorPanel = new JPanel();
    	UIColorPanel.add(UIColorPane);
    	
    	JPanel hexPanel = new JPanel();
    	hexPanel.add(hexPane);
    	hexPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

    	
    	
    	
    	// center the text pane items
    	StyledDocument doc1 = UIColorPane.getStyledDocument();
    	SimpleAttributeSet center1 = new SimpleAttributeSet();
    	StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
    	doc1.setParagraphAttributes(0, doc1.getLength(), center1, false);
    	
    	StyledDocument doc2 = hexPane.getStyledDocument();
    	SimpleAttributeSet center2 = new SimpleAttributeSet();
    	StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
    	doc2.setParagraphAttributes(0, doc2.getLength(), center2, false);
    	
    	
    	
        JButton button = new JButton("Convert");
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
        panel.setLayout(new GridLayout(0, 1));
        
        hexPane.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        hexPane.setText("Empty text fields above");
        hexPane.setEditable(false);
        hexPane.setBackground(null);
        hexPane.setBorder(null); 
        
        UIColorPane.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        UIColorPane.setEditable(false);
        UIColorPane.setBackground(null); 
        UIColorPane.setBorder(null);
        
        panel.add(redPanel);
        panel.add(greenPanel);
        panel.add(bluePanel);
        panel.add(button);        
        panel.add(hexPanel);
        panel.add(UIColorPanel);
    }
    
    
    public JPanel createColorInputPanel(String color) {
    	JPanel colorPanel = new JPanel();
    	JLabel colorLabel = new JLabel(color + ":");
    	colorPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
    	colorPanel.setLayout(new GridLayout(1, 0));
    	colorPanel.add(colorLabel);
    	return colorPanel;
    }
    
    public String formatHexString(int value) {
    	String result;
    	if(Integer.toString(value, 16).length() < 2) {
    		result = "0" + Integer.toString(value, 16);
    	} else {
    		result = Integer.toString(value, 16);
    	}
    	
    	return result;
    }
    
    public String formatUIColorString(int red, int green, int blue) {
    	float redValue = (float) (red/255.0);
    	float greenValue = (float) (green/255.0);
    	float blueValue = (float) (blue/255.0);
    	
    	String result = String.format("UIColor(red: %.3f, green: %.3f, blue: %.3f, alpha: 1.00)", redValue, greenValue, blueValue);
    	return result;
    }

    public void actionPerformed(ActionEvent e) {
    	// handle errors
    	int redInput = Integer.parseInt(redTextField.getText());
    	int greenInput = Integer.parseInt(greenTextField.getText());
    	int blueInput = Integer.parseInt(blueTextField.getText());
    	
    	String redHex = formatHexString(redInput);
    	String greenHex = formatHexString(greenInput);
    	String blueHex = formatHexString(blueInput);
    	
    	
        hexPane.setText("#" + redHex + "" + greenHex + "" + blueHex);
        hexPane.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        
        UIColorPane.setText(formatUIColorString(redInput, greenInput, blueInput));
    }
    
    // create one Frame
    public static void main(String[] args) {
        new ConverterView();
    }
}
package uni.fmi.bachelors;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstForm frame = new FirstForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblHello = new JLabel("Hello");
		panel.add(lblHello);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JButton bSayHello = new JButton("Hello");
		bSayHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = tfName.getText();
				lblHello.setText("Hello " + name);
			}
		});
		panel.add(bSayHello);
		
		JButton bReset = new JButton("Reset");
		
		bReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				
			}
		});
		
		panel.add(bReset);
	}

}

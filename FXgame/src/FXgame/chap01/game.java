package FXgame.chap01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class game extends JFrame implements ActionListener{

	String str;
	private JTextField textfield; 
	game(){
		
		setTitle("editor");
		setBounds(500, 80, 500, 80);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textfield = new JTextField(20);
		textfield.addActionListener(this);
		JLabel label = new JLabel("excelにoutputしたい文字を入力して下さい。。。");
		JPanel p = new JPanel();
		p.add(textfield);
		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);

	}

	
	
	public static void main(String[] args) {

		game frame = new game();
		
		frame.setVisible(true);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	
		this.dispose();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("excel出力");
		frame.setBounds(500, 80, 500, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField text = new JTextField(20);
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String textstr = textfield.getText();
				
			
			str = text.getText();
			ExcelOut ex = new ExcelOut();
			ex.ExcelOutExe(str,textstr);
			
			}				
		});	
		JPanel p = new JPanel();
		p.add(text);
		JLabel label = new JLabel("保存するexcel名入力。。。");
		Container contentPane = frame.getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);

		frame.setVisible(true);		
	}
}
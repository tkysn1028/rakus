package FXgame.chap01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExcelQuestion{
String textstr;
	public static void main(String[] args) {
		
		ExcelQuestion q = new ExcelQuestion();
		JFrame frame = new JFrame();
		frame.setTitle("editor");
		frame.setBounds(400, 0, 850, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textarea = new JTextArea(40,40);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		JScrollPane scr = new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JButton bt = new JButton("get");	
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				q.textstr = textarea.getText();
				String str1[] = q.textstr.split("\n");

				for(String result : str1) {
					System.out.println(result);
				}				
			}
		});
		JPanel p = new JPanel();
		p.add(scr);
		p.add(bt);
		Container contentPane = frame.getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		frame.setVisible(true);


		
		
	
}
}
package Practice.java.chap01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PracticeText extends JFrame implements ActionListener{

	private JTextField title;
	private JTextArea text;	
	public PracticeText() {
				
	setBounds(400, 0, 850, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("タイトル");

	text = new JTextArea(40,40);
	title = new JTextField(10); 
				
	text.setLineWrap(true);
	text.setWrapStyleWord(true);
	JScrollPane scr = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				
				
	JButton bt1 = new JButton("exit");
	JButton bt2 = new JButton("record");
	JButton bt3 = new JButton("export");
				
	bt1.addActionListener(this);
				
				JPanel jp = new JPanel();
				jp.add(title);
				jp.add(scr);
				jp.add(bt2);
				jp.add(bt3);
				jp.add(bt1);
				
				Container contentPane = getContentPane();
				contentPane.add(jp,BorderLayout.NORTH);
				
			}
			public static void main (String args[]) {
				PracticeText frame = new PracticeText();
				frame.setVisible(true);
			}
			
	
				public void actionPerformed(ActionEvent e) {
				
					PracticeTrim pt = new PracticeTrim();
					int txtnum = pt.PrTrimExe(text.getText());
					
					PracticeRecord pr = new PracticeRecord();
					pr.recordExe(title.getText(),txtnum);
					
					this.dispose();
					System.out.println(txtnum);
				}			
			}
			

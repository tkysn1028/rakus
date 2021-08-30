package practiice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class calculator extends JFrame implements ActionListener{

	JLabel label1;
	private JLabel label2;
	public JLabel getLabel2() {
		return label2;
	}




	String str;
	StringBuilder sb;
	
	public	calculator(){
			
		
		
			setTitle("my calculator");
			setBounds(500, 100, 300, 450);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			GridBagLayout layout = new GridBagLayout();
			JPanel p = new JPanel();
			GridBagConstraints gbc = new GridBagConstraints();
			sb = new StringBuilder("0");
			
			Arithma ari = new Arithma();
			
			
			label1 = new JLabel(sb.toString());
			label1.setOpaque(true);
			label1.setBackground(Color.WHITE);
			
			label1.setBorder(new LineBorder(Color.BLACK,1,true));
			
			label1.setFont(new Font("Arial", Font.PLAIN, 30));
			label1.setPreferredSize(new Dimension(220,60));

			gbc.gridx = 0;
			gbc.gridy = 0;
			layout.setConstraints(label1, gbc);
			p.add(label1);
			
			
			label2 = new JLabel("");
			label2.setOpaque(true);
			label2.setBackground(Color.WHITE);
			
			label2.setBorder(new LineBorder(Color.BLACK,1,true));
			
			label2.setFont(new Font("Arial", Font.PLAIN, 40));
			label2.setPreferredSize(new Dimension(30,60));

			gbc.gridx = 1;
			gbc.gridy = 0;
			layout.setConstraints(label2, gbc);
			p.add(label2);
			
			
		
			JButton btAC = new JButton("AC");
			gbc.gridx = 0;
			gbc.gridy = 1;
			layout.setConstraints(btAC, gbc);
			p.add(btAC);
			btAC.setPreferredSize(new Dimension(60,60));
			
			btAC.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			
					sb.delete(0, sb.toString().length());
					sb.append("0");
					label1.setText(sb.toString());
					label2.setText("");
					
					ari.deleteOp();
					
				}
			});
			
			
			
			JButton btplmin = new JButton("  ");
			gbc.gridx = 1;
			gbc.gridy = 1;
			layout.setConstraints(btplmin, gbc);
			p.add(btplmin);
			btplmin.setPreferredSize(new Dimension(60,60));
			
			
			
			JButton btback = new JButton("←");
			gbc.gridx = 2;
			gbc.gridy = 1;
			layout.setConstraints(btback, gbc);
			p.add(btback);
			btback.setPreferredSize(new Dimension(60,60));
			
			btback.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				
					DeleteNum del = new DeleteNum();
					del.deletenum(sb);
					
					label1.setText(sb.toString());
					}
					
				}
			);
			
			
			
			
			
			
			JButton btdiv = new JButton("÷");
			gbc.gridx = 3;
			gbc.gridy = 1;
			layout.setConstraints(btdiv, gbc);
			p.add(btdiv);
			btdiv.setPreferredSize(new Dimension(60,60));
btdiv.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					if(ari.getFstoprnd() != null && ari.getScdoprnd() != null) {
						ari.calculate(ari.getFstoprnd(), ari.getScdoprnd(), ari.getOperator());
						
						sb.delete(0, sb.toString().length());
						sb.append(String.valueOf(ari.getResult()));
						label1.setText(sb.toString());
						ari.deleteOp();
						
					}
					
					label2.setText(btdiv.getText());
					ari.setOperator(label2.getText());
					ari.setFstoprnd(Double.parseDouble(label1.getText()));
				
					sb.delete(0, sb.toString().length());
					sb.append(0);
				
				
				}
			});
			
			
			
			
			JButton btseven = new JButton("7");
			gbc.gridx = 0;
			gbc.gridy = 2;
			layout.setConstraints(btseven, gbc);
			p.add(btseven);
			btseven.setPreferredSize(new Dimension(60,60));
			
			btseven.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					if(sb.toString().equals("0")) {
						
						sb.replace(0, 1,"");
					
					
					}	
					sb.append(btseven.getText());
					label1.setText(sb.toString());
					
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}	
				}
			});
			
			
			
			JButton bteight = new JButton("8");
			gbc.gridx = 1;
			gbc.gridy = 2;
			layout.setConstraints(bteight, gbc);
			p.add(bteight);
			bteight.setPreferredSize(new Dimension(60,60));
		
	bteight.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(bteight.getText());
					label1.setText(sb.toString());
					
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
					}
					
					
					
				}
			});
		
			
			
			
			JButton btnine= new JButton("9");
			gbc.gridx = 2;
			gbc.gridy = 2;
			layout.setConstraints(btnine, gbc);
			p.add(btnine);
			btnine.setPreferredSize(new Dimension(60,60));
			
	btnine.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btnine.getText());
					label1.setText(sb.toString());
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
					}

					
				}
			});
		
			
			
			
			JButton btmul= new JButton("×");
			gbc.gridx = 3;
			gbc.gridy = 2;
			layout.setConstraints(btmul, gbc);
			p.add(btmul);
			btmul.setPreferredSize(new Dimension(60,60));
btmul.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(ari.getFstoprnd() != null && ari.getScdoprnd() != null) {
						ari.calculate(ari.getFstoprnd(), ari.getScdoprnd(), ari.getOperator());
						
						sb.delete(0, sb.toString().length());
						sb.append(String.valueOf(ari.getResult()));
						label1.setText(sb.toString());
						ari.deleteOp();
						
					}
				
					
					label2.setText(btmul.getText());
					ari.setOperator(label2.getText());
					ari.setFstoprnd(Double.parseDouble(label1.getText()));
				
					sb.delete(0, sb.toString().length());
					sb.append(0);
				
										
				}
			});
			
			
			
			JButton btfour = new JButton("4");
			gbc.gridx = 0;
			gbc.gridy = 3;
			layout.setConstraints(btfour, gbc);
			p.add(btfour);
			btfour.setPreferredSize(new Dimension(60,60));
	btfour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btfour.getText());
					label1.setText(sb.toString());

					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
					}

					
				}
				
	});
		
			
			
			
			JButton btfive = new JButton("5");
			gbc.gridx = 1;
			gbc.gridy = 3;
			layout.setConstraints(btfive, gbc);
			p.add(btfive);
			btfive.setPreferredSize(new Dimension(60,60));
	btfive.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btfive.getText());
					label1.setText(sb.toString());

					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}

				}
			});
		
			
			
			
			JButton btsix = new JButton("6");
			gbc.gridx = 2;
			gbc.gridy = 3;
			layout.setConstraints(btsix, gbc);
			p.add(btsix);
			btsix.setPreferredSize(new Dimension(60,60));
	btsix.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btsix.getText());
					label1.setText(sb.toString());
					
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}

				}
			});
		
			
			JButton btminus= new JButton("-");
			gbc.gridx = 3;
			gbc.gridy = 3;
			layout.setConstraints(btminus, gbc);
			p.add(btminus);
			btminus.setPreferredSize(new Dimension(60,60));
btminus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(ari.getFstoprnd() != null && ari.getScdoprnd() != null) {
						ari.calculate(ari.getFstoprnd(), ari.getScdoprnd(), ari.getOperator());
						
						sb.delete(0, sb.toString().length());
						sb.append(String.valueOf(ari.getResult()));
						label1.setText(sb.toString());
						ari.deleteOp();
						
					}
					
					label2.setText(btminus.getText());
					ari.setOperator(label2.getText());
					ari.setFstoprnd(Double.parseDouble(label1.getText()));
				
					sb.delete(0, sb.toString().length());
					sb.append(0);
									
				}
			});
			
			
			
			JButton btone = new JButton("1");
			gbc.gridx = 0;
			gbc.gridy = 4;
			layout.setConstraints(btone, gbc);
			p.add(btone);
			btone.setPreferredSize(new Dimension(60,60));
	btone.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btone.getText());
					label1.setText(sb.toString());

					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}

					
				}
			});
		
			
			JButton bttwo = new JButton("2");
			gbc.gridx = 1;
			gbc.gridy = 4;
			layout.setConstraints(bttwo, gbc);
			p.add(bttwo);
			bttwo.setPreferredSize(new Dimension(60,60));
	bttwo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(bttwo.getText());
					label1.setText(sb.toString());
					
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}

				}
			});
		
			
			JButton btthree = new JButton("3");
			gbc.gridx = 2;
			gbc.gridy = 4;
			layout.setConstraints(btthree, gbc);
			p.add(btthree);
			btthree.setPreferredSize(new Dimension(60,60));
	btthree.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btthree.getText());
					label1.setText(sb.toString());
					
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}

					
				}
			});
		
			
			JButton btplus= new JButton("+");
			gbc.gridx = 3;
			gbc.gridy = 4;
			layout.setConstraints(btplus, gbc);
			p.add(btplus);
			btplus.setPreferredSize(new Dimension(60,60));
btplus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(ari.getFstoprnd() != null && ari.getScdoprnd() != null) {
						ari.calculate(ari.getFstoprnd(), ari.getScdoprnd(), ari.getOperator());
						
						sb.delete(0, sb.toString().length());
						sb.append(String.valueOf(ari.getResult()));
						label1.setText(sb.toString());
						ari.deleteOp();
						
					}
				
					label2.setText(btplus.getText());
					ari.setOperator(label2.getText());
					ari.setFstoprnd(Double.parseDouble(label1.getText()));
				
					sb.delete(0, sb.toString().length());
					sb.append(0);
				
				
												
				}
			});
			

			
			
			
			JButton btzero = new JButton("0");
			gbc.gridx = 0;
			gbc.gridy = 5;
			layout.setConstraints(btzero, gbc);
			p.add(btzero);
			btzero.setPreferredSize(new Dimension(120,60));
	btzero.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					DeleteZero del = new DeleteZero();
					del.MakeNum(sb);
					sb.append(btzero.getText());
					label1.setText(sb.toString());
					
					if(ari.getFstoprnd() != null && !(ari.getOperator().equals(""))   ) {
						ari.setScdoprnd(Double.parseDouble(label1.getText()));
						
					}

					
				}
			});
		
			
		

			
			
			JButton btequal= new JButton("=");
			gbc.gridx = 3;
			gbc.gridy = 4;
			layout.setConstraints(btequal, gbc);
			p.add(btequal);
			btequal.setPreferredSize(new Dimension(120,60));
btequal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(ari.getFstoprnd() != null && ari.getScdoprnd() != null) {
						ari.calculate(ari.getFstoprnd(), ari.getScdoprnd(), ari.getOperator());
						
						sb.delete(0, sb.toString().length());
						sb.append(String.valueOf(ari.getResult()));
						label1.setText(sb.toString());
						ari.deleteOp();
						
					}
													
					sb.delete(0, sb.toString().length());
					sb.append(0);							
				}
			});
			
		
			
			
			
			
			
			Container contentPane = getContentPane();
			contentPane.add(p, BorderLayout.CENTER);
		
		}

		
		
		public static void main(String[] args) {

			calculator frame = new calculator();
			
			frame.setVisible(true);
			
			
		}




		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

	
	
	
	
}

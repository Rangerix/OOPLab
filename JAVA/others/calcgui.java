
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class calculator{
	JFrame jfr;
	JPanel pan;
	JLabel l1,l2,l3;
	JButton b1,b2,b3,b4;
	JTextField tf1,tf2,tf3;
	calculator(){
		jfr=new JFrame("My calculator");
		jfr.setLayout(new BorderLayout());
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfr.setSize(500,500);
		buildpanel();
		jfr.add(pan);
		jfr.setVisible(true);
	}
	void buildpanel(){
		l1=new JLabel("First Number ");
		l2=new JLabel("Second Number");
		l3=new JLabel("Result ");
		l1.setPreferredSize(new Dimension(100,20));
		tf1=new JTextField(10);
		tf2=new JTextField(10);
		tf3=new JTextField(15);
		//tf1.setPreferredSize(new Dimension(50,20));
		b1=new JButton("add");
		b2=new JButton("sub");
		b3=new JButton("mul");
		b4=new JButton("div");
		pan=new JPanel();
		b1.addActionListener(new MyListener());
		b2.addActionListener(new MyListener());
		b3.addActionListener(new MyListener());
		b4.addActionListener(new MyListener());
		pan.add(l1,BorderLayout.CENTER);
		pan.add(tf1,BorderLayout.EAST);
		pan.add(l2,BorderLayout.CENTER); 
		pan.add(tf2);
		pan.add(l3,BorderLayout.CENTER); 
		pan.add(tf3);
		pan.add(b1,BorderLayout.SOUTH);
		pan.add(b2,BorderLayout.SOUTH);
		pan.add(b3,BorderLayout.SOUTH);
		pan.add(b4,BorderLayout.SOUTH);
	}
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			int v1=Integer.parseInt(tf1.getText());
			int v2=Integer.parseInt(tf2.getText());
			float v3=0;
			if(ae.getSource()==b1)
				v3=v1+v2;
			else if(ae.getSource()==b2)
				v3=v1-v2;
			else if(ae.getSource()==b3)
				v3=v1*v2;
			else if(ae.getSource()==b4)
				v3=(float)v1/v2;
			tf3.setText(Float.toString(v3));
		}
	}
}

class calcgui{
	public static void main(String[] args) {
		calculator c=new calculator();
	}
}
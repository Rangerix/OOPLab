// user can select only one out of four options and when OK is presses, the selected option is displayed
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myclass{
	JFrame jfr;
	JPanel pan,bpan;
	JTextField tf;
	JButton b1,b2;
	JRadioButton rb1,rb2,rb3,rb4;
	myclass(){
		jfr=new JFrame("My Window");
		jfr.setLayout(new FlowLayout());
		jfr.setSize(300,300);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan=new JPanel(new GridLayout(4,1));
		bpan=new JPanel();
		buildoptionpanel();
		buildbuttonpanel();
		jfr.add(pan,BorderLayout.NORTH);
		//jfr.add(bpan,BorderLayout.SOUTH);
		tf=new JTextField(10);
		//tf.setPreferredSize(new Dimension(80,30));
		jfr.add(tf,BorderLayout.CENTER);
		jfr.add(bpan,BorderLayout.SOUTH);
		jfr.setVisible(true);
	} 
	void buildoptionpanel(){
		ButtonGroup bg=new ButtonGroup();
		rb1=new JRadioButton("option 1");
		rb2=new JRadioButton("option 2");
		rb3=new JRadioButton("option 3");
		rb4=new JRadioButton("option 4");
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		pan.add(rb1);
		pan.add(rb2);
		pan.add(rb3);
		pan.add(rb4);
	}
	/*void buildoptionpanel(){

	}*/
	void buildbuttonpanel(){
		b1=new JButton("OK");
		b2=new JButton("EXIT");
		b1.addActionListener(new MyListener());
		b2.addActionListener(new MyListener());
		bpan.add(b1);
		bpan.add(b2);
	}
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			String s=new String("123");
			if(ae.getSource()==b1){
				if(rb1.isSelected()==true) s=new String("option 1");
				if(rb2.isSelected()==true) s=new String("option 2");
				if(rb3.isSelected()==true) s=new String("option 3");
				if(rb4.isSelected()==true) s=new String("option 4");
				tf.setText(s);
				tf.setEditable(false);
			}
			else 
				System.exit(0);
		}
	}
}

class sem17{
	public static void main(String[] args) {
		myclass mc=new myclass();
	}
}
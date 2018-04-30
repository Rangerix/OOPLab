import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myclass{
	myclass()
	{
		JFrame jfm=new JFrame("My window");
		jfm.setLayout(new FlowLayout());
		jfm.setSize(200,200);
		jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlb=new JLabel("");
		JButton jbAlpha=new JButton("Alpha");
		JButton jbBeta=new JButton("Beta");
		jbAlpha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jlb.setText("Alpha is pressed");
			}
		});
		jbBeta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jlb.setText("Beta is pressed");
			}
		});
		jfm.add(jbAlpha);
		jfm.add(jbBeta);
		jlb.setText("okay");
		jfm.add(jlb);
		jfm.setVisible(true);
	}
}
class guidemo2{
	public static void main(String[] args) {
		myclass mc=new myclass();
	}
}
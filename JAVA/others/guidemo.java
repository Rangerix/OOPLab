
import javax.swing.*;
class myclass{
	void myfunc()
	{
		JFrame jfr=new JFrame("My Window");
		jfr.setSize(500,300);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfr.setVisible(true);
		JLabel jlab=new JLabel("This shows this...\n\n\n\n\n MEOW\n");
		jfr.add(jlab);
		//jfr.setVisible(true);
	}
}
class guidemo{
	public static void main(String[] args) {
		myclass mc=new myclass();
		mc.myfunc();
	}
}
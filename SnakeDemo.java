package snake;

import javax.swing.JFrame;

public class SnakeDemo extends JFrame {
	static SnakeBody sb = new SnakeBody();

	public SnakeDemo() {
		setBounds(0, 0, 500, 1000);
		this.add(sb);
		this.addKeyListener(sb);
		Thread td = new Thread(sb);
		td.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SnakeDemo sd = new SnakeDemo();
		sd.setVisible(true);
	}
}

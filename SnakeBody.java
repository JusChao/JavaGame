package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class SnakeBody extends JPanel implements Runnable, KeyListener {
	SnakeList sl = null;
	int code = 0;
	Direction dr = new Direction();
	int num = 0;
	Food fd = new Food();
	int x = fd.getNode().x;
	int y = fd.getNode().y;

	public SnakeBody() {
		sl = new SnakeList();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(x, y, 10, 10);
		g.setColor(Color.black);
		synchronized (this) {
			for (int i = 0; i < sl.snakelenght(); i++) {
				g.fillRect(sl.getNode(i).x, sl.getNode(i).y, 10, 10);
			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 38:
			code = 38;
			break;
		case 39:
			code = 39;
			break;
		case 37:
			code = 37;
			break;
		case 40:
			code = 40;
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (sl.isEmpty()) {

			} else {
				if (sl.getfirst().x == x && sl.getfirst().y == y) {
					sl.addSnake(new SnakeNode(x, y));
					x = fd.getNode().x;
					y = fd.getNode().y;
				}
				num = dr.dir(num, code);
				switch (num) {
				case 38:
					sl.snakerun(new SnakeNode(sl.getfirst().x,
							sl.getfirst().y - 10));
					break;
				case 39:
					sl.snakerun(new SnakeNode(sl.getfirst().x + 10, sl
							.getfirst().y));
					break;
				case 37:
					sl.snakerun(new SnakeNode(sl.getfirst().x - 10, sl
							.getfirst().y));
					break;
				case 40:
					sl.snakerun(new SnakeNode(sl.getfirst().x,
							sl.getfirst().y + 10));
					break;
				default:
					break;
				}
				repaint();
			}
		}
	}

}

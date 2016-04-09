package snake;

import java.util.Iterator;
import java.util.LinkedList;

public class SnakeList {
	LinkedList<SnakeNode> sl = new LinkedList<SnakeNode>();

	public SnakeList() {
		SnakeNode sn = new SnakeNode(100, 100);
		sl.addFirst(sn);
	}

	public LinkedList addSnake(SnakeNode sn) {
		sl.addFirst(sn);
		return sl;
	}

	public int snakelenght() {
		return sl.size();
	}

	public SnakeNode getNode(int i) {
		return sl.get(i);
	}

	public SnakeNode getLast() {
		return sl.getLast();
	}

	public SnakeNode getfirst() {
		return sl.getFirst();
	}

	public void snakerun(SnakeNode sn) {
		if (!sl.isEmpty()) {
			synchronized (sn) {
				sl.addFirst(sn);
				sl.remove(sl.size() - 1);
			}
		}
		for (int i = 0; i < sl.size(); i++) {
			if (sl.get(i).y < 0) {
				sl.get(i).y = 1000;
			}
			if (sl.get(i).y > 1000) {
				sl.get(i).y = 0;
			}
			if (sl.get(i).x < 0) {
				sl.get(i).x = 500;
			}
			if (sl.get(i).x > 500) {
				sl.get(i).x = 0;
			}
		}
		for (int i = 1; i < sl.size(); i++) {
			if (sl.getFirst().x == sl.get(i).x
					&& sl.getFirst().y == sl.get(i).y) {
				System.out.println("Åö×²");
			}
		}
	}

	public boolean isEmpty() {
		return sl.isEmpty();
	}
}

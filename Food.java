package snake;

import java.util.Random;

public class Food {
	SnakeNode sb = null;
	Random rd = new Random();
	public SnakeNode getNode() {
		return sb = new SnakeNode(rd.nextInt(40)*10, rd.nextInt(80)*10);
	}
}

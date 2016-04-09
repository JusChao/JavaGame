package snake;

public class Direction {
	public int dir(int x, int y) {
		if((x-y==2)||(x-y==-2)){
			return x;
		}
		return y;
	}
}

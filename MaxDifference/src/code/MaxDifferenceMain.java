package code;

public class MaxDifferenceMain {

	public static void main(String[] args) {
		MaxDifference robot = new MaxDifference();
		System.out.println(robot.computeCapacity(new int[]{9, 7, 2, 8, 6, 5, 12}));
		
		System.out.println(robot.computeCapacity(new int[] {1, 2, 3, 4, 5, 12, 9, 6}));
	}

}

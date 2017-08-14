package code;

public class MaxDifference {
	public int computeCapacity(int arr[]) {
		int capacity = 0, currentMin = arr[0];
		for (int i = 1; i < arr.length; i++){
			if (arr[i]  - currentMin > capacity) {
				capacity = arr[i] - currentMin;
			}
			if (arr[i] < currentMin)
			{
				currentMin = arr[i];
			}
		}
		return capacity;
	}
}

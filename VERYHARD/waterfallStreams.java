package VERYHARD;
public class waterfallStreams {

	public static void main(String[] args) {
		double[][] nums = {{0,0,0,0,0,0,0}, {1,0,0,0,0,0,0}, {0,0,1,1,1,0,0}, {0,0,0,0,0,0,0}, {1,1,1,0,0,1,0}, {0,0,0,0,0,0,1}, {0,0,0,0,0,0,0}};
		System.out.println(calcPercentage(nums, 3));
	}
	
	public static double[] calcPercentage(double[][] nums, int source) {
		double[] rowAbove = nums[0];
		rowAbove[source] = -1;
		for(int i = 1; i < nums.length; i++) {
			double[] currentRow = nums[i];
			for(int j = 0; j < currentRow.length; j++) {
				double valueInTheAboveBlock = rowAbove[j];
				boolean hasWaterInTheAboveBlock = valueInTheAboveBlock < 0;
				boolean isBlock = currentRow[j] == 1.0;
				if(!hasWaterInTheAboveBlock)
					continue;
				if(!isBlock) {
					currentRow[j] += valueInTheAboveBlock;
					continue;
				}
				double splitWater = valueInTheAboveBlock / 2;
				int right = j;
				while(right + 1 < rowAbove.length) {
					right += 1;
					if(rowAbove[right] == 1.0) {
						break;
					}
					if(currentRow[right] != 1.0) {
						currentRow[right] += splitWater;
						break;
					}
				}
				int left = j;
				while(left - 1 >= 0) {
					left -= 1;
					if(rowAbove[left] == 1.0) {
						break;
					}
					if(currentRow[left] != 1.0) {
						currentRow[left] += splitWater;
						break;
					}
				}
			}
			rowAbove = currentRow;
		}
		double[] result = new double[rowAbove.length];
		for(int i = 0; i < rowAbove.length; i++) {
			if(rowAbove[i] == 0.0) continue;
			result[i] = rowAbove[i] * -100;
		}
		return result;
	}

}

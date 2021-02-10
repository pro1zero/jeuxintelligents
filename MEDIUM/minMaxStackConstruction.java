package MEDIUM;
import java.util.*;
public class minMaxStackConstruction {

	static class MinMaxStack{
		List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
		List<Integer> stack = new ArrayList<>();
		
		public int peek() {
			return stack.get(stack.size() - 1);
		}
		
		public int pop() {
			minMaxStack.remove(minMaxStack.size() - 1);
			return stack.remove(stack.size() - 1);
		}
		
		public void push(int number) {
			Map<String, Integer> newMinMax = new HashMap<String, Integer>();
			newMinMax.put("min", number);
			newMinMax.put("max", number);
			
			if(minMaxStack.size() > 0) {
				Map<String, Integer> lastMinMax = new HashMap<String, Integer>(minMaxStack.get(minMaxStack.size() - 1));
				newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
				newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
			}
			minMaxStack.add(newMinMax);
			stack.add(number);
			}
		
		public int getMin() {
			return minMaxStack.get(minMaxStack.size() - 1).get("min");
		}
		
		public int getMax() {
			return minMaxStack.get(minMaxStack.size() - 1).get("max");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

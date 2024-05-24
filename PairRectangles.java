import java.util.*;

public class PairRectangles {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int[] ratio(int a, int b){
        int gcd = gcd(a, b);
        return new int[]{a / gcd, b / gcd};
    }

    public static long interchangeableRectangles(int[][] nums) {
        Map<String,Set<Integer>> temp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int[] ratio = ratio(nums[i][0],nums[i][1]);
            String s = "" + ratio[0] + ":" + ratio[1];
            Set<Integer> myList = new HashSet<>();
            if(temp.containsKey(s)){
                myList = temp.get(s);
            }
            myList.add(i);
            temp.put(s,myList);
        }

        long out = 0;

        for(String s: temp.keySet()){
            Set<Integer> list1 = temp.get(s);
            long size = list1.size();
            if(size > 1){
                out += (size*(size-1))/2;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] nums = {{2,3},{6,9},{4,5},{5,2},{9,7},{1,8},{5,8},{7,9}};
        System.out.println(interchangeableRectangles(nums));
    }
}

import java.util.ArrayList;

public class Unit0ProblemSet {
    public static void main (String[] args) {
        //test all functions
        int [] nums = {0,2,4,6,8,10};
        System.out.println(countInRange(nums, 3,7));
        ArrayList<String> words = new ArrayList<>();
        words.add("hi");
        words.add("there");
        words.add("what");
        words.add("is");
        words.add("up");
        System.out.println(clump(words));
        double [][] doubleArr = {{2,7,6}, {9,5,1}, {4,3,8}};
        System.out.println(isMagicSqaure(doubleArr));
        int [] test = {1,3,10,5,2};
        System.out.println(median(test));

        
    }
    public static int countInRange(int [] nums, int min, int max) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //have to follow both conditions
            if (nums[i] > min && nums[i] < max) {
                count ++;
            }
        }
        return count;
    }

    public static ArrayList<String> clump(ArrayList<String> words) {
        ArrayList<String> toRet = new ArrayList <> ();
        for (int i = 0; i<words.size()-2; i+=2) {
            //add new element to arr
            String toPush = "(" + words.get(i) + " " + words.get(i+1) + ")";
            toRet.add(toPush);
        }
        if (words.size()%2 ==1) {
            toRet.add(words.get(words.size() -1));
        }
        return toRet;
    }

    public static boolean isMagicSqaure(double [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length) {
                return false;
            }
        }
    
        double toCheck = 0;
        for (int j = 0; j < arr.length; j++) {
            toCheck += arr[0][j];
        }
    
        // Check all row sums
        for (int i = 1; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
            if (sum != toCheck) {
                return false;
            }
        }
    
        // Check all column sums
        for (int j = 0; j < arr.length; j++) {
            double sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][j];
            }
            if (sum != toCheck) {
                return false;
            }
        }
    
        // Check main diagonal
        double mainDiag = 0;
        for (int i = 0; i < arr.length; i++) {
            mainDiag += arr[i][i];
        }
        if (mainDiag != toCheck) {
            return false;
        }
        return true;
    }

    public static int median(int [] arr){
        int [] count = new int [100];
        for (int num : arr) {
            count[num] ++;
        }
        int mid = arr.length/2;
        int total = 0;

        for (int i= 0; i<count.length; i ++) {
            total += count [i];
            if (total > mid) {
                return i;
            }
        }
        //need a return, but should never be -1
        return -1;
    }
}
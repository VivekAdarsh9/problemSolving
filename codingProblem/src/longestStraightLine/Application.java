package longestStraightLine;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    /**
     * { {1, 4}, {3, 7}, {8, 11} }
     *
     * for(i=0;i<input.size())
     *
     * i=0
     * {1,4}
     * maxLength=0
     *
     * [4]-[1]=3
     * [7]-[3]=4
     * if(3<4){
     * overlapCount=4-3=1
     * }
     * maxlength=3+([7]-[3])-1=6
     *
     * if()
     * maxlenght=a[i].a[1]-a[i].ar[0]+[a[i+1].ar[1]-arr[i].ar[0]]-overlapcount();
     *
     * a[0].a[1]==4
     * a[0].a[0]==1
     * 3+4=7-1
     * maxlengt=6
     *
     * input= { {1, 4}, {3, 7}, {8, 11} }
     *
     * noOfElement[]={(4-1),(7-3),(11-8)}
     * =={3,4,3}
     * maxlength=noOfElement[0]==3
     * for(i=0,input.size-1)
     *
     * if(4<3){
     * maxlength=numberOfElemetnt[i+1]
     * }else
     * if(4=3){
     * maxlength+=numberOfElemetnt[i+1]
     * }else{
     * if(4>=7)
     * }else{
     * maxlength+=7-4
     *
     * }
     *
     *
     *
     *
     */

    public static int longestStraightLine(List<List<Integer>> input) {
        ArrayList maxLength = new ArrayList<>();

        /**
         * { {1, 4}, {3, 7}, {8, 11} }
         * i=0,j=1
         * {1,4} {3,7}
         * 3>4 cross
         * 3<4tick
         *
         *
         *
         */
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {

                if (input.get(j).get(0) > input.get(i).get(1)) {//i)3>4 ii) 8>4 iii) 8>7
                    System.out.println(input.get(i).get(1) - input.get(i).get(0));
                    maxLength.add(input.get(i).get(1) - input.get(i).get(0));//{3} {4}
                    maxLength.add(input.get(j).get(1) - input.get(j).get(0)); //{3}{3}
                } else
                {
                    if (input.get(j).get(0) < input.get(i).get(1)) {//3<4
                        if (input.get(j).get(1) <= input.get(i).get(1)) {//7<=4
                            System.out.println(input.get(i).get(1) - input.get(i).get(0));
                            maxLength.add(input.get(i).get(1) - input.get(i).get(0));
                        } else {
                            int count = (input.get(i).get(1) - input.get(i).get(0))
                                    + (input.get(j).get(1) - input.get(j).get(0))
                                    - (input.get(i).get(1) - input.get(j).get(0));
                            System.out.println(count);
                            maxLength.add(count);//{6,3,3,4,3}
                        }
                    }
                }
            }
        }

        return (int) Collections.max(maxLength);
    }

    public static void main(String[] args) {

        // int[][] input1 = new int[3][2];
        // int [] [] input2 = { {2, 3}, {9, 8}, {1, 7} };
        // System.out.println(input2[0][0]);
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 4), Arrays.asList(5, 7),Arrays.asList(8,20));
        // System.out.println(lists.get(0).get(1));
        int result = Application.longestStraightLine(lists);
        System.out.println("final result: "+result);
    }
}

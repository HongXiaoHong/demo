package cz.hong.demo.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ErrorArray {

    public static int[] findErrorNums_bits(int[] nums) {
        int n = nums.length;
        int xor = 0;  // 异或变量，用于记录数组元素和索引的异或结果
        for (int num : nums) {
            xor ^= num;  // 将数组元素逐个进行异或操作
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;  // 将索引逐个进行异或操作
        }
        int lowbit = xor & (-xor);  // 获取异或结果中最低位的 1 所对应的值
        int num1 = 0, num2 = 0;  // 两个变量用于记录重复的数和缺失的数
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                num1 ^= num;  // 异或操作，将数组中低位为 0 的数进行异或
            } else {
                num2 ^= num;  // 异或操作，将数组中低位为 1 的数进行异或
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowbit) == 0) {
                num1 ^= i;  // 异或操作，将索引中低位为 0 的数进行异或
            } else {
                num2 ^= i;  // 异或操作，将索引中低位为 1 的数进行异或
            }
        }
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};  // 如果在数组中找到了与 num1 相等的数，则返回 [num1, num2]
            }
        }
        return new int[]{num2, num1};  // 否则返回 [num2, num1]
    }

    public static int[] findErrorNums_officials(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            } else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }
        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }
    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        // 通过对比 f(i) = i, 不想等则是重复的数字
        // 1 2 2 4
        // 1 2 3 4
        // 3,2,3,4,6,5 这种情况下就不成立了
       /* for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] != i) {
                result[0] = nums[i-1];
                break;
            }
        }*/
        Set<Integer> existedSet = new HashSet<>();
        for (int num : nums) {
            if (existedSet.contains(num)) {
                result[0] = num;
                break;
            }
            existedSet.add(num);
        }
        // 通过集合差集找出相差的数字
        List<Integer> goodArray = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toList());
        List<Integer> badArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
        goodArray.removeAll(badArray);
        result[1] = goodArray.get(0);
        return result;
    }

    public static void main(String[] args) {
//        findErrorNums(new int[]{3, 2, 3, 4, 6, 5});
//        findErrorNums_officials(new int[]{3, 2, 3, 4, 6, 5});
        findErrorNums_bits(new int[]{1,2,2,4});
    }
}

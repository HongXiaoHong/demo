package cz.hong.demo.ds.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ZeroLastTest {

    private int[] nums;

    @BeforeEach
    public void before() {
        nums = new int[]{0, 1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }

    @Test
    void moveZeroes() {
        ZeroLast.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void moveZeroes_hong() {
        ZeroLast.moveZeroes_hong(nums);
        System.out.println(Arrays.toString(nums));
    }
}
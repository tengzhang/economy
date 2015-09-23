package com.webexam.common.utils;

import java.util.List;
import java.util.Random;

/**
 * RandomUtil
 *
 * @author: zhangteng
 * @time: 14-2-12 下午3:43
 */
public final class RandomUtil {

    public static int[] getRandomNumbers(Integer max, Integer numbers) {
        boolean[] isExist = new boolean[max+1];
        int[] results = new int[numbers];
        int num = 0;
        int randomNum = numbers;
        Random random = new Random();
        // 特殊处理一下，如果最大的数和要取得的随机数数目相等
        // 的话，只随机一般，全部随机可能死循环，随机几率低
        if(max+1 == numbers) {
            randomNum /= 2;
        }
        int i;
        for(i = 0;i < randomNum; ++i) {
            do {
                num = random.nextInt(max);
            } while (isExist[num]);
            isExist[num] = true;
            results[i] = num;
        }
        if(i < numbers) {
            for(int j = 0;j < max+1; ++j) {
                if(i >= numbers) {
                    break;
                }
                if(isExist[j] == false) {
                    results[i] = j;
                    i ++;
                }
            }
        }
        return results;
    }
}

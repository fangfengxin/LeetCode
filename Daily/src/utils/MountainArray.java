package utils;

/**
 * @Author hustffx
 * @Date 2020/4/29 10:32
 */
public interface MountainArray {
    /**
     * 返回数组中索引为 index 的元素
     *
     * @param index 下标，从 0 开始
     * @return 数组中索引为 index 的元素
     */
    int get(int index);

    /**
     * 返回该数组的长度
     *
     * @return 数组的长度
     */
    int length();
}

package demo;


public class No24 {

    public static void main(String[] args) {
        int[] array1 = { 5, 7, 6, 9, 11, 10, 8 };
        System.out.println(verifySequenceOfBinarySearchTree(array1, 0,
                array1.length - 1));
        int[] array2 = { 7, 1, 6, 5 };
        System.out.println(verifySequenceOfBinarySearchTree(array2, 0,
                array2.length - 1));

    }

    public static boolean verifySequenceOfBinarySearchTree(int[] array,
            int start, int end) {
        if (array == null || start > end || start < 0 || end < 0)
            return false;
        if (start == end)
            return true;
        int root = array[end];
        int i = start;
        for (; i < end; i++) {
            if (array[i] > root)
                break;
        }
        int j = i;
        for (; j <= end; j++) {
            if (array[j] < root)
                return false;
        }
        // 递归判断左子树是不是二叉搜索树
        boolean left = false;
        if (i > start) {
            left = verifySequenceOfBinarySearchTree(array, start, i - 1);
        }
        // 递归判断右子树是不是二叉搜索树
        boolean right = false;
        if (i < end) {
            right = verifySequenceOfBinarySearchTree(array, i, end - 1);
        }
        return left && right;
    }
}
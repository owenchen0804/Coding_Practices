package BinaryTreeEnhanced;

import BinaryTree.TreeNode;

public class LA211_ReconstructBSTFromPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        // Assume that post is not null
        int[] index = new int[] {post.length - 1};
        // 搞一个大小为1的指代当前root所对应post[]的index，传到helper里面去，实现recursion中传递
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] index, int min) {
        // base case，利用BST的性质，当前的root肯定不能比变化的min还要小
        if (index[0] < 0 || post[index[0]] <= min) {
            return null; // index[0] < 0 说明整个post[]已经从后往前遍历完成了
            // 如果出现post[index[0]] <= min 说明不符合BST的定义也不对
        }
        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = helper(post, index, root.key);
        // 这里是root的右边肯定要比root.key要大，毫无疑问
        root.left = helper(post, index, min);
        // 这里是虽然root.left可以比自己root.key小，但是要注意隐含条件！！
        // 下一个pos[index[]]的值一定要比上面一层的那个root.key的值大，也就是
        // 传下来的这个min(就是上一层的root.key)，如果发现下一个数字比上面一层的key还要小，
        // 那肯定不能接在当前root的左边，因为根据BST定义，上一层root的右边所有子树的值都要比它大
        // 换句话说如果发现了index[0]的值比min(上一层的root)要小，说明index[0]已经不可能在上一层的右边
        // 那么index[0]一定会接在上一层root的左边
        // 我们讨论的这个数是要作为上一层root的右子树，也就是当前的root的左子树的可能性，它必须大于上一层root.key
        return root;
    }

    public static void main(String[] args) {
        LA211_ReconstructBSTFromPostorderTraversal test = new LA211_ReconstructBSTFromPostorderTraversal();
        int[] array = {1,4,3,11,8,5};
        System.out.println(test.reconstruct(array).key);
    }
}


// Binary Tree & Its functions.
import java.util.LinkedList;
import java.util.Queue;

public class binaryTree {

    // Node of Binary tree.
    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Binary tree
    static class BinaryTree {

        static int index = -1;

        // To build binary tree from given Preorder Sequence array. - O(n)
        public static TreeNode buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            // Taking index'th element of array as the root of the subtree.
            TreeNode root = new TreeNode(nodes[index]);

            root.left = buildTree(nodes); // Building the left subtree.

            root.right = buildTree(nodes); // Building the right subtree.

            return root;
        }

    }

    // Height - O(n)
    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        // Getting the height of the left subtree of the current subtree.
        int leftHeight = height(root.left);

        // Getting the height of the right subtree of the current subtree.
        int rightHeight = height(root.left);

        // Total height, adding the height of the root of the current subtree.
        return leftHeight + rightHeight + 1;
    }

    // Count toal no. of nodes - O(n)
    public static int countTreeNodes(TreeNode root) {
        if (root == null)
            return 0;

        // counting nodes of the left subtree of the current subtree.
        int countLeft = countTreeNodes(root.left);

        // counting nodes of the right subtree of the current subtree.
        int countRight = countTreeNodes(root.right);

        // Total no. nodes, adding the height of the root of the current subtree.
        return countLeft + countRight + 1;
    }

    // Sum of all Nodes - O(n)
    public static int sumOfTreeNodes(TreeNode root) {
        if (root == null)
            return 0;

        // Getting the sum of all nodes of left subtree of the current subtree.
        int leftSum = sumOfTreeNodes(root.left);

        // Getting the sum of all nodes of the right subtree of the current subtree.
        int rightSum = sumOfTreeNodes(root.right);

        // Total sum of all nodes, adding the root node of the current subtree.
        return leftSum + rightSum + root.data;
    }

    // Diameter approach 1 - O(n^2)
    public static int diameter1(TreeNode root) {
        if (root == null)
            return 0;

        // diameter that doesn't includes root node
        int dm1 = diameter1(root.left); /* diameter of left subtree. */
        int dm2 = diameter1(root.right);/* diameter of right subtree. */
        // diameter that includes root node.
        /* Height of left subtree + right subtree + 1(for root node). */
        int dm3 = height(root.left) + height(root.right) + 1;

        // Diameter of the binary tree is maximum of the 3 diameters.
        return Math.max(dm1, Math.max(dm2, dm3));
    }

    // Used as an object to store two variables
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Diameter approach 2 - O(n)
    public static TreeInfo diameter2(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left); // diameter & height of left subtree.
        TreeInfo right = diameter2(root.right); // diameter & height of right subtree.

        int myHeight = left.diameter + right.diameter + 1; // Height of tree.

        int dm1 = diameter1(root.left);
        int dm2 = diameter1(root.right);
        int dm3 = left.height + right.height + 1;
        int myDiameter = Math.max(dm1, Math.max(dm2, dm3)); // Diameter of tree.

        return new TreeInfo(myHeight, myDiameter);
    }

    // TRAVERSALS
    // 1> Depth First Search DFS traversals
    // A. Preorder -
    public static void preorder(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }

        System.out.print(root.data + " "); // 1 - Root
        preorder(root.left); // 2 - the left subtree
        preorder(root.right); // 3 - the left subtree
    }

    // B. Inorder -
    public static void inorder(TreeNode root) {
        if (root == null) {
            // System.out.print(-1+" ");
            return;
        }

        inorder(root.left); // 1 - left subtree
        System.out.print(root.data + " "); // 2 - root
        inorder(root.right); // 3 - right subtree
    }

    // C. Postorder -
    public static void postorder(TreeNode root) {
        if (root == null) {
            // System.out.print(-1+" ");
            return;
        }

        preorder(root.left); // 1 - the left subtree
        preorder(root.right); // 2 - the left subtree
        System.out.print(root.data + " "); // 3 - root
    }

    // 2>> Breadth First Search BFS traversal
    // D. Levelorder -
    public static void levelorder(TreeNode root) {
        if (root == null) {
            // System.out.print(-1+" ");
            return;
        }

        // Using queue to store nodes of each level.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            if (currNode == null) { // root is empty
                System.out.println(); // change line
                if (q.isEmpty())
                    break; // empty queue.
                else
                    q.add(null);
            } else {
                System.out.print(currNode.data + " ");

                if (currNode.left != null) // adding the left subtree
                    q.add(currNode.left);

                if (currNode.right != null) // adding the right subtree
                    q.add(currNode.right);
            }

        }
    }

    // To check if two subtrees are identical.
    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) // when both the trees are
            return true; // empty then they are subtree of each other.

        if (subRoot == null || root == null) // when only one tree is empty
            return false; // then it's not a subtree.

        if (root.data == subRoot.data) { // check if roots are identical.
            return isIdentical(root.left, subRoot) && isIdentical(root.right, subRoot);
        } // check if both of left & right subtrees are also identical.

        return false;
    }

    // To check if a given tree(subRoot) is subtree of tree(root.)
    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        if (isIdentical(root, subRoot)) { // checking if given subtree is identical
            return true; // to any of the subtrees of the tree.
        }

        // check in the left & right subtrees of the main tree.
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

}
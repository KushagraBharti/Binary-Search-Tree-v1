public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() { }
    public void insert(E e, Article a) {
        if (root == null) {
            root = new TreeNode<E>(e);

        }
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else {
                    // add the Article
                    return;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<E>(e);
                parent.left.list.addFirst(e);
            }
            else {
                parent.right = new TreeNode<E>(e);
                parent.right.list.addFirst(e);
            }

        }
    }

    protected void print() {
        if (root == null) return;
        System.out.print(root.element);

        System.out.println();
    }

    protected void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element);
        System.out.println();
        inorder(root.right);
    }
}









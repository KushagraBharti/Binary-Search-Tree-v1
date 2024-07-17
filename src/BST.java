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
                    current.list.addFirst(a);
                    return;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<E>(e);
                parent.left.list.addFirst(a);
            }
            else{
                parent.right = new TreeNode<E>(e);
                parent.right.list.addFirst(a);
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

    protected void inorder(TreeNode<E> current) {
        if (current == null)
            return;
        inorder(current.left);
        System.out.printf("%s\n", current.element);
        System.out.printf("%s\n", current.list);
        inorder(current.right);
    }
}
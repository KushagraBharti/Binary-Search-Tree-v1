public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() { }

    public void insert(E e, Article a) {
        if (root == null) {
            root = new TreeNode<E>(e);
            root.head = new Node<Article>(a);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    // add the Article
                    Node<Article> newNode = new Node<Article>(a);
                    newNode.next = current.head;
                    current.head = newNode;
                    return;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<E>(e);
                parent.left.head = new Node<Article>(a);
            } else {
                parent.right = new TreeNode<E>(e);
                parent.right.head = new Node<Article>(a);
            }
        }
    }

    public void search(E e) {
        if (root == null) {
            System.out.printf("%s not found!\n", e);
            return;
        } else {
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                } else {
                    // Display the element and its associated articles
                    System.out.printf("Key: %s\n", current.element);
                    Node<Article> articleNode = current.head;
                    while (articleNode != null) {
                        System.out.printf("Article: %s\n", articleNode);
                        articleNode = articleNode.next;
                    }
                    return;
                }
            }

            System.out.printf("%s not found!\n", e);
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

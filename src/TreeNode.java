class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    protected Node<Article> head;

    public TreeNode(E e) {
        element = e;
        head = null; // Initialize the head of the list to null
    }
}

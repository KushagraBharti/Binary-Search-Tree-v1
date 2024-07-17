class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    //protected Node<Article> head;
    protected MyLinkedList<Article> list;
    public TreeNode(E e) {
        element = e;
        list = new MyLinkedList<>();
    }
}
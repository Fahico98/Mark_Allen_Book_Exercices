
public class Section_18_2_Binary_Tree {
    
    public static void main(String[] arguments){
        
        IntegerBinaryTree numbersTree = new IntegerBinaryTree(50);
        
        numbersTree.addInteger(32);
        numbersTree.addInteger(40);
        numbersTree.addInteger(33);
        numbersTree.addInteger(9);
        numbersTree.addInteger(66);
        numbersTree.addInteger(78);
        numbersTree.addInteger(55);
        numbersTree.addInteger(20);
        numbersTree.addInteger(52);
        
        numbersTree.printPreOrder();
        System.out.println("");
        numbersTree.printPostOrder();
        System.out.println("");
        numbersTree.printInOrder();
        System.out.println("");
        numbersTree.printLevelOrder();
        System.out.println("");
    }
}

class IntegerBinaryTree extends BinaryTree{
    
    private BinaryNode<Integer> root = new BinaryNode();
    
    public IntegerBinaryTree(){
        super(0);
    }
    
    public IntegerBinaryTree(int root){
        super(root);
    }
    
    /**
     * Recursive method.
     */
    public void addInteger(int num){
        this.addInteger(num, getRoot());
    }
    
    /**
     * Recursive method.
     */
    private void addInteger(int num, BinaryNode<Integer> root){
        if(num < root.getElement()){
            if(root.getLeft() == null){
                root.setLeft(new BinaryNode(num));
            }else{
                addInteger(num, root.getLeft());
            }
        }else{
            if(root.getRight() == null){
                root.setRight(new BinaryNode(num));
            }else{
                addInteger(num, root.getRight());
            }
        }
    }
}

class BinaryTree<T>{
    
    private BinaryNode<T> root;
    
    public BinaryTree(){
        this.root = null;
    }
    
    public BinaryTree(T rootItem){
        this.root = new BinaryNode(rootItem, null, null);
    }
    public BinaryNode<T> getRoot(){
        return root;
    }
    
    public int size(){
        return BinaryNode.size(root);
    }
    
    public int height(){
        return BinaryNode.height(root);
    }
    
    /**
     * It uses the printPreOrder method from BinaryNode class.
     */
    public void printPreOrder(){
        if(root != null){
            root.printPreOrder();
        }
    }
    
    /**
     * It uses the printInOrder method from BinaryNode class.
     */
    public void printInOrder(){
        if(root != null){
            root.printInOrder( );
        }
    }
    
    /**
     * It uses the printPostOrder method from BinaryNode class.
     */
    public void printPostOrder(){
        if(root != null){
            root.printPostOrder( );
        }
    }
    
    /**
     * It uses the printLevelOrder method from BinaryNode class.
     */
    public void printLevelOrder(){
        if(root != null){
            root.printLevelOrder( );
        }
    }
    
    public void makeEmpty(){
        root = null;
    }
    
    public boolean isEmpty(){
        return(root == null);
    }
    
    /**
     * Merge routine for BinaryTree class, forms a new tree with rootItem
     * in the root of the new tree and t1 and t2 as right and left subtrees
     * (does not allow t1 and t2 to be the same).
     */
    public void merge(T rootItem, BinaryTree<T> t1, BinaryTree<T> t2){
        
        if((t1.root == t2.root) && (t1.root != null)){
            throw new IllegalArgumentException();
        }
        
        // Allocate new node.
        root = new BinaryNode(rootItem, t1.root, t2.root);
        
        //Ensure that every node is in one tree.
        if(this != t1){
            t1.root = null;
        }
        if(this != t2){
            t2.root = null;
        }
    }
}

class BinaryNode<T>{
    
    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right; 
    
    public BinaryNode(){
        this(null, null, null);
    }
    
    public BinaryNode(T theElement){
        this(theElement, null, null);
    }
    
    public BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt){
        this.element = theElement;
        this.left = lt;
        this.right = rt;
    }
    
    /**
     * Return the size of the binary tree rooted at t.
     */
    public static <T> int size(BinaryNode<T> t){
        if(t == null){
            return 0;
        }else{
            return(1 + size(t.getLeft()) + size(t.getRight()));
        }
    }
    
    /**
     * Return the height of the binary tree rooted at t.
     */
    public static <T> int height(BinaryNode<T> t){
        if(t == null){
            return(-1);
        }else{
            return(1 + Math.max(height(t.getLeft()), height(t.getRight())));
        }
    }
    
    /**
     * Return a reference to a node that is the root of a
     * duplicate of the binary tree rooted at the current node.
     */
    public BinaryNode<T> duplicate(){
        BinaryNode<T> root = new BinaryNode(getElement(), null, null);
        if(getLeft() != null){
            root.setLeft(getLeft().duplicate());
        }
        if(getRight() != null){
            root.setRight(getRight().duplicate());
        }
        return root;
    }
    
    /**
     * Print tree rooted at current node using preorder traversal.
     */
    public void printPreOrder(){
        System.out.print(getElement() + " ");
        if(getLeft() != null){
            getLeft().printPreOrder();
        }
        if(getRight() != null){
            getRight().printPreOrder();
        }
    }
    
    /**
     * Print tree rooted at current node using postorder traversal.
     */
    public void printPostOrder(){
        if(getLeft() != null){
            getLeft().printPostOrder();
        }
        if(getRight() != null){
            getRight().printPostOrder();
        }
        System.out.print(getElement() + " ");
    }
    
    /**
     * Print tree rooted at current node using inorder traversal.
     */
    public void printInOrder(){
        if(getLeft() != null){
            getLeft().printInOrder();
        }
        System.out.print(getElement() + " ");
        if(getRight() != null){
            getRight().printInOrder();
        }
    }
    
    /**
     * printLevelOrder method uses the ArrayQueue class defined into 
     * 'Section_16_1_Dynamic_Array_Implementations_Queue.java' file, in 
     * this directory.
     */
    public void printLevelOrder(){
        ArrayQueue<BinaryNode<T>> queue = new ArrayQueue();
        queue.enqueue(this);
        while(!queue.isEmpty()){
            BinaryNode<T> bufferNode = queue.dequeue();
            System.out.print(bufferNode.getElement() + " ");
            if(bufferNode.getLeft() != null){
                queue.enqueue(bufferNode.getLeft());
            }
            if(bufferNode.getRight() != null){
                queue.enqueue(bufferNode.getRight());
            }
        }
    }

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return the left
     */
    public BinaryNode<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryNode<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}

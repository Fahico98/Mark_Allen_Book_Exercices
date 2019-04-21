
public class Section_18_2_Search_Binary_Tree{
    
    public static void main(String[] arguments){
        
        SearchBinaryTree numbersTree = new SearchBinaryTree(50);
        
        numbersTree.add(32);
        numbersTree.add(40);
        numbersTree.add(33);
        numbersTree.add(9);
        numbersTree.add(66);
        numbersTree.add(78);
        numbersTree.add(55);
        numbersTree.add(20);
        numbersTree.add(52);
        
        System.out.print("Pre-order:\t");
        numbersTree.printPreOrder();
        System.out.println("");
        
        System.out.print("Post-order:\t");
        numbersTree.printPostOrder();
        System.out.println("");
        
        System.out.print("In-order:\t");
        numbersTree.printInOrder();
        System.out.println("");
        
        System.out.print("Level-order:\t");
        numbersTree.printLevelOrder();
        System.out.println("");
    }
}

class SearchBinaryTree extends BinaryTree{
    
    private BinaryNode<Integer> root = new BinaryNode();
    
    public SearchBinaryTree(){
        super(0);
    }
    
    public SearchBinaryTree(int root){
        super(root);
    }
    
    /**
     * Recursive method.
     */
    public BinaryNode add(int num){
        return(this.addInteger(num, getRoot()));
    }
    
    /**
     * @throws RuntimeException if the integer to insert already exist.
     */
    private BinaryNode addInteger(int num, BinaryNode<Integer> root){
        BinaryNode<Integer> toReturn = new BinaryNode(0);;
        if(num < root.getElement()){
            if(root.getLeft() == null){
                toReturn = new BinaryNode(num);
                root.setLeft(toReturn);
            }else{
                addInteger(num, root.getLeft());
            }
        }else if(num > root.getElement()){
            if(root.getRight() == null){
                toReturn = new BinaryNode(num);
                root.setRight(toReturn);
            }else{
                addInteger(num, root.getRight());
            }
        }else{
            throw new RuntimeException("Fail insertion...!");
        }
        return(toReturn);
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

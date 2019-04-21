
public class Section_19_4_AVL_Trees {
    
    public static void main(String[] arguments){
        
        AVLTree avlTree = new AVLTree(10);
        
        avlTree.AVLadd(20);
        avlTree.AVLadd(30);
        avlTree.AVLadd(40);
        avlTree.AVLadd(50);
        avlTree.AVLadd(25);
        
        //avlTree.printInOrder();
        
        //System.out.println("");
        
        //System.out.println(avlTree.height());
    }
}

class AVLTree{
    
    private AVLBinaryNode root;
    private int height;
    
    public AVLTree(){
        this.root = null;
    }
    
    public AVLTree(int rootData){
        this.root = new AVLBinaryNode(rootData);
    }
    
    public int computeHeight(){
        this.height = this.computeHeight(this.root);
        return(this.height);
    }
    
    private int computeHeight(AVLBinaryNode root){
        return(AVLBinaryNode.height(root));
    }
    
    public void AVLadd(int num){
        AVLadd(num, root);
        AVLBinaryNode unbalancedNode = AVLBinaryNode.unbalancedNode(root);
        if(unbalancedNode != null){
            //System.out.println("Unbalanced node: " + unbalancedNode.getData());
        }
    }
    
    private void AVLadd(int num, AVLBinaryNode node){
        if(num < node.getData()){
            if(node.getLeft() == null){
                node.setLeft(new AVLBinaryNode(num));
                AVLBinaryNode.height(node);
            }else{
                AVLadd(num, node.getLeft());
            }
        }else if(num > node.getData()){
            if(node.getRight() == null){
                node.setRight(new AVLBinaryNode(num));
                AVLBinaryNode.height(node);
            }else{
                AVLadd(num, node.getRight());
            }
        }else{
            throw new RuntimeException("Insertion fail...!");
        }
    }
    
    /*
    public void add(int num){
        
        
        
        buffer.setHeight(1 + Math.max(AVL_BinaryNode.height(buffer.getLeft()),
                AVL_BinaryNode.height(buffer.getRight())));
        
        int balance = getBalance(buffer);
        
        if(balance > 1 && buffer.getElement() < buffer.getLeft().getElement()){
            return(rotateWithRightChild(buffer));
        }
        
        if(balance < -1 && buffer.getElement() > buffer.getRight().getElement()){
            return(rotateWithLeftChild(buffer));
        }
        
        if(balance > 1 && buffer.getElement() > buffer.getLeft().getElement()){
            return(doubleRotateWithLeftChild(buffer));
        }
        
        if(balance < -1 && buffer.getElement() < buffer.getRight().getElement()){
            return(doubleRotateWithRightChild(buffer));
        }
            
        return(buffer);
    }
    */
    
    /**
     * [Single Rotation]************************************************
     * Rotate binary tree node with left child, for AVL trees, this is a
     * single rotation for case 1.
     * @param BinaryNode object to do rotation.
     * @return BinaryNode object what is in the k2 place rightnow.
     */
    public static AVLBinaryNode rotateWithLeftChild(AVLBinaryNode k2){
        AVLBinaryNode k1 = (AVLBinaryNode)k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(AVLBinaryNode.height(k2.getLeft()), AVLBinaryNode.height(k2.getRight())) + 1);
        k1.setHeight(Math.max(AVLBinaryNode.height(k1.getLeft()), AVLBinaryNode.height(k1.getRight())) + 1);
        return(k1);
    }
    
    /**
     * [Single Rotation]************************************************
     * Rotate binary tree node with right child, for AVL trees, this is
     * a single rotation for case 4.
     * @param BinaryNode object to do rotation.
     * @return BinaryNode object what is in the k1 place rightnow.
     */
    public static AVLBinaryNode rotateWithRightChild(AVLBinaryNode k1){
        AVLBinaryNode k2 = (AVLBinaryNode)k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k2.setHeight(Math.max(AVLBinaryNode.height(k2.getLeft()), AVLBinaryNode.height(k2.getRight())) + 1);
        k1.setHeight(Math.max(AVLBinaryNode.height(k1.getLeft()), AVLBinaryNode.height(k1.getRight())) + 1);
        return(k2);
    }
    
    /**
     * [Double Rotation]************************************************
    * Double rotate binary tree node: first left child with its right child;
    * then node k3 with new left child, for AVL trees, this is a double
    * rotation for case 2.
    */
    public static AVLBinaryNode doubleRotateWithLeftChild(AVLBinaryNode k3){
        k3.setLeft(rotateWithRightChild((AVLBinaryNode)k3.getLeft()));
        return(rotateWithLeftChild(k3));
    }
    
    /**
     * [Double Rotation]************************************************
    * Double rotate binary tree node: first left child with its left child;
    * then node k1 with new right child, for AVL trees, this is a double
    * rotation for case 3.
    */
    public static AVLBinaryNode doubleRotateWithRightChild(AVLBinaryNode k1){
        k1.setRight(rotateWithLeftChild((AVLBinaryNode)k1.getRight()));
        return(rotateWithRightChild(k1));
    }

    /**
     * @return the root
     */
    public AVLBinaryNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(AVLBinaryNode root) {
        this.root = root;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
}

class AVLBinaryNode{
    
    private int height;
    private int data;
    private AVLBinaryNode right;
    private AVLBinaryNode left;
    
    public AVLBinaryNode(){
        this(0, null, null);
        this.height = 0;
    }
    
    public AVLBinaryNode(int data){
        this(data, null, null);
        this.height = 1;
    }
    
    public AVLBinaryNode(int data, AVLBinaryNode leftChild, AVLBinaryNode rightChild){
        this.data = data;
        this.left = leftChild;
        this.right = rightChild;
    }
    
    public static AVLBinaryNode unbalancedNode(AVLBinaryNode node){
        ArrayQueue<AVLBinaryNode> queue = new ArrayQueue();
        queue.enqueue(node);
        while(!queue.isEmpty()){
            AVLBinaryNode bufferNode = queue.dequeue();
            int balance = height(node.getLeft()) - height(node.getRight());
            if(2 <= Math.abs(balance)){
                return(node);
            }
            if(bufferNode.getLeft() != null){
                queue.enqueue(bufferNode.getLeft());
            }
            if(bufferNode.getRight() != null){
                queue.enqueue(bufferNode.getRight());
            }
        }
        return null;
    }
    
    /**
     * Return the height of the binary tree rooted at 'node'.
     */
    public static int height(AVLBinaryNode node){
        if(node == null){
            return(-1);
        }else{
            node.height = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
            return(node.height);
        }
    }
    
    /**
     * @return the heigth
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param heigth the heigth to set
     */
    public void setHeight(int heigth) {
        this.height = heigth;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the right
     */
    public AVLBinaryNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(AVLBinaryNode right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public AVLBinaryNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(AVLBinaryNode left) {
        this.left = left;
    }
}
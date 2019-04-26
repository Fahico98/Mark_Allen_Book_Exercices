
public class Section_19_4_AVL_Tree{
    
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
    
    private AVLNode root;
    private int height;
    
    public AVLTree(){
        this.root = null;
        
    }
    
    public AVLTree(int rootData){
        this.root = new AVLNode(rootData);
        this.height = 1;
    }
    
    public AVLTree(AVLNode rootNode){
        this.root = rootNode;
        this.height = rootNode.getHeight();
    }
    
    public void AVLadd(int num){
        AVLNode addedNode = simpleAVLadd(num, root);
        AVLNode unbalancedNode = this.unbalancedNode(addedNode);
        if(unbalancedNode != null){
            int balance = unbalancedNode.getBalance();
            int leftBalance = unbalancedNode.getLeft().getBalance();
            int rightBalance = unbalancedNode.getRight().getBalance();
            if(balance > 0){
                if(leftBalance > 0){
                    
                }else if(leftBalance < 0){
                    
                }
            }else if(balance < 0){
                if(rightBalance > 0){
                    
                }else if(rightBalance < 0){
                    
                }
            }
        }
    }
    
    private AVLNode simpleAVLadd(int num, AVLNode root){
        AVLNode toReturn = new AVLNode(0);
        if(num < root.getData()){
            if(root.getLeft() == null){
                toReturn = new AVLNode(num);
                root.setLeft(toReturn);
                toReturn.setParent(root);
            }else{
                simpleAVLadd(num, root.getLeft());
            }
        }else if(num > root.getData()){
            if(root.getRight() == null){
                toReturn = new AVLNode(num);
                root.setRight(toReturn);
                toReturn.setParent(root);
            }else{
                simpleAVLadd(num, root.getRight());
            }
        }else{
            throw new RuntimeException("Fail insertion...!");
        }
        return(toReturn);
    }
    
    private AVLNode unbalancedNode(AVLNode node){
        if(node == this.root){
            return(null);
        }else if(Math.abs(node.getBalance()) >= 2){
            return(node);
        }else{
            return(unbalancedNode(node.getParent()));
        }
    }
    
    private void leftRotate(AVLNode node){
        AVLNode bufferNode = node.getRight();
        node.setRight(bufferNode.getRight());
    }
    
    /*
    public void AVLadd(int num){
        AVLadd(num, root);
        AVLNode unbalancedNode = root.unbalancedNode();
        
        if(unbalancedNode != null){
            System.out.println("unbalancedNode.balance(): " + unbalancedNode.balance());
            System.out.println("unbalancedNode.getData(): " + unbalancedNode.getData());
            System.out.println("num: " + num);
            
            int balance = unbalancedNode.balance();
            
            if(balance > 1 && num < unbalancedNode.getLeft().getData()){
                rotateWithRightChild(unbalancedNode);
            }else if(balance < -1 && num > unbalancedNode.getRight().getData()){
                rotateWithLeftChild(unbalancedNode);
            }else if(balance > 1 && num > unbalancedNode.getLeft().getData()){
                doubleRotateWithRightChild(unbalancedNode);
            }else if(balance < -1 && num < unbalancedNode.getRight().getData()){
                doubleRotateWithLeftChild(unbalancedNode);
            }
        }
    }
    
    private void AVLadd(int num, AVLNode node){
        if(num < node.getData()){
            if(node.getLeft() == null){
                node.setLeft(new AVLNode(num));
                AVLNode.height(node);
            }else{
                AVLadd(num, node.getLeft());
            }
        }else if(num > node.getData()){
            if(node.getRight() == null){
                node.setRight(new AVLNode(num));
                AVLNode.height(node);
            }else{
                AVLadd(num, node.getRight());
            }
        }else{
            throw new RuntimeException("Insertion fail...!");
        }
    }
    
    public AVLNode unbalanceNode(AVLNode node){
        if(node == this.root){
            return(new AVLNode(-1));
        }else if(Math.abs(node.getBalance()) >= 2){
            return(node);
        }else{
            return(unbalanceNode(node.getParent()));
        }
    }
    */
    
    /**
     * [Single Rotation]************************************************
     * Rotate binary tree node with left child, for AVL trees, this is a
     * single rotation for case 1.
     * @param BinaryNode object to do rotation.
     * @return BinaryNode object what is in the k2 place rightnow.
    
    public static AVLNode rotateWithLeftChild(AVLNode k2){
        AVLNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(AVLNode.updateHeight(k2.getLeft()), AVLNode.updateHeight(k2.getRight())) + 1);
        k1.setHeight(Math.max(AVLNode.updateHeight(k1.getLeft()), AVLNode.updateHeight(k1.getRight())) + 1);
        return(k1);
    }
     */
    
    /**
     * [Single Rotation]************************************************
     * Rotate binary tree node with right child, for AVL trees, this is
     * a single rotation for case 4.
     * @param BinaryNode object to do rotation.
     * @return BinaryNode object what is in the k1 place rightnow.
    
    public static AVLNode rotateWithRightChild(AVLNode k1){
        AVLNode k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k2.setHeight(Math.max(AVLNode.updateHeight(k2.getLeft()), AVLNode.updateHeight(k2.getRight())) + 1);
        k1.setHeight(Math.max(AVLNode.updateHeight(k1.getLeft()), AVLNode.updateHeight(k1.getRight())) + 1);
        return(k2);
    }
     */
    
    /**
     * [Double Rotation]************************************************
    * Double rotate binary tree node: first left child with its right child;
    * then node k3 with new left child, for AVL trees, this is a double
    * rotation for case 2.
    public static AVLNode doubleRotateWithLeftChild(AVLNode k3){
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return(rotateWithLeftChild(k3));
    }
     */
    
    /**
     * [Double Rotation]************************************************
    * Double rotate binary tree node: first left child with its left child;
    * then node k1 with new right child, for AVL trees, this is a double
    * rotation for case 3.
    public static AVLNode doubleRotateWithRightChild(AVLNode k1){
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return(rotateWithRightChild(k1));
    }
     */

    /**
     * @return the root
     */
    public AVLNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(AVLNode root) {
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

class AVLNode{
    
    private int balance;
    private int height;
    private int data;
    private AVLNode parent;
    private AVLNode right;
    private AVLNode left;
    
    public AVLNode(){
        this(0, null, null, null);
    }
    
    public AVLNode(int data){
        this(data, null, null, null);
    }
    
    public AVLNode(int data, AVLNode leftChild, AVLNode rightChild, AVLNode parent){
        this.parent = parent;
        this.left = leftChild;
        this.right = rightChild;
        this.data = data;
        this.height = Math.max(leftChild.height, rightChild.height) + 1;
        this.balance = 0;
        this.parent.updateBalance();
        this.parent.updateHeight();
    }
    
    /*
    public AVLNode unbalancedNode(){
        ArrayQueue<AVLNode> queue = new ArrayQueue();
        queue.enqueue(this);
        while(!queue.isEmpty()){
            AVLNode bufferNode = queue.dequeue();
            int balance = this.balance();
            if(2 <= Math.abs(balance)){
                return(this);
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
    */
    
    /**
     * Update the balance of the node that invokes it.
     */
    public void updateBalance(){
        this.balance = this.left.height - this.right.height;
    }
    
    /**
     * Update the height of the node that invokes it.
     */
    public void updateHeight(){
        this.height = Math.max(this.left.height, this.right.height) + 1;
    }
    
    /**
     * @return the heigth
     */
    public int getHeight() {
        return height;
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
    public AVLNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(AVLNode right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public AVLNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(AVLNode left) {
        this.left = left;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @return the parent
     */
    public AVLNode getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(AVLNode parent) {
        this.parent = parent;
        parent.updateBalance();
    }
}
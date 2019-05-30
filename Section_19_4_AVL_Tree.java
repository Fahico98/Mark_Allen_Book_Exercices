
public class Section_19_4_AVL_Tree{
    
    public static void main(String[] arguments){
        
        AVLTree avlTree = new AVLTree(10);
        
        avlTree.AVLadd(20);
        avlTree.AVLadd(30);
        avlTree.AVLadd(40);
        avlTree.AVLadd(50);
        avlTree.AVLadd(25);
        
        System.out.println("AVL Tree printed in Level Order Transversal:");
        avlTree.printLevelOrder();
        System.out.println("");
        
        avlTree.AVLremove(30);
        
        System.out.println("AVL Tree printed in Level Order Transversal after remove:");
        avlTree.printLevelOrder();
        System.out.println("");
        
        System.out.println("root: " + avlTree.getRoot().getData());
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
        AVLNode addedNode = simpleAdd(num, root);
        updateHeight(addedNode);
        updateBalance(addedNode);
        AVLNode unbalancedNode = unbalancedNode(addedNode);
        makeRotation(unbalancedNode);
    }
    
    private void makeRotation(AVLNode unbalancedNode){
        if(unbalancedNode != null){
            int balance = unbalancedNode.getBalance();
            int leftBalance;
            if(unbalancedNode.getLeft() != null){
                leftBalance = unbalancedNode.getLeft().getBalance();
            }else{
                leftBalance = 0;
            }
            int rightBalance;
            if(unbalancedNode.getRight() != null){
                rightBalance = unbalancedNode.getRight().getBalance();
            }else{
                rightBalance = 0;
            }
            if(balance > 0){
                if(leftBalance > 0){
                    leftLeftRotation(unbalancedNode);
                }else if(leftBalance < 0){
                    leftRightRotation(unbalancedNode);
                }
            }else if(balance < 0){
                if(rightBalance > 0){
                    rightLeftRotation(unbalancedNode);
                }else if(rightBalance < 0){
                    rightRightRotation(unbalancedNode);
                }
            }
        }
    }
    
    private AVLNode simpleAdd(int num, AVLNode root){
        if(num < root.getData()){
            if(root.getLeft() == null){
                root.setLeft(new AVLNode(num));
                root.getLeft().setParent(root);
                return(root.getLeft());
            }else{
                return(simpleAdd(num, root.getLeft()));
            }
        }else if(num > root.getData()){
            if(root.getRight() == null){
                root.setRight(new AVLNode(num));
                root.getRight().setParent(root);
                return(root.getRight());
            }else{
                return(simpleAdd(num, root.getRight()));
            }
        }else{
            throw new RuntimeException("Fail insertion...!");
        }
    }
    
    public void AVLremove(int data){
        AVLNode toRebalance = simpleRemove(data);
        updateHeight(toRebalance);
        updateBalance(toRebalance);
        AVLNode unbalancedNode = unbalancedNode(toRebalance);
        makeRotation(unbalancedNode);
    }
    
    private AVLNode simpleRemove(int data){
        AVLNode toRemove = search(data);
        if(toRemove == null){
            return(null);
        }
        // Case 1: node to be deleted is a leaf.
        if(toRemove.getLeft() == null && toRemove.getRight() == null){
            AVLNode parent = toRemove.getParent();
            if(parent.getLeft() == toRemove){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
            return(parent);
        // Case 2: node to be deleted has only one child.
        }else if(toRemove.getLeft() == null ^ toRemove.getRight() == null){
            AVLNode parent = toRemove.getParent();
            if(toRemove.getLeft() != null){
                AVLNode child = toRemove.getLeft();
                if(parent.getLeft() == toRemove){
                    parent.setLeft(child);
                }else{
                    parent.setRight(child);
                }
                child.setParent(parent);
            }else{
                AVLNode child = toRemove.getRight();
                if(parent.getLeft() == toRemove){
                    parent.setLeft(child);
                }else{
                    parent.setRight(child);
                }
                child.setParent(parent);
            }
            return(parent);
        // Case 3: node to be deleted has two children.
        }else{
            AVLNode nextNode = nextNode(data);
            simpleRemove(nextNode.getData());
            if(toRemove.getRight() != null){
                nextNode.setRight(toRemove.getRight());
                toRemove.getRight().setParent(nextNode);
            }
            if(toRemove.getLeft() != null){
                nextNode.setLeft(toRemove.getLeft());
                toRemove.getLeft().setParent(nextNode);
            }
            if(toRemove == root){
                root = nextNode;
                nextNode.setParent(null);
                return(root);
            }else{
                if(toRemove.getParent().getRight() == toRemove){
                    toRemove.getParent().setRight(nextNode);
                }else{
                    toRemove.getParent().setLeft(nextNode);
                }
                nextNode.setParent(toRemove.getParent());
                return(nextNode);
            }
            
        }
    }
    
    private AVLNode nextNode(int data){
        AVLNode buffer = search(data);
        AVLNode nextNode = buffer.getRight();
        while(true){
            if(nextNode.getLeft() == null){
                break;
            }else{
                nextNode = nextNode.getLeft();
            }
        }
        return(nextNode);
    }
    
    private AVLNode search(int data){
        return(search(data, root));
    }
    
    private AVLNode search(int data, AVLNode root){
        if(data == root.getData()){
            return(root);
        }else if(data > root.getData()){
            if(root.getRight() != null){
                return(search(data, root.getRight()));
            }else{
                return(null);
            }
        }else{
            if(root.getLeft() != null){
                return(search(data, root.getLeft()));
            }else{
                return(null);
            }
        }
    }
    
    private AVLNode unbalancedNode(AVLNode node){
        if(Math.abs(node.getBalance()) >= 2){
            return(node);
        }else{
            if(node.getParent() != null){
                return(unbalancedNode(node.getParent()));
            }else{
                return(null);
            }
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
    
    public void printBalances(){
        if(root != null){
            root.printBalances();
        }
    }
    
    public void printHeights(){
        if(root != null){
            root.printHeights();
        }
    }
    
    private void updateBalance(AVLNode node){
        if(node == root){
            AVLNode.updateBalance(root);
        }else{
            AVLNode.updateBalance(node);
            updateBalance(node.getParent());
        }
    }
    
    private void updateHeight(AVLNode node){
        if(node == root){
            AVLNode.updateHeight(root);
        }else{
            AVLNode.updateHeight(node);
            updateHeight(node.getParent());
        }
    }
    
    /**
     * [Single Rotation]************************************************
     * Rotate binary tree node with left child.
     * @param BinaryNode object to do rotation.
     */
    private void leftLeftRotation(AVLNode node){
        AVLNode buffer = node.getLeft();
        if(buffer.getRight() != null){
            buffer.getRight().setParent(node);
            node.setLeft(buffer.getRight());
        }else{
            node.setLeft(null);
        }
        if(node == this.root){
            buffer.setRight(node);
            node.setParent(buffer);
            this.root = buffer;
            root.setParent(null);
        }else{
            AVLNode bufferParent = node.getParent();
            buffer.setParent(node.getParent());
            buffer.setRight(node);
            node.setParent(buffer);
            node.setLeft(null);
            if(bufferParent.getLeft() == node){
                bufferParent.setLeft(buffer);
            }else if(bufferParent.getRight() == node){
                bufferParent.setRight(buffer);
            }
        }
        updateHeight(node);
        updateBalance(node);
    }
    
    /**
     * [Single Rotation]************************************************
     * Rotate binary tree node with right child.
     * @param BinaryNode object to do rotation.
     */
    private void rightRightRotation(AVLNode node){
        AVLNode buffer = node.getRight();
        if(buffer.getLeft() != null){
            buffer.getLeft().setParent(node);
            node.setRight(buffer.getLeft());
        }else{
            node.setRight(null);
        }
        if(node == this.root){
            buffer.setLeft(node);
            node.setParent(buffer);
            this.root = buffer;
            root.setParent(null);
        }else{
            AVLNode bufferParent = node.getParent();
            buffer.setParent(node.getParent());
            buffer.setLeft(node);
            node.setParent(buffer);
            node.setRight(null);
            if(bufferParent.getLeft() == node){
                bufferParent.setLeft(buffer);
            }else if(bufferParent.getRight() == node){
                bufferParent.setRight(buffer);
            }
        }
        updateHeight(node);
        updateBalance(node);
    }
    
    /**
     * [Double Rotation]************************************************
     * Double rotate binary tree node: first left child with its right
     * child; then unbalanced node with its new left child.
     * @param BinaryNode object to do rotation.
     */
    private void leftRightRotation(AVLNode node){
        rightRightRotation(node.getLeft());
        leftLeftRotation(node);
    }
    
    /**
     * [Double Rotation]************************************************
     * Double rotate binary tree node: first right child with its left
     * child; then unbalanced node with its new right child.
     * @param BinaryNode object to do rotation.
     */
    private void rightLeftRotation(AVLNode node){
        leftLeftRotation(node.getRight());
        rightRightRotation(node);
    }

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
        this.height = 1;
        this.balance = 0;
    }
    
    /**
     * Update the balance of the node that invokes it.
     */
    public static void updateBalance(AVLNode node){
        if(node.left == null && node.right != null){
            node.balance = - node.right.height;
        }else if(node.left != null && node.right == null){
            node.balance = node.left.height;
        }else if(node.left == null && node.right == null){
            node.balance = 0;
        }else{
            node.balance = node.left.height - node.right.height;
        }
    }
    
    /**
     * Update the height of the node that invokes it.
     */
    public static void updateHeight(AVLNode node){
        if(node.left == null && node.right != null){
            node.height = node.right.height + 1;
        }else if(node.left != null && node.right == null){
            node.height = node.left.height + 1;
        }else if(node.left == null && node.right == null){
            node.height = 1;
        }else{
            node.height = Math.max(node.left.height, node.right.height) + 1;
        }
    }
    
    /**
     * Print tree rooted at current node using preorder traversal.
     */
    public void printPreOrder(){
        System.out.print(getData() + " ");
        if(getLeft() != null){
            getLeft().printPreOrder();
        }
        if(getRight() != null){
            getRight().printPreOrder();
        }
    }
    
    /**
     * Print tree rooted at current node using inorder traversal.
     */
    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        System.out.print(getData() + " ");
        if(right != null){
            right.printInOrder();
        }
    }
    
    /**
     * Print tree rooted at current node using postorder traversal.
     */
    public void printPostOrder(){
        if(left != null){
            left.printPostOrder();
        }
        if(right != null){
            right.printPostOrder();
        }
        System.out.print(getData() + " ");
    }
    
    /**
     * printLevelOrder method uses the ArrayQueue class defined into 
     * 'Section_16_1_Dynamic_Array_Implementations_Queue.java' file, in 
     * this directory.
     */
    public void printLevelOrder(){
        ArrayQueue<AVLNode> queue = new ArrayQueue();
        queue.enqueue(this);
        while(!queue.isEmpty()){
            AVLNode bufferNode = queue.dequeue();
            System.out.print(bufferNode.data + " ");
            if(bufferNode.left != null){
                queue.enqueue(bufferNode.left);
            }
            if(bufferNode.right != null){
                queue.enqueue(bufferNode.right);
            }
        }
    }
    
    public void printBalances(){
        ArrayQueue<AVLNode> queue = new ArrayQueue();
        queue.enqueue(this);
        while(!queue.isEmpty()){
            AVLNode bufferNode = queue.dequeue();
            System.out.print(bufferNode.getBalance() + " ");
            if(bufferNode.getLeft() != null){
                queue.enqueue(bufferNode.getLeft());
            }
            if(bufferNode.getRight() != null){
                queue.enqueue(bufferNode.getRight());
            }
        }
    }
    
    public void printHeights(){
        ArrayQueue<AVLNode> queue = new ArrayQueue();
        queue.enqueue(this);
        while(!queue.isEmpty()){
            AVLNode bufferNode = queue.dequeue();
            System.out.print(bufferNode.getHeight() + " ");
            if(bufferNode.getLeft() != null){
                queue.enqueue(bufferNode.getLeft());
            }
            if(bufferNode.getRight() != null){
                queue.enqueue(bufferNode.getRight());
            }
        }
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
    }
}
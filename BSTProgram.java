class BSTNode{
  int data;
  BSTNode leftNode;
  BSTNode rightNode;

  public BSTNode(int data){
    this.data = data;
    this.leftNode = null;
    this.rightNode = null;
  }

  public int getData(){
    return this.data;
  }
}

class BST{
  // Binary Search Tree
  BSTNode root;

  public BST(){
    this.root = null;
  } 

  public void createBSTFromArray(int arr[]){
    this.root = new BSTNode( arr[0] );

    for( int i=1; i<arr.length; i++ ){
      addToBST( this.root, arr[i] ); 
    }
  }

  private BSTNode addToBST(BSTNode node, int newValue){
    if( node == null ){
      node = new BSTNode( newValue );
    }
    else{
      if( newValue < node.data ){
        node.leftNode = addToBST(node.leftNode, newValue);
      }
      else{
        node.rightNode = addToBST(node.rightNode, newValue);
      }
    }

    return node;
    
  }

  public void printBST(){
    printNode(root);
  } 

  private void printNode(BSTNode node){
    if( node!=null){
      printNode(node.leftNode);
      System.out.print(node.data + ", ");
      printNode(node.rightNode);
    }
    
  }

  
}

class BSTProgram{

  public static void main(String args[]){
    // BSTNode node = new BSTNode(7);
    // System.out.println(node.getData());

    BST bst = new BST();
    int arr[] = {9,1,4,6,3,2,7,4};
    bst.createBSTFromArray(arr);
    bst.printBST();
    System.out.println();
  }

}
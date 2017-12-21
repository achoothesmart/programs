import java.io.Console;
import java.util.Scanner;

class RadarProgram{
  public static void main(String args[]){
    System.out.println("Enter no.of coordinates:");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    Point p[] = new Point[n];
    for(int i=0; i<n; i++){
      System.out.print("\nEnter x" + (i+1) + ": " );
      int x = scan.nextInt();
      System.out.print("\nEnter y" + (i+1) + ": " );
      int y = scan.nextInt();

      p[i] = new Point(x, y);
      System.out.println( "\nDistance b/w Origin and (" + p[i].x + "," + p[i].y + ") is " + p[i].distance );
    }

    BST bst = new BST();
    bst.createBSTFromArray(p);
    System.out.println("\nCoOrdinates Ordered by Distance from Origin:");
    bst.printBST();
    System.out.println();

  }
  
}

class Point{
  int x,y;
  double distance;

  public Point(int x, int y){
    this.x = x;
    this.y = y;
    // Calculating distance of point (x,y) from Origin (0,0)
    this.distance = calculateDistance(x,y);
  }

  private double calculateDistance(int x, int y){
    // Calculating distance between point (x,y) and Origin (0,0) using Pythogoras Theoram
    return Math.sqrt( (x*x) + (y*y) );
  }

}

class BSTPoint{
  Point point;
  BSTPoint leftPoint;
  BSTPoint rightPoint;

  public BSTPoint(Point point){
    this.point = point;
    this.leftPoint = null;
    this.rightPoint = null;
  }
}

class BST{
  // Binary Search Tree - tailored for Points
  BSTPoint root;

  public BST(){
    this.root = null;
  } 

  public void createBSTFromArray(Point pArr[]){
    this.root = new BSTPoint( pArr[0] );

    for( int i=1; i<pArr.length; i++ ){
      addToBST( this.root, pArr[i] ); 
    }
  }

  private BSTPoint addToBST(BSTPoint node, Point newPoint){
    if( node == null ){
      node = new BSTPoint( newPoint );
    }
    else{
      if( newPoint.distance < node.point.distance ){
        node.leftPoint = addToBST(node.leftPoint, newPoint);
      }
      else{
        node.rightPoint = addToBST(node.rightPoint, newPoint);
      }
    }

    return node;
    
  }

  public void printBST(){
    printNode(root);
  } 

  private void printNode(BSTPoint node){
    if( node!=null){
      printNode(node.leftPoint);
      System.out.println("(" + node.point.x + "," + node.point.y + ") => " + node.point.distance);
      printNode(node.rightPoint);
    }
    
  }

  
}
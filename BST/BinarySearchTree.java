import java.util.*;
public class BinarySearchTree {
	public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	public int countNodes(){
		return countNodes(root);
	}

	private int countNodes(Node root){
		if(root==null){
			return 0;
		}
		else{
			int count = 1;
			count += countNodes(root.left);
			count += countNodes(root.right);
			return count;
		}
	}
	public boolean find(int id){
				Node current = root;
				while(current!=null){
					if(current.data==id){
						return true;
					}
					else if(current.data>id){
						current = current.left;
					}
					else{
						current = current.right;
					}
				}
				return false;
		}

	public void insert(int a){
			Node newNode = new Node(a);
			if(root==null){
				root = newNode;
				return;
			}
			Node current = root;
			Node parent = null;
			while(true){
				parent = current;
				if(a<current.data){
					current = current.left;
				if(current==null){
						parent.left = newNode;
						return;
					  }
				}else{
					  current = current.right;
					  if(current==null){
						parent.right = newNode;
						return;
					}
			  }
		  }
  	}
	public void display(Node root){
		if(root!=null){
      display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public void displayeven(Node root){
	 if(root!=null){
			displayeven(root.left);
		 if(root.data%2==0){
		 System.out.print(" " + root.data);
	 }
		 displayeven(root.right);
	 }
 }

  public int maxvalue(){
		if(root==null){
			System.out.println();
			return 0;
		}
		return maxvalue(root);
		}

	private int maxvalue(Node root1){
		int max = 0;
		if(root1==null){
			return root1.data;
		}
		else{
				int rootval = root1.data;
				int left = maxvalue(root1.left);
				int right = maxvalue(root1.right);
				if(left>right){
					max = left;
				}
				else{
					max = right;
				}
				if(rootval>max){
				max = rootval;
			}
		}
		return max;
	}
	public int minvalue(){
		if(root==null){
			System.out.println();
			return 0;
		}
		else{
		return minvalue(root);
	}
		}

	private int minvalue(Node root1){
		if(root1.left==null&&root1.right==null){
			return root1.data;
		}
		int minval = root1.data;
		if(root1.left!=null){
			minval = Math.min(minval,minvalue(root1.left));
		}
		if(root1.right!=null){
			minval = Math.min(minval,minvalue(root1.right));
		}
		return minval;
	}

	public int sum(){
		return sum(root);
	}
	private int sum(Node root){
		if(root==null){
			return 0;
		}
		else{
			return root.data+sum(root.left)+sum(root.right);

		}
	}



	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);
		b.insert(6);b.insert(2);
		b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);
		b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
    System.out.println("No. of nodes :"+b.countNodes());
		//System.out.println("the max value is:"+b.maxvalue());
		b.display(root);
		System.out.println();
		System.out.print("The even nodes in tree is:");
		b.displayeven(root);
		System.out.println();
		System.out.println("The sum of all nodes is: "+b.sum());
		b.display(root);
	  System.out.println();
    System.out.println("the min value is:"+b.minvalue());
	}
}

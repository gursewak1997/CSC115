import java.util.*;

//
// An implementation of a binary search tree.
//
// This tree stores both keys and values associated with those keys.
//
// More information about binary search trees can be found here:
//
// http://en.wikipedia.org/wiki/Binary_search_tree
//
// Note: Wikipedia is using a different definition of
//       depth and height than we are using.  Be sure
//       to read the comments in this file for the
//	 	 height function.
//
class BinarySearchTree < K extends Comparable < K > , V > {

    public static final int BST_PREORDER = 1;
    public static final int BST_POSTORDER = 2;
    public static final int BST_INORDER = 3;

    // These are package friendly for the TreeView class
    BSTNode < K,
    V > root;
    int count;

    int findLoops;
    int insertLoops;

    public BinarySearchTree() {
        root = null;
        count = 0;
        resetFindLoops();
        resetInsertLoops();
    }


    public int getFindLoopCount() {
        return findLoops;
    }

    public int getInsertLoopCount() {
        return insertLoops;
    }

    public void resetFindLoops() {
        findLoops = 0;
    }
    public void resetInsertLoops() {
        insertLoops = 0;
    }

    //
    // Purpose:
    //
    // Insert a new Key:Value Entry into the tree.  If the Key
    // already exists in the tree, update the value stored at
    // that node with the new value.
    //
    // Pre-Conditions:
    // 	the tree is a valid binary search tree
    //
    public void insert(K k, V v) {
        root = insert(k, v, root);
    }

    private BSTNode < K,
    V > insert(K k, V v, BSTNode < K, V > base) {
        insertLoops++;
        if (base == null) {                     //when the root is null we make a new node to insert
            count++;
            return new BSTNode < K, V > (k, v);
        }
        int a = k.compareTo(base.key);
        if (a == 0) {
            base.value = v;
            return base;
        } else if (a < 0) {                     //as the left child is always smaller
            if (base.left == null) {
                count++;
                base.left = new BSTNode < K, V > (k, v);
                return base;
            } else {
                base.left = insert(k, v, base.left);
            }
        } else {
            if (base.right == null) {
                count++;
                base.right = new BSTNode < K, V > (k, v);
                return base;
            } else {
                base.right = insert(k, v, base.right);
            }
        }
        return base;
    }






    //
    // Purpose:
    //
    // Return the value stored at key.  Throw a KeyNotFoundException
    // if the key isn't in the tree.
    //
    // Pre-conditions:
    //	the tree is a valid binary search tree
    //
    // Returns:
    //	the value stored at key
    //
    // Throws:
    //	KeyNotFoundException if key isn't in the tree
    //
    public V find(K key) throws KeyNotFoundException {
        return find(root, key);

    }

    private V find(BSTNode < K, V > base, K k) throws KeyNotFoundException {
        findLoops++;
        if (base == null) {
            throw new KeyNotFoundException(); //not found case
        } else {
            int a = base.key.compareTo(k);
            if (a == 0) {
                return base.value;
            } else if (a > 0) {
                if (base.left == null) {
                    throw new KeyNotFoundException();
                } else {
                    return find(base.left, k);
                    //return base.value;
                }
            } else {
                if (base.right == null) {
                    throw new KeyNotFoundException();
                } else {
                    // find(base.right,k);
                    return find(base.right, k);
                }
            }
        }
        //return base.value	;
    }



    //
    // Purpose:
    //
    // Return the number of nodes in the tree.
    //
    // Returns:
    //	the number of nodes in the tree.
    public int size() {
        return count;
    }

    //
    // Purpose:
    //	Remove all nodes from the tree.
    //
    public void clear() {
        root = null;
        count = 0;
    }

    //
    // Purpose:
    //
    // Return the height of the tree.  We define height
    // as being the number of nodes on the path from the root
    // to the deepest node.
    //
    // This means that a tree with one node has height 1.
    //
    // Examples:
    //	See the assignment PDF and the test program for
    //	examples of height.
    //
    public int height() {
        return height(root);
    }

    private int height(BSTNode < K, V > t) {
        if (t == null)
            return 0;
        else {
            //System.out.println(1+Math.max(height(t.left),height(t.right)));
        }
        return 1 + Math.max(height(t.left), height(t.right));
    }


    private void doInOrder(BSTNode < K, V > n, List < Entry < K, V > > l) {
        if (n != null) {
            doInOrder(n.left, l);
            l.add(new Entry < K, V > (n.key, n.value));
            doInOrder(n.right, l);
        }
    }
    private void doPreOrder(BSTNode < K, V > n, List < Entry < K, V > > l) {
        if (n != null) {
            l.add(new Entry < K, V > (n.key, n.value));
            doPreOrder(n.left, l);
            doPreOrder(n.right, l);
        }
    }

    private void doPostOrder(BSTNode < K, V > n, List < Entry < K, V > > l) {
        if (n != null) {
            doPostOrder(n.left, l);
            doPostOrder(n.right, l);
            l.add(new Entry < K, V > (n.key, n.value));
        }
    }
    //
    // Purpose:
    //
    // Return a list of all the key/value Entrys stored in the tree
    // The list will be constructed by performing a level-order
    // traversal of the tree.
    //
    // Level order is most commonly implemented using a queue of nodes.
    //
    //  From wikipedia (they call it breadth-first), the algorithm for level order is:
    //
    //	levelorder()
    //		q = empty queue
    //		q.enqueue(root)
    //		while not q.empty do
    //			node := q.dequeue()
    //			visit(node)
    //			if node.left != null then
    //			      q.enqueue(node.left)
    //			if node.right != null then
    //			      q.enqueue(node.right)
    //
    // Note that we will use the Java LinkedList as a Queue by using
    // only the removeFirst() and addLast() methods.
    //=
    public List < Entry < K,
    V >> entryList() {
        List < Entry < K, V >> l = new LinkedList < Entry < K, V > > ();
        LinkedList < BSTNode < K, V >> e1 = new LinkedList < BSTNode < K, V >> ();

        BSTNode < K, V > node = null;
        e1.addLast(root);

        while (!e1.isEmpty()) {
            node = e1.removeFirst();
            l.add(new Entry < K, V > (node.key, node.value));
            if (node.left != null) {
                e1.addLast(node.left);
            }
            if (node.right != null) {
                e1.addLast(node.right);
            }
        }

        return l;
    }

    //
    // Purpose:
    //
    // Return a list of all the key/value Entrys stored in the tree
    // The list will be constructed by performing a traversal
    // specified by the parameter which.
    //
    // If which is:
    //	BST_PREORDER	perform a pre-order traversal
    //	BST_POSTORDER	perform a post-order traversal
    //	BST_INORDER	perform an in-order traversal
    //
    public List < Entry < K,V > > entryList(int which) {
        List < Entry < K, V > > l = new LinkedList < Entry < K, V > > ();
        if (which == 1) {
            doPreOrder(root, l);
        }

        if (which == 2) {
            doPostOrder(root, l);
        }
        if (which == 3) {
            doInOrder(root, l);
        }
        return l;
    }

    // Your instructor had the following private methods in his solution:
    // private void doInOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
    // private void doPreOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
    // private void doPostOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
    // private int doHeight (BSTNode<K,V> t)
}

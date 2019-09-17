/** Class LeftistHeap **/
class LeftistHeap
{
    private LeftHeapNode root;

    /** Constructor **/
    public LeftistHeap()
    {
        root = null;
    }

    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** Make heap empty **/
    public void clear( )
    {
        root = null;
    }

    /** Function to insert data **/
    public void insert(int x )
    {
        root = merge(new LeftHeapNode( x ), root);
    }

    /** Function merge **/
    private LeftHeapNode merge(LeftHeapNode x, LeftHeapNode y)
    {
        if (x == null)
            return y;
        if (y == null)
            return x;
        if (x.element > y.element)
        {
            LeftHeapNode temp = x;
            x = y;
            y = temp;
        }

        x.right = merge(x.right, y);

        if(x.left == null)
        {
            x.left = x.right;
            x.right = null;
        }
        else
        {
            if(x.left.sValue < x.right.sValue)
            {
                LeftHeapNode temp = x.left;
                x.left = x.right;
                x.right = temp;
            }
            x.sValue = x.right.sValue + 1;
        }
        return x;
    }

    /** Function to delete minimum element **/
    public int deleteMin( )
    {
        if (isEmpty() )
            return -1;
        int minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    /** Inorder traversal **/
    public String inorder()
    {
        return inorder(root);
    }

    private String inorder(LeftHeapNode r)
    {
        if (r != null)
        {
            String string = "";
            string = string.concat(inorder(r.left));
            string = string.concat(r.element +" ");
            string = string.concat(inorder(r.right));
            return string;
        }
        return "";
    }
}
/**
 *  Java Program to Implement LeftistHeap
 **/

/** Class LeftHeapNode **/
class LeftHeapNode
{
    int element, sValue;
    LeftHeapNode left, right;

    public LeftHeapNode(int ele)
    {
        this(ele, null, null);
    }
    public LeftHeapNode(int ele, LeftHeapNode left, LeftHeapNode right)
    {
        this.element = ele;
        this.left = left;
        this.right = right;
        this.sValue = 0;
    }
}

 
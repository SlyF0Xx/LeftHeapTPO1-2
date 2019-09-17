import java.util.Scanner;

/** Class LeftistHeapMain **/
public class LeftistHeapMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("LeftistHeap Test\n\n");
        LeftistHeap lh = new LeftistHeap();

        char ch;
        /**  Perform LeftistHeap operations  **/
        do
        {
            System.out.println("\nLeftist Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check empty");
            System.out.println("4. clear");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    lh.insert( scan.nextInt() );
                    break;
                case 2 :
                    lh.deleteMin();
                    break;
                case 3 :
                    System.out.println("Empty status = "+ lh.isEmpty());
                    break;
                case 4 :
                    lh.clear();
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /** Display heap **/
            System.out.print("\nInorder Traversal : ");
            System.out.println(lh.inorder());

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
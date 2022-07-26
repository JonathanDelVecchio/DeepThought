import Prog1Tools.IOTools;
import java.util.*;
class binaryTreeNode {
    binaryTreeNode left;
    binaryTreeNode right;
    int number;
    public binaryTreeNode(int number) {
        this.number = number;
    }
}
public class Unit4Assignment {
    public static void main(String[] args) {
        binaryTreeNode link, root;
        int treeValue;
        int search;
        int runs;
        runs = 0;
        root = null;
        link = null;
        Scanner in = new Scanner(System.in);
        do { //Builds the binary tree and adds numbers.
            System.out.println("Enter number,  enter 0 to stop):");
            treeValue = in .nextInt();
            if (treeValue > 0) {
                if (root != null) {
                    addNode(root, treeValue);
                } else {
                    root = new binaryTreeNode(treeValue);
                }
            }
        } while (treeValue > 0);
        System.out.println("Which number should we search for (integers only):");
        search = in .nextInt();
        runs = findNode(root, search, runs);
        if (runs == 0) {
            System.out.println("Number not found.");
        } else {
            System.out.println("Number found! It took " + runs + " runs");
        }
    }
    public static int findNode(binaryTreeNode node, int number, int iter) {
        //Searches for the number.
        if (node != null) {
            if (number == node.number) {
                iter += 1;
            } else if (number < node.number) {
                iter += 1;
                iter = findNode(node.left, number, iter);
            } else {
                iter += 1;
                iter = findNode(node.right, number, iter);
            }
        }
        return (iter);
    }
    public static void addNode(binaryTreeNode node, int number) {
        // Informs where the node has been inserted.
        binaryTreeNode addedNode;
        addedNode = null;
        if (number < node.number) {
            if (node.left != null) {
                addNode(node.left, number);
            } else {
                System.out.println(number + " has been inserted to left of " +
                    node.number);
                node.left = new binaryTreeNode(number);
            }
        } else if (number > node.number) {
            if (node.right != null) {
                addNode(node.right, number);
            } else {
                System.out.println(number + " has been inserted to the right of " + node.number);
                node.right = new binaryTreeNode(number);
            }
        }
    }
}
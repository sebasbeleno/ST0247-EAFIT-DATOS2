package src;


/**
 *
 * @author htrefftz
 */
//import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        NaryTree tree = new NaryTree(null);
        tree.readTree("./arbol.txt");
        tree.printTree();
        // System.out.println(tree.find(2));
        System.out.println(tree.find(80));
        //tree.find(30);
        //System.out.println(tree.find(60));
    }
}

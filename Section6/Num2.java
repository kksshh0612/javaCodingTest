package Section6;

import java.util.Scanner;
import java.util.Stack;

//2. 이진트리 순회(깊이우선탐색)
class Node{
    int data;
    Node leftChild, rightChild;

    public Node(int val){               //생성자
        data = val;
        leftChild = rightChild = null;
    }
}

public class Num2 {

    public Stack<Integer> stack = new Stack<>();

    public static void dfsPreOrder(Node node) {
        System.out.print(node.data + " ");
        if (node.leftChild != null) {     //왼쪽 자식 있으면
            dfsPreOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            dfsPreOrder(node.rightChild);
        }
    }
    public static void dfsInOrder(Node node) {
        if (node.leftChild != null) {     //왼쪽 자식 있으면
            dfsInOrder(node.leftChild);
        }
        System.out.print(node.data + " ");
        if (node.rightChild != null) {
            dfsInOrder(node.rightChild);
        }
    }
    public static void dfsPostOrder(Node node) {
        if (node.leftChild != null) {     //왼쪽 자식 있으면
            dfsPostOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            dfsPostOrder(node.rightChild);
        }
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(6);
        root.rightChild.rightChild = new Node(7);

        System.out.print("전위순회 출력 : ");
        dfsPreOrder(root);
        System.out.println();
        System.out.print("중위순회 출력 : ");
        dfsInOrder(root);
        System.out.println();
        System.out.print("후위순회 출력 : ");
        dfsPostOrder(root);
    }
}

package Gelas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Gelas {

    public static int A, B;
    public static Stack<Node> stack = new Stack<>();
    public static Set<String> jalur;
    public static int jumlahnode = 0;

    public static void main(String args[]) {
        Scanner nilai = new Scanner(System.in);
        System.out.println("Masukkan nilai dari wadah yang tersedia ? ");
        A = nilai.nextInt();
        B = nilai.nextInt();
        
        Node root = new Node(0, 0);

        stack.push(root);
        jalur = new HashSet<>();
        String rootStr = root.a + " " + root.b;
        jalur.add(rootStr);

        while (!stack.isEmpty()) {
            jumlahnode++;
            Node node = stack.pop();

            int a = node.a;
            int b = node.b;

            System.out.println("( " + a + " , " + b + "  )");
            //Mengisi isi A didalam B 
            if (a > 0) {
                //isi A ke B
                if ((a + b) <= B) {
                    //kosongkan A kedalam B 
                    getStates(0, a + b);
                } else {
                    getStates((a + b - B), B);
                }

                //kosongan A
                getStates(0, b);
            }
            //Mengisi isi A didalam B
            if (b > 0) {   //Mengisi isi B didalam A 
                if ((a + b) <= A) {
                    //kosongkan A kedalam B
                    getStates(a + b, 0);
                } else {
                    getStates(A, a + b - A);
                }
                getStates(a, 0);
            }
            //isi A
            if (a < A) {
                getStates(A, b);
            }
//Isi B
            if (b < B) {
                getStates(a, B);
            }
        }
        System.out.println("Jumlah Node " + jumlahnode);

    }

    public static void getStates(int a, int b) {
        if (a <= A && b <= B && a >= 0 && b >= 0) {
            Node newNode = new Node(a, b);
            String nodeStr = newNode.a + " " + newNode.b;
            boolean isVisted = jalur.contains(nodeStr);
            if (!isVisted) {
                stack.add(newNode);
                jalur.add(nodeStr);

            }

        }

    }

}

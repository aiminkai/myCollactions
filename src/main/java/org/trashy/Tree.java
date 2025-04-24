package org.trashy;

import java.util.*;

public class Tree {

    public static class Node {
        private String name;
        private List<Node> child = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public boolean addChild(Node childNode) {
            return this.child.add(childNode);
        }
    }

    public static class Util {
        public static List<Node> toFlatList(Node n) {
            List<Node> result = new ArrayList<>();
            if (n == null) {
                return result;
            }

            Queue<Node> queue = new LinkedList<>();
            Set<Node> set = new HashSet<>();
            queue.add(n);
//            set.add(n);
            while (!queue.isEmpty()) {
               Node root = queue.poll();
                set.add(root);
                result.add(root);
               for (Node node : root.child){
                   if(!set.contains(node)) {
                       set.add(node);
                       result.add(node);
                   }
               }
//               result.add(root);
               queue.addAll(root.child);
            }

//            result.add(n); // Добавляем текущий узел
//            for (Node child : n.child) {
//                result.addAll(toFlatList(child)); // Рекурсивно добавляем всех потомков
//            }
//            Queue<Node> queue = new LinkedList<>();
//            queue.add(n);
//
//            while (!queue.isEmpty()) {
//                Node current = queue.poll();
//                result.add(current);
//                queue.addAll(current.child); // Добавляем всех детей в очередь
//            }
            return result;
        }
    }

    public static void main(String[] args) {
        Tree.Node a = new Tree.Node("a");
        Tree.Node b = new Tree.Node("b");
        Tree.Node c = new Tree.Node("c");
        Tree.Node d = new Tree.Node("d");
        Tree.Node e = new Tree.Node("e");
        Tree.Node f = new Tree.Node("f");

        a.addChild(b);
        a.addChild(c);

        c.addChild(d);
        c.addChild(e);
        c.addChild(f);

        b.addChild(f);

        List<Tree.Node> result = Tree.Util.toFlatList(a);
        Set<Node> res = new HashSet<>(result);
        System.out.println(result);
        System.out.println(res);
    }
}

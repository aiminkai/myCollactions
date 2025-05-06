package org.trashy;

import java.util.*;

public class UtilTree {

    public static List<Node> toFlatList(Node root) {
        Set<Node> result = new HashSet<>();
//        Queue <Node> queue = new LinkedList<>();
//        result.add(root);
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            Node current = queue.poll();
//            result.add(root);
//            result.addAll(current.getChildNodeList());
//            queue.addAll(current.getChildNodeList());
//        }
        result.add(root); // Добавляем текущий узел
            for (Node child : root.getChildNodeList()) {
                result.addAll(toFlatList(child)); // Рекурсивно добавляем всех потомков
            }
        return new ArrayList<>(result);
    }
}

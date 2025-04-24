package org.trashy;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> childNodeList = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public boolean addChildNode(Node node) {
        return this.childNodeList.add(node);
    }

    public List<Node> getChildNodeList() {
        return childNodeList;
    }
}

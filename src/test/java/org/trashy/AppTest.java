package org.trashy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void example() {

        Tree.Node a = new Tree.Node("a");
        Tree.Node b = new Tree.Node("b");
        Tree.Node c = new Tree.Node("c");
        Tree.Node d = new Tree.Node("d");
        Tree.Node e = new Tree.Node("e");
        Tree.Node f = new Tree.Node("f");

//        a.child.add(b);
//        a.child.add(c);
//
//        c.child.add(d);
//        c.child.add(e);
//        c.child.add(f);

        List<Tree.Node> result = Tree.Util.toFlatList(a);

        Assertions.assertThat(result).containsExactlyInAnyOrder(a, b, c, d, e, f);
    }

    @Test
    public void treeTest() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.addChildNode(b);
        a.addChildNode(c);

        c.addChildNode(d);
        c.addChildNode(e);
        c.addChildNode(f);

        List<Node> nodeList = UtilTree.toFlatList(a);

        Assertions.assertThat(nodeList).containsExactlyInAnyOrder(a, b, c, d, e, f);
    }
}

package net.ins.edu.algorithms.leetcode.util.integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListNodeTest {

    @Test
    void shouldBuildNodeList() {
        var node = ListNode.build(1, 2, 3);
        Assertions.assertEquals(
                new ListNode(1, new ListNode(2, new ListNode(3))),
                node
        );
    }
}

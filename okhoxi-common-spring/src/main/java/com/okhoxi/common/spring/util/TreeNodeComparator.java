package com.okhoxi.common.spring.util;

import com.okhoxi.common.spring.model.vo.TreeNode;

import java.util.Comparator;

public class TreeNodeComparator implements Comparator<TreeNode> {
    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        if (o1.getSort() > o2.getSort()) {
            return 1;
        } else {
            return -1;
        }
    }
}

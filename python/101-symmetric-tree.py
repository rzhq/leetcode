#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def check(node1, node2):
            if isinstance(node1, TreeNode) and isinstance(node2, TreeNode):
                if node1.val == node2.val:
                    return check(node1.left, node2.right) and check(node1.right, node2.left)
                else:
                    return False
            else:
                return node1 == node2

        if isinstance(root, TreeNode):
            return check(root.left, root.right)
        else:
            return True

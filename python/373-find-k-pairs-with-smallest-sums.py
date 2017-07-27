#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        def swap(start, end):
            node = start
            while True:
                child = 2 * node
                if child > end:
                    break
                if child + 1 <= end and heap[child][0] > heap[child + 1][0]:
                    child = child + 1
                if heap[node][0] > heap[child][0]:
                    heap[node], heap[child] = heap[child], heap[node]
                    node = child
                else:
                    break

        if not nums1 or not nums2 or not k:
            return []

        ln1 = len(nums1)
        ln2 = len(nums2)
        m = ln1 * ln2
        bound = 2 * k + 1
        
        if k > m:
            k = m

        heap = {}
        res = []
        i = 0
        for n1 in nums1:
            i += 1
            if i > k:
                break
            heap[i] = (n1 + nums2[0], [n1, nums2[0]], 0)

        node = ln1 / 2
        for n in xrange(node, 0, -1):
            swap(n, len(heap))
        
        for i in range(k):
            res.append(heap[1][1])
            m = len(heap)
            p = heap[1][2] + 1
            if p >= ln2:
                heap[1] = heap[m]
                del heap[m]
                m -= 1
            else:
                heap[1] = (heap[1][1][0] + nums2[p], [heap[1][1][0], nums2[p]], p)
            swap(1, m)
        return res

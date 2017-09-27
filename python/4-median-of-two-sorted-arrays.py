#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        def bSearch(a, l, h, v):
            while l <= h:
                m = ( l + h ) / 2
                if a[m] == v:
                    return m
                if v > a[m]:
                    l = m + 1
                else:
                    h = m - 1
            return l

        def insert(a, k, v):
            return a[ : k ] + [ v ] + a[ k : ]

        len1 = len(nums1)
        len2 = len(nums2)
        tlen = len1 + len2
        n = tlen / 2

        if len1 != 0 and len2 !=0:
            if len1 > len2:
                nums1, nums2 = nums2, nums1

            for v in nums2:
                k = bSearch(nums1, 0, len(nums1) - 1, v)
                nums1 = insert(nums1, k, v)
                if k >= n:
                    break
        else:
            nums1 = nums1 + nums2

        if tlen % 2:
            r = nums1[n]
        else:
            r = ( nums1[n - 1] + nums1[n] ) / 2.0

        return r

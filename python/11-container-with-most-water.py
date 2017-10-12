#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        l = 0
        h = len(height) - 1

        area = 0
        while l < h:
            area = max(area, ( h - l ) * min(height[l], height[h]))
            if height[l] < height[h]:
                lh = height[l]
                l += 1
                while height[l] < lh and l < h:
                    l += 1
            else:
                hh = height[h]
                h -= 1
                while height[h] < hh and l < h:
                    h -= 1
        return area

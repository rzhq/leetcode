#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        le = len(nums)
        n = nums
        t = target
        ll = -1
        rr = -1

        if le == 0:
            return [ll, rr]
        if le == 1:
            if n[0] == t:
                return [0, 0]
            else:
                return [ll, rr]
        if le == 2:
            if n[0] == t and n[1] != t:
                return [0, 0]
            elif n[0] != t and n[1] == t:
                return [1, 1]
            elif n[0] == t and n[1] == t:
                return [0, 1]
            else:
                return [ll, rr]

        if n[0] == t:
            ll = 0
        else:
            l = 0
            r = le - 1
            m = le / 2
            while l < r:
                if n[m-1] < t and n[m] == t:
                    ll = m
                    break
                if n[m] < t and n[m+1] == t:
                    ll = m+1
                    break

                if n[m] >= t:
                    r = m
                else:
                    l = m
                if l + 1 == r:
                    break
                m = int(( l + r ) / 2)

        if n[le-1] == t:
            rr = le - 1
        else:
            l = 0
            r = le - 1
            m = le / 2
            while l < r:
                if n[m+1] > t and n[m] == t:
                    rr = m
                    break
                if n[m] > t and n[m-1] == t:
                    rr = m-1
                    break

                if n[m] <= t:
                    l = m
                else:
                    r = m
                if l + 1 == r:
                    break
                m = int(( l + r ) / 2)
        
        return [ll, rr]

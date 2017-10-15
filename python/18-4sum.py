#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        l = len(nums)
        if l < 4: return []

        nums.sort()
        d = {}
        res = set()
        for p in range(l):
            for q in range(p+1, l):
                n = nums[p] + nums[q]
                if n in d:
                    d[n].append((p, q))
                else:
                    d[n] = [(p, q)]
        for i in range(l):
            for j in range(i+1, l):
                s = target - nums[i] - nums[j]
                if s in d:
                    for k in d[s]:
                        if j < k[0]:
                            res.add((nums[i], nums[j], nums[k[0]], nums[k[1]]))
        return [list(x) for x in res]

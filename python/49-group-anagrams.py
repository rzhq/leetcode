#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        
        d = {}
        for s in strs:
            ns = tuple(sorted(s))
            d[ns] = d.get(ns, []) + [s]
        return list(d.values())

from dotest import DoTest
DoTest(Solution().groupAnagrams).input(
    (["eat", "tea", "tan", "ate", "nat", "bat"],),
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ],
).run()

#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        
        if not words or not s: return []
        wl = len(words[0])
        for w in words[1:]:
            if wl != len(w): return []
        if len(s) < wl * len(words): return []

        d = {}
        for w in words:
            if w in d:
                d[w] += 1
            else:
                d[w] = 1

        res = []
        for i in range(len(s) - wl * len(words) + 1):
            tmp = d.copy()
            for j in range(i, len(s), wl):
                cur = s[j:j+wl]
                if cur in tmp:
                    if tmp[cur] == 1:
                        del tmp[cur]
                    else:
                        tmp[cur] -= 1
                else:
                    break
            if not tmp: res.append(i)
        return res

#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        st = []
        m = 0
        for i in range(len(s)):
            if s[i] == '(':
                st.append((i, '('))
            else:
                if len(st) and st[-1][1] == '(':
                    del st[-1]
                else:
                    st.append((i, ')'))
                    continue
                if len(st):
                    l = i - st[-1][0]
                else:
                    l = i + 1
                m = max(m, l)
                    
        return m

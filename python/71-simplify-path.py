#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def simplifyPath(self, path: 'str') -> 'str':
        stack = []
        is_word = False
        word = ''
        for i in range(len(path)):
            if path[i] != '/':
                is_word = True
                word += path[i]
            else:
                if is_word:
                    if word == '..' and stack:
                        del stack[-1]
                    if word not in ['.', '', '..']:
                        stack.append(word)
                is_word = False
                word = ''
        if word == '..' and stack:
            del stack[-1]
        elif word not in ['.', '', '..']:
            stack.append(word)
        res = ''
        for w in stack:
            res += '/' + w
        return res if res else '/'

from dotest import DoTest
DoTest(Solution().simplifyPath).input(
    ('/home/',), '/home',
    ('/../',), '/',
    ('/home//foo/',), '/home/foo',
    ('/a/./b/../../c/',), '/c',
    ('/a/../../b/../c//.//',), '/c',
    ('/a//b////c/d//././/..',), '/a/b/c',
).run()

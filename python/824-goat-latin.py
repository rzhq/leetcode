#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def toGoatLatin(self, S: 'str') -> 'str':
        vowel = [
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U',
        ]
        ans = ''
        start = True
        suf = ''
        i = 1
        S += ' '
        for l in S:
            if start:
                if l in vowel:
                    ans += l
                else:
                   suf += l
                suf += 'ma'
                start = False
            elif l == ' ':
                ans += suf + 'a' * i + ' '
                suf = ''
                i += 1
                start = True
            else:
                ans += l

        return ans[:-1]
                
from dotest import DoTest
DoTest(Solution().toGoatLatin).input(
    ('I speak Goat Latin',), 'Imaa peaksmaaa oatGmaaaa atinLmaaaaa',
    ('The quick brown fox jumped over the lazy dog',),
    'heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa',
).run()

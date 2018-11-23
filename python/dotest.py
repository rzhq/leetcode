#!/usr/bin/env python
# -*- coding: utf-8 -*-

def sort(l):
    for i in range(len(l)):
        if isinstance(l[i], list):
             l[i] = sort(l[i])
    return sorted(l)

class DoTest:

    def __init__(self, test_func):
        self.test_case = []
        self.test_func = test_func
        self.all_succ = True

    def input(self, *args):
        for k in range(len(args)):
            if k % 2 == 0:
                self.test_case.append([args[k], args[k+1]])
        return self
    
    def run(self):
        if self.test_func == None:
            print('test_func unset.')
        for k in self.test_case:
            try:
                out = self.test_func(*k[0])
                target = k[1]
                if isinstance(out, list):
                    out = sort(out)
                if isinstance(target, list):
                    target = sort(target)
                assert out == target
            except AssertionError:
                self.all_succ = False
                print('\nwrong output.')
                print('input: {}'.format(k[0]))
                print('output: {}'.format(out))
                print('expected: {}'.format(k[1]))

        if self.all_succ:
            print('\nfinished!\n')

if __name__ == '__main__':

    class TestClass:    
        def test_func(self, a, b):
            return a+b
    
    DoTest(TestClass().test_func).input(
        (1, 2), 3,
        (1, 2), 4,
    ).run()

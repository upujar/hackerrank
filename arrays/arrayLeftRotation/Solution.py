#!/bin/python3

import math
import os
import random
import re
import sys


def rotate(arr, d):
    arr2 = arr[d:]
    arr2 += arr[0:d]
    print(' '.join(str(x) for x in arr2))

if __name__ == '__main__':
    nd = input().split()

    n = int(nd[0])

    d = int(nd[1])

    a = list(map(int, input().rstrip().split()))
    rotate(a,d)


#!/bin/python3

import os
import sys

#
# Complete the miniMaxSum function below.
#
def miniMaxSum(arr):
    #
    # Write your code here.
    #
    arr.sort()
    print(sum(arr[:-1]),sum(arr[1:]))

if __name__ == '__main__':
    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)

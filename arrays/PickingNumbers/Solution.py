#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the pickingNumbers function below.
def pickingNumbers(a):
    res = 0
    print(a)
    for i in a:
        res = max(res, sum(j == i+1 for j in a)+ sum(j == i for j in a),sum(j == i-1 for j in a)+ sum(j == i for j in a))
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    a = list(map(int, input().rstrip().split()))

    result = pickingNumbers(a)

    fptr.write(str(result) + '\n')

    fptr.close()

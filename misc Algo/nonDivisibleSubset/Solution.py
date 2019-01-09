#!/bin/python3

import os
import sys
from itertools import combinations

#
# Complete the nonDivisibleSubset function below.
#
def nonDivisibleSubset(k, S):
    #
    # Write your code here.
    #
    residuals = [i %k for i in S]
    print(residuals)
    counter = [0] * k
    print(counter)
    for r in residuals:
        counter[r] += 1
    print(counter)
    # max one element with residual 0
    c = min(counter[0], 1)
    print(c)
    for i in range(1, (k//2)+1):
        print(k//2+1, i)
        if i != k-i:
            c += max(counter[i], counter[k-i])
        else:
            c += min(counter[i], 1)
    return c


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    S = list(map(int, input().rstrip().split()))

    result = nonDivisibleSubset(k, S)

    fptr.write(str(result) + '\n')

    fptr.close()

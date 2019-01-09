#!/bin/python3

import os
import sys
from fractions import gcd

#
# Complete the getTotalX function below.
#

def getTotalX(a, b):
    #
    # Write your code here.
    #
    n=a[0]
    for i in range(1, len(a)):
         n=n*a[i]/gcd(n,a[i])
    print(n)
    x=[n*i for i in range(1, min(b)+1) if n*i <= min(b) and all((n*i)%j == 0 for j in a) and all(j%(n*i) == 0 for j in b)]
    print(x)
    return len(x)

if __name__ == '__main__':
    f = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    a = list(map(int, input().rstrip().split()))

    b = list(map(int, input().rstrip().split()))

    total = getTotalX(a, b)

    f.write(str(total) + '\n')

    f.close()

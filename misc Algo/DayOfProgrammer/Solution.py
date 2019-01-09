#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the solve function below.
def solve(year):
    ar = [31,28,31,30,31,30,31,31,30,31,30,31]
    if year < 1918:
        if year%4==0:
            ar[1]=29
    elif year > 1918:
        if year%400==0 or (year%4==0 and year%100!=0):
            ar[1]=29
    else:
        ar[1]=15
    for i in range(len(ar)):
        if sum(ar[:i])>256:
            res=[]
            res.append(str(256-sum(ar[:i-1])))
            res.append('0'+str(i))
            res.append(str(year))
            return('.'.join(res))







if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    year = int(input())

    result = solve(year)

    fptr.write(result + '\n')

    fptr.close()

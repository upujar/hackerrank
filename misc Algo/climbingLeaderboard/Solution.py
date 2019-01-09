#!/bin/python3

import os
import sys


#
# Complete the climbingLeaderboard function below.
#
def climbingLeaderboard(scores, alice):
    #
    # Write your code here.
    #
    result = []
    k = sorted(set(scores), reverse = True)



    l = len(k)

    for a in alice:
        while (l > 0) and (a >= k[l-1]):
            l -= 1
        result.append( l+1)


    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()

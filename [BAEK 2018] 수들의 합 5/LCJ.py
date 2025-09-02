import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    N = int(input())
    cnt=0
    sum_val=0
    end=0

    for start in range(N):
        while sum_val < N and end < N:
            sum_val += end+1
            end += 1
        if sum_val == N:
            cnt+=1

        sum_val -= start+1
        
    output(str(cnt))

function()

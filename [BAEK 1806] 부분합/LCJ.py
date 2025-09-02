import sys
input = sys.stdin.readline
output = sys.stdout.write


def function():
    n,s = map(int, input().split())
    arr = list(map(int, input().split()))
    sum_val=0
    end=0
    min_len = float('inf')
    for start in range(n):
        while sum_val < s and end < n:
            sum_val += arr[end]
            end += 1
        if sum_val >= s:
            min_len = min(min_len, end-start)
        sum_val -= arr[start]
        
    if min_len == float('inf'):
        min_len = 0
    output(str(min_len))


function()

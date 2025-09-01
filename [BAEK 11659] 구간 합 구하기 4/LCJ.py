import sys
input = sys.stdin.readline
output = sys.stdout.write


def function():
    n,m = map(int, input().split())
    nums = list(map(int, input().split()))
    pre = [0]
    sum = 0

    for i in range(n):
        sum += nums[i]
        pre.append(sum)

    for _ in range(m):
        a,b = map(int, input().split())
        output(str(pre[b]-pre[a-1]) + '\n')


function()

import sys
input = sys.stdin.readline
output = sys.stdout.write


def function():
    n,m = map(int, input().split())
    nums = [[] for _ in range(n)]
    dp = [[0]*(n+1) for _ in range(n+1)]

    for i in range(n):
        nums[i] = list(map(int,input().split()))

    for i in range(1,n+1):
        for j in range(1,n+1):
            dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + nums[i-1][j-1]

    for _ in range(m):
        x1,y1,x2,y2 = map(int, input().split())
        sum = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]
        output(str(sum) + '\n')


function()

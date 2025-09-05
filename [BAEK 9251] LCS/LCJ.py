import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    text1 = input().strip()
    text2 = input().strip()

    dp = [0] * len(text1)
    longest = 0

    for c in text2:
        cur = 0
        for i, val in enumerate(dp):
            if cur < val:
                cur = val
            elif c == text1[i]:
                dp[i] = cur + 1
                longest = max(longest, cur+1)
    output(str(longest))

function()

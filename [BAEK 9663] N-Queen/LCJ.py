import sys
input = sys.stdin.readline
output = sys.stdout.write

n = int(input())

col = [False]*n
d1 = [False]*(2*n-1)
d2 = [False]*(2*n-1)
ans = 0

def dfs(r):
    global ans
    if r == n:
        ans += 1
        return
    for c in range(n):
        i = r+c
        j = r-c+n-1
        if not col[c] and not d1[i] and not d2[j]:
            col[c] = d1[i] = d2[j] = True
            dfs(r+1)
            col[c] = d1[i] = d2[j] = False

dfs(0)
output(str(ans))

import sys

input = sys.stdin.readline

def dyp(n, cnt):
    for i in range(2,n+1):
        cnt[i] = cnt[i-1] + 1

        if i % 2 == 0:
            cnt[i] = min(cnt[i], cnt[i//2] + 1)

        if i% 3 == 0:
            cnt[i] = min(cnt[i], cnt[i//3]+1)
    print(cnt[n])

if __name__ == "__main__":
    N = int(input())
    dp = [0] * 10000001
    dyp(N,dp)
    

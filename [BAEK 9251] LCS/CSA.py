# 다이나믹프로그래밍

# 입력
s1=list(input())
s2=list(input())

# 알고리즘
# 테이블 초기화
dp = [[0] * (len(s2) + 1) for _ in range(len(s1) + 1)]

for i in range(1,len(s1)+1):
    for j in range(1,len(s2)+1):
        # 두 문자가 같으면 +1, 다르면 이전 값 중 최댓값
        if s1[i-1]==s2[j-1]:
            dp[i][j]=dp[i-1][j-1]+1
        else:
            dp[i][j]=max(dp[i-1][j],dp[i][j-1])

# 출력
print(max(map(max,dp)))
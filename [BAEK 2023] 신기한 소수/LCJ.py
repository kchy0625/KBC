import sys

input = sys.stdin.readline

def isPrime(n):
    if (n<2):
        return False
    for i in range(2,int(n**0.5)+1):
        if n%i == 0:
            return False
    return True


def dfs(n):
    if (len(str(n))) == N:
        print(n)
    else:
        for i in range(10):
            tmp = n*10 + i
            if isPrime(tmp):
                dfs(tmp)

if __name__ == "__main__":
    N = int(input())
    nums = [2,3,5,7,9]
    for num in nums:
        if isPrime(num):
            dfs(num)

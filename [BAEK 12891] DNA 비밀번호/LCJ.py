import sys
input = sys.stdin.readline
output = sys.stdout.write


def function():
    n,s = map(int, input().split())
    password = input().strip()
    a,c,g,t = map(int, input().split())
    answer = 0
    start=0
    end = s -1
    target = password[start:end]
    dict = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
    for i in target:
        dict[i] += 1

    while end < n:
        dict[password[end]] += 1

        if dict['A']>= a and dict['C'] >= c and dict['G'] >= g and dict['T'] >= t:
            answer += 1

        dict[password[start]] -= 1
        start +=1
        end += 1
    
        
    output(str(answer))
function()

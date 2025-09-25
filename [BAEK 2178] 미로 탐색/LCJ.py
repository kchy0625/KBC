from collections import deque

import sys
input = sys.stdin.readline
output = sys.stdout.write

def function():
    row , col = map(int,input().split())
    maps = []
    for _ in range(row):
        maps.append(list(map(int,input().strip())))

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    queue = deque()
    queue.append((0,0))

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<row and 0<=ny<col and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx,ny))

    return output(str(maps[row-1][col-1]))

function()

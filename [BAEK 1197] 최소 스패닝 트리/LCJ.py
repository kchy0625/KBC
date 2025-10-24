import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def find_pr(parent,x):
    if parent[x] != x:
        parent[x] = find_pr(parent, parent[x])
    return parent[x]

def union_pr(parent, a, b):
    a = find_pr(parent, a)
    b = find_pr(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


if __name__ == "__main__":
    V,E = map(int, input().split())
    parent = [i for i in range(V+1)]
    graph = []
    costs = 0
    for _ in range(E):
        a, b, cost = map(int, input().split())
        graph.append([a,b,cost])
    graph.sort(key=lambda x:x[2])

    for i in graph:
        a,b,cost = i 
        if find_pr(parent,a) != find_pr(parent, b):
            union_pr(parent, a, b)
            costs += cost

    print(costs)

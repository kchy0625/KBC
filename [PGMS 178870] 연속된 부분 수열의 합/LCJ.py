def solution(sequence, k):
    n = len(sequence)
    start, end, total = 0,0, sequence[0]
    sequence += [0]
    s_idx, e_idx = 1000000, 2000000
    
    while end <= n - 1:
        if total<=k:
            if total == k and end - start < e_idx-s_idx:
                s_idx, e_idx = start, end
            end += 1
            total += sequence[end]
        else:
            start += 1
            total -= sequence[start-1]
            
    return [s_idx, e_idx]

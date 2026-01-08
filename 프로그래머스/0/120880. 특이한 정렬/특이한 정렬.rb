def solution(numlist, n)
    answer = numlist.sort_by{ |i| [[n-i, i-n].max, -i] }
    return answer
end
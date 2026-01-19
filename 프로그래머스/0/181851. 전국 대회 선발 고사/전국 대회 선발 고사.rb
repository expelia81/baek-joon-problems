def solution(rank, attendance)
    answer = 0
    value = []
    hash = {}
    
    (0..rank.size-1).each do |i|
        hash[rank[i]]=i if attendance[i] 
    end
    (1..rank.size).each do |i|
        value << (hash[i]) if hash[i]
        break if value.size==3
    end
    answer+=value[0]*10000
    answer+=value[1]*100
    answer+=value[2]
    return answer
end
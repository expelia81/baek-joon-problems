def solution(array)
    answer = 0
    hash = {}
    
    max = 0
    array.each do |i|
        hash[i] = (hash[i] || 0) +1 
        max = [max,hash[i]].max
    end
    count = 0
    index = -1
    hash.each do |k,v|
        if(v==max)
            index = k
            count+=1
        end
    end
    return index if count==1
    return -1
end
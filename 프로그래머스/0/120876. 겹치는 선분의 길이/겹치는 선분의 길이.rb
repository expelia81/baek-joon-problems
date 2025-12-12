def solution(lines)
    answer = 0
    array = Array.new(201, 0)
    lines.each do |arr|
        find(array,arr[0],arr[1]-1)
    end
    array.each { |i| 
        answer = answer+1 unless i<2
    }
    return answer
end

def find(array,a,b)
    a=a+100
    b=b+100
    (a..b).each do |i|
        array[i]+=1 
    end
end
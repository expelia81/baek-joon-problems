def solution(array, commands)
    answer = []
    commands.each { |i| 
        answer << fun(array,i[0]-1, i[1]-1, i[2]-1)
    }
    return answer
end

def fun(array,i,j,k) 
    arr =  array[i..j].sort
    arr[k]
end
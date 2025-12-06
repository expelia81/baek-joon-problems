def solution(n)
    answer = 0
    array = Array.new(n+1,0)
    array[0]=1
    array[1]=1
    
    (2..n).each do |i|
        number = i+i
        while(number<=n) do
            array[number]=1
            number+=i
        end
    end
        
    array.each_with_index do |n,i| 
        if(n==0)
            answer+=1
        end
    end
    
    return answer
end
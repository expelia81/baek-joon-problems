def solution(my_string, queries)
    answer = ''
    chars = my_string.chars
    queries.each do |i|
        left = i[0]
        right = i[1]
        while(left<=right)
            temp = chars[left]
            chars[left]=chars[right]
            chars[right]=temp
            left+=1
            right-=1
        end
    end
    return chars.join
end
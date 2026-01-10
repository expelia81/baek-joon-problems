def solution(code)
    answer = []
    mode = true
    
    (0..code.length-1).each do |i|
        if(code[i]=='1') 
            mode = !mode
        else
            add(answer, mode, i, code[i])
        end
        
    end
    return "EMPTY" if answer.empty?
    return answer.join
end

def add(answer, mode, index, value)
     if mode
         answer << value if index%2==0
     else
         answer << value if index%2==1
     end
 end

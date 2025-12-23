def solution(park, routes)
    answer=''
    park.each_with_index do |y,ydex|
        y.each_char.with_index do |x, xdex|
            if(x=="S")
                answer=[ydex,xdex]
            end
        end
    end
    ymax = park.length
    xmax = park[0].length
    routes.each do |order|
        direction = order[0]
        size = order[2].to_i
        temp = answer.clone
        bool=true
        size.times do 
            temp = move(temp,direction)
            bool=false unless valid(temp,ymax,xmax)
            break unless valid(temp,ymax,xmax)
        end
        temp = answer.clone
        next unless bool
        size.times do 
            temp = move(temp,direction)
            bool=false if park[temp[0]][temp[1]]=="X"
            break if park[temp[0]][temp[1]]=="X"
        end
        answer = temp if bool
    end
    return answer
end

def valid(arr,maxy,maxx)
    boolean = true
    return false if(arr[0]==-1)
    return false if(arr[0]==maxy)
    return false if(arr[1]==maxx)
    return false if(arr[1]==-1)
    true
end

# E => X축 +1
# W => X축 -1
# S => Y축 +1
# N => Y축 -1
def move(temp,op)
    arr=temp.clone
    case op
        when "E" then arr[1]+=1
        when "W" then arr[1]-=1
        when "S" then arr[0]+=1
        when "N" then arr[0]-=1
    end
    arr
end
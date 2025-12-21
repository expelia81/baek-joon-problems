def solution(m, n, startX, startY, balls)
    answer = []
    balls.each do |ball|
        answer << find_min_length(startX,startY,m,n,ball) 
    end
    return answer
end


# 4개의 면 중 반전시켰을 때, 가장 가까운 것을 찾는 함수.
# 면을 기준으로 
def find_min_length(bx, by, m, n, ball)
    arrx = [bx,-bx,bx,2*m-bx]
    arry = [-by,by,2*n-by,by]
    x = ball[0]
    y = ball[1]
    max = 2000000000
    if(bx==x)
        if(y<by)
            d = (n-y) + (n-by)
        else
            d = y+by            
        end
        max = d*d
    elsif(by==y)
        if(x<bx)
            d = (m-x) + (m-bx)
        else
            d = x+bx            
        end
        max = d*d
    end
    # puts "ball : x #{x} m #{m} / y #{y} n #{n}"
    # 특정 상황에 공이 겹치는 경로가 된다. 공이 겹치는 경로에 대해서는 수행하면 안됨.
    (0..3).each do |i|
        sx = arrx[i]-x
        sy = arry[i]-y
      #   next if bx == x && (i == 0 && y < by || i == 2 && y > by)
      # next if by == y && (i == 1 && x < bx || i == 3 && x > bx)
        if(sx==0 || sy==0)
            # 이 부분이 오류다.
            # 예를 들어, 가로가 극단적으로 긴 당구장에서는 세로로 벽으로 꺾어야 최소거리가 된다.
            next
        else
            
        end
        length = sx*sx + sy*sy
        max = length if length<max
        
        # puts "x=#{arrx[i]} : y=#{arry[i]} = length ->  #{length}" 
    end
    
    max
end
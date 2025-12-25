def solution(n)
    @arr = Array.new(n) {Array.new(n){0}}
    @direction = :right
    @x = 0
    @y = 0
    @length = n
    @hash = {
        :right => {:x => 1, :y => 0, :d => :down},
        :down => {:x => 0, :y => 1, :d => :left},
        :left => {:x => -1, :y => 0, :d => :up},
        :up => {:x => 0, :y => -1, :d => :right}
    }
    @count=1;
    @arr[0][0]=1
    while(@count<n*n)
        move 
        # log
    end
    return @arr
end

def log
    @arr.each do |arr| 
        puts arr.join(' ') 
    end
end

def move
    x=@x+@hash[@direction][:x]
    y=@y+@hash[@direction][:y]
    if(valid?(x,y))
        @count+=1
        @x=x
        @y=y
        @arr[@y][@x]=@count
        # puts "[going] :#{@direction} | Pos: (#{@x}, #{@y})"
    else
        @direction = @hash[@direction][:d]
        # puts "[change] :#{@direction} | Pos: (#{@x}, #{@y}) next? #{x}, #{y}"
    end
end
def valid?(x,y)
    return false if(x<0 || y<0 || x==@length || y==@length)
    if(@arr[y][x]!=0)
        return false 
    end
    true
end
s1 = gets.chomp
s2 = ''
s1.each_char do |c|
    if c.match?(/[A-Z]/)
        s2 += c.downcase
    else
        s2 += c.upcase
    end
end
puts s2
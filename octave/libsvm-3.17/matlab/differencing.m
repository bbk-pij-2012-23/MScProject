function [d, trend] = differencing(data, sscColumn)

x = data(:,sscColumn);


plot(x);

trend = mean(x);
hold on


d = zeros(length(x),1);
for i = 2:length(x)
    d(i,1) = (x(i,1)-x(i-1,1));
end

trend = [trend; mean(d)];

plot(d, '-r');


end 
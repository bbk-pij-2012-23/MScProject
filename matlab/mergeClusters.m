function newData = mergeClusters(data, int1, int2)

newData = zeros(length(data), 3);
for i = 1:length(data);
    newData(i,:) = data(i,:);
    if data(i,3)==int1
        newData(i,3)= int2;
    end    
end;

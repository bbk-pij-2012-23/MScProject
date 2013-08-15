function plotVectors(data, segments, sscCol)

for row = 1:length(segments)
    vector = createEventVectors(data, segments,row,sscCol);
    plot(vector);
    pause;
end    

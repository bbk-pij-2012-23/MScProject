
%create a matrix of subsequences of hot flush and non-hot flush events

function[y, segmentPoints] = findSubsequences(data, labelColumn)

%select segments of data by locating the datapoint where a subsequence of 
%target cluster starts and the point where it ends, create a vector (segmentPoints) to hold
%these start and end points 

segmentPoints = [];

label = 0;
y = 0;

for row = 1:length(data)
    if label ~= data(row, labelColumn)
        y=[y; data(row,labelColumn)];
        segmentPoints = [segmentPoints; row];
        label=data(row,labelColumn);
    end
    
end

segmentPoints = [segmentPoints; length(data)];

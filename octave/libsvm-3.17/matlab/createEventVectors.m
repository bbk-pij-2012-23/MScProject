%theres some problems with this
function  vector = createEventVectors (data, segments, rowNum, sscColumn)

%create a vector of subsequence size
%first entry in segmentSize starts at segments(1,1) and ends at
%segment(2,1)-1
    if rowNum+1>length(segments)
       segmentSize = length(data)-segments(rowNum,1);
    else    
        segmentSize = segments(rowNum+1,1)-segments(rowNum,1);
    end
    vector = zeros(1, segmentSize);
    for index = 1:length(vector)
        vector(1,index) = data(segments(rowNum,1)+index,sscColumn);
    end
    

end


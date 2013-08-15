function [smoothedData] = smoothingSpline(data, sscColumn, toleranceValues)

index = 1:1:length(data);


smoothedData = [];


for i = 1:length(toleranceValues)
    [splineStatistics splineValues] = spaps(index,data(:,sscColumn),toleranceValues(1,i));
    smoothedData = [smoothedData; splineValues];
       
end
  

end
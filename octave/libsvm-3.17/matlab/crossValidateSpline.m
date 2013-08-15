%cross validation of smoothing spline takes a vector of tolerance values to create smoothed data
% to train data on. The values were chosen to range from very little
% smoothing (0.001) to clear over-smoothing (3). 

%as smoothed data is formated as row vectors rather than columns, the
%transpose is used

%settings were crossvalidated before to c = 32, g = 1

function [outcomes] = crossValidateSpline(data, tolerances)

    smoothedData = smoothingSpline(data, 2, tolerances);
    
    outcomes = [];
    for row = 1: length(smoothedData(:,1))
       tempData = [data(:,1) smoothedData(row, :)'];
       [labels, features, testLabels, testFeatures] = getSVMVariables(tempData);
       model = svmtrain(labels, features, '-q -c 32 -g 1'); 
       [~, accuracy, ~]= svmpredict(testLabels, testFeatures, model);
       outcomes = [outcomes; accuracy];
    end
     
end


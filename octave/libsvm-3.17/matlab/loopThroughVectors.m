function getFeature = loopThroughVectors(data, segments)

getFeature = [];

featureType = input('Select the feature you would like to create by typing the word as indicated: \n mean skin conductance level: mean \n standard deviation of mean skin condcuatance level: std \ncalculate skewness: skew \nCalculate kurtosis: kurtosis \nor type cancel to exit\n >> ', 's');

for row = 1:length(segments)
    vector = createEventVectors(data, segments,row,2);
    feature = featureSelect(vector, featureType);
    getFeature = [getFeature; feature];
end    



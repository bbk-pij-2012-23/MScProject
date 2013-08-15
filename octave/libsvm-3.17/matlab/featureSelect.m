function feature = featureSelect(vector, featureType)


    
switch featureType
    case 'mean'
        feature = mean(vector);
    case 'std'
        feature = std(vector);
    case 'gaussian'    
        feature = 'coming soon';
    case 'skew'
        feature = skewness(vector);
    case 'kurtosis'
        feature = kurtosis(vector);
    case 'cancel'
        feature = 'canceled';
    otherwise
        feature = 'canceled';
end

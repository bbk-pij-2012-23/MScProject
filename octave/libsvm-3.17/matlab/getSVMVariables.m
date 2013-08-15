function [trainlabels, trainfeatures, testlabels, testfeatures] = getSVMVariables(data)


train = data(1:round(length(data)*0.8),:);
test = data(round(length(data)*0.8)+1:end,:);

[trainlabels, trainfeatures] = formatLibsvm(train, []);
[testlabels, testfeatures] = formatLibsvm(test, []);

end
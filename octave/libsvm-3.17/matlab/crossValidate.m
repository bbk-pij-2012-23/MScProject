%cross validation takes a vector of values to train data on. The values
%were suggested by Hsu, Chang, & Lin (2011) in their guide to SVM.

%C is the parameter for the cost function and sigma is the parameter for
%the gaussian kernel

%the code below draws heavily on example code from H, C & L

function [outcomes] = crossValidate(data, c, gamma)

    [labels, features, testLabels, testFeatures] = getSVMVariables(data);
   
    outcomes = [];
    for i = 1:length(c);
      for j = 1:length(gamma);
        settings = ['-q -c ', num2str(c(i)), ' -g ', num2str(gamma(j))];
        model = svmtrain(labels, features, settings); 
        [~, accuracy, ~]= svmpredict(testLabels, testFeatures, model);
        outcomes = [outcomes; accuracy];
      end
    end      
 
end


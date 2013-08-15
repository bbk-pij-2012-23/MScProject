function resultsData = createPredictedHFs(testedData, label)

hf = zeros(length(testedData), 1);
for i = 1: length(hf)
    if testedData(i,label)==1
        hf(i,1) = testedData(i,3);
    end 
end    
resultsData = [testedData hf];

function allNormed = addToAll(allSamples, newSample)

if max(newSample(:,2))>1
    newSample = [newSample(:,1) normc(newSample(:,2))];
end
 
        
allNormed = [allSamples; zeros(30,2); newSample];
dlmwrite('allNormed.txt', allNormed);

end
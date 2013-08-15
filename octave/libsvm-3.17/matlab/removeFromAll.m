function allData = removeFromAll(allSamples, sampleToRemove)

allData = allSamples(1:end-(length(sampleToRemove)+30),:);
%check the correct data haas been removed
subplot(2,1,1)
plot(allData(end-length(sampleToRemove):end,2));

subplot(2,1,2)
plot(sampleToRemove(:,2))
clf
end 

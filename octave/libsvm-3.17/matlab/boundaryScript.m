% test-retest reliability
% the data was split into 80% training then 20% testing samples at three
% different cutpoints: 0, 10%, 20%

% 0

boundary0 = round(length(data)*0.8);

trainFirst = data(1:boundary0,:);
testSecond = data(boundary0+1:end,:);


boundary20 = round(length(data)*0.2);

testFirst = data(1:boundary20, :);
trainSecond = data(boundary20+1:end,:);



function data = addID(data, id)

data = [data(:,1:2) normc(ones(length(data), 1).*id)];

end
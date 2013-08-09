function f_data = parse(data)

n_data = normc(data(:,2));
c_data = kmeans(n_data, 3);

p_data = [n_data normc(c_data)];

plot(p_data);
f_data = [n_data c_data];

end
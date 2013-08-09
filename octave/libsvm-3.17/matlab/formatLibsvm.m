function [labels, features_sparse] = formatLibsvm(data, destfile)

labels = data(:, 1); % labels from the 1st column
features = data(:, 2:end); 
features_sparse = sparse(features); % features must be in a sparse matrix
libsvmwrite(destfile, labels, features_sparse);

end

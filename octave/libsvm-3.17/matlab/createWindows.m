function movingWindow = createWindows(data, dimensions, window)
		
movingWindow = zeros(dimensions(1,1), window);

for rows = 1:dimensions(1,1)
    for cols = 1:window
		if rows+cols<dimensions(1,1)
            movingWindow(rows,cols) = data(rows+cols,2);
        else
			continue;
        end
    end
end

%add the outcome column at the front, also the participant id for person
%level variation - test whether the prediction is better or worse with this

extras = [data(:,1) data(:,3)];
movingWindow = [data(:,1) movingWindow];
	
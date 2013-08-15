function pd1 = createFit(arg_1,arg_2)
%CREATEFIT    Create plot of datasets and fits
%   PD1 = CREATEFIT(ARG_1,ARG_2)
%   Creates a plot, similar to the plot in the main distribution fitting
%   window, using the data that you provide as input.  You can
%   apply this function to the same data you used with dfittool
%   or with different data.  You may want to edit the function to
%   customize the code and this help message.
%
%   Number of datasets:  1
%   Number of fits:  1
%
%   See also FITDIST.

% This function was automatically generated on 10-Aug-2013 17:40:54

% Output fitted probablility distribution: PD1

% Data from dataset "v22(1, 200:500) data":
%    Y = arg_1 (originally v22(1, 200:500))
%    Frequency = arg_2 (originally v22(1, 200:500) data frequency)

% Force all inputs to be column vectors
arg_1 = arg_1(:);
arg_2 = arg_2(:);

% Prepare figure
clf;
hold on;
LegHandles = []; LegText = {};


% --- Plot data originally in dataset "v22(1, 200:500) data"
[CdfF,CdfX] = ecdf(arg_1,'Function','cdf','freq',arg_2);  % compute empirical cdf
BinInfo.rule = 1;
[~,BinEdge] = internal.stats.histbins(arg_1,[],arg_2,BinInfo,CdfF,CdfX);
[BinHeight,BinCenter] = ecdfhist(CdfF,CdfX,'edges',BinEdge);
hLine = bar(BinCenter,BinHeight,'hist');
set(hLine,'FaceColor','none','EdgeColor',[0.333333 0 0.666667],...
    'LineStyle','-', 'LineWidth',1);
xlabel('Data');
ylabel('Density')
LegHandles(end+1) = hLine;
LegText{end+1} = 'v22(1, 200:500) data';

% Create grid where function will be computed
XLim = get(gca,'XLim');
XLim = XLim + [-1 1] * 0.01 * diff(XLim);
XGrid = linspace(XLim(1),XLim(2),100);


% --- Create fit "fit 5"

% Fit this distribution to get parameter values
% To use parameter estimates from the original fit:
%     pd1 = ProbDistUnivParam('generalized extreme value',[ 1.070900707565, 0.001246574032031, 0.00591432552382])
pd1 = fitdist(arg_1, 'generalized extreme value','freq',arg_2);
YPlot = pdf(pd1,XGrid);
hLine = plot(XGrid,YPlot,'Color',[1 0 0],...
    'LineStyle','-', 'LineWidth',2,...
    'Marker','none', 'MarkerSize',6);
LegHandles(end+1) = hLine;
LegText{end+1} = 'fit 5';

% Adjust figure
box on;
hold off;

% Create legend from accumulated handles and labels
hLegend = legend(LegHandles,LegText,'Orientation', 'vertical', 'Location', 'NorthEast');
set(hLegend,'Interpreter','none');

function allSamples = createAllSamples()

id012 = load('id012.txt');
id014 = load('id014.txt');
id018 = load('id018.txt');
id022 = load('id022.txt');
id023 = load('id023.txt');
id025 = load('id025.txt');
id034 = load('id034.txt');

hedge = zeros(30,2);

allSamples = [id012; hedge; id014; hedge; id018; hedge; id022; hedge; id023; hedge; id034];

if max(allSamples(:,2))>1
    printf('something not normalised')
end
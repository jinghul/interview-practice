class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] results = new double[queries.size()];
        if (queries.size() == 0) return results;
        
        HashMap<String, HashMap<String, Double>> calcMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String numerator = eq.get(0);
            String denominator = eq.get(1);
            HashMap<String, Double> numCalc = calcMap.getOrDefault(numerator, new HashMap<String, Double>());
            HashMap<String, Double> denomCalc = calcMap.getOrDefault(denominator, new HashMap<String, Double>());
            numCalc.put(denominator, values[i]);
            denomCalc.put(numerator, 1 / values[i]);
            calcMap.put(numerator, numCalc);
            calcMap.put(denominator, denomCalc);
        }
        
        // System.out.println(calcMap.toString());
        
        for (int i = 0; i < queries.size(); i++)
        {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String denominator = query.get(1);
            // System.out.println(query);
            if (!calcMap.containsKey(numerator) || !calcMap.containsKey(denominator)) results[i] = -1;
            else if (numerator.equals(denominator)) results[i] = 1;
            else if (calcMap.get(numerator).containsKey(denominator)) results[i] = calcMap.get(numerator).get(denominator);
            else {
                HashSet<String> visited = new HashSet<>();
                results[i] = calculate(calcMap, visited, query.get(0), query.get(1)); 
            }
        }
        
        return results;
    }
    
    public double calculate(HashMap<String, HashMap<String, Double>> calcMap, HashSet<String> visited, String curr, String end)
    {
        visited.add(curr);
        HashMap<String, Double> submap = calcMap.get(curr);
        if (submap.containsKey(end)) return submap.get(end);
        else {
            for (String key : submap.keySet())
            {
                if (!visited.contains(key))
                {
                    double result = calculate(calcMap, visited, key, end);
                    if (result != -1)
                    {
                        return submap.get(key) * result;
                    }
                }
            }
        }
        
        return -1;
    }
}
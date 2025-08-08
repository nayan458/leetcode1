class Solution {
    private Map<String, String> parent = new HashMap<>();
    private Set<String> visited;
    private Map<String,List<edge>> adjList;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];

        adjList = createGraph(equations, values);
        
        int i = 0;
        for(List<String> querie: queries){
            String u = querie.get(0);
            String v = querie.get(1);

            if(!adjList.containsKey(u) || !adjList.containsKey(v) || !find(u).equals(find(v))){
                ans[i++] = -1.00000;
                continue;
            }

            visited = new HashSet<>();
            ans[i++] = dfs(u,v,adjList,1);
        }

        return ans;
    }

    private double dfs(String u, String v, Map<String,List<edge>> adjList, double weight){
        visited.add(u);
        for(edge neighbour: adjList.get(u)){
            if(neighbour.vertex.equals(v))
                return weight* neighbour.weight;
            if(!visited.contains(neighbour.vertex)){
                double result = dfs(neighbour.vertex, v, adjList, weight * neighbour.weight);
                if(result != -1.0)
                    return result;
            }
        }

        return -1.0;
    }

    private String find(String x){
        if(parent.get(x).equals(x))
            return x;
        String root = find(parent.get(x));
        parent.put(x, root);
        return root;
        // return parent.put(x, find(parent.get(x)));
    }

    private Map<String,List<edge>> createGraph(List<List<String>> equations, double[] values){
        Map<String, List<edge>> adjList = new HashMap<>();
        
        int i = 0;      // for values
        for(List<String> edg: equations){
            String u = edg.get(0);
            String v = edg.get(1);

            parent.putIfAbsent(u,u);
            parent.putIfAbsent(v,v);

            String p_u = find(u);
            String p_v = find(v);
            if(!p_u.equals(p_v))
                parent.put(p_u, p_v);
            double weight = values[i++];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            adjList.get(u).add(new edge(v, weight));
            adjList.get(v).add(new edge(u, 1/weight));
        }
        return adjList;
    }

    class edge{
        String vertex;
        double weight;

        public edge(String vertex, double weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
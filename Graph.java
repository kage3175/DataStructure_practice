public class Graph{
    private int numVertex = 0;
    private int numEdge = 0;

    public class Vertex{
        int key;
        boolean connected;

        public Vertex(int key_){
            key = key_;
            connected = false;
        }
    }

    public class Edge{
        boolean directed;
        Vertex v1;
        Vertex v2;
        int weight = 0;

        public Edge(int v1_, int v2_, int weight_){
            v1 = v1_;
            v2 = v2_;
            weight = weight_;
        }
    }

}
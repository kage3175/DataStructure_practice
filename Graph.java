public class Graph{
    private int numVertex = 0;
    private int numEdge = 0;
    private Vertex[] listVertex;
    private Edge[] listEdge;
    private int[][] adjacentMatrix;
    
    public class LinkedList{
        int key = 0;
        
    }

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

        public Edge(Vertex v1_, Vertex v2_, int weight_){
            v1 = v1_;
            v2 = v2_;
            weight = weight_;
        }
    }

    public Graph(){

    }

}
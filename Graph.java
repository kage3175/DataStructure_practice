public class Graph{
    private int numVertex = 0;
    private int numEdge = 0;
    private Vertex[] listVertex = new Vertex[1000];
    private Edge[] listEdge = new Edge[1000000];
    private int[][] adjacentMatrix = new int[1000][1000];
    private LinkedList[] adjacentList = new LinkedList[1000];
    
    public class LinkedList{
        Vertex key;
        LinkedList next;
        
        public LinkedList(Vertex key_){
            key = key_;
            next = null;
        }
    }

    public class Vertex{
        int key;
        String name;
        boolean connected;

        public Vertex(int key_, String name_){
            name = name_;
            key = key_;
            connected = false;
        }
        public String getName(){
            return name;
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

    public boolean isValid(String name){
        for(int i = 0; i < numVertex; i++){
            if(name.equals(listVertex[i].getName())) return false;
        }
        return true;
    }

    public void newVertex(String name){
        if(numVertex > 999){
            System.out.println("Too much vertices.");
            return;
        }
        if(!isValid(name)){
            System.out.println("There already exists a vertex with same name.");
        }
        Vertex v = new Vertex(numVertex, name);

    }

}
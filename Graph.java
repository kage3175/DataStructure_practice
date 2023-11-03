public class Graph{
    private int numVertex = 0;
    private int numEdge = 0;
    private Vertex[] listVertex = new Vertex[1000];
    private Edge[] listEdge = new Edge[1000000];
    private int[][] adjacentMatrix = new int[1000][1000];
    private LinkedList[] adjacentList = new LinkedList[1000];
    
    public class LinkedList{
        Vertex key;
        int weight;
        LinkedList next;
        
        public LinkedList(Vertex key_, int weight_){
            key = key_;
            weight = weight_;
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

        public Edge(Vertex v1_, Vertex v2_, int weight_, boolean directed_){
            v1 = v1_;
            v2 = v2_;
            weight = weight_;
            directed= directed_;
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
        listVertex[numVertex] = v;
        numVertex++;
    }

    public void newEdge(String v1_, String v2_, int weight, boolean directed){
        if(v1_.equals(v2_)) System.out.println("You can't add an edge on two same vertices");
        if(isValid(v1_) || isValid(v2_)){ //v1 v2중 하나라도 존재하지 않으면
            System.out.println("No such pair of vertices exists");
        }
        Vertex v1 = null;Vertex v2 = null;
        int locv1 = 0;int locv2 = 0;
        for(int i=0; i< numVertex;i++){
            if(v1_.equals(listVertex[i].getName())){v1 = listVertex[i]; locv1 = i;} 
            else if(v2_.equals(listVertex[i].getName())) {v2 = listVertex[i]; locv2 = i;}
        }
        Edge e = new Edge(v1,v2, weight, directed);
        listEdge[numEdge] = e;
        numEdge++;
        updateAdList(locv1, locv2, directed, weight);
        updateAdMatrix(locv1, locv2, directed, weight);
    }

    public void updateAdMatrix(int locv1, int locv2, boolean directed,int weight){
        if(directed){
            adjacentMatrix[locv1][locv2] = weight;
        }
        else{
            adjacentMatrix[locv1][locv2] = weight;
            adjacentMatrix[locv2][locv1] = weight;
        }
    }

    public void updateAdList(int locv1, int locv2, boolean directed, int weight){
        Vertex v1 = listVertex[locv1]; Vertex v2 = listVertex[locv2];
        if(directed){
            if(adjacentList[locv1] == null) {
                adjacentList[locv1] = new LinkedList(v1, 0);
                adjacentList[locv1].next = new LinkedList(v2, weight);
            }
            else{
                LinkedList tmp = adjacentList[locv1];
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                tmp.next = new LinkedList(v2, weight);
            }
        }
        else{
            if(adjacentList[locv1] == null) {
                adjacentList[locv1] = new LinkedList(v1, 0);
                adjacentList[locv1].next = new LinkedList(v2, weight);
            }
            else{
                LinkedList tmp = adjacentList[locv1];
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                tmp.next = new LinkedList(v2, weight);
            }
            if(adjacentList[locv2] == null) {
                adjacentList[locv2] = new LinkedList(v2, 0);
                adjacentList[locv2].next = new LinkedList(v1, weight);
            }
            else{
                LinkedList tmp = adjacentList[locv2];
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                tmp.next = new LinkedList(v1, weight);
            }
        }
    }

    public void printAdList(){
        for(int i = 0;i < numVertex;i++){
            System.out.print(i + "\t");
            LinkedList tmp = adjacentList[i];
            while(tmp != null){
                System.out.print(tmp.key.name + "("+tmp.weight+")" + " -> ");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
    
    public void printAdMatrix(){
        for(int i = 0; i < numVertex;i++){
            for(int j = 0;j < numVertex;j++){
                System.out.print(adjacentMatrix[i][j] + " ");

            }
            System.out.println("");
        }
    }

}
/*
*noder med tallet og nr i rekka.
*lage noder med tallrekker, hvis en node er mindre en forrige, legg den til nærmeste node.
*legger aldri til i feil rekefølge fordi
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FileNotFoundException;

public class Luke7{
    static int count = 0;
    //Node root = new Node(-1,count);
    //Node forrige = root;

    public static void main(String[] args) {
        Graph g = new Graph();
        try{
            //URL url = new URL("http://www.puzzlers.org/pub/wordlists/pocket.txt");
            File file = new File("input/luke7.txt");
            Scanner inn = new Scanner(file);
            while(inn.hasNextLine()){ // && count < 166){
                int tall = Integer.parseInt(inn.nextLine());
                if(count%20000 == 0){
                    System.out.println("reading\t" + (count+1) + "\t" +tall);
                }
                Node ny = new Node(tall,++count);
                g.leggTilNode(ny);
            }
        /*} catch(MalformedURLException mue){
            System.out.println("wrong url");*/
        } catch (FileNotFoundException fnf) {
            System.out.println("no file");
        }
        //System.out.println(g.findLongestWay());//SO WRONG
    }
}

class Node{
    int data;
    int nr;
    ArrayList<Node> barn;
    boolean visited;

    Node(int data,int nr){
        this.data = data;
        this.nr = nr;
        barn = new ArrayList<Node>();
        visited = false;
    }
    void leggTilBarn(Node n){
        barn.add(n);
    }
    boolean ingenBarnUnder(int grense){
        for(Node b : barn){
            if(b.data < grense){
                return false;
            }
        }
        return true;
    }
}

class Graph{
    Node root;
    ArrayList<Node> nodene;

    Graph(){
        root = new Node(-1,0);
        nodene = new ArrayList<Node>();
        nodene.add(root);
    }
    void leggTilNode(Node n){ //legger til noden alle steder den er neste i rekken.
        //String tillegg = "legger til " + n.data + " hos ";
        for(Node gn : nodene){
            if(gn.data <= n.data && gn.ingenBarnUnder(n.data)){
                gn.leggTilBarn(n);
                //tillegg += ", " + bl.data;
            }
        }
        nodene.add(n);
        //System.out.println(tillegg);
    }

    ArrayList<Node> finnLavere(int grense, Node n){
        //System.out.println("leter i " + n.data + " " + n.nr);
        ArrayList<Node> noder = new ArrayList<>();
        //noder der alle barna er over grensen.
        for (Node nbarn : n.barn){
            n.visited = true;
            if(nbarn.data <= grense){ //hvis barnet er under grensa, let videre.
                //System.out.println(nbarn.data + " " + nbarn.nr + " er mindre eller lik, ser på neste");
                for (Node nbarnebarn : finnLavere(grense,nbarn)){
                    if(!noder.contains(nbarnebarn)){
                        noder.add(nbarnebarn);
                    }
                }
            }
        }
        if(n.barn.isEmpty() || noder.isEmpty()){
            //System.out.println(n.data + " " + n.nr + " har ingen barn, eller ungen mindre barn.");
            noder.add(n);
            return noder;
        }
        //String noderusk= "returnerer barna hos " + n.data + " " + n.nr;
        for (Node nr: noder){
            //noderusk += nr.data + " " + nr.nr + ", ";
        }
        //System.out.println(noderusk);
        return noder;
    }

    int findLongestWayFrom(Node n){
        int lengste = 0;
        if(n.barn.isEmpty()){
            //System.out.println("found end at " + n.nr + n.data);
            return 0;
        }
        for(Node bn : n.barn){
            int vei = findLongestWayFrom(n);
            if( vei > lengste){
                lengste = vei;
            }
        }
        return lengste;
    }

    int findLongestWay(){
        return findLongestWayFrom(root);
    }

}


/**
*   Æsj, bare rot!
*/


import java.util.HashMap;
import java.util.Scanner;
import java.net.URL;
import java.io.IOException;

//grupere linjer etter stigning
public class Luke2{
    private static HashMap<Double,Integer> grupper;

    public static void main(String[] args) throws IOException{
        grupper  = new HashMap<>();
        URL link = new URL("https://s3-eu-west-1.amazonaws.com/knowit-julekalender-2018/input-rain.txt");
        Scanner input = new Scanner(link.openStream());
        while (input.hasNextLine()){
            double[] punkter = lesInn(input.nextLine());
            double stigning = finnStigning(punkter);
            if(grupper.containsKey(stigning)){
                grupper.put(stigning,grupper.get(stigning)+1);
            } else {
                grupper.put(stigning,1);
            }
            System.out.println(stigning + " : " + grupper.get(stigning));

        }
        Integer greatest = Integer.MIN_VALUE;
        for(Integer i: grupper.values()){
            if(i>greatest){
                greatest = i;
            }
        }
        System.out.println("Greatest: " + greatest);

    }

    private static double[] lesInn(String fraFil){
        //(x,y);(x,y)
        String[] punkter = fraFil.split(";");
        //() og ()
        /*for (String p: punkter){
            p = p.substring(1,p.length()-1);
        }*/
        //x,y og x,y
        double[] xyxy = new double[4];
        xyxy[0] = Double.parseDouble(punkter[0].substring(1,punkter[0].length()-1).split(",")[0]);
        xyxy[1] = Double.parseDouble(punkter[0].substring(1,punkter[0].length()-1).split(",")[1]);
        xyxy[2] = Double.parseDouble(punkter[1].substring(1,punkter[1].length()-1).split(",")[0]);
        xyxy[3] = Double.parseDouble(punkter[1].substring(1,punkter[1].length()-1).split(",")[1]);
        return xyxy;
    }

    private static double finnStigning(double[] data){
        //x,y,x,y
        return data[2]-data[0]/data[3]-data[1];
    }
}

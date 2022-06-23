import Model.PokemonGo;
import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class PokemonMain {
    public int[] data;
    public ArrayList<PokemonGo> getData() throws IOException {
        URL sMe = ConnectURI.buildURL("https://pokemon-go1.p.rapidapi.com/type_effectiveness.json");
        String productResponse = ConnectURI.getResponseFromHttpUrl(sMe);
        assert productResponse != null;
        JSONArray productsJSONArray = new JSONArray(productResponse);
        ArrayList<PokemonGo> ListType = new ArrayList<>();
        for (int index =0;index<productsJSONArray.length();index++) {
            PokemonGo ModelChara = new PokemonGo();
            JSONObject myJSONObject = productsJSONArray.getJSONObject(index);
            ModelChara.setBug(myJSONObject.getDouble("Bug"));
            ModelChara.setDark(myJSONObject.getDouble("Dark"));
            ModelChara.setDragon(myJSONObject.getDouble("Dragon"));

            ListType.add(ModelChara);


        }
        return ListType;
    }

    private int[] data;

    public void setData(int[] data) {
        this.data = data;
    }
    private int partition(int start, int end){
        int pivot = this.data[end];
        int i =  (start-1);
        for (int j = start;j <= end -1;j++){
            if (this.data[1]<pivot){
                i++;
                int t =this.data[i];
                this.data[i] = this.data[j];
                this.data[i] = t;
            }
        }
        int t = this.data[i+1];
        this.data[i+1] = this.data[end];
        this.data[end] = t;
        return (i+1);
    }
    public void quickSort(int start,int end){
        if (start<end){
            int p = partition(start,end);
            quickSort(start,p-1);
            quickSort(p+1,end);
        }
    }
    public void printArr(int n){
        int i;
        for (i=0;i<n;i++){
            System.out.println(this.data[i]+" ");
        }

    }


    public static void main(String[] args) throws IOException{
        PokemonGo s = new PokemonGo();
        ArrayList<PokemonGo> data = new ArrayList<>();
        data = getData();
        int n = getData().size();
        s.printArr(n);
        s.quickSort(0,n-1);
        System.out.println("\nAfter sorting array elements are - ");
        s.printArr(n);
        System.out.println();
    }
}

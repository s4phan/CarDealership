// Sheehan Phan 500890672
import java.util.*;
class SalesTeam{
    private LinkedList<String> names;
    ArrayList<Integer> sales = new ArrayList<Integer>();
    public SalesTeam(){
        names = new LinkedList<String>(); //reinitializes linked list 
        names.add("Jason");names.add("Yao");names.add("Brandon");names.add("Matt");names.add("Kelvin");
        sales.add(0);sales.add(0);sales.add(0);sales.add(0);sales.add(0); //i thought arraylist would default to 0 but it didnt work so i manually set 0 to each element
       
    }
    /**
     * @return random name of the sales team
     */
    public String ranSale(){
        Random rand00m = new Random();
        int n = rand00m.nextInt(5);
        sales.set(n, (sales.get(n) +1));
        return names.get(n);
    }
    /**
     * @return entire sales team using iterator 
     */
    public String team(){
        String result = "";
        ListIterator<String> iterator = names.listIterator();
        while (iterator.hasNext()) {
            result += (iterator.next() + " ");
        }
        return result;
    }
    /**
     * @return who has the most sales by comparing it to the sales arraylist. 
     */
    public String topSale(){
        int max = 0;
        String topsaleman = "";
        for(int x=0;x<sales.size();x++){
            if(sales.get(x) > max){
                max = sales.get(x);
            }
        }
        for(int x=0;x<sales.size();x++){
            if(sales.get(x) == max){
                topsaleman += names.get(x) + " ";
            }
        }
        return topsaleman +" "+ max;
    }
}
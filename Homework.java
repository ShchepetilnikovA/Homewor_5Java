import java.util.*;

public class Homework {


    public static HashMap<String, ArrayList<Integer>> GetMap() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        System.out.println("Input operation");
        String op = sc.nextLine();
        while(!op.contains("export") ) {
            
            System.out.println("Input Surname");
            String sur = sc.next();
            System.out.println("Input number");
            Integer num = sc.nextInt();
            if(!hm.containsKey(sur)){
                hm.put(sur, new ArrayList<Integer>() {{add(num);}});
            }
            else {
                hm.get(sur).add(num);
            }
            System.out.print(hm);
            System.out.println("Input operation");
            op = sc.next();
        }
        sc.close();
        return hm;
    }


    public static void export(HashMap<String, ArrayList<Integer>> hm) {
        ArrayList<String> keysArr = new ArrayList<>(hm.keySet());
        ArrayList<Integer> valuesArr = new ArrayList<>(hm.values().size());
        for (int i = 0; i < keysArr.size() - 2; i++) {
            for (int j = 0; j < keysArr.size() - 2; j++) {
                if(valuesArr.get(j) < valuesArr.get(j + 1)) {
                    int temp = valuesArr.get(j);
                    valuesArr.set(j, valuesArr.get(j + 1));
                    valuesArr.set(j + 1, temp);
                    String temp2 = keysArr.get(j);
                    keysArr.set(j, keysArr.get(j + 1));
                    keysArr.set(j + 1, temp2);
                }
            }  
        }
        for (String item : keysArr) {
            System.out.printf(item + hm.get(item));
        }
    }


    public static void main(String[] args) {
        export(GetMap());
    }
}

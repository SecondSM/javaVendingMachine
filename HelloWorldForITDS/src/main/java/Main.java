import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;

public class Main {

    public static ArrayList<Integer> calculateChange(List<Integer> moneyInMachine, List<Integer> moneyInput, int productValue){

        // add money input to moneyMachine
        moneyInMachine.addAll(moneyInput);

        Collections.sort(moneyInMachine);

        int changeValueToReturn = moneyInput.stream().mapToInt(Integer::intValue).sum() - productValue;
        ArrayList<Integer> changeArray = new ArrayList<>();

        for(int i = moneyInMachine.size() - 1; i >= 0; i--){
            if(moneyInMachine.get(i) <= changeValueToReturn){
                changeArray.add(moneyInMachine.get(i));

                changeValueToReturn -= moneyInMachine.get(i);
                System.out.println("dodana moneta do wydania: " + moneyInMachine.get(i));
                moneyInMachine.remove(new Integer(moneyInMachine.get(i)));
            }
        }

        if(moneyInMachine.stream().mapToInt(Integer::intValue).sum()< 73){
            System.out.println("Produkt nie moze zostac sprzedany");
        }

        return changeArray;
    }

    public static void main(String[] args){
        List<Integer> moneyInMachine = new ArrayList<>();
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(5);
        moneyInMachine.add(5);
        moneyInMachine.add(5);


        List<Integer> moneyInput = new ArrayList<>();
        moneyInput.add(200);
        moneyInput.add(50);
        moneyInput.add(20);

        calculateChange(moneyInMachine, moneyInput, 254);

    }
}
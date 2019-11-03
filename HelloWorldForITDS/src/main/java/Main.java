import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<Integer> calculateChange(List<Integer> moneyInMachine, List<Integer> moneyInput, int productValue){

        moneyInMachine.addAll(moneyInput);
        Collections.sort(moneyInMachine);

        final int changeValueToReturn = moneyInput.stream().mapToInt(Integer::intValue).sum() - productValue;
        int remainingChangeValueToReturn = changeValueToReturn;

        if(changeValueToReturn < 0){
            System.out.println("Produkt nie moze zostac sprzedany - zbyt malo gotowki");
            moneyInMachine.removeAll(moneyInput);
            return moneyInput;
        }

        List<Integer> changeArray = new ArrayList<>();

        for(int i = moneyInMachine.size() - 1; i >= 0; i--){
            if(moneyInMachine.get(i) <= remainingChangeValueToReturn){
                changeArray.add(moneyInMachine.get(i));

                remainingChangeValueToReturn -= moneyInMachine.get(i);
                moneyInMachine.remove(new Integer(moneyInMachine.get(i)));
            }
        }

        if(moneyInMachine.stream().mapToInt(Integer::intValue).sum()< 73){
            System.out.println("Produkt nie moze zostac sprzedany");
            moneyInMachine.removeAll(moneyInput);
            return moneyInput;
        }

        if(remainingChangeValueToReturn > 0){
            int firstGreaterValueCoin = moneyInMachine.stream()
                    .filter(x -> x > changeValueToReturn)
                    .findFirst()
                    .get();
            moneyInMachine.addAll(changeArray);
            changeArray.clear();

            moneyInMachine.remove(new Integer(firstGreaterValueCoin));
            changeArray.add(firstGreaterValueCoin);
        }

        if(moneyInMachine.stream().mapToInt(Integer::intValue).sum()< 73){
            System.out.println("Produkt nie moze zostac sprzedany - brak zapasu reszty w maszynie");
            moneyInMachine.removeAll(moneyInput);
            return moneyInput;
        }

        return changeArray;
    }

    public static void main(String[] args){
        List<Integer> moneyInMachine = new ArrayList<>();
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(1);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(2);
        moneyInMachine.add(5);
        moneyInMachine.add(5);
        moneyInMachine.add(5);
        moneyInMachine.add(5);

        List<Integer> moneyInput = new ArrayList<>();

        moneyInput.add(200);
        moneyInput.add(50);
        moneyInput.add(20);

        System.out.println(calculateChange(moneyInMachine, moneyInput, 254));
    }
}
package ru.sberbank.service;

import ru.sberbank.data.Tester;
import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> {
    public ArrayList<Tester> list;

    public TesterService() {
        super();
    }

    public void createTester(int id, String firstName, String secondName){
        if (firstName == null || secondName == null || firstName == "" || secondName == ""){
            throw new IllegalStateException("Tester is not created");
        }
        Tester QA = new Tester(id, firstName, secondName);
        list.add(QA);
    }

    public Tester getTester(String firstName, String secondName) {
        for (Tester n : list) {
            if (firstName.equalsIgnoreCase(n.getFirstName()) && secondName.equalsIgnoreCase(n.getSecondName()))
                return n;
        }
        throw new IllegalStateException("Tester is not found");
    }


    public ArrayList getFreeTesters() {
        ArrayList<Tester> temp = new ArrayList<>();
        for (Tester n : list) {
            if (n.isFree()) {
                temp.add(n);
            }
        }
        if (temp.isEmpty()){
            throw new IllegalStateException("Testers list is empty");
        }
        return temp;
    }
}



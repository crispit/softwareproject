package crispit.busserviceapp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class BusListTest {
    @Test
    public void addition_isCorrect() throws Exception {
        BusList busList = new BusList();
        ArrayList<String> list = new ArrayList<>();
        list.add("Hej");
        busList.setList(list);
        busList.setTypeOfBus("BusInfo");
        //assert(busList.onQueryTextSubmit(null));
    }
}

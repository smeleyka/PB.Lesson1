package ru.geekbrains.android3_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav on 2/26/2018.
 */

public class CounterModel
{
    private List<Integer> counters;

    public CounterModel()
    {
        counters = new ArrayList<>();
        counters.add(0);
        counters.add(0);
        counters.add(0);
    }

    public int getAt(int index)
    {
        return counters.get(index);
    }


    public int setAt(int index, int value)
    {
        return counters.set(index, value);
    }
}

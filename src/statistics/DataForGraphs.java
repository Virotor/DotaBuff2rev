package statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataForGraphs implements Serializable {

    private List<Integer> netWorse = new ArrayList<>();
    private List<Integer> exp = new ArrayList<>();

    public List<Integer> getNetWorse() {
        return netWorse;
    }

    public void setNetWorse(List<Integer> netWorse) {
        this.netWorse = netWorse;
    }

    public List<Integer> getExp() {
        return exp;
    }

    public void setExp(List<Integer> exp) {
        this.exp = exp;
    }
}
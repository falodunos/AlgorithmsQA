/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Oluremi Adekanmbi <oluremi.adekanmbi@etranzact.com>
 */
public class Dataplan {

    private int position;
    private String amount;
    private String size;
    private String validity;

    private static final String dataPlansStr = Utils.getConfigDetails("DATA_PLANS");

    public Dataplan(int position, String amount, String size, String validity) {
        this.position = position;
        this.amount = amount;
        this.size = size;
        this.validity = validity;
    }

    public Dataplan() {
    }

    public Dataplan(int position) {
        this.position = position;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Dataplan{" + "amount=" + amount + ", size=" + size + ", validity=" + validity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.position);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dataplan other = (Dataplan) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }

    public static List<Dataplan> getDataPlans() {
        List<Dataplan> dataPlansLst = new ArrayList<>();
        Dataplan dataplan;
        int position = 0;
        String[] dataPlans = dataPlansStr.split(",");
        
        for (String dataPlan : dataPlans) {
            position += 1;
            String[] dataPlanParts = dataPlan.split(":");
            dataplan = new Dataplan(position, dataPlanParts[0], dataPlanParts[1], dataPlanParts[2]);
           dataPlansLst.add(dataplan);
        }
        return dataPlansLst;
    }

    public static void main(String[] args) {
        System.out.println("==============     dataPlans      ================");
        getDataPlans().forEach((dp) -> {
            System.out.println(dp.getPosition() + " " + dp.getAmount() + " " + dp.getSize() + " " + dp.getValidity());
        });
    }
}

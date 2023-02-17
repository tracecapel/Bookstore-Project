package Project1;

public class Member {
    private String name;
    private boolean isPremium;
    private String payMethod;
    private double totalSpent;
    private boolean isPaid;

    public Member(String name, boolean isPremium, boolean isPaid, String payMethod, double totalSpent){
        this.name = name;
        this.isPremium = isPremium;
        this.payMethod = payMethod;
        this.totalSpent = totalSpent;
        this.isPaid = isPaid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getPremium(){
        return isPremium;
    }

    public void setPremium(boolean isPremium){
        this.isPremium = isPremium;
    }

    public String getPayMethod(){
        return payMethod;
    }

    public void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }

    public double getTotalSpent(){
        return totalSpent;
    }

    public void setSpent(double totalSpent){
        this.totalSpent = totalSpent;
    }

    public boolean getPaid(){
        return isPaid;
    }

    public void setPaid(boolean isPaid){
        this.isPaid = isPaid;
    }


    
}

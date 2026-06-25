ggclass Player{
    private double balance;
    Player(int bal){
        this.balance=bal;
    }
    public void getbalance(double balance)
    {
        this.balance=balance;
    }
    double setbalance(){
        return balance;
    }
    void placeBet(){
        double betamnt=0;
        if(balance>0 && balance<20000)
        {
            betamnt-= balance;
        }
        else{
            betamnt=5;
        }
    }
}
class Path{
    double  multiplier=1.0;
    boolean fire;
    int pathNum;
        for(int i=0;i<22;i++){
        multiplier[i]=multiplier;
        multiplier+= 0.5;
    Path(double mul, boolean fire, int pathNum){
        this.multiplier=mul;
        this.fire=fire;
        this.pathNum=pathNum;
    }
    }

}

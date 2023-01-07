public class AnalysisError{
    private int Error6,Error7,Error8,Error9,Error10,Error11,Error12;
    public AnalysisError(int Error6,int Error7,int Error8,int Error9,int Error10,int Error11,int Error12){
        this.Error6 = Error6;
        this.Error7 = Error7;
        this.Error8 = Error8;
        this.Error9 = Error9;
        this.Error10 = Error10;
        this.Error11 = Error11;
        this.Error12 = Error12;
    }
    public void Max(){
          if(Error6 > Error7 && Error6 > Error8 && Error6 > Error9 && Error6 > Error10 && Error6 > Error11 && Error6 > Error12){
                    System.out.println("The month that have the most error: June ");
                }
                else if(Error7 > Error6 && Error7 > Error8 && Error7 > Error9 && Error7 > Error10 && Error7 > Error11 && Error7 > Error12){
                    System.out.println("The month that have the most error: July");
                }
                else if(Error8 > Error6 && Error8 > Error7 && Error8 > Error9 && Error8 > Error10 && Error8 > Error11 && Error8 > Error12){
                    System.out.println("The month that have the most error: August");
                }
                else if(Error9 > Error6 && Error9 > Error7 && Error9 > Error8 && Error9 > Error10 && Error9 > Error11 && Error9 > Error12){
                    System.out.println("The month that have the most error: September");
                }
                else if(Error10 > Error6 && Error10 > Error7 && Error10 > Error8 && Error10 > Error9 && Error10 > Error11 && Error10 > Error12){
                    System.out.println("The month that have the most error: October");
                }
                else if(Error11 > Error6 && Error11 > Error7 && Error11 > Error8 && Error11 > Error9 && Error11 > Error10 && Error11 > Error12){
                    System.out.println("The month that have the most error: November");
                }
                else{
                    System.out.println("The month that have the most error: December");
                }
    }
    public void Min(){
          if(Error6 < Error7 && Error6 < Error8 && Error6 < Error9 && Error6 < Error10 && Error6 < Error11 && Error6 < Error12){
                    System.out.println("The month that have the least error: June ");
                }
                else if(Error7 < Error6 && Error7 < Error8 && Error7 < Error9 && Error7 < Error10 && Error7 < Error11 && Error7 < Error12){
                    System.out.println("The month that have the least error: July");
                }
                else if(Error8 < Error6 && Error8 < Error7 && Error8 < Error9 && Error8 < Error10 && Error8 < Error11 && Error8 < Error12){
                    System.out.println("The month that have the least error: August");
                }
                else if(Error9 < Error6 && Error9 < Error7 && Error9 < Error8 && Error9 < Error10 && Error9 < Error11 && Error9 < Error12){
                    System.out.println("The month that have the least error: September");
                }
                else if(Error10 < Error6 && Error10 < Error7 && Error10 < Error8 && Error10 < Error9 && Error10 < Error11 && Error10 < Error12){
                    System.out.println("The month that have the least error: October");
                }
                else if(Error11 < Error6 && Error11 < Error7 && Error11 < Error8 && Error11 < Error9 && Error11 < Error10 && Error11 < Error12){
                    System.out.println("The month that have the least error: November");
                }
                else{
                    System.out.println("The month that have the least error: December");
                }
    }
}
            

public class AnalysisError{
    private int Error6,Error7,Error8,Error9,Error10,Error11,Error12;
    private int sum;
    
    public AnalysisError(int Error6,int Error7,int Error8,int Error9,int Error10,int Error11,int Error12){
        this.Error6 = Error6;
        this.Error7 = Error7;
        this.Error8 = Error8;
        this.Error9 = Error9;
        this.Error10 = Error10;
        this.Error11 = Error11;
        this.Error12 = Error12;
    }
    public String Max(){
        String result = " ";
          if(Error6 > Error7 && Error6 > Error8 && Error6 > Error9 && Error6 > Error10 && Error6 > Error11 && Error6 > Error12){
                    result = "June";
                }
                else if(Error7 > Error6 && Error7 > Error8 && Error7 > Error9 && Error7 > Error10 && Error7 > Error11 && Error7 > Error12){
                    result = "July";
                }
                else if(Error8 > Error6 && Error8 > Error7 && Error8 > Error9 && Error8 > Error10 && Error8 > Error11 && Error8 > Error12){
                    result = "August";
                }
                else if(Error9 > Error6 && Error9 > Error7 && Error9 > Error8 && Error9 > Error10 && Error9 > Error11 && Error9 > Error12){
                    result = "September";
                }
                else if(Error10 > Error6 && Error10 > Error7 && Error10 > Error8 && Error10 > Error9 && Error10 > Error11 && Error10 > Error12){
                    result = "October";
                }
                else if(Error11 > Error6 && Error11 > Error7 && Error11 > Error8 && Error11 > Error9 && Error11 > Error10 && Error11 > Error12){
                    result = "November";
                }
                else if(Error12 > Error6 && Error12 > Error7 && Error12 > Error8 && Error12 > Error9 && Error12 > Error10 && Error12 > Error11){
                    result = "December";
                }
          return result;
    }
    public String Min(){
        String result = " ";
          if(Error6 < Error7 && Error6 < Error8 && Error6 < Error9 && Error6 < Error10 && Error6 < Error11 && Error6 < Error12){
                    result = "June";
                }
                else if(Error7 < Error6 && Error7 < Error8 && Error7 < Error9 && Error7 < Error10 && Error7 < Error11 && Error7 < Error12){
                    result = "July";
                }
                else if(Error8 < Error6 && Error8 < Error7 && Error8 < Error9 && Error8 < Error10 && Error8 < Error11 && Error8 < Error12){
                    result = "August";
                }
                else if(Error9 < Error6 && Error9 < Error7 && Error9 < Error8 && Error9 < Error10 && Error9 < Error11 && Error9 < Error12){
                   result = "September";
                }
                else if(Error10 < Error6 && Error10 < Error7 && Error10 < Error8 && Error10 < Error9 && Error10 < Error11 && Error10 < Error12){
                    result = "October";
                }
                else if(Error11 < Error6 && Error11 < Error7 && Error11 < Error8 && Error11 < Error9 && Error11 < Error10 && Error11 < Error12){
                    result = "November";
                }
                else if(Error12 <= Error6 && Error12 <= Error7 && Error12 <= Error8 && Error12 <= Error9 && Error12 <= Error10 && Error12 <= Error11){
                    result = "December";
                }
          return result;
    }
    
    public double Average(int a){
        double average = 0;
        this.sum = a;
        average = (double) sum / 7;
        return average;
    }
} 
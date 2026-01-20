package pkstudent_extra.component;

import java.io.*;

public class Science extends Student implements InfStudent
{
    private int sugaku;
    
    public Science(int no,String name)
    {
        super(no,name);
    }
    public int getSugaku()
    {
        return sugaku;
    }
    public int getTotal()
    {
        return super.getKokugo() + super.getEigo() + getSugaku();
    }
    public double getAvg()
    {
        return (double)getTotal() / 3;
    }
    public void setSelect(int sugaku)
    {
        this.sugaku = sugaku;
    }
    public String getSelectName()
    {
        return "数学";
    }
    public void show()
    {
        System.out.printf("\t%-4d　%s\t%4d\t%4d\t%4d(%s)\t%6d\t%6.1f\n",
                          super.getNo(),
                          super.getName(),
                          super.getKokugo(),
                          super.getEigo(),
                          getSugaku(),
                          getSelectName(),
                          getTotal(),
                          getAvg());
    }
    public void show(PrintWriter pw)
    {
        pw.printf("%-4d　%s\t%4d\t%4d\t%4d(%s)\t%6d\t%6.1f\n",
                    super.getNo(),
                    super.getName(),
                    super.getKokugo(),
                    super.getEigo(),
                    getSugaku(),
                    getSelectName(),
                    getTotal(),
                    getAvg());
    }
}
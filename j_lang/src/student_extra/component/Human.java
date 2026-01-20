package pkstudent_extra.component;

import java.io.*;

public class Human extends Student implements InfStudent
{
    private int syakai;
    
    public Human(int no,String name)
    {
        super(no,name);
    }
    public int getSyakai()
    {
        return syakai;
    }
    public int getTotal()
    {
        return super.getKokugo() + super.getEigo() + getSyakai();
    }
    public double getAvg()
    {
        return (double)getTotal() / 3;
    }
    public void setSelect(int syakai)
    {
        this.syakai = syakai;
    }
    public String getSelectName()
    {
        return "社会";
    }
    public void show()
    {
        System.out.printf("\t%-4d　%s\t%4d\t%4d\t%4d(%s)\t%6d\t%6.1f\n",
                          super.getNo(),
                          super.getName(),
                          super.getKokugo(),
                          super.getEigo(),
                          getSyakai(),
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
                    getSyakai(),
                    getSelectName(),
                    getTotal(),
                    getAvg());
    }
}
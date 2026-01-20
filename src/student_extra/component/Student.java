package pkstudent_extra.component;

import java.io.*;

public abstract class Student
{
    private int no;
    private String name;
    private int kokugo;
    private int eigo;

    public Student(int no,String name)
    {
        this.no = no;
        this.name = name;
    }
    public int getNo()
    {
        return no;
    }
    public String getName()
    {
        return name;
    }
    public int getKokugo()
    {
        return kokugo;
    }
    public int getEigo()
    {
        return eigo;
    }
    public void setKokugo(int kokugo)
    {
        this.kokugo = kokugo;
    }
    public void setEigo(int eigo)
    {
        this.eigo = eigo;
    }
    public String getKokugoName()
    {
        return "国語";
    }
    public String getEigoName()
    {
        return "英語";
    }
    public abstract void setSelect(int kamoku);
    public abstract String getSelectName();
    public abstract void show();
    public abstract void showToFile(PrintWriter pw);
    public static void printTitle()
    {
        System.out.println("\t番号　氏名\t国語\t英語\t　選択\t\t合計点\t平均点");
    }
    public static void writeTitle(PrintWriter pw)
    {
        pw.println("番号　氏名\t国語\t英語\t　選択\t\t合計点\t平均点");
    }
}
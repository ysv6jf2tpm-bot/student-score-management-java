package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

public class Fin
{
    private StudentMgr mgr;

    public Fin(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
    public void saveToFile(String filename) throws IOException
    {
        PrintWriter pw = new PrintWriter
            (new BufferedWriter(new FileWriter(filename)));
        Student.writeTitle(pw);
        Student s;
        if(mgr.isScoreInputDone()){
            for(int i = 0; i < mgr.getListLength(); i++){
                s = mgr.getData(i);
                s.showToFile(pw);
            }
        }else{
            for(int i = 0; i < mgr.getListLength(); i++){
                s = mgr.getData(i);
                pw.printf("%-4d　%s\n",s.getNo(),s.getName());
            }
        }
        pw.close();
    }
}

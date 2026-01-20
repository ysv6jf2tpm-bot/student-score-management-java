package pkstudent_extra;

import java.util.*;
import pkstudent_extra.component.*;

public class StudentMgr
{
    private ArrayList<Student> list = new ArrayList<Student>();
    private boolean scoreInputDone = false;
	
    public Student getData(int i)
    {
        return list.get(i);
    }
    public void addData(int no,String name,String major)
    {
        if(major.equalsIgnoreCase("S"))
            list.add(new Science(no,name));
        else if(major.equalsIgnoreCase("H"))
            list.add(new Human(no,name));
    }
    public int getListLength()
    {
        return list.size();
    }
    public void setScoreInputDone(boolean done)
    {
        scoreInputDone = done;
    }
    public boolean isScoreInputDone()
    {
        return scoreInputDone;
    }
}
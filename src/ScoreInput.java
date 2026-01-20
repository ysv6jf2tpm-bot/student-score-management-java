package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

public class ScoreInput
{
    private StudentMgr mgr;
        
    public ScoreInput(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
    public void enterScores() throws IOException
    {
		BufferedReader br =
            new BufferedReader
            (new InputStreamReader(System.in));
		StudentCheck sc = new StudentCheck();
        System.out.println("\n*** 学生の科目ごとの点数を入力してください。 ***");
		int i;
		for(i = 0; i < mgr.getListLength(); ){
			try{
				Student s = mgr.getData(i);
				System.out.println(s.getNo() + " " + s.getName());
				System.out.print("\t" + s.getKokugoName() + "==>");
				s.setKokugo(sc.pointCheck(br.readLine()));
				System.out.print("\t" + s.getEigoName() + "==>");
				s.setEigo(sc.pointCheck(br.readLine()));
				System.out.print("\t" + s.getSelectName() + "==>");
				s.setSelect(sc.pointCheck(br.readLine()));
				i++;
			}catch(NumberFormatException e){
				System.out.println("エラー：入力値が整数ではありません。");
			}catch(StudentException e){
				System.out.println(e.getMessage());
			}
		}
		//br.close();
		if(i == mgr.getListLength())
			mgr.setScoreInputDone(true);
    }
}
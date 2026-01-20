package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

//成績一覧表示クラス
public class ScoreList
{
    private StudentMgr mgr;
	
    public ScoreList(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
    public void dispScores()
    {
        Student.printTitle();
        Student s;
        
        //点数入力済みであればshowメソッドを呼び出してすべての情報を表示し、未入力の場合は番号と氏名のみを表示する
        if(mgr.isScoreInputDone()){
            for(int i = 0; i < mgr.getListLength(); i++){
                s = mgr.getData(i);
                s.show();
            }
        }else{
            for(int i = 0; i < mgr.getListLength(); i++){
                s = mgr.getData(i);
                System.out.printf("%-4d　%s\n",s.getNo(),s.getName());
            }
        }
    }
}

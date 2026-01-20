
package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

//点数入力クラス
public class ScoreInput
{
    private StudentMgr mgr;
        
    public ScoreInput(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
    //点数入力メソッド
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
				i++; //全科目の点数を正しく入力できたら次の学生へ進む（途中で例外が送出されたら捕捉して最初の科目から再入力する）
			}catch(NumberFormatException e){
				System.out.println("エラー：入力値が整数ではありません。");
			}catch(StudentException e){
				System.out.println(e.getMessage());
			}
		}
		
		//iの値がリストの長さ（初期化クラスで登録した学生の人数）と等しい（全員の点数を正しく入力できた）とき学生管理クラスのフィールドの点数入力済み判定をtrueにする
		if(i == mgr.getListLength())
			mgr.setScoreInputDone(true);
    }
}

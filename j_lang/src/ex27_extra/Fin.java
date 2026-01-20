
package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

//終了クラス
public class Fin
{
    private StudentMgr mgr;
	
    public Fin(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
    //ファイル出力メソッド
    public void saveToFile(String filename) throws IOException
    {
        PrintWriter pw = new PrintWriter
            (new BufferedWriter(new FileWriter(filename)));
        Student.printTitle(pw);
        Student s;
        
        //点数入力済みであればshowメソッドを呼び出してすべての情報を表示し、未入力の場合は番号と氏名のみを表示する
        if(mgr.isScoreInputDone()){
            for(int i = 0; i < mgr.getListLength(); i++){
                s = mgr.getData(i);
                s.show(pw);
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

package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

//学生検索クラス
public class StudentSearch
{
    private StudentMgr mgr;
	
    public StudentSearch(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
    //学生検索メソッド
    public void findStudent() throws IOException
    {
        BufferedReader br =
            new BufferedReader
            (new InputStreamReader(System.in));
        String str = "\0";
        
        System.out.println("***　学生検索");
        while(!(str.equals(""))){
            System.out.println("学生番号または氏名を入力してください。");
            System.out.print("検索ワード(Enterのみで終了)==>");
            str = br.readLine();
            
            //strが空文字でなければリストを走査して番号または氏名が完全一致する学生の情報を表示し、空文字であれば検索を終了する
            if(!(str.equals(""))){
                Student s = null;
                boolean find = false;
                for(int i = 0; find == false && i < mgr.getListLength(); ){
                    s = mgr.getData(i);
                    //標準入力から受け取った文字列がリストのi番目の学生の番号（整数から変換する）または氏名と一致するかを判断する
                    if(str.equals(Integer.toString(s.getNo())) || str.equals(s.getName()))
                        find = true;
                    else
                        i++;
                }
                
                if(find){
                    Student.printTitle();
                    //点数入力済みであれば学生クラスのshowメソッドを呼び出して点数も含めてすべての情報を表示
                    if(mgr.isScoreInputDone())
                        s.show();
                    else
                        System.out.printf("\t%-4d　%s\n",s.getNo(),s.getName()); //未入力の場合は番号と氏名のみを表示
                }else{
                    System.out.println("\t番号または氏名が[" + str + "]の学生は見つかりませんでした。");
                }
            }else
                System.out.println("検索を終了します。");
        }
    }
}

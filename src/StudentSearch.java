package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

public class StudentSearch
{
    private StudentMgr mgr;

    public StudentSearch(StudentMgr mgr)
    {
        this.mgr = mgr;
    }
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
            if(!(str.equals(""))){
                Student s = null;
                boolean find = false;
                for(int i = 0; find == false && i < mgr.getListLength(); ){
                    s = mgr.getData(i);
                    if(str.equals(Integer.toString(s.getNo())) || str.equals(s.getName()))
                        find = true;
                    else
                        i++;
                }
                if(find){
                    Student.printTitle();
                    if(mgr.isScoreInputDone())
                        s.show();
                    else
                        System.out.printf("\t%-4d　%s\n",s.getNo(),s.getName());
                }else{
                    System.out.println("\t番号または氏名が[" + str + "]の学生は見つかりませんでした。");
                }
            }else
                System.out.println("検索を終了します。");
        }
        //br.close();
    }
}
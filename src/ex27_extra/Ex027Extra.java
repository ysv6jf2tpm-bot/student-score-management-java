
package pkex27_extra;

import pkstudent_extra.*;
import pkstudent_extra.component.*;
import java.io.IOException;

class Ex027Extra
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Java課題27(補充)　成績システム");
        if(args.length == 2){
            try{
                StudentMgr mgr = new StudentMgr();
                Init in = new Init(mgr);
                in.loadFromFile(args[0]);
                System.out.println("学生リストを作成しました。");
                MenuController mc = new MenuController("成績システム",4);
                mc.setOptions(new int[]{1,2,3,99});
                mc.setLabels(new String[]{"点数入力","学生検索","成績一覧","終了"});
                int end = 99;
                int opt = 0;
                while(opt != end){
                    mc.dispMenu();
                    opt = mc.inputOption();
                    switch(opt){
                        case 1:
                        	if(mgr.isScoreInputDone())
                        		System.out.println("エラー：点数入力は既に完了しています。");
                        	else{
                        		ScoreInput si = new ScoreInput(mgr);
                            	si.enterScores();
                        	}
                            break;
                        case 2:
                            StudentSearch ss = new StudentSearch(mgr);
                            ss.findStudent();
                            break;
                        case 3:
                            ScoreList sl = new ScoreList(mgr);
                            sl.dispScores();
                            break;
                        case 99:
                            Fin f = new Fin(mgr);
                            f.saveToFile(args[1]);
                            break;
                        default:
                            break;
                    }
                }
            }catch(IOException e){
                System.out.println("入出力エラー");
            }
        }else{
            System.out.println("コマンドライン引数を2つ指定してください。");
        }
    }
}

/* 入力ファイル
"Z:\neo_j_lang\student_extra.dat"
10,中野太郎,s
aa,亀戸花子,S
120,板橋一郎,i
13,品川三郎,h
14,飯田和男,S
15,aaaaaaaaaaaaaaaaaaaaaaaaa,S
16,荏原次郎,S
17,府中和子,h
18,足立司郎,H
19,王子公子,s
20,赤羽保子,H
*/

/*
"Z:\neo_j_lang\src\ex27_extra\学生の点数.txt"
10,中野太郎,90,85,30
13,品川三郎,96,93,100
14,飯田和男,87,92,0
16,荏原次郎,80,65,56
17,府中和子,78,75,98
18,足立司郎,67,86,79
19,王子公子,54,63,84
20,赤羽保子,41,68,78
*/

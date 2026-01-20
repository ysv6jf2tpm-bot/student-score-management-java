package pkex27_extra;

import pkstudent_extra.*;
import pkstudent_extra.component.*;
import java.io.IOException;

//アプリケーションクラス
class Ex027Extra
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Java課題27(補充)　成績システム");
        
        //コマンドライン引数が2のとき処理を開始する
        if(args.length == 2){
            try{
            	//学生管理クラス、初期化クラスのオブジェクトを作成してリストに学生の情報を初期化する
                StudentMgr mgr = new StudentMgr();
                Init in = new Init(mgr);
                in.loadFromFile(args[0]);
                System.out.println("学生リストを作成しました。");
                
                int end = 99; //終了コード
                int opt = 0; //メニュー制御クラスのinputOptionメソッドの戻り値を受け取る
                
                //メニュー制御クラスで表示する内容を決める
                MenuController mc = new MenuController("成績システム",4);
                mc.setOptions(new int[]{1,2,3,end});
                mc.setLabels(new String[]{"点数入力","学生検索","成績一覧","終了"});
                
                //optとendが一致しない間ループする
                while(opt != end){
                    mc.dispMenu();
                    opt = mc.inputOption();
                    switch(opt){
                        case 1: //点数入力
                        	if(mgr.isScoreInputDone())
                        		System.out.println("エラー：点数入力は既に完了しています。");
                        	else{
                        		ScoreInput si = new ScoreInput(mgr);
                            	si.enterScores();
                        	}
                            break;
                        case 2: //学生検索
                            StudentSearch ss = new StudentSearch(mgr);
                            ss.findStudent();
                            break;
                        case 3: //成績一覧表示
                            ScoreList sl = new ScoreList(mgr);
                            sl.dispScores();
                            break;
                        case 99: //終了
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

<<<<<<< HEAD
/* 入力ファイル    "student_extra.dat"
=======
/* コンパイルと実行
j_lang (main) $ javac -encoding UTF-8 -d ./ src/student_extra/*.java src/student_extra/component/*.java src/ex27_extra/*.java
j_lang (main) $ java pkex27_extra.Ex027Extra student_extra.dat student_out.txt
*/

/* 入力ファイル "student_extra.dat"
>>>>>>> b4ca30a (commit)
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

/* 学生の点数
10,中野太郎,90,85,30
13,品川三郎,96,93,100
14,飯田和男,87,92,0
16,荏原次郎,80,65,56
17,府中和子,78,75,98
18,足立司郎,67,86,79
19,王子公子,54,63,84
20,赤羽保子,41,68,78
*/

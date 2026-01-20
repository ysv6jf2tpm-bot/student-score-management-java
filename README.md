# Java 成績管理システム（CUI）

## 概要
Javaのオブジェクト指向プログラミングを学ぶための課題として作成した
**CUIベースの学生成績管理システム**です。

CSV形式の入力ファイル（学生番号・氏名・専攻区分）から学生リストを読み込み、
以下の操作をメニュー形式で行います：
- 国語・英語＋専攻別選択科目（数学or社会）の点数入力
- 学生の検索（番号または氏名）
- 全学生の成績一覧表示
- 結果をテキストファイルに出力

**主な学習目的**
- 継承・抽象クラス・インターフェイスによるオブジェクト指向設計
- 例外処理（独自例外クラス作成）
- ファイル入出力（BufferedReader / PrintWriter）
- コレクション（ArrayList）の活用
- 入力バリデーションの実装

## 使用技術
- Java（標準ライブラリのみ）
- パッケージ構成（複数パッケージで整理）
- 例外処理（カスタム例外 `StudentException`）
- ファイル入出力（UTF-8対応）
- コレクション（`ArrayList<Student>`）
- コンソールUI（メニュー選択＋入力バリデーション）

## 機能一覧
- **学生データ読み込み**
  `student_extra.dat` から学生番号・氏名・専攻（S:理系 / H:文系）を読み込み
  入力エラー（範囲外・文字数超過・区分誤り）はスキップ＋エラーメッセージ表示

- **点数入力**
  各学生ごとに国語・英語・選択科目（数学or社会）の点数を入力
  0〜100の範囲チェック＋整数チェック

- **学生検索**
  学生番号または氏名で完全一致検索
  点数入力前は基本情報のみ、入力後は合計点・平均点も表示

- **成績一覧表示**  
  フォーマット整列した表形式でコンソール出力
  合計点・平均点（小数点1位）を自動計算
  点数未入力時は基本情報のみ出力

- **ファイル出力**
  メニュー終了時に `student_out.txt` へ成績一覧表示と同じ形式で保存
  点数未入力時は基本情報のみ出力

## ディレクトリ構成
```text
student-score-management-java
└ j_lang
   ├ student_extra.dat                 ← 入力データ（学生リスト）
   ├ student_out.txt                   ← 出力ファイル（成績一覧）
   └ src
      ├ ex27_extra                     ← パッケージ: pkex27_extra
      │  ├ Ex027Extra.java             ← アプリケーションクラス（main）
      │  ├ Init.java                   ← ファイル入力・学生情報初期化クラス
      │  ├ ScoreInput.java             ← 点数入力クラス
      │  ├ StudentSearch.java          ← 学生検索クラス
      │  ├ ScoreList.java              ← 成績一覧表示クラス
      │  ├ Fin.java                    ← ファイル出力・終了クラス
      │  └ MenuController.java         ← メニュー表示・入力制御クラス
      └ student_extra                  ← パッケージ: pkstudent_extra
         ├ StudentMgr.java             ← 学生リスト管理クラス
         └ component                   ← パッケージ: pkstudent_extra.component
            ├ InfStudent.java          ← 合計点・平均点インターフェイス
            ├ Student.java             ← 抽象クラス
            ├ Human.java               ← 文系学生（社会）クラス
            ├ Science.java             ← 理系学生（数学）クラス
            ├ StudentException.java    ← カスタム例外クラス
            └ StudentCheck.java        ← 入力バリデーションクラス

## 実行方法
```bash
j_lang (main) $ javac -encoding UTF-8 -d ./ src/student_extra/*.java src/student_extra/component/*.java src/ex27_extra/*.java
j_lang (main) $ java pkex27_extra.Ex027Extra student_extra.dat student_out.txt
# student-score-management-java

# Java 成績管理システム（CUI）

## 概要
学生情報を読み込み、点数入力・検索・一覧表示・ファイル出力を行う
CUIベースの成績管理システムです。

## 使用技術
- Java
- 標準ライブラリ（I/O, Collection）
- 例外処理

## 機能
- 学生データの読み込み（.dat）
- 入力値バリデーション（独自例外）
- 点数入力
- 学生検索（番号・氏名）
- 成績一覧表示
- ファイル出力（.txt）

## 実行方法
```bash
javac -encoding UTF-8 -d ./ src/**/**/*.java
java pkex27_extra.Ex027Extra student_extra.dat student_out.txt
# student-score-management-java

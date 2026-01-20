package pkex27_extra;

import java.io.*;

public class MenuController
{
    private String title;
    private int[] options;
    private String[] labels;
    
    public MenuController(String title,int len)
    {
        this.title = title;
        options = new int[len];
        labels = new String[len];
    }
    public void setOptions(int[] options)
    {
        for(int i = 0; i < this.options.length; i++){
            this.options[i] = options[i];
        }
    }
    public void setLabels(String[] labels)
    {
        for(int i = 0; i < this.labels.length; i++){
            this.labels[i] = labels[i];
        }
    }
    public void dispMenu()
    {
        printAsters(25);
        System.out.println("[" + title + "]");
        for(int i = 0; i < options.length; i++){
            System.out.println("\t" + labels[i] + "\t" + "==>" + options[i]);
        }
        printAsters(25);
    }
    public static void printAsters(int n)
    {
        for(int i = 0; i < n; i++){
            System.out.print("*");
        }
        System.out.print("\n");
    }
    public int inputOption() throws IOException
    {
        int opt = 0;
        boolean ok = false;
        BufferedReader br =
            new BufferedReader
            (new InputStreamReader(System.in));
        while(!ok){
            try{
                System.out.print("処理番号==>");
                opt = Integer.parseInt(br.readLine());
                for(int i = 0; ok == false && i < options.length; i++){
                    if(options[i] == opt)
                        ok = true;
                }
                if(!ok)
                    System.out.println("エラー：無効な処理番号です。");
                else if(opt == options[options.length - 1]){
                    System.out.print("終了しますか。(Y/N)==>");
                    String str = br.readLine();
                    if(!(str.equalsIgnoreCase("Y")))
                        ok = false;
                }
            }catch(NumberFormatException e){
                System.out.println("エラー：入力値が整数ではありません。");
            }
        }
        return opt;
    }
}
package pkex27_extra;

import java.io.*;
import pkstudent_extra.*;
import pkstudent_extra.component.*;

//初期化クラス
public class Init
{
	private StudentMgr mgr;
	
	public Init(StudentMgr mgr)
	{
		this.mgr = mgr;
	}
	public void loadFromFile(String filename) throws IOException
	{
		BufferedReader br =
	  	new BufferedReader(new InputStreamReader
	  	(new FileInputStream(filename),"UTF-8"));
		String line;
		StudentCheck sc = new StudentCheck();
		while((line = br.readLine())!= null){
	  		String data[] = line.split(",");
	  		try{
	    		int no = sc.noCheck(data[0]);
	    		String name = sc.nameCheck(data[1]);
	    		String major = sc.majorCheck(data[2]);
	    		mgr.addData(no,name,major);
	  		}catch(StudentException e){
	    		System.out.println(line + "\t" + e.getMessage());
	  		}catch(NumberFormatException e){
	    		System.out.println(line + "\t" + e.getMessage());
	  		} //IOExceptionはmainで捕捉するため、このクラスのcatchブロックにException eとは書かない
		}
		br.close();
	}
}
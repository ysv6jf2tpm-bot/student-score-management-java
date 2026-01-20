package pkstudent_extra.component;

public class StudentCheck
{
    public int noCheck(String s) throws StudentException
    {
        int no = Integer.parseInt(s);
        if(no < 1 || no > 100)
            throw new StudentException("番号範囲エラー：1～100");
        return no;
    }
    public String nameCheck(String s) throws StudentException
    {
        if(s.length() < 1 || s.length() > 20)
            throw new StudentException("文字数エラー：1～20");
        return s;
    }
    public String majorCheck(String s) throws StudentException
    {
        if(!(s.equalsIgnoreCase("S")) && !(s.equalsIgnoreCase("H")))
			throw new StudentException("専攻区分エラー：S or H");
        return s;
    }
    public int pointCheck(String s) throws StudentException
    {
        int point = Integer.parseInt(s);
        if(point < 0 || point > 100)
            throw new StudentException("点数範囲エラー：0～100");
        return point;
    }
}
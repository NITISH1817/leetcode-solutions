class Solution {
    public String reversePrefix(String word, char ch) {
        char[] ch1=word.toCharArray();
        StringBuilder str=new StringBuilder();
        int y=0;
        for(int i=0;i<ch1.length;i++)
        {
            if (ch1[i]==ch)
            {
                y=i;
                break;
            }
        }
          for(int i=y;i>=0;i--)
        {
            str.append(ch1[i]);
        }
         for(int i=y+1;i<ch1.length;i++)
        {
            str.append(ch1[i]);
        }
        return str.toString();
}}
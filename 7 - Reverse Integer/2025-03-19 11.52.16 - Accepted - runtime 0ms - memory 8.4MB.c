int reverse(int x){
long int cpy=0;
int rem;
while(x!=0)
{
    rem=x%10;
    cpy=cpy*10+rem; 
    if(cpy>INT_MAX || cpy<INT_MIN)
  return 0;
    x=x/10;
}
return (int) cpy;


}
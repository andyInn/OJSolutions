package jiuDuOj_Answers;

public class Main_1556_CPlusPlus {
	public static void main(String[] args) {
		System.out.println();
	}
}
/*
#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
struct node
{
    int t;
    char s[20];
    int flag;
}v[202];
char s[3];
int sta[3][202];
int top[3];
int tail[3];
int a[3];
int main()
{
    int n;
    while(~scanf("%d",&n))
    {
        for(int i=1;i<=n;i++)
        {
            int x,y;
            scanf("%d:%d %s %s",&x,&y,v[i].s,s);
            v[i].t=x*60+y;
            v[i].flag=s[0]-'A';
        }
        memset(tail,0,sizeof(tail));
        for(int i=0;i<=2;i++)
        top[i]=1;
        for(int i=0;i<=2;i++)
        a[i]=-10000;
        for(int i=0;i<1440;i++)
        {
            while(1)
            {
                int e=-1;
                int r=-1;
                for(int j=0;j<=2;j++)
                {
                    if(i-a[j]>=20)
                    {
                        e=j;
                        break;
                    }
                }
                for(int j=0;j<=2;j++)
                {
                    if(tail[j]>=top[j])
                    {
                        r=j;
                        break;
                    }
                }
                if(e==-1||r==-1)
                break;
                a[e]=i;
                printf("%s,landing on runway %d.@%02d:%02d\n",v[sta[r][top[r]]].s,e+1,i/60,i%60);
                top[r]++;
            }
            if(i%20==0)
            {
                for(int j=1;j<=2;j++)
                {
                    if(tail[j]>=top[j])
                    {
                        sta[j-1][++tail[j-1]]=sta[j][top[j]];
                        printf("%s,level up from %c to %c.@%02d:%02d\n",v[sta[j][top[j]]].s,'A'+j,'A'+j-1,i/60,i%60);
                        top[j]++;
                    }
                }
            }
            for(int j=1;j<=n;j++)
            {
                if(v[j].t==i)
                {
                    sta[v[j].flag][++tail[v[j].flag]]=j;
                    printf("hello %s.@%02d:%02d\n",v[j].s,i/60,i%60);
                }
            }
        }
    }
    return 0;
}
/**************************************************************
    Problem: 1556
    User: sleepyhunt
    Language: C++
    Result: Accepted
    Time:50 ms
    Memory:1028 kb
****************************************************************/
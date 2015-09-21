package com.beijing.qunar;

public class _2016死锁检测工具 {

}
/*
别人的代码C++
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


#define N 100  
#define M 100  
struct Edge  
{  
	int v;  
	int next;  
}; 

Edge edge[M]; 
int node[N]; 
int instack[N];
int stack[N];  
int Belong[N]; 
int DFN[N];
int LOW[N]; 
int n, m;
int cnt_edge;
int Index;
int top;  
int Bcnt;


class xc{
public:
	int node;
	vector<int> kep;
	vector<int> req;
	xc(vector<int> k,vector<int> r,int n):kep(k),req(r),node(n){}
	~xc(){}
};

bool binarysearch(vector<int>& v,vector<int> s1){
	if(s1.size()==0) return false;
	int s = s1[0];
	int n = v.size();
	if(n<=0||(n==1&&v[0]!=s)) return 0;
	if(v[0]==s) return 1;
	int begin = 0,end = n-1;
	while(begin<=end){
		int mid = (begin+end)/2;
		if(v[mid]==s)
			return 1;
		if(v[mid]>s)
			end = mid - 1;
		else
			begin = mid + 1;
	}
	return 0;
}

xc getxc(string str,int i){

	vector<int> kep;
	vector<int> req;
	xc myxc(kep,req,i+1);
	int tmp = 0;
	int n = str.length();
	int k = 0;
	while(k<n&&str[k]>='0'&&str[k]<='9')
		++k;
	++k;
	if(k<n&&str[k]==' ') ++k;
	else{
		while(k<n&&str[k]!=' '){
			tmp = 0;
			while(k<n&&str[k]>='0'&&str[k]<='9'){
				tmp = tmp*10 + str[k]-'0';
				++k;
			}
			myxc.kep.push_back(tmp);
			if(k<n&&str[k]==',')
				++k;
		}
	}
	++k;
	if(k<n&&str[k]!=' '){
		tmp = 0;
		while(k<n&&str[k]>='0'&&str[k]<='9'){
			tmp = tmp*10 + str[k]-'0';
			++k;
		}
		myxc.req.push_back(tmp);
	}
	return myxc;
}


void add_edge(int u, int v) 
{  
	edge[cnt_edge].next = node[u];  
	edge[cnt_edge].v = v;  
	node[u] = cnt_edge++;  
}  
void tarjan(int u)  
{  
	int i,j;  
	int v;  
	DFN[u]=LOW[u]=++Index;  
	instack[u]=true;  
	stack[++top]=u;  
	for (i = node[u]; i != -1; i = edge[i].next)  
	{  
		v=edge[i].v;  
		if (!DFN[v])
		{  
			tarjan(v);  
			if (LOW[v]<LOW[u])  
				LOW[u]=LOW[v];  
		}  
		else 
			if (instack[v] && DFN[v]<LOW[u])  
				LOW[u]=DFN[v];  
	}  
	if (DFN[u]==LOW[u])  
	{  
		Bcnt++;  
		do  
		{  
			j=stack[top--];  
			instack[j]=false;  
			Belong[j]=Bcnt;  
		}  
		while (j!=u);  
	}  
}  


void solve()  
{  
	int i;  
	top=Bcnt=Index=0;  
	memset(DFN,0,sizeof(DFN));  
	memset(LOW,0,sizeof(LOW));  
	for (i=1;i<=n;i++)  
		if (!DFN[i])  
			tarjan(i);  
}


int main(){
	int T;
	char ch;
	string str;
	cin>>T;
	ch = getchar();
	vector<xc> x;

	memset(node,-1,sizeof(node));  
	for (int i=0;i<T;i++)
	{
		str = "";
		while((ch=getchar())!='\t'&&ch!='\n'){
			str += ch;
		}
		x.push_back(getxc(str,i));
	}
	n = T;
	m = 0;
	for (int i=0;i<T;i++){
		for(int j=0;j<T;j++){
			if(binarysearch(x[j].kep,x[i].req)){
				++m;
				add_edge(i+1,j+1);
			}
		}
	}
	solve();
	vector<int> num(Bcnt+1,0);
	for (int i=1;i<=n;i++)
	{
		num[Belong[i]]++;
	}
	int cnt = 0;
	for (int i=1;i<=Bcnt;i++)
	{
		if(num[i]>1) cnt++;
	}
	cout << cnt << endl;
	system("pause");
	return 0;
}*/
#include<bits/stdc++.h>
using namespace std;
typedef int INT;
#define int long long
const int INF=1e17;
const int N=2e6+100;
int vis[N]={};
int Prime[N]={};
int idx=0;
void Pre(int maxn){
	for(int i=2;i<=maxn;i++){
		if(!vis[i]){
			idx++;
			Prime[idx]=i;
		}
		for(int j=1;j<=idx&&Prime[j]*i<=maxn;j++){
			vis[i*Prime[j]]=1;
			if(i%Prime[j]==0)break;
		}
	}
}
struct Front_star{
	int u,v,w,c,nxt;
}e[N<<2];
int cnt=1;
int n;
int first[N]={};
void addedge(int u,int v,int w,int c){
	cnt++;
	e[cnt].u=u;
	e[cnt].v=v;
	e[cnt].w=w;
	e[cnt].c=c;
	e[cnt].nxt=first[u];
	first[u]=cnt;
}
void add(int u,int v,int w,int c){
	addedge(u,v,w,c);
	addedge(v,u,0,-c);
}
int S=0;
int T=N-1;
int ans=0;
vector<int> A,B;
int dis[N];
int inqueue[N];
int pre[N];
queue<int> Q;
bool SPFA(){
    memset(pre,0,sizeof(pre));
    for(int i=S;i<=T;i++){
        dis[i]=-INF;
    }
    dis[S]=0;
    Q.push(S);
    while(!Q.empty()){
        int x=Q.front();
        Q.pop();
        inqueue[x]=0;
        for(int i=first[x];i;i=e[i].nxt){
            int v=e[i].v;
            if(e[i].w&&dis[x]+e[i].c>dis[v]){
                dis[v]=dis[x]+e[i].c;
                pre[v]=i;
                if(!inqueue[v]){
                    Q.push(v);
                    inqueue[v]=1;
                }
            }
        }
    }
    return dis[T]>=0;
}
void MCMF(int ans){
    int dat=0;
    while(SPFA()){
        int s=INF;
        for(int i=pre[T];i;i=pre[e[i^1].v])s=min(s,e[i].w);
        for(int i=pre[T];i;i=pre[e[i^1].v]){
            e[i].w-=s;
            e[i^1].w+=s;
        }
        dat+=s;
        ans+=dis[T]*s;
    }
    cout<<ans+1;
}
int Get(int n,int t){
	int ret=t;
	while(ret*t<=n){
		ret=ret*t;
	}
	return ret;
}
int Build_Gra(){
	for(int i=1;i<=idx;i++){
		int t=Prime[i];
		if(Prime[i]*2>n)ans+=Prime[i];
		else{
			if(t*t<=n){
				ans+=Get(n,t);
				add(S,i,1,0);
				A.push_back(i);
			}
			else{
				add(i,T,1,0);
				ans+=t;
				B.push_back(i);
			}
		}
	}
	for(int i=0;i<A.size();i++){
		for(int j=0;j<B.size();j++){
			int a=Prime[A[i]];
			int b=Prime[B[j]];
			if(a*b<=n){
				int tmp=Get(n/b,a)*b;
				if(tmp>Get(n,a)+b){
					add(A[i],B[j],1,tmp-Get(n,a)-b);
				}
			}
			else break;
		}
	}
}
INT main(){
	freopen("test.in","r",stdin);
	cin>>n;
	Pre(n);
	Build_Gra();
	MCMF(ans);
}

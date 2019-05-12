package leetcodeOJ;

public class _1020NumEnclaves {
    /*public int numEnclaves(int[][] A) {
        int m=A.length,n=A[0].length;
        Vector<Vector<Boolean>> used(m,vector<bool>(n,false));
        queue<pair<int,int>> qq;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(A[i][j]==1){
                    if(i==0||i==m-1||j==0||j==n-1){
                        qq.push(make_pair(i,j));
                        used[i][j]=true;
                    }
                }
            }
        int dd[][2]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!qq.empty()){
            auto p=qq.front();
            qq.pop();
            for(int i=0;i<4;i++){
                int x=p.first+dd[i][0];
                int y=p.second+dd[i][1];
                if(x<0||x>=m||y<0||y>=n) continue;
                if(A[x][y]==0||used[x][y]) continue;
                qq.push(make_pair(x,y));
                used[x][y]=true;
            }
        }

        int ans=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(A[i][j]==1&&!used[i][j]){
                    ans++;
                }
            }
        return ans;
    }*/
}

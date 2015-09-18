package com.beijing.jd;
/*#include<iostream>
#include<vector>
using namespace std;

int main()
{
	vector< vector<int> > grid(6, vector<int>(6,0));
	for(int i = 0 ; i < 6; ++i){
		for(int j = 0 ; j < 6 ; ++j)
			cin>>grid[i][j];
	}

	for(int i = 1 ; i < 6 ; ++i){
		grid[0][i] += grid[0][i-1];
	}

	for(int i = 1 ; i < 6 ; ++i){
		grid[i][0] += grid[i-1][0];
	}


	for(int i = 1 ; i < 6 ; ++i){
		for(int j = 1 ; j < 6 ; ++j){
			grid[i][j] += max(grid[i-1][j], grid[i][j-1]);
		}
	}

	cout<<grid[5][5]<<endl;

	return 0;
}*/
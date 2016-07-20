#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
class Solution {
public:
    int rob(vector<int> &num) {
		int result=0;
		for(int i=0;i<int(num.size()-1);i++){
			for(int j=i+2;j<num.size();j++){
				if(result<num[i]+num[j])
					result = num[i]+num[j];
				}
			}
        return result;
}
};

int main() {
	// your code goes here
	int i[10]={10,9,8,7,6,5,4,3,2,1};
	vector<int> num1(i,i+10);
	Solution *solution = new Solution();
	cout<<solution->rob(num1);
	system("pause");
	return 0;
}

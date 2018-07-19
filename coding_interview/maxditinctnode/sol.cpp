#include <iostream>
#include <unordered_map>
using namespace std;

struct Node {
	int data;
	struct Node *left, *right;
};

Node* newNode(int data)
{
    Node* temp = new Node;
	temp->data = data;
	temp->left = temp->right = NULL;
	return temp;
}

int pathFindByHash(Node* node, unordered_map<int, int> m){
    if(!node)
	    return m.size();
	m[node->data]++;
	int max_path = max( pathFindByHash(node->left,m), pathFindByHash(node->right,m) );
	
	if(m[node->data] == 0)
		m.erase(node->data);

	return max_path;
}

int maxUniquePath(Node* node) {
    if (!node)
	    return 0;
	unordered_map<int,int> hash;
	return pathFindByHash(node,hash);
}

int main()
{
    Node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);
    root->right->left->right = newNode(8);
    root->right->right->right = newNode(9);
 
    cout << maxUniquePath(root) << endl;
 
    return 0;
}

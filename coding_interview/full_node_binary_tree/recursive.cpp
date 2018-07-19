#include <iostream>
using namespace std;

struct Node
{
    int data;
	struct Node* left, *right;
};

unsigned int count(struct Node* root)
{
    if ( root == NULL )
	    return 0;
	int res = 0;
	if ( root -> left && root -> right ) 
	    res++;
	
	res += (count(root->left) + count(root->right));
	return res;
}


struct Node* newNode(int data)
{
    struct Node* node = new Node;
	node->data = data;
	node->left = node->right = NULL;
	return (node);
}

int main(void)
{
   struct Node * root = newNode(2);
   root->left = newNode(8);
   root->right = newNode(6);
   root->left->right = newNode(7);
   root->left->right->left = newNode(1);
   root->left->right->right = newNode(12);
   root->right->right = newNode(10);
   root->right->right->left = newNode(4);
   root->right->right->right= newNode(11);
   cout << count(root) << endl;
   return 0;
}

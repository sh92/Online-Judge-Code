bool findDuplicate(vector<Type>& keys) {
    unordered_set<Type> hashset;
    for(Type key : keys) { 
        if (hashset.count(key) > 0 ) {
            return true;
        }
        hashset.insert(key);
    }
    return false;
}

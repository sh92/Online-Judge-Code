
boolean findDuplicates(List<Type>& type) {

    Set<Type hanhset = new HashSet<>();
    for (Type key: keys) {
        if (hashset.contains(key)) { 
            return true;
        }
        hashset.insert(key);
    }
    return false;
}

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        
        return dfs(id, map);
    }
    
    public int dfs(int id, Map<Integer, Employee> map){
        int sum=0;
        
        for(int ind : map.get(id).subordinates)
            sum += dfs(ind, map);
        
        return sum+map.get(id).importance;
    }
}
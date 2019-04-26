
/**

There are many types of java maps such as HashMap, LinkedHashMap, TreeMap, EnumMap,
WeakHashMap, HashTable and CurrentHashMap


* HashMap class methods

* void clear()
Removes all of the mappings from this map

* Object clone()
Returns a shallow copy of this HashMap instance: the keys and values themselves
are not cloned

* boolean containsKey(Object key)
Returns true if this map contains a mapping for the specified key

* boolean containsValue(Object value)
Returns true if this map maps one or more keys to the specified value

* Set<Map.Entry<K,V>> entrySet()
Returns a Set view of the mappings contained in this map

* V get(Object key)
Returns the value to which the specified key is mapped, or null if this map
contains no mapping for the key

* boolean isEmpty()
Returns true if this map contains no key-value mappings

* Set<K> keySet()
Returns a Set view of the keys contained in this map

* V put(K key, V value)
Associates the specified value with the specified key in this map

* void putAll(Map<? extends K,? extends V> m)
Copies all of the mappings from the specified map to this map

* V remove(Object key)
Removes the mapping for the specified key from this map if present

* int size()
Returns the number of key-value mappings in this map

* Collection<V> values()
Returns a Collection view of the values contained in this map.

*/

import java.util.HashMap;

public class Section_6_8_Maps {
    
    public static void main(String[] arguments){
        
        HashMap<Integer, Employee> employeesMap = new HashMap();
        
        employeesMap.put(1234, new Employee("Daniel Perez", 2100.55));
        employeesMap.put(9876, new Employee("Jose Monrroy", 5000.00));
        employeesMap.put(1001, new Employee("Ricardo Duran", 9999.99));
        employeesMap.put(5555, new Employee("Jesus Colmenares", 100100.00));
        employeesMap.put(3434, new Employee("David Torres", 5500.99));
        
        System.out.println(employeesMap);
        
        System.out.println("----------------------------------------------------");
        
        employeesMap.remove(1001);
        
        System.out.println(employeesMap);
        
        System.out.println("----------------------------------------------------");
        
        /*
        If we try to insert a element whit repeated key, the element will be
        replaced whit the last element inserted.
        */
        
        employeesMap.put(3434, new Employee("Grant Imajara", 100000.89));
        
        System.out.println(employeesMap);
    }
}

class Employee{
    
    private String name;
    private double wage;
    
    public Employee(String name, double wage){
        this.name = name;
        this.wage = wage;
    }
    
    /**
     * @return a string whit all attributes of the object
     */
    public String toString(){
        return "[Name: " + this.name + ", Wage: " + this.wage + "]\n";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the wage
     */
    public double getWage() {
        return wage;
    }

    /**
     * @param wage the wage to set
     */
    public void setWage(double wage) {
        this.wage = wage;
    }
}
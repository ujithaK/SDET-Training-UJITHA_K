package org.example.CollectionsOperations;

import java.util.*;

public class CollectionsOperation {
    public static void ArrayListt() {
        Scanner s = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("Select option First add items to do the operations");
            System.out.println("1. Add Items");
            System.out.println("2. Search Item");
            System.out.println("3. Remove by Index");
            System.out.println("4 Remove by value");
            System.out.println("5. Sort List");
            System.out.println("6 Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How many names to add?");
                    int n = s.nextInt();
                    System.out.println("Enter " + n + " names:");
                    for (int i = 0; i < n; i++) {
                        list.add(s.next());
                    }
                    System.out.println(list);
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchItem = s.next();
                    if (list.contains(searchItem)) {
                        System.out.println(searchItem + " found ");
                    } else {
                        System.out.println(searchItem + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to remove: ");
                    int index = s.nextInt();
                    if (index >= 0 && index < list.size()) {
                        list.remove(index);
                        System.out.println("Updated List: " + list);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.print("Enter value to remove: ");
                    String value = s.next();
                    if (value!=null) {
                        list.remove(value);
                        System.out.println("Updated List: " + list);
                    } else {
                        System.out.println("Invalid valuee or value might be null!");
                    }
                    break;

                case 5:
                    Collections.sort(list);
                    System.out.println("List sorted: " + list);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);
    }

    public static void hashmapp(){
        Scanner s=new Scanner(System.in);
        Map<String,Integer> names=new HashMap<>();
        int n=3;
        System.out.println("Enter 3 people names along with ages");

        while(n>0){
            names.put(s.next(),s.nextInt());
            n--;
        }
        System.out.println(names);

        // Get value
        System.out.println("enter name to Get");
        String key = s.next();
        Integer value = names.get(key);

        if (value != null) {
            System.out.println(  key + " age is " + value);
        } else {
            System.out.println( " not found");
        }

        // Remove key
        System.out.println("enter a value to remove");
        String val=s.next();
        names.remove(val);
        System.out.println("After removing : "+val +"  "+ names);

        // Iterate entries

        System.out.println("Iterating through entries:");
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }


    }
    public static void hashsett(){
        // Create HashSet
        HashSet<String> set = new HashSet<>();

        //Adding items
        set.add("ujitha");
        set.add("manasa");
        set.add("ujitha");
        set.add("padma");
        set.add("padma");
        set.add("Gayathri");


        System.out.println(set);


        // Iterate items

        System.out.println("\nIterating through items:");
        for (String item : set) {
            System.out.println(item);
        }


        // Check contains()

        String search = "ujitha";
        if (set.contains(search)) {
            System.out.println("\nSet contains: " + search);
        } else {
            System.out.println("\nSet does NOT contain: " + search);
        }
    }
    public static void performanceComparison() {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        int ch;

        do {
            System.out.println("\n==== Performance Comparison Menu ====");
            System.out.println("1. Queue (LinkedList)");
            System.out.println("2. ArrayList vs LinkedList (add/search/remove)");
            System.out.println("3. HashSet vs ArrayList (search)");
            System.out.println("4. HashMap vs ArrayList (lookup)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {

                // Queue operations
                case 1:
                    System.out.print("Enter item to add to Queue: ");
                    queue.add(sc.next());
                    System.out.println("Removed from Queue (poll): " + queue.poll());
                    System.out.println("Peek at Queue: " + queue.peek());
                    System.out.println("Current Queue: " + queue);
                    break;

                // ArrayList vs LinkedList
                case 2:
                    int n = 30000;
                    List<Integer> al = new ArrayList<>();
                    List<Integer> ll = new LinkedList<>();

                    // Add
                    long t1 = System.nanoTime();
                    for (int i = 0; i < n; i++) al.add(i);
                    long t2 = System.nanoTime();
                    System.out.println("ArrayList adding elements time: " + (t2 - t1) + " ns");

                    t1 = System.nanoTime();
                    for (int i = 0; i < n; i++) ll.add(i);
                    t2 = System.nanoTime();
                    System.out.println("LinkedList adding elements time: " + (t2 - t1) + " ns");

                    // ArrayList vs LinkedList: SEARCH
                    t1 = System.nanoTime();
                    al.contains(n - 1);
                    t2 = System.nanoTime();
                    System.out.println("ArrayList searching element time: " + (t2 - t1) + " ns");

                    t1 = System.nanoTime();
                    ll.contains(n - 1);
                    t2 = System.nanoTime();
                    System.out.println("LinkedList searching an element time: " + (t2 - t1) + " ns");


                     //ArrayList vs LinkedList: REMOVE
                    // Remove last element
                    t1 = System.nanoTime();
                    al.remove(al.size() - 1);
                    t2 = System.nanoTime();
                    System.out.println("Time took by ArrayList to remove last element: " + (t2 - t1) + " ns");

                    t1 = System.nanoTime();
                    ll.remove(ll.size() - 1);
                    t2 = System.nanoTime();
                    System.out.println("Time took by LinkedList to remove last element:: " + (t2 - t1) + " ns");
                    break;

                // HashSet vs ArrayList search
                case 3:
                    ArrayList<Integer> arr = new ArrayList<>();
                    HashSet<Integer> set = new HashSet<>();
                    for (int i = 0; i < 50000; i++) {
                        arr.add(i);
                        set.add(i);
                    }

                    t1 = System.nanoTime();
                    arr.contains(49999);
                    t2 = System.nanoTime();
                    System.out.println("ArrayList search time: " + (t2 - t1) + " ns");

                    t1 = System.nanoTime();
                    set.contains(49999);
                    t2 = System.nanoTime();
                    System.out.println("HashSet search time: " + (t2 - t1) + " ns");
                    break;

                // HashMap vs List: LOOKUP
                case 4:
                    int size = 50000;
                    HashMap<Integer, String> map = new HashMap<>();
                    ArrayList<String> list = new ArrayList<>();

                    for (int i = 0; i < size; i++) {
                        map.put(i, "Value" + i);
                        list.add("Value" + i);
                    }

                    // HashMap lookup
                    t1 = System.nanoTime();
                    map.get(49999);
                    t2 = System.nanoTime();
                    System.out.println("HashMap lookup by key: " + (t2 - t1) + " ns");

                    // ArrayList lookup by index
                    t1 = System.nanoTime();
                    list.get(49999);
                    t2 = System.nanoTime();
                    System.out.println("ArrayList lookup by index: " + (t2 - t1) + " ns");

                    // ArrayList lookup by value
                    t1 = System.nanoTime();
                    list.contains("Value49999");
                    t2 = System.nanoTime();
                    System.out.println("ArrayList lookup by value (contains): " + (t2 - t1) + " ns");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (ch != 5);

        sc.close();
    }

public static void main(String[] args) {
        ArrayListt();
//        hashmapp();
//        hashsett();
//   performanceComparison();

}
}


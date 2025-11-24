package org.example.Arrayylist;

import java.util.*;

public class ArrayListOperations {
    public static void ArrayListt() {
        Scanner s = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("Select option");
            System.out.println("1. Add Items");
            System.out.println("2. Search Item");
            System.out.println("3. Remove by Index");
            System.out.println("4. Sort List");
            System.out.println("5. Exit");
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
                        System.out.println(searchItem + " found at index " + list.indexOf(searchItem));
                    } else {
                        System.out.println(searchItem + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to remove: ");
                    int index = s.nextInt();
                    if (index >= 0 && index < list.size()) {
                        System.out.println("Removed: " + list.remove(index));
                        System.out.println("Updated List: " + list);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    Collections.sort(list);
                    System.out.println("List sorted: " + list);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
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
    public static void performanceComparision() {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        int ch;

        do {
            System.out.println("\n1. Queue (LinkedList)");
            System.out.println("2. ArrayList vs LinkedList");
            System.out.println("3. HashSet vs ArrayList (Search)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                // Queue
                case 1:
                    System.out.print("Enter item to add: ");
                    queue.add(sc.next());
                    System.out.println( queue.poll());
                    System.out.println(queue.peek());
                    System.out.println(queue);
                    break;


                // ArrayList vs LinkedList
                case 2:
                    int n = 30000;
                    List<Integer> al = new ArrayList<>();
                    List<Integer> ll = new LinkedList<>();

                    long t1 = System.nanoTime();
                    for (int i = 0; i < n; i++) al.add(i);
                    long t2 = System.nanoTime();
                    System.out.println("ArrayList time taken to add : " + (t2 - t1));
//  t2=end time and t1 start time(end-start)
                    t1 = System.nanoTime();
                    for (int i = 0; i < n; i++) ll.add(i);
                    t2 = System.nanoTime();
                    System.out.println("LinkedList time taken to add: " + (t2 - t1));

                    break;

                // HashSet vs ArrayList

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
                    System.out.println("ArrayList search: " + (t2 - t1));

                    t1 = System.nanoTime();
                    set.contains(49999);
                    t2 = System.nanoTime();
                    System.out.println("HashSet search: " + (t2 - t1));
                    break;

                case 4:
                    System.out.println("Bye!");
                    break;
            }

        } while (ch != 4);
    }
    static void main(String[] args) {
//        ArrayListt();
//        hashmapp();
//        hashsett();
//        performanceComparision();
    }
}

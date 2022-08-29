package com.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestAndRun {
	
	public static void main(String[] args) {
		
		
		
//		
//		HashMap<String, Integer> map = new HashMap<>();
//		
//		map.put("One", 1);
//		map.put("Two", 2);
//		map.put("Three", 3);
//		map.put("Four", 4);
	
		
		
		Map<Integer, Order> orderMap = new ConcurrentHashMap();
		
		orderMap.put(101,new Order(201, "vendor", "Hydrolic"));
		orderMap.put(108,new Order(209, "dotted", "Engine"));
		orderMap.put(106, new Order(203, "english", "Filter"));
		orderMap.put(109, new Order(202, "indian", "Carborator"));
		
		
		orderMap.entrySet().stream().sorted(Map.Entry.comparingByValue(
				Comparator.comparing(Order::getOrderType)))
		.forEach(System.out::println);
		
		System.exit(0);
		
		
//****************	1.	 Counting Empty String
		
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "", "ajk", "tj");
		
		System.out.println("This is the Input String for Below all output:-  "+strList);
		
		Long countEmptyString = strList.stream().filter(s->s.equals("")).count();
		
		System.out.println("1.   Prining the  Empty String count here:-  "+ countEmptyString);
		

		
//****************	2. Count String whose length is more than three
		Long countStringLength = strList.stream().filter(s->s.length()>=3).count();
		
		System.out.println("2.   Printing the String count whose length is equal or more than 3 character. "+countStringLength);
		
		
//****************	3. Count number of String which starts with "a"

		Long countStringLengthStartWithA =  strList.stream().filter(s->s.startsWith("a")).count();
		
		System.out.println("3.   Printing the String count whose start with A "+countStringLengthStartWithA);
		
		
		
//****************	4.	Remove all empty Strings from List	
		
		List<String> list = strList.stream().filter(s->!s.equals("")).collect(Collectors.toList());
		
		System.out.println("4.   Printing all String after removing the empty Strings "+list);
			
			
//		System.exit(0);
		
//****************	5.  Create a List with String more than 2 characters
		
		List<String> listOfStringWhoseCountHaveMoreThanTwo = strList.stream().filter(s-> s.length()>2)
				.collect(Collectors.toList());
		
		System.out.println("5.   Printing the list of String whose have length more than two "+ listOfStringWhoseCountHaveMoreThanTwo);

//****************	6.	Java 8 Map functional Example: Convert non Empty String to uppercase and Join them with comma
		
		List<String> strList1 = Arrays.asList("abc", "bcd", "ajk", "tj");

		String string = strList1.stream().map(s-> s.toUpperCase()).collect(Collectors.joining(","));
		
		System.out.println("6.   Printing the String with comma separated.   "+string);
		
		
//**************** 7.  Java 8 Map Example 2: Create a List of the square of all distinct numbers
		
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

		List<Integer> result = numbers.stream().distinct().map(s->s*s).collect(Collectors.toList());
		
		System.out.println("7.   Printing the Integer Value in square after removing the duplicate value  "+result);
		
		
//****************	8. Java 8 Statistics Example: Get count, min, max, sum, and the average for numbers

		
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); 
		
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x) .summaryStatistics();
		
		System.out.println(stats);

		
		System.exit(0);
		
//****************		Find the duplicate and return the duplicate the list
		
		List<String> listOfString = Arrays.asList("2","1","8","3","5","2","8","1");
		
		Set<Integer> set = new HashSet<>();
		
		listOfString.stream().map(s->Integer.valueOf(s)).filter(n->!set.add(n))//.collect(Collectors.toSet());
		
		.collect(Collectors.toSet()).forEach(System.out::println);
		
//		System.out.println(set);
		
//		Find the duplicate recrods of the list
//		Map<Integer, Order> orderMap = new ConcurrentHashMap();
//		
//		orderMap.put(101,new Order(201, "vendor", "Hydrolic"));
//		orderMap.put(108,new Order(209, "dotted", "Engine"));
//		orderMap.put(106, new Order(203, "english", "Filter"));
//		orderMap.put(109, new Order(202, "indian", "Carborator"));
//		
//		orderMap.entrySet().stream().sorted(Map.Entry.comparingByValue
//				(Comparator.
//				 comparing(Order::getOrderType).reversed()))
//				.forEach(System.out::println);
//		
//		Map result = orderMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
//		.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getValue,
//				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
//		
//		
//		System.out.println(result);
		
//		System.out.println("Before sorting the order:- "+ orderList);
////		orderList.stream().sorted(Comparator.comparing(Order::getOrderName)).forEach(System.out::println);
//		
//		Map result = orderList.entrySet().stream()
//				.sorted(Map.Entry.comparingByKey()) 			
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
//		
//		System.out.println(orderList);
//		
//		System.out.println(result);
		
		
		
//		List Sorting.....
		
//		Arrays.asList(2,5,6,1,3,7).stream().sorted((o1,o2)->o2.compareTo(o1))
//				.collect(Collectors.toList()).forEach(System.out::println);

		
//		Predicate<Integer> predicate = (num) -> num ==2022;
//		System.out.println(predicate.test(2022));
//		System.out.println(predicate.test(2020));
		
		
		
//		Arrays.asList(2,5,6,1,3,7).stream().sorted((o1,o2)->o1.compareTo(o2))
//				.collect(Collectors.toList()).forEach(System.out::println);
//		
//		Arrays.asList(2,5,6,1,3,7).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
//		.forEach(System.out::println);
	}
}

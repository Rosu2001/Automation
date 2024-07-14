import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Java22Streams {
	@Test
	public static void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Roshan");
		names.add("Rosu");
		names.add("Kanhaiya");
		names.add("Dibakar");
		names.add("Mayank");

		int count = 0;
		System.out.println("Names in regular ArrayList :");
		for (String name : names) {
			if (name.startsWith("R")) {
				System.out.println(name);
				count++;
			}
		}
		System.out.println("Count in regular Arraylist : " + count);
	}

	@Test
	public static void stream() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Roshan");
		names.add("Rosu");
		names.add("Kanhaiya");
		names.add("Dibakar");

		Long c = names.stream().filter(s -> s.startsWith("R")).count();
		System.out.println("Count in Stream : " + c);

//		There is no life for intermediate operation if there is no terminal operation
//		Terminal operation will only execute if intermediate(filter) return true
//		We can create stream 

		long d = Stream.of("Roshan", "Rosu", "Kanhaiya", "Dibakar").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		System.out.println("Count in Stream multiline : " + d);

//		Print all the name
		System.out.println("Names > 4 using stream filter are : ");
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		System.out.println("Names > 4 using stream filter for limit 1 : ");
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	@Test
	public static void map() {
//		Names end with n, convert to upper case
		System.out.println("Name ends with n and convert to upper case :");
		Stream.of("Roshan", "Rosu", "Kanhaiya", "Dibakar").filter(s -> s.endsWith("n")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		
//		Names start with R, convert to upper case and sorted order
		System.out.println("Name starts with R, convert to upper case and print in sorted order :");
		Stream.of("Roshan", "Rosu", "Kanhaiya", "Dibakar").filter(s -> s.startsWith("R")).map(s -> s.toUpperCase())
				.sorted().forEach(s -> System.out.println(s));
		
//		U have 2 list concatenate the both and get the result
		List<String> l1=Arrays.asList("Roshan","Rosu");
		List<String> l2=Arrays.asList("Man","Boy");
		System.out.println("After two list concatenate :");
		Stream<String> newStream=Stream.concat(l1.stream(), l2.stream());
		newStream.sorted().forEach(s -> System.out.print(s+","));
//		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("boy"));
//		Assert.assertTrue(flag);
	}
	
	
	@Test
	public static void collect() {
		List<String> list=Stream.of("Roshan", "Rosu", "Kanhaiya", "Dibakar").filter(s -> s.endsWith("n")).map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println("Convert to list using stream :");	
		System.out.println(list.get(0));
		
		List<Integer> num=Arrays.asList(1,2,2,5,3,7,5,0,7);
		num.stream().distinct().sorted().forEach(s->System.out.print(s));
//		Get third index
		List<Integer> li=num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regular();
		stream();
		map();
		collect();
	}

}

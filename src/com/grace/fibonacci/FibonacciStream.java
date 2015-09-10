package com.grace.fibonacci;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibonacciStream {
	public BigInteger sumFionacci(){
		Stream<BigInteger> fibonacci = Stream.generate(new FibonacciSupplier());
//		fibonacci.filter(pre -> pre.mod(new BigInteger("3")).intValue() == 0).limit(100)
//			.forEach(System.out::println);
		return fibonacci.filter(pre -> pre.mod(new BigInteger("3")).intValue() == 0).limit(100)
				.reduce(BigInteger.ZERO,(sum, item) -> sum.add(item.multiply(item)));
	}
	
	public static void main(String[] args){
		FibonacciStream fs = new FibonacciStream();
		System.out.println(fs.sumFionacci());
	}
}

class FibonacciSupplier implements Supplier<BigInteger> {
	BigInteger first = BigInteger.ZERO;
	BigInteger second = BigInteger.ONE;
	
	@Override
	public BigInteger get() {
		BigInteger next = first.add(second);
		first = second;
		second = next;
		return first;
	}
}

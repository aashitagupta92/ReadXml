package com.sample.readdata;

public class test {

	public static void main(String[] args) {
		test tes = new test();
		A obj = new B();
		obj.m1();
		//B.m1();
	}

	 static class A{
		static void m1(){
			System.out.println("Calling class A M1 method...........");
		}
	}
	
	static class B extends A{
		static void m1(){
			System.out.println("Calling class B M1 method...........");
		}
	}
}

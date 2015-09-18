package com.cun.java.oop;

class A {
	int a;
	int b;

	A() {
		System.out.println("Constructor A()");
	}

	void foo() {
		System.out.println("A: foo()");
	}
}

class B extends A {
	int a;
	int b;

	B() {
		System.out.println("Constructor B()");
	}

	void foo() {
		System.out.println("B: foo()");
	}
}

public class ___C extends B {
	int a;
	int bbb;

	___C() {
		System.out.println("Constructor C()");
	}

	void foo() {
		System.out.println("C: foo()");
	}

	public static void main(String... strings) {
		A o_a1 = new A();
		A o_a2 = new B();
		A o_a3 = new ___C();
		B o_b1 = new ___C();
		o_a1.foo();
		o_a2.foo();
		o_a3.foo();
		o_b1.foo();
		
//		B o_b = (B) new A();// Type mismatch: cannot convert from A to B
//		___C o_c = (___C) new A();// Type mismatch: cannot convert from A to C
//		o_b.foo();
//		o_c.foo();
	}
}
package com.demo.test;

import java.util.Vector;

public class TestVector2 {

	public static void main(String[] args) {
		Vector<Integer> v=new Vector(20,3);
		for(int i=0;i<22;i++) {
			v.add(i);
		}
		System.out.println("size:"+v.size());
		System.out.println("capacity:"+v.capacity());

	}

}

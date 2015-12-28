package br.com.fiap.teste;

import static java.lang.System.out;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteReflection {

	enum ClassMember {
		CONSTRUCTOR, FIELD, METHOD, CLASS, ALL
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome da Classe: ");
		String nomeDaClasse = sc.next();
		out.format("%n%n ****************************** %n%n");
		carregarClasseReflection(nomeDaClasse);
		
	}

	private static void carregarClasseReflection(String nomeDaClasse)
			throws ClassNotFoundException {
		Class<?> c = Class.forName(nomeDaClasse);

		System.out.println(String.format("Class:%n  %s%n%n",
				c.getCanonicalName()));

		System.out.println(String.format("Modifiers:%n  %s%n%n",
				Modifier.toString(c.getModifiers())));

		out.format("Type Parameters:%n");
		TypeVariable[] tv = c.getTypeParameters();
		if (tv.length != 0) {
			out.format("  ");
			for (TypeVariable t : tv)
				out.format("%s ", t.getName());
			out.format("%n%n");
		} else {
			out.format("  -- No Type Parameters --%n%n");
		}

		out.format("Implemented Interfaces:%n");
		Type[] intfs = c.getGenericInterfaces();
		if (intfs.length != 0) {
			for (Type intf : intfs)
				out.format("  %s%n", intf.toString());
			out.format("%n");
		} else {
			out.format("  -- No Implemented Interfaces --%n%n");
		}

		out.format("Inheritance Path:%n");
		List<Class> l = new ArrayList<Class>();
		printAncestor(c, l);
		if (l.size() != 0) {
			for (Class<?> cl : l)
				out.format("  %s%n", cl.getCanonicalName());
			out.format("%n");
		} else {
			out.format("  -- No Super Classes --%n%n");
		}

		out.format("Annotations:%n");
		Annotation[] ann = c.getAnnotations();
		if (ann.length != 0) {
			for (Annotation a : ann)
				out.format("  %s%n", a.toString());
			out.format("%n");
		} else {
			out.format("  -- No Annotations --%n%n");
		}

		Package p = c.getPackage();
		out.format("Package:%n  %s%n%n", (p != null ? p.getName()
				: "-- No Package --"));

		printMembers(c.getConstructors(), "Constructor");
		printMembers(c.getFields(), "Fields");
		printMembers(c.getMethods(), "Methods");
		printClasses(c);
	}

	private static void printAncestor(Class<?> c, List<Class> l) {
		Class<?> ancestor = c.getSuperclass();
		if (ancestor != null) {
			l.add(ancestor);
			printAncestor(ancestor, l);
		}
	}

	private static void printMembers(Member[] mbrs, String s) {
		out.format("%s:%n", s);
		for (Member mbr : mbrs) {
			if (mbr instanceof Field)
				out.format("  %s%n", ((Field) mbr).toGenericString());
			else if (mbr instanceof Constructor)
				out.format("  %s%n", ((Constructor) mbr).toGenericString());
			else if (mbr instanceof Method)
				out.format("  %s%n", ((Method) mbr).toGenericString());
		}
		if (mbrs.length == 0)
			out.format("  -- No %s --%n", s);
		out.format("%n");
	}

	private static void printClasses(Class<?> c) {
		out.format("Classes:%n");
		Class<?>[] clss = c.getClasses();
		for (Class<?> cls : clss)
			out.format("  %s%n", cls.getCanonicalName());
		if (clss.length == 0)
			out.format("  -- No member interfaces, classes, or enums --%n");
		out.format("%n");
	}

}

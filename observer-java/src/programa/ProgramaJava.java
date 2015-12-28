package programa;

import java.util.Scanner;

import br.com.fiap.aop.Subject;
import br.com.fiap.aop.impl.BinObserver;
import br.com.fiap.aop.impl.HexObserver;
import br.com.fiap.aop.impl.OctObserver;

public class ProgramaJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subject subject = new Subject();
		new BinObserver(subject);
		new HexObserver(subject);
		new OctObserver(subject);
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Digite um numero: ");
			subject.setState(sc.nextInt());
		}

	}

}

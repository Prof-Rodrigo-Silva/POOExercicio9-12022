package classeexecutavel;

import javax.swing.JOptionPane;

import model.Agenda;
import model.Compromisso;

public class ClasseExecutavel {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		agenda.setNome(JOptionPane.showInputDialog("Informe o nome do Usuário: "));
		agenda.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano: ")));

		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos compromissos: "));

		for(int i = 1; i <= qtd; i++) {
			Compromisso compromisso = new Compromisso();
			compromisso.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia: ")));
			compromisso.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o mes: ")));
			compromisso.setDescricao(JOptionPane.showInputDialog("Informe a descrição: "));

			agenda.addCompromisso(compromisso);
		}

		System.out.println(agenda);
		System.out.println("--- Lista de compromissos ---");
		for(Compromisso c: agenda.getCompromissos())
			System.out.println(c);

		int rep = 0;
		do {
			rep = JOptionPane.showConfirmDialog(null, "Deseja remover um compromisso ? ");
			if(rep == 0) {
				if(agenda.getSizeList()) {
					int dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia: "));
					int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o mes: "));
					//agenda.removeCompromisso(dia, mes);
					System.out.println(agenda.removeCompromisso(dia, mes));

				}else {
					JOptionPane.showMessageDialog(null, "Lista Vazia");
					rep = 1;
				}

			}else {
				rep = 1;
			}			
		}while(rep == 0);

		System.out.println();
		System.out.println(agenda);
		System.out.println("--- Lista de compromissos ---");
		if(agenda.getCompromissos().size() != 0) {
			for(Compromisso c: agenda.getCompromissos())
				System.out.println(c);
		}else {
			System.out.println("A lista está vazia!!");
		}

	}

}

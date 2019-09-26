package br.edu.cesmac.noticia;

import java.io.IOException;

import br.edu.cesmac.manipulador.ManipuladorEditoria;
import br.edu.cesmac.manipulador.ManipuladorJornalista;
import br.edu.cesmac.model.Editoria;
import br.edu.cesmac.model.Jornalista;
import br.edu.cesmac.view.EditoriaView;
import br.edu.cesmac.view.GerenciadorView;
import br.edu.cesmac.view.JornalistaView;

public class Gerenciador {

	public static void main(String[] args) throws IOException {
		GerenciadorView gerenciadorView = new GerenciadorView();
		EditoriaView editoriaView = new EditoriaView();
		JornalistaView jornalistaView = new JornalistaView();

		ManipuladorEditoria manipuladorEditoria = new ManipuladorEditoria();
		ManipuladorJornalista manipuladorJornalista = new ManipuladorJornalista();

		int opcaoMenuPrincipal = 0;
		int opcaoSubmenu = 0;

		while (opcaoMenuPrincipal != 4) {
			opcaoMenuPrincipal = gerenciadorView.montarMenuPrincipal();

			if (opcaoMenuPrincipal == 1) {

				while (opcaoSubmenu != 5) {
					opcaoSubmenu = gerenciadorView.montarMenuEditoria();

					if (opcaoSubmenu == 1) {
						manipuladorEditoria.cadastrar(editoriaView.ler());
					} else if (opcaoSubmenu == 2) {
						manipuladorEditoria.alterar(editoriaView.ler());
					}else if (opcaoSubmenu == 3) {
						manipuladorEditoria.listar();
						Editoria e = manipuladorEditoria.getById(editoriaView.lerId());
						
						if (e == null) {
							System.out.println("Editoria n�o encontrada!");
						} else {
							manipuladorEditoria.excluir(editoriaView.ler());
						}
	
					} else if (opcaoSubmenu == 4) {
						manipuladorEditoria.listar();
					}
				}
			}
				
				if (opcaoMenuPrincipal == 2) {

					while (opcaoSubmenu != 5) {
						opcaoSubmenu = gerenciadorView.montarMenuJornalista();

						if (opcaoSubmenu == 1) {
							manipuladorJornalista.cadastrar(jornalistaView.ler());
						} else if (opcaoSubmenu == 2) {
							manipuladorJornalista.alterar(jornalistaView.ler());
						}else if (opcaoSubmenu == 3) {
							manipuladorJornalista.listar();
							Jornalista j = manipuladorJornalista.getById(jornalistaView.lerId());
							
							if (j == null) {
								System.out.println("Jornalista n�o encontrado!");
							} else {
								manipuladorJornalista.excluir(jornalistaView.ler());
							}
		
						} else if (opcaoSubmenu == 4) {
							manipuladorJornalista.listar();
						}
			}
		}

		System.out.println("Fim");
	}

}
}

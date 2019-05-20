# Navigation-Arch-Sample

Aplicação simples de navegação utilizando Android Architecture Components Navigation:

- Anunciado no último GoogleIO como parte do Android JetPack (Atualmente Alpha 5, funciona apenas nas versões 3.2 em diante)

- NÃO É UM STORYBOARD!!!!! (iOS). É apenas para navegação

- Segue os princípios de navegação indicados pela Google:
	- A navegação deve possuir um ponto de entrada fixo;
	- A Stack representa o "estado da navegação" utilizando o padrão L.I.F.O (Ou seja, o ponto de entrada no final da stack e a última tela no topo)
	- O botão de voltar (Up button) não deve existir no ponto de entrada do app
	- O botão de voltar do app (Up) e o botão de voltar do sistema devem possuir o mesmo comportamento;
	- Acessar o App por deep link deve manter a hierarquia da navegação;

- Possui escopo de Single Activity (Não é possível criar navegações apenas com Activities);
	- Caso um fragment abra uma nova Activity, esta nova deveria ter sua própria navegação;

- Tem que usar Fragments;  :'(

- Fragment Manager está abstraído pelo Navigation;  \o/

- Resolve o problema de ter de controlar um fluxo de Fragments em uma Activity (Boilerplate?);

- Guia de implementação simples: https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing ;

- Documentação técnica não tão boa;

- O grafo de navegação pode ser criado de forma visual (Mas apenas abstrai um XML)

- A Activity que possui navegação deve possuir um filho Fragment com os atributos app:defaultNavHost="true" e app:navGraph="@navigation/navigation_graph".
	- app:defaultNavHost="true" garante que a activity intercepte o system back button
	- app:navGraph define o grafo de navegação que a Activity possui

- A Activity assim possui um fragment com "NavigationHost". Para controlar o "Back" do sistema, a Activity deve sobreescrever o onSupportNavigateUp()

- Funcionamento:
	- Definir todas as Destinations (Telas do fluxo)
	- Criar as actions (Conectar os destinos)
	- Definir a "Start destination"
	- A navegação pode ser criada programaticamente, mas não né.
	- A navegação pode receber argumentos (Bundle) - Pode ser utilizado Safe Args
	- Chamar um fragment ou uma action não definida na navegação causa crash

- Navigation com Bottom Nav, menu hamb, etc..:
	- Criar um arquivo de menu
	- Criar uma navegação e incluir as telas que serão destino pelo menu
	- Definir o id dos fragments dentro da navegação iguais aos do menu
	- Na Activity, configurar a bottom_nav com o metodo setupWithNavControler

- Animações de transição são controladas pela própria Navigation \o/
	- As Actions definem a forma de navegação de uma tela a outra, inclusive a animação
	- Para a transição funcionar, é necessário utilizar o id da action e não da tela de destino

- Pronto para utilizar com KTX (Caso utilize Kotlin).
	- Utilizar view.findNavController() ou findNavController() nos fragments, ao invés de Navigation.findNavController(view)

- Métodos de teste não definidos ainda. Mas a estratégia seria testar as actions e não o fluxo

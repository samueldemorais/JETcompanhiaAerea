# JETcompanhiaAerea
![JETcompanhiaAerea](https://github.com/samueldemorais/JETcompanhiaAerea/assets/93936945/32ed0fe6-f5c0-4d15-84d2-c8f35531c87f)

# Padrão Observer:
O padrão Observer é usado para criar uma relação de dependência um-para-muitos entre objetos, de modo que, quando um objeto (chamado de "sujeito" ou "observado") muda de estado, todos os seus dependentes (chamados de "observadores") são notificados e atualizados automaticamente.

# Voo (Sujeito Observado):
A classe Voo atua como o sujeito observado.
Ela possui uma lista de observadores (passageiros) registrados.
Métodos como adicionarObservador(Observador observador), removerObservador(Observador observador) e notificarObservadores() permitem gerenciar os observadores e notificar sobre mudanças.
Quando o status do voo é alterado por meio do método setStatus(StatusVoo status), o método notificarObservadores() é chamado para informar a todos os passageiros sobre a mudança.
# Passageiro (Observador):
A classe Passageiro implementa a interface Observador.
A implementação do método atualizar(Voo voo) na classe Passageiro é chamada quando o método notificarObservadores() é invocado na classe Voo.
No método atualizar(Voo voo), é realizada a lógica para notificar o passageiro sobre o status do voo, de acordo com sua preferência de notificação.
O padrão Observer foi usado para estabelecer uma relação onde os passageiros (observadores) são registrados para observar mudanças no estado do voo (sujeito observado). Quando o estado do voo é modificado, todos os passageiros são notificados automaticamente sobre essa mudança através do método atualizar(Voo voo). Isso permite que cada passageiro seja notificado de acordo com suas preferências quando o status do voo muda.


# Padrão Observer:
O padrão Strategy permite que você encapsule diferentes algoritmos em classes separadas e os torne intercambiáveis dentro de um contexto. Isso significa que pode selecionar qual algoritmo usar em tempo de execução, conforme necessário.

# Interface StrategyNotification:

Possui uma interface chamada StrategyNotification. Essa interface declara o método enviarNotificacao(String mensagem), estabelecendo o contrato que cada estratégia de notificação deve seguir.

# Implementações da interface StrategyNotification:
Existem classes concretas, como EstrategyEmail, EstrategySMS, EstrategyPush, etc. Cada uma dessas classes representa uma estratégia específica para enviar notificações aos passageiros.
Uso da estratégia:

Dentro da classe Voo ou de um serviço associado, há uma referência à interface StrategyNotification. Isso permite que você defina dinamicamente qual estratégia de notificação deseja utilizar para notificar os passageiros sobre mudanças no voo.

Durante a execução, você pode definir ou alterar a estratégia de notificação que será usada para enviar mensagens aos passageiros. Isso é feito através de métodos como setEstrategiaNotificacao(StrategyNotification estrategiaNotificacao).

Ao chamar enviarNotificacao na classe Voo, a lógica dentro deste método será executada de acordo com a estratégia de notificação configurada no momento.

O padrão Strategy permite que você gerencie diferentes estratégias de notificação em classes separadas, dando a flexibilidade de alternar entre essas estratégias na classe Voo sem precisar modificar seu código principal. Isso facilita a adição de novas estratégias sem alterar a lógica central da classe Voo.


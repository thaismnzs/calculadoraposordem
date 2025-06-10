Aplicação Web: Calculadora Pós-Ordem em Spring Boot

Desenvolvimento de uma calculadora em notação pós-ordem (RPN - Reverse Polish Notation) utilizando Java com Spring Boot, onde as expressões são avaliadas com o auxílio de estruturas de dados (pilha).

✨ Funcionalidades:

- Cálculos em pós-ordem (ex: 3 4 * = 12).
- Operações básicas: +, -, *, /, % (resto da divisão).
- Validação de entrada: tratamento de erros como divisão por zero e operandos insuficientes.
- Frontend intuitivo: interface web responsiva com HTML, CSS e JavaScript.
- Backend robusto: API RESTful com Spring Boot e manipulação de pilha (Stack).

🛠️ Tecnologias Utilizadas:

- Backend: Java 17, Spring Boot 3, Maven.

- Frontend: HTML5, CSS3, JavaScript (Vanilla JS).

- Controle de Versão: Git & GitHub.

🔧 Como Funciona?

O usuário digita a expressão no formato pós-ordem (ex: 5 2 /).

O frontend envia a expressão para o backend via requisição HTTP (POST /api/calculadora/calcular).

O Spring Boot processa a expressão usando uma pilha (Stack<Double>) para calcular o resultado.

O resultado é retornado e exibido no display da calculadora.

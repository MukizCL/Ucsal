A atividade avaliativa corresponde ao desenvolvimento de jogos, com as regras deﬁnidas a seguir:

1.	Os jogos deverão ser desenvolvidos em equipe e o número de alunos por equipe será deﬁnido pelo professor em conformidade com os alunos.

2.	Os jogos devem ser construídos exclusivamente na linguagem Java para ser executado no console da IDE do eclipse. Não será aceito qualquer tipo gráﬁco na construção dos jogos, apenas os resultados apresentados no console. Os jogos devem ser desenvolvidos de forma que qualquer pessoa possa executá-lo.

3.	Os jogos devem ser apresentados pelos alunos que fazem parte da equipe e os jogos devem estar funcionando corretamente (sem erro), de acordo com o que está deﬁnido na regra do jogo.

4.	Todos os alunos devem estar preparados para apresentar e responder aos questionamentos relacionados à lógica empregada, ao código desenvolvido e todas as estruturas utilizadas.

5.		O professor deverá indicar os alunos da equipe que irão apresentar os jogos, responder aos questionamentos e demais retornos necessários.


O que fazer:

1)	Inicialmente o usuário que irá executar o jogo deve se identiﬁcar, informando seu nome e um código de acesso. (uso do Scanner e Array).

2)		Em seguida será apresentado ao usuário com seu nome e um menu com as opções dos jogos que poderá executar. São eles: (1) Jogo da Forca, (2) Batalha Naval, (3) Campo Minado e (4) Sair.

3)	O usuário deverá escolher um jogo de cada vez e ao ﬁnalizar o jogo, retornará ao menu e poderá optar por executar outro jogo ou ﬁnalizar a execução dos jogos.


1.	O Jogo da Forca

O jogo da forca é um jogo em que o jogador tem que acertar qual é a palavra oculta, tendo como dica o número de letras deﬁnidas através de um traçado. A cada letra errada é desenhado uma parte do corpo do “enforcado” e a cada letra certa a posição do traço é substituída pela letra. Se o jogador conseguir adivinhar todas as letras da palavra antes de ﬁnalizar o desenho do “enforcado” ele ganha o jogo. O trabalho aqui é elaborar um jogo da forca em Java considerando passagem de parâmetro por valor, delegação de responsabilidade para os métodos e implementação correta da estratégia do jogo. Nesse caso utilize métodos para:
a.	Construir a forca e do enforcado
 
b.	Deﬁnir a palavra oculta
c.	Efetuar a jogada
d.	Validar a jogada
e.	Efetuar a estratégia
f.	Identiﬁcar o vencedor / perdedor



Na ﬁgura abaixo, pode-se observar a tela inicial do jogo quando executado.

<img src=/Avaliacoes/TerceiraAtvAvaliativa3Uni1Seme/img/Screenshot_1.jpg>

2.	O Jogo Batalha Naval

Batalha naval é um jogo de tabuleiro 10 x 10 onde dois jogadores tem que adivinhar os quadrados onde os navios estão escondidos. Ganha o jogo quem identiﬁcar todos os “barcos” do adversário primeiro. Nesse jogo cada jogador tem um tabuleiro (mínimo 02) pelo qual irão dispor todos os seus “barcos” em posições que diﬁculte o palpite do adversário. Os barcos não podem se sobrepor, o número de barcos é o mesmo para todos os jogadores. Após os barcos serem posicionados o jogo é iniciado e cada jogador propõe uma posição do tabuleiro do adversário alternadamente. Os tipos de barcos são:
(1) porta-aviões (cinco quadrados)
(2) navios-tanque (quatro quadrados)
(3) contratorpedeiros (três quadrados)
(4) submarinos (dois quadrados).

Os quadrados que compõem os barcos devem estar conectados e em ﬁla reta. O trabalho aqui é elaborar um jogo batalha naval em Java considerando passagem de parâmetro por valor, delegação de responsabilidade para os métodos e implementação correta da estratégia do jogo. Nesse caso utilize métodos para:

a.	Deﬁnir a quantidade de jogadores
b.	Construir os tabuleiros
c.	Deﬁnir a posição de cada barco nos tabuleiros
d.	Efetuar a jogada
e.	Validar a jogada
f.	Efetuar a estratégia
g.	Identiﬁcar o vencedor / perdedor

<img src=/Avaliacoes/TerceiraAtvAvaliativa3Uni1Seme/img/Screenshot_2.jpg>

3.	O Jogo Campo Minado

Esse jogo foi inventado por Robert Donner em 1989, para ser jogado por um único jogador, e tem como objetivo revelar as minas distribuídas pelo tabuleiro, evitando que qualquer uma delas seja detonada. Cada quadrado do tabuleiro irá revelar se há uma mina ou não após receber um clique. Se o quadrado clicado contiver uma mina, então o jogo acaba. Se, por outro lado, o quadrado não contiver uma mina poderá aparecer um valor indicando a quantidade de quadrados adjacentes que contêm minas ou nenhum número aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio, já que não podem conter minas. O jogador vence o jogo quando todos os quadrados que não tem minas forem revelados. (Fonte: h ttps://pt.wikipedia.org/wiki/Campo_minado).
Para essa atividade, considere um tabuleiro de tamanho 16 x 16 para ser distribuído as “minas”.

<img src=/Avaliacoes/TerceiraAtvAvaliativa3Uni1Seme/img/Screenshot_3.jpg>

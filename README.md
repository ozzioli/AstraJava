# ASTRA — Adaptive Space Tourism & Readiness Assessment

> Plataforma inteligente de preparação e gestão de turismo espacial.

**Global Solution 2026 — ODS 9: Indústria, Inovação e Infraestrutura**  
**FIAP — Turma 2ESPZ | Disciplina: Domain Driven Design — Java | Profa. Damiana Costa**

---

## Equipe
- **Enzo Ozzioli** - RM 564812
- **Thiago Nascimento** - RM 561967
- **Vinicius Herreira** - RM 565662
- **Gustavo Rocha** - RM 564152
- **Gabriel Santos** - RM 562419

---

## Diagrama de classes

![Diagrama UML](https://i.ibb.co/s9517T0j/t-Lb-RR-F65-Nv-VOFy3i-Nsed-AMDR8-DDWM1-XX9-Oe-H8-Kjgw-BNBq-LHZCYn-Tng-A8mo7oc-Mp-GDu2v-Bdv-HVj-F-ajwvigva.png)

---

## Descrição do Projeto

A **ASTRA** é uma aplicação Java que centraliza toda a jornada do turista espacial em um único sistema. O projeto simula uma plataforma real de turismo espacial conectando três tipos de usuários — turistas, médicos e operadoras — em um fluxo estruturado de avaliação, preparação e reserva de viagens.

**O problema que resolve:** o setor de turismo espacial opera de forma fragmentada. Candidatos a uma viagem espacial precisam buscar informações em múltiplos lugares, realizar avaliações médicas em clínicas que não se comunicam e seguir preparações sem acompanhamento estruturado. Operadoras não têm visibilidade centralizada sobre a prontidão dos passageiros.

**A solução:** a ASTRA unifica esse processo com:
- Cadastro e login por perfil (turista, médico, operadora)
- Questionário de aptidão com cálculo do **Space Readiness Score** (0–100)
- Painel médico para validação de candidatos
- Catálogo de pacotes espaciais com reservas e cancelamentos

---

## Instruções de Execução

### Pré-requisitos

- Java 17 ou superior instalado
- IDE recomendada: IntelliJ IDEA ou Eclipse (ou compilação via terminal)

### Como executar via terminal

```bash
# 1. Clone o repositório
git clone https://github.com/[seu-usuario]/astra-java.git
cd astra

# 2. Compile todos os arquivos Java
javac -d out -sourcepath src src/app/Main.java

# 3. Execute o projeto
java -cp out app.Main
```

### Como executar via IDE

1. Abra o projeto na sua IDE
2. Localize o arquivo `src/app/Main.java`
3. Execute o método `main()`

### Credenciais de teste (dados pré-carregados)

| Perfil | Nome | Email | Senha |
|--------|------|-------|-------|
| Turista | Carlos Mendonça | `teste` | `123` |
| Turista | Ana Lima | `ana@email.com` | `senha123` |
| Médico | Dra. Aline Ferreira | `aline@clinica.com` | `senha123` |
| Operadora | SpaceX Tourism | `spacex` | `123` |

---

## Estrutura do Projeto

```
src/
├── app/
│   ├── Main.java               # Ponto de entrada — inicializa listas e menus
│   ├── MenuPrincipal.java      # Login e redirecionamento por perfil
│   ├── MenuTurista.java        # Painel do turista
│   ├── MenuMedico.java         # Painel do médico
│   └── MenuOperadora.java      # Painel da operadora
├── model/
│   ├── Turista.java            # Entidade turista (extends UsuarioBase)
│   ├── Medico.java             # Entidade médico (extends UsuarioBase)
│   ├── Operadora.java          # Entidade operadora (extends UsuarioBase)
│   ├── PacoteEspacial.java     # Pacote de viagem (implements Reservavel)
│   ├── Reserva.java            # Vínculo turista + pacote
│   ├── AvaliacaoAptidao.java   # Respostas e scores do questionário
│   ├── PlanoPreparacao.java    # Plano gerado após aprovação médica
│   ├── StatusTurista.java      # Enum: CADASTRADO, EM_AVALIACAO, APROVADO...
│   └── ClassificacaoScore.java # Enum: INAPTO, EM_DESENVOLVIMENTO, APTO
├── abstracts/
│   ├── UsuarioBase.java        # Classe abstrata base para todos os usuários
│   └── ServicoEspacial.java    # Classe abstrata base para services
├── interfaces/
│   ├── Avaliavel.java          # Contrato: responderQuestionario(), getScoreAtual()
│   ├── Reservavel.java         # Contrato: reservar(Turista), cancelar(Reserva)
│   └── Notificavel.java        # Contrato: receberNotificacao(String)
├── service/
│   ├── ScoreService.java       # Cálculo do Space Readiness Score (sobrecarga)
│   ├── ReservaService.java     # Reservas, cancelamentos e política de reembolso
│   ├── MedicoService.java      # Avaliações médicas e geração de plano
│   ├── PacoteService.java      # Catálogo de pacotes espaciais
│   └── AutenticacaoService.java# Login e identificação de perfil
└── util/
    ├── DataUtil.java           # Cálculos de data (LocalDate)
    ├── Validador.java          # Validações de email, senha, idade, CRM
    └── Formatador.java         # Formatação de moeda e exibição no console
```

---

## Explicação das Classes Principais

### `UsuarioBase` — `abstracts/`
Classe abstrata que serve de base para todos os tipos de usuário. Centraliza os atributos comuns (nome, email, senha, dataCadastro) e declara o método abstrato `exibirPerfil()`, que cada subclasse implementa com `@Override` exibindo seus dados específicos.

### `Turista` — `model/`
Subclasse de `UsuarioBase`. Implementa as interfaces `Avaliavel` e `Notificavel`. Possui os atributos `scoreAtual`, `statusAptidao`, `avaliacao` e `planoPreparacao`. É a entidade central do fluxo — passa pelo questionário, recebe aprovação médica e faz reservas.

### `Medico` — `model/`
Subclasse de `UsuarioBase`. Implementa `Notificavel`. Tem `crm` e `especialidade`. O método `avaliarCandidato(Turista, boolean, String)` processa a decisão médica e atualiza o status do turista.

### `Operadora` — `model/`
Subclasse de `UsuarioBase`. Gerencia uma lista de `PacoteEspacial`. Métodos para cadastrar e listar pacotes de viagem espacial.

### `ScoreService` — `service/`
Demonstra **sobrecarga de métodos**: `calcularScore()` possui três assinaturas — recebe `int[]` com respostas brutas, três `double` com sub-scores separados, ou um objeto `AvaliacaoAptidao` completo. Aplica pesos por categoria (Físico 40% | Cardiovascular 35% | Psicológico 25%).

### `ReservaService` — `service/`
Gerencia reservas com validação de regras de negócio: status APROVADO obrigatório, antecedência mínima de 180 dias e disponibilidade de vagas. Calcula reembolso no cancelamento: >180 dias = total | 90–180 dias = 50% | <90 dias = sem reembolso.

### `AvaliacaoAptidao` — `model/`
Armazena as respostas do questionário divididas em três categorias e os sub-scores calculados. O campo `scoreTotal` e `classificacao` são preenchidos pelo `ScoreService` após o questionário.

---

## Conceitos de POO Aplicados

| Conceito | Onde foi aplicado |
|----------|------------------|
| **Herança** | `Turista`, `Medico`, `Operadora` estendem `UsuarioBase` |
| **Classe abstrata** | `UsuarioBase` (método `exibirPerfil()` abstrato) e `ServicoEspacial` |
| **Interface** | `Avaliavel`, `Reservavel`, `Notificavel` |
| **Sobrescrita (@Override)** | `exibirPerfil()` em Turista, Medico e Operadora; `toString()` em todas as entidades |
| **Sobrecarga** | `calcularScore()` em `ScoreService` com 3 assinaturas |
| **Encapsulamento** | Todos os atributos `private` com getters/setters |
| **Construtores** | Construtor padrão e completo em todas as classes; subclasses chamam `super()` |

---

## Relação com o ODS 9

O ODS 9 trata de **Indústria, Inovação e Infraestrutura**. A ASTRA se relaciona com esse objetivo ao propor uma infraestrutura digital para um setor emergente (turismo espacial), automatizar processos manuais e fragmentados com inovação tecnológica, e conectar atores distintos (turistas, médicos, operadoras) em um sistema único e estruturado.

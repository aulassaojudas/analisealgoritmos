# Definindo a classe Pilha
class Pilha:
    def __init__(self):
        self.itens = []

    def push(self, item):
        self.itens.append(item)

    def pop(self):
        if not self.itens:
            return None
        return self.itens.pop()

# Função para realizar as operações descritas
def operacoes_pilha():
    pilha = Pilha()
    operacoes = ["push(6)", "push(2)", "pop()", "push(2)", "push(8)", "pop()", "pop()",
                 "push(9)", "push(1)", "pop()", "push(7)", "push(6)", "pop()",
                 "push(4)", "pop()", "pop()"]

    print("Operações de Pilha e Saída Resultante:")
    for op in operacoes:
        if "push" in op:
            item = int(op.split("(")[1].split(")")[0])
            pilha.push(item)
            print(f"Push: {item}, Pilha: {pilha.itens}")
        elif op == "pop()":
            pop_item = pilha.pop()
            print(f"Pop: {pop_item}, Pilha: {pilha.itens}")

# Chamando a função para realizar as operações
operacoes_pilha()

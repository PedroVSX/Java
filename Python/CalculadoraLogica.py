import ttg

#################################

# ∨ - Disjunção (A or B)
# ∧ - Conjunção (A and B)
# → - Condicional (not A or B)
# ↔ - Bicondicional (A == B)
# ~ - Negação (not A)

#################################

A = True
B = True
C = True
D = True

#form = input("Digite a fórmula: ")
form = "A∧(A→B)" # 
formEscrita = ""
formVars = []

for i in range(len(form)):
    if (form[i] == "→"):
        if (form[i-1] == "A"): 
            formEscrita = form[:i-1] + "not A" + form[i:]

        elif (form[i-1] == "B"):
            formEscrita = form[:i-1] + "not B" + form[i:]

        elif (form[i-1] == "C"):
            formEscrita = form[:i-1] + "not C" + form[i:]

        elif (form[i-1] == "D"): 
            formEscrita = form[:i-1] + "not D" + form[i:]

    item = ""

    if (form[i] == "A"):
        item = "A"

    elif (form[i] == "B"):
        item = "B"

    elif (form[i] == "C"):
        item = "C"

    elif (form[i] == "D"):
        item = "D"

    if (item not in formVars):
        formVars.append(item)

formEscrita = formEscrita.replace("∨"," or ").replace("∧"," and ").replace("~","not ").replace("↔"," == ").replace("→"," or ")
formVars.remove("")

print(f"Escrita: {formEscrita}")
print(f"Original: {form}")
print()

print(ttg.Truths(formVars,[formEscrita]))

import random
from hypothesis import given, strategies as st
from datetime import datetime, timedelta

# Definições de Tipos de Dados
class Acao:
    COMPRAR = "Comprar"
    VENDER = "Vender"

class TipoArtigo:
    SAPATILHA = "Sapatilha"
    MALA = "Mala"
    TSHIRT = "TShirt"

class Marca:
    NIKE = "Nike"
    ADIDAS = "Adidas"
    PUMA = "Puma"

# Gerar uma data aleatória
@st.composite
def arbitrary_day(draw):
    start_date = datetime(2000, 1, 1)
    end_date = datetime(2100, 12, 28)
    delta = end_date - start_date
    random_days = draw(st.integers(min_value=0, max_value=delta.days))
    return start_date + timedelta(days=random_days)

# Gerar uma entrada de log
@st.composite
def arbitrary_log_entry(draw):
    data_log = draw(arbitrary_day())
    id_utilizador = draw(st.integers(min_value=1, max_value=2))
    acao = draw(st.sampled_from([Acao.COMPRAR, Acao.VENDER]))

    if acao == Acao.COMPRAR:
        id_artigo = draw(st.sampled_from(["A1", "A2", "A3", "A4", "A5"]))
        detalhes = id_artigo
        tipo_artigo = None
    else:
        tipo_artigo = draw(st.sampled_from([TipoArtigo.SAPATILHA, TipoArtigo.MALA, TipoArtigo.TSHIRT]))
        if tipo_artigo == TipoArtigo.SAPATILHA:
            detalhes = ",".join(map(str, [
                draw(st.booleans()),
                draw(st.sampled_from(["Como Novas", "Usadas", "Muito Usadas"])),
                draw(st.sampled_from([Marca.NIKE, Marca.ADIDAS, Marca.PUMA])),
                draw(st.integers(min_value=0, max_value=5000)),
                draw(st.booleans()),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.integers(min_value=0, max_value=20)),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.integers(min_value=12, max_value=50)),
                draw(st.booleans()),
                draw(st.sampled_from(["Preto", "Branco", "Azul", "Vermelho", "Verde"])),
                draw(st.integers(min_value=2000, max_value=2020))
            ]))
        elif tipo_artigo == TipoArtigo.MALA:
            detalhes = ",".join(map(str, [
                draw(st.sampled_from(["Como Novas", "Usadas", "Muito Usadas"])),
                draw(st.sampled_from([Marca.NIKE, Marca.ADIDAS, Marca.PUMA])),
                draw(st.integers(min_value=0, max_value=5000)),
                draw(st.booleans()),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.integers(min_value=0, max_value=20)),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.sampled_from(["Pele", "Algodao", "Poliamida", "Poliester", "Nylon"])),
                draw(st.integers(min_value=2000, max_value=2020)),
                draw(st.booleans())
            ]))
        elif tipo_artigo == TipoArtigo.TSHIRT:
            detalhes = ",".join(map(str, [
                draw(st.sampled_from(["Como Novas", "Usadas", "Muito Usadas"])),
                draw(st.sampled_from([Marca.NIKE, Marca.ADIDAS, Marca.PUMA])),
                draw(st.integers(min_value=0, max_value=5000)),
                draw(st.booleans()),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.integers(min_value=0, max_value=20)),
                draw(st.integers(min_value=0, max_value=2)),
                draw(st.sampled_from(["S", "M", "L", "XL"])),
                draw(st.sampled_from(["liso", "riscas", "palmeiras"]))
            ]))

    return {
        "data_log": data_log,
        "id_utilizador": id_utilizador,
        "acao": acao,
        "tipo_artigo": tipo_artigo,
        "detalhes": detalhes
    }

def format_log_entry(entry):
    date_str = entry["data_log"].strftime("%d:%m:%Y")
    id_utilizador = entry["id_utilizador"]
    acao = entry["acao"]
    if acao == Acao.COMPRAR:
        detalhes = entry["detalhes"]
        return f"{date_str},{id_utilizador},Comprar,{detalhes}"
    else:
        tipo_artigo = entry["tipo_artigo"]
        detalhes = entry["detalhes"]
        return f"{date_str},{id_utilizador},Vender,{tipo_artigo},{detalhes}"

def generate_logs(num_entries):
    logs = []
    for _ in range(num_entries):
        entry = arbitrary_log_entry().example()
        logs.append(format_log_entry(entry))
    return logs

if __name__ == "__main__":
    num_entries = 10
    logs = generate_logs(num_entries)
    with open("logs.txt", "w") as f:
        for log in logs:
            f.write(log + "\n")

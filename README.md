# Assistente de Arquivos

Aplicativo desktop em **Java Swing** para consultar os arquivos de uma pasta. Escolha uma pasta, como Downloads, e veja seu caminho completo e os nomes dos arquivos em uma tabela.

O projeto nasceu como um exercício de Java. Ele reúne eventos de interface, leitura de diretórios e atualização de uma tabela a partir dos dados lidos.

## O que já funciona

- Seleção de pastas pelo botão **Escolher pasta**.
- Exibição do caminho completo da pasta selecionada.
- Listagem, em uma tabela com rolagem, dos arquivos que estão diretamente dentro da pasta.
- Atualização da lista ao escolher outra pasta. Se você cancelar a seleção, a lista anterior continua na tela.

## Como executar

Instale um **JDK 17 ou superior** e use um ambiente com interface gráfica. O projeto usa a biblioteca padrão do Java e pode ser compilado diretamente com `javac`.

```bash
git clone https://github.com/GabrielFrancoo/AssistentedeArquivos.git
cd AssistentedeArquivos
javac -encoding UTF-8 -d out src/main/java/assistente/App.java src/main/java/assistente/view/TelaPrincipal.java
java -cp out assistente.App
```

Se preferir usar o **VS Code**, abra a pasta do repositório com o **Extension Pack for Java** instalado. Abra [App.java](src/main/java/assistente/App.java) e clique em **Run** acima do método `main`.

## Como usar

1. Na janela do aplicativo, clique em **Escolher pasta**.
2. Selecione uma pasta que contenha arquivos e confirme a escolha.
3. Confira o caminho no topo da janela e os nomes na coluna **Nome do arquivo**.

Se a pasta tiver subpastas, os arquivos dentro delas ficam fora da listagem. Uma pasta sem arquivos diretamente nela deixa a tabela vazia.

## Como o código funciona

| Arquivo | Responsabilidade |
| --- | --- |
| [App.java](src/main/java/assistente/App.java) | Inicia o programa e abre a janela na thread de eventos do Swing. |
| [TelaPrincipal.java](src/main/java/assistente/view/TelaPrincipal.java) | Monta a interface, recebe a seleção da pasta e atualiza a tabela. |

Ao clicar no botão, o `JFileChooser` abre a caixa de seleção. Depois da confirmação, `File.listFiles()` lê os itens da pasta, `isFile()` identifica os arquivos e o `DefaultTableModel` recebe os nomes que a `JTable` exibe.

## Próximas etapas

- Adicionar filtros por nome e tipo de arquivo.
- Exibir mais informações, como tamanho e data de modificação.
- Explorar buscas em linguagem natural, como “mostre os PDFs desta pasta”.
